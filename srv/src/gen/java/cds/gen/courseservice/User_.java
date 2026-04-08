package cds.gen.courseservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import java.lang.String;
import javax.annotation.processing.Generated;

@CdsName("CourseService.User")
@Generated("cds-maven-plugin")
public interface User_ extends LinkedStructuredType<User, User_> {
  String CDS_NAME = "CourseService.User";

  ElementRef<String> email();

  ElementRef<String> role();

  ElementRef<String> password();
}
