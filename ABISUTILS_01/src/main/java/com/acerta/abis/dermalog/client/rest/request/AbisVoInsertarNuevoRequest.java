package com.acerta.abis.dermalog.client.rest.request;

import com.acerta.abis.dermalog.client.rest.QueryBiometrics;

public class AbisVoInsertarNuevoRequest {
	String identityId = "";
	QueryBiometrics biometrics = null;
	
	public String getIdentityId() {
		return identityId;
	}
	public AbisVoInsertarNuevoRequest setIdentityId(String identityId) {
		this.identityId = identityId;
		return this;
	}
	public QueryBiometrics getBiometrics() {
		return biometrics;
	}
	public AbisVoInsertarNuevoRequest setBiometrics(QueryBiometrics biometrics) {
		this.biometrics = biometrics;
		return this;
	}
	
	
}
