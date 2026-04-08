package cds.gen.courseservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;
import javax.annotation.processing.Generated;

@CdsName("CourseService.Courses")
@Generated("cds-maven-plugin")
public interface Courses_ extends LinkedStructuredType<Courses, Courses_> {
  String ID = "ID";

  String INSTRUCTOR_EMAIL = "instructor_email";

  String CDS_NAME = "CourseService.Courses";

  @CdsName(ID)
  ElementRef<String> ID();

  ElementRef<String> title();

  ElementRef<String> description();

  ElementRef<Integer> capacity();

  User_ instructor();

  User_ instructor(Function<User_, CqnPredicate> filter);

  @CdsName(INSTRUCTOR_EMAIL)
  ElementRef<String> instructor_email();
}
