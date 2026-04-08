package cds.gen.onlinecourses;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("onlinecourses.User")
@Generated("cds-maven-plugin")
public interface User extends CdsData {
  String EMAIL = "email";

  String ROLE = "role";

  String PASSWORD = "password";

  String getEmail();

  void setEmail(String email);

  String getRole();

  void setRole(String role);

  String getPassword();

  void setPassword(String password);

  User_ ref();

  static User create() {
    return Struct.create(User.class);
  }

  static User of(Map<String, Object> map) {
    return Struct.access(map).as(User.class);
  }

  static User create(String email) {
    Map<String, Object> keys = new HashMap<>();
    keys.put(EMAIL, email);
    return Struct.access(keys).as(User.class);
  }
}
