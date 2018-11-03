package com.acerta.abis.dermalog.client.rest;

public class BuscarBiometricosAbisResponse {
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
