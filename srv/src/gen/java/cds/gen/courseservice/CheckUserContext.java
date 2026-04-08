package cds.gen.courseservice;

import cds.gen.CheckUserResult;
import com.sap.cds.services.EventContext;
import com.sap.cds.services.EventName;
import java.lang.Override;
import java.lang.String;
import javax.annotation.processing.Generated;

@EventName("CheckUser")
@Generated("cds-maven-plugin")
public interface CheckUserContext extends EventContext {
  String CDS_NAME = "CheckUser";

  @Override
  CourseService getService();

  void setResult(CheckUserResult result);

  CheckUserResult getResult();

  static CheckUserContext create() {
    return EventContext.create(CheckUserContext.class, null);
  }
}
