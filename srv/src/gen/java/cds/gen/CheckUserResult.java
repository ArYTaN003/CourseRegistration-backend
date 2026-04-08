package cds.gen;

import com.sap.cds.CdsData;
import com.sap.cds.Struct;
import com.sap.cds.ql.CdsName;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.util.Map;
import javax.annotation.processing.Generated;

@CdsName("CheckUserResult")
@Generated("cds-maven-plugin")
public interface CheckUserResult extends CdsData {
  String VALUE = "value";

  String EMAIL = "email";

  String ROLE = "role";

  Boolean getValue();

  void setValue(Boolean value);

  String getEmail();

  void setEmail(String email);

  String getRole();

  void setRole(String role);

  static CheckUserResult create() {
    return Struct.create(CheckUserResult.class);
  }

  static CheckUserResult of(Map<String, Object> map) {
    return Struct.access(map).as(CheckUserResult.class);
  }
}
