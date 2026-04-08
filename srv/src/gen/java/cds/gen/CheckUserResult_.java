package cds.gen;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.LinkedStructuredType;
import java.lang.Boolean;
import java.lang.String;
import javax.annotation.processing.Generated;

@CdsName("CheckUserResult")
@Generated("cds-maven-plugin")
public interface CheckUserResult_ extends LinkedStructuredType<CheckUserResult, CheckUserResult_> {
  String CDS_NAME = "CheckUserResult";

  ElementRef<Boolean> value();

  ElementRef<String> email();

  ElementRef<String> role();
}
