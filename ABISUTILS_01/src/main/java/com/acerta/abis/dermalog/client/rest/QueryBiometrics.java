package com.acerta.abis.dermalog.client.rest;

import java.util.ArrayList;
import java.util.List;

public class QueryBiometrics 
{
	List<Fingerprint> fingerprints = new ArrayList<Fingerprint>();
	List<Faces>			  faces	   = new  ArrayList<Faces>();
	
	public List<Fingerprint> getFingerprints() {
		return fingerprints;
	}
	public void setFingerprints(List<Fingerprint> fingerprints) {
		this.fingerprints = fingerprints;
	}
	public List<Faces> getFaces() {
		return faces;
	}
	public void setFaces(List<Faces> faces) {
		this.faces = faces;
	}

}
