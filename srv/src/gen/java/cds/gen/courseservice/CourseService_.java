package cds.gen.courseservice;

import com.sap.cds.ql.CdsName;
import java.lang.Class;
import java.lang.String;
import javax.annotation.processing.Generated;

@Generated("cds-maven-plugin")
@CdsName("CourseService")
public interface CourseService_ {
  String CDS_NAME = "CourseService";

  Class<Enrollments_> ENROLLMENTS = Enrollments_.class;

  Class<User_> USER = User_.class;

  Class<Courses_> COURSES = Courses_.class;

  Class<Prerequisites_> PREREQUISITES = Prerequisites_.class;
}
