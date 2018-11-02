package VariableObjects;

public class BuscarBiometricosAbisRequestVo
{
  String identityId = "";
  QueryBiometrics biometrics = null;
  
  public String getIdentityId()
  {
    return this.identityId;
  }
  
  public void setIdentityId(String identityId)
  {
    this.identityId = identityId;
  }
  
  public QueryBiometrics getBiometrics()
  {
    return this.biometrics;
  }
  
  public void setBiometrics(QueryBiometrics biometrics)
  {
    this.biometrics = biometrics;
  }
}
