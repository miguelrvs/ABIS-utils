package com.acerta.abis.dermalog.client.rest.response;

import java.util.ArrayList;

import com.acerta.abis.dermalog.client.rest.Candidates;

public class AbisVoBuscarBiometricosResponse {

	public ArrayList<Candidates> candidates = new ArrayList<>();

	public ArrayList<Candidates> getCandidates() {
		return candidates;
	}

	public void setCandidates(ArrayList<Candidates> candidates) {
		this.candidates = candidates;
	}
	
	
	
	
}
