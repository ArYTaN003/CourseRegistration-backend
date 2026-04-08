package cds.gen.courseservice;

import com.sap.cds.services.EventContext;
import com.sap.cds.services.EventName;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import javax.annotation.processing.Generated;

@EventName("Logout")
@Generated("cds-maven-plugin")
public interface LogoutContext extends EventContext {
  String CDS_NAME = "Logout";

  @Override
  CourseService getService();

  void setResult(Boolean result);

  Boolean getResult();

  static LogoutContext create() {
    return EventContext.create(LogoutContext.class, null);
  }
}
