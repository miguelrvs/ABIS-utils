package com.acerta.abis.dermalog.client.rest.request;

import com.acerta.abis.dermalog.client.rest.QueryBiometrics;

public class AbisVoBuscarBiometricosRequest {
	QueryBiometrics queryBiometrics = null;
	
	public QueryBiometrics getBiometrics() {
		return queryBiometrics;
	}
	public void setBiometrics(QueryBiometrics biometrics) {
		this.queryBiometrics = biometrics;
	}
	
	
}
