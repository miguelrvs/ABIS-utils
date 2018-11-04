package com.acerta.abis.dermalog.client.rest.response;

import com.acerta.abis.dermalog.client.rest.QueryBiometrics;

public class AbisVoValidarResponse {
	String identityId = "";
	QueryBiometrics queryBiometrics = null;
	
	public String getIdentityId() {
		return identityId;
	}
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
	public QueryBiometrics getBiometrics() {
		return queryBiometrics;
	}
	public void setBiometrics(QueryBiometrics biometrics) {
		this.queryBiometrics = biometrics;
	}
	
	
}
