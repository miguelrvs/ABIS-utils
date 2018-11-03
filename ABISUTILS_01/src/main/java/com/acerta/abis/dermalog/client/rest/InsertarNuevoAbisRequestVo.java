package com.acerta.abis.dermalog.client.rest;

public class InsertarNuevoAbisRequestVo {
	String identityId = "";
	QueryBiometrics biometrics = null;
	
	public String getIdentityId() {
		return identityId;
	}
	public InsertarNuevoAbisRequestVo setIdentityId(String identityId) {
		this.identityId = identityId;
		return this;
	}
	public QueryBiometrics getBiometrics() {
		return biometrics;
	}
	public InsertarNuevoAbisRequestVo setBiometrics(QueryBiometrics biometrics) {
		this.biometrics = biometrics;
		return this;
	}
	
	
}
