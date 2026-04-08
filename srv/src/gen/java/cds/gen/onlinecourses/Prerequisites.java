package cds.gen.onlinecourses;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("onlinecourses.Prerequisites")
@Generated("cds-maven-plugin")
public interface Prerequisites extends CdsData {
  String ID = "ID";

  String COURSE = "course";

  String COURSE_ID = "course_ID";

  String PREREQUISITE = "prerequisite";

  String PREREQUISITE_ID = "prerequisite_ID";

  @CdsName(ID)
  String getId();

  @CdsName(ID)
  void setId(String id);

  Courses getCourse();

  void setCourse(Map<String, ?> course);

  @CdsName(COURSE_ID)
  String getCourseId();

  @CdsName(COURSE_ID)
  void setCourseId(String courseId);

  Courses getPrerequisite();

  void setPrerequisite(Map<String, ?> prerequisite);

  @CdsName(PREREQUISITE_ID)
  String getPrerequisiteId();

  @CdsName(PREREQUISITE_ID)
  void setPrerequisiteId(String prerequisiteId);

  Prerequisites_ ref();

  static Prerequisites create() {
    return Struct.create(Prerequisites.class);
  }

  static Prerequisites of(Map<String, Object> map) {
    return Struct.access(map).as(Prerequisites.class);
  }

  static Prerequisites create(String id) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(ID, id);
    return Struct.access(keys).as(Prerequisites.class);
  }
}
