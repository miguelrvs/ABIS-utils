package VariableObjects;

public class BuscarBiometricosAbisRequestVo {
	String identityId = "";
	QueryBiometrics biometrics = null;
	
	public String getIdentityId() {
		return identityId;
	}
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
	public QueryBiometrics getBiometrics() {
		return biometrics;
	}
	public void setBiometrics(QueryBiometrics biometrics) {
		this.biometrics = biometrics;
	}
	
	
}
