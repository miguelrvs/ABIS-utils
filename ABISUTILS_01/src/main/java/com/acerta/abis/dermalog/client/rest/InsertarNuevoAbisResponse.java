package com.acerta.abis.dermalog.client.rest;

public class InsertarNuevoAbisResponse {
	String identityId = "";
	QueryBiometrics biometrics = null;
	
	public String getIdentityId() {
		return identityId;
	}
	public InsertarNuevoAbisResponse setIdentityId(String identityId) {
		this.identityId = identityId;
		return this;
	}
	
}
