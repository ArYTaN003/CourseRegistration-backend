package customer.onlinecourseregistration.Handlers;

import cds.gen.CheckUserResult;
import com.sap.cds.ql.Insert;
import com.sap.cds.ql.cqn.CqnInsert;
import com.sap.cds.ql.cqn.CqnSelect;
import com.sap.cds.services.EventContext;
import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.Before;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.ql.Select;
import com.sap.cds.services.handler.annotations.ServiceName;


import cds.gen.courseservice.User_;
import cds.gen.courseservice.User;
import cds.gen.courseservice.Courses_;
import cds.gen.courseservice.Courses;
import cds.gen.courseservice.ValidateUserContext;
import cds.gen.courseservice.CheckUserContext;
//import cds.gen.

import com.sap.cds.services.persistence.PersistenceService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@ServiceName("CourseService")
public class courseService implements EventHandler {
    @Autowired
    PersistenceService db;

    @Before(event = CqnService.EVENT_CREATE, entity = User_.CDS_NAME)
    public void beforeStudentCreation(CdsCreateEventContext context){
        Map<String,Object> data = context.getCqn().asInsert().entries().get(0);
        String email = (String)data.get("email");
        String email_regex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,}$";
        Pattern email_pattern = Pattern.compile(email_regex);
        Matcher email_matcher = email_pattern.matcher(email);
        if(!email_matcher.matches()){
            context.getMessages().error("Invalid email.");
            return ;
        }
//        System.out.println(email);
    }
    @On(event = CqnService.EVENT_READ, entity = User_.CDS_NAME)
    public void onGetStudents(CdsReadEventContext context){
        CqnSelect s = Select.from("onlinecourses.User");
//        Object result = db.run(s);
//        System.out.println(result);
        context.setCqn(s);
//        Map<String,Object> m = new HashMap<>();
//        m.put("Message","Read Complete");
//        m.put("email","sample");
        List<User> studentsList = db.run(s).listOf(User.class);
//        System.out.println(studentsList);
        List<Map<String,Object>> message = new java.util.ArrayList<>(studentsList.stream().map(i -> {
            Map<String, Object> row = new HashMap<>();
            row.put("role", i.getRole());
            row.put("email", i.getEmail());
            row.put("password",i.getPassword());
            return row;
        }).toList());
//        message.add(m);
        context.setResult(message);
//        System.out.println(message);
//        System.out.println(context.);
    }
    @On(event = CqnService.EVENT_CREATE, entity = User_.CDS_NAME)
    public void onCreateStudent(CdsCreateEventContext context){
        Map<String,Object> data = context.getCqn().asInsert().entries().get(0);
        String name = (String)data.get("name");
        String email = (String)data.get("email");
        CqnInsert insert =  Insert.into("onlinecourses.User").entry(data);
        context.setCqn(insert);
//        db.run(insert);
        System.out.println("Student Created: " + name + " with email: " + email);
    }
    @On (event = CqnService.EVENT_CREATE, entity = Courses_.CDS_NAME)
    public void onCreateCourse(CdsCreateEventContext context,Courses courses) {
        System.out.println("Course Creation Call Initiated!");
        HttpServletRequest req = getRequest();
        String role = req != null ? (String) req.getSession().getAttribute("userRole") : null;
        String email = req != null ? (String) req.getSession().getAttribute("userEmail") : null;
//        System.out.println("Here");
        // deny if no login
        System.out.println(role);
        System.out.println(email);
        if (role == null || email== null) {
            context.getMessages().error("Not logged in");
            context.setResult(Collections.emptyList());
            return;
        }
        if("instructor".equals(role)){
            System.out.println(courses);
//        CqnSelect s = Select.from("onlinecourses.Courses");
//        List<Courses> existingCourses = db.run(s).listOf(Courses.class);
//        System.out.println(existingCourses.size());
//            email = courses.getInstructorEmail();
            String title = courses.getTitle();
            String description = courses.getDescription();
            if (!present(email)) {
                System.out.println("Instructor not present");
                context.getMessages().error("Instructor not Present.");
                throw new RuntimeException("Invalid Instructor");
            }else {
                System.out.println("Course Created: " + title + " with description: " + description);
            }
        }else{
            context.getMessages().error("Only instructor is allowed to create courses.");
//            context.set
        }
        System.out.println("Course Created!");
    }
    @On( event=CqnService.EVENT_READ, entity=Courses_.CDS_NAME)
    public void onReadCourse(CdsReadEventContext context){

    }
    @On (event="ValidateUser")
    public void onValidateUser(ValidateUserContext context){
//        System.out.println(context);
//        System.out.println("Context class: " + context.getClass());
//        context.entrySet().forEach(e -> {
//            System.out.println("Key: " + e.getKey() + "  Value: " + e.getValue());
//        });
        String email = context.getEmail();
        String password = context.getPassword();
        String role = context.getRole();
//        System.out.println(email + " "+password);
        CqnSelect s = Select.from("onlinecourses.User").where(i->i.get("email").eq(email).and(i.get("password").eq(password)).and(i.get("role").eq(role)));
        List<User> users = db.run(s).listOf(User.class);
//        System.out.println(users);
        long i = db.run(s).rowCount();
//        System.out.println(i);
        if(i==1){
            HttpServletRequest request = getRequest();
            request.getSession(true).setAttribute("userEmail", email);
            request.getSession(true).setAttribute("userRole",role);
            context.setResult(true);
        }else{
            context.setResult(false);
        }
      //context.setResult(i==1);
    }
    @On (event="CheckUser")
    public void onCheckUser(CheckUserContext context){
        HttpServletRequest request = getRequest();
        if (request != null && request.getSession(false) != null) {
            String email = (String) request.getSession(false).getAttribute("userEmail");
            String role = (String) request.getSession(false).getAttribute("userRole");

            if (email != null && role != null) {
                CheckUserResult result = CheckUserResult.create();
                result.put("value", true);
                result.put("email", email);
                result.put("role", role);
                context.setResult(result);
                return;
            }
        }

        // fallback: not logged in
        CheckUserResult result = CheckUserResult.create();
        result.put("value", false);
        context.setResult(result);
    }
    @On(event = "Logout")
    public void onLogout(cds.gen.courseservice.LogoutContext context) {
        HttpServletRequest req = getRequest();
        if (req != null) {
            req.getSession().invalidate();
            context.setResult(true);
        } else {
            context.setResult(false);
        }
    }

    private boolean present(String email){
        CqnSelect s = Select.from("onlinecourses.User").where(i -> i.get("email").eq(email).and(i.get("role").eq("instructor")));
        long i = db.run(s).rowCount();
        return i>0;
    }
    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}
