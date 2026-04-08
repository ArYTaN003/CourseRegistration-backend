package cds.gen.courseservice;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("CourseService.Courses")
@Generated("cds-maven-plugin")
public interface Courses extends CdsData {
  String ID = "ID";

  String TITLE = "title";

  String DESCRIPTION = "description";

  String CAPACITY = "capacity";

  String INSTRUCTOR = "instructor";

  String INSTRUCTOR_EMAIL = "instructor_email";

  @CdsName(ID)
  String getId();

  @CdsName(ID)
  void setId(String id);

  String getTitle();

  void setTitle(String title);

  String getDescription();

  void setDescription(String description);

  Integer getCapacity();

  void setCapacity(Integer capacity);

  User getInstructor();

  void setInstructor(Map<String, ?> instructor);

  @CdsName(INSTRUCTOR_EMAIL)
  String getInstructorEmail();

  @CdsName(INSTRUCTOR_EMAIL)
  void setInstructorEmail(String instructorEmail);

  Courses_ ref();

  static Courses create() {
    return Struct.create(Courses.class);
  }

  static Courses of(Map<String, Object> map) {
    return Struct.access(map).as(Courses.class);
  }

  static Courses create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(Courses.class);
  }
}
