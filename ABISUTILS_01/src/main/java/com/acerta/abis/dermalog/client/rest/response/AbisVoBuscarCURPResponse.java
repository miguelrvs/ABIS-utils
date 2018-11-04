package com.acerta.abis.dermalog.client.rest.response;

import com.acerta.abis.dermalog.client.rest.QueryBiometrics;

public class AbisVoBuscarCURPResponse {
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
