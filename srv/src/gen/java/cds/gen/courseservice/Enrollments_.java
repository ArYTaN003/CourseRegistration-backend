package cds.gen.courseservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.String;
import java.time.Instant;
import java.util.function.Function;
import javax.annotation.processing.Generated;

@CdsName("CourseService.Enrollments")
@Generated("cds-maven-plugin")
public interface Enrollments_ extends LinkedStructuredType<Enrollments, Enrollments_> {
  String ID = "ID";

  String STUDENT_EMAIL = "student_email";

  String COURSE_ID = "course_ID";

  String CDS_NAME = "CourseService.Enrollments";

  @CdsName(ID)
  ElementRef<String> ID();

  User_ student();

  User_ student(Function<User_, CqnPredicate> filter);

  @CdsName(STUDENT_EMAIL)
  ElementRef<String> student_email();

  Courses_ course();

  Courses_ course(Function<Courses_, CqnPredicate> filter);

  @CdsName(COURSE_ID)
  ElementRef<String> course_ID();

  ElementRef<String> status();

  ElementRef<Instant> registeredAt();
}
