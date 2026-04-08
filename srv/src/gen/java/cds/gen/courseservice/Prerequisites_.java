package cds.gen.courseservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import com.sap.cds.ql.cqn.CqnPredicate;
import java.lang.String;
import java.util.function.Function;
import javax.annotation.processing.Generated;

@CdsName("CourseService.Prerequisites")
@Generated("cds-maven-plugin")
public interface Prerequisites_ extends LinkedStructuredType<Prerequisites, Prerequisites_> {
  String ID = "ID";

  String COURSE_ID = "course_ID";

  String PREREQUISITE_ID = "prerequisite_ID";

  String CDS_NAME = "CourseService.Prerequisites";

  @CdsName(ID)
  ElementRef<String> ID();

  Courses_ course();

  Courses_ course(Function<Courses_, CqnPredicate> filter);

  @CdsName(COURSE_ID)
  ElementRef<String> course_ID();

  Courses_ prerequisite();

  Courses_ prerequisite(Function<Courses_, CqnPredicate> filter);

  @CdsName(PREREQUISITE_ID)
  ElementRef<String> prerequisite_ID();
}
