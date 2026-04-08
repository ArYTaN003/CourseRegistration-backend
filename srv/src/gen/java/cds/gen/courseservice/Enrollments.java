package cds.gen.courseservice;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("CourseService.Enrollments")
@Generated("cds-maven-plugin")
public interface Enrollments extends CdsData {
  String ID = "ID";

  String STUDENT = "student";

  String STUDENT_EMAIL = "student_email";

  String COURSE = "course";

  String COURSE_ID = "course_ID";

  String STATUS = "status";

  String REGISTERED_AT = "registeredAt";

  @CdsName(ID)
  String getId();

  @CdsName(ID)
  void setId(String id);

  User getStudent();

  void setStudent(Map<String, ?> student);

  @CdsName(STUDENT_EMAIL)
  String getStudentEmail();

  @CdsName(STUDENT_EMAIL)
  void setStudentEmail(String studentEmail);

  Courses getCourse();

  void setCourse(Map<String, ?> course);

  @CdsName(COURSE_ID)
  String getCourseId();

  @CdsName(COURSE_ID)
  void setCourseId(String courseId);

  String getStatus();

  void setStatus(String status);

  Instant getRegisteredAt();

  void setRegisteredAt(Instant registeredAt);

  Enrollments_ ref();

  static Enrollments create() {
    return Struct.create(Enrollments.class);
  }

  static Enrollments of(Map<String, Object> map) {
    return Struct.access(map).as(Enrollments.class);
  }

  static Enrollments create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(Enrollments.class);
  }
}
