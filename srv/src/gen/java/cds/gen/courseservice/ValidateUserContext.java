package cds.gen.courseservice;

import com.sap.cds.services.EventContext;
import com.sap.cds.services.EventName;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import javax.annotation.processing.Generated;

@EventName("ValidateUser")
@Generated("cds-maven-plugin")
public interface ValidateUserContext extends EventContext {
  String EMAIL = "email";

  String PASSWORD = "password";

  String ROLE = "role";

  String CDS_NAME = "ValidateUser";

  String getEmail();

  void setEmail(String email);

  String getPassword();

  void setPassword(String password);

  String getRole();

  void setRole(String role);

  @Override
  CourseService getService();

  void setResult(Boolean result);

  Boolean getResult();

  static ValidateUserContext create() {
    return EventContext.create(ValidateUserContext.class, null);
  }
}
