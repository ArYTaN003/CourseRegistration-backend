package cds.gen.courseservice;

import cds.gen.CheckUserResult;
import com.sap.cds.ql.CdsName;
import com.sap.cds.services.cds.ApplicationService;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.cds.RemoteService;
import java.lang.Boolean;
import java.lang.String;
import javax.annotation.processing.Generated;

@Generated("cds-maven-plugin")
@CdsName(CourseService_.CDS_NAME)
public interface CourseService extends CqnService {
  @CdsName(LogoutContext.CDS_NAME)
  Boolean Logout();

  @CdsName(ValidateUserContext.CDS_NAME)
  Boolean ValidateUser(@CdsName(ValidateUserContext.EMAIL) String email,
      @CdsName(ValidateUserContext.PASSWORD) String password,
      @CdsName(ValidateUserContext.ROLE) String role);

  @CdsName(CheckUserContext.CDS_NAME)
  CheckUserResult CheckUser();

  interface Application extends ApplicationService, CourseService {
  }

  interface Remote extends RemoteService, CourseService {
  }
}
