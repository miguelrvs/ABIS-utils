package VariableObjects;

import java.util.ArrayList;
import java.util.List;

public class QueryBiometrics
{
  List<Fingerprint> fingerprints = new ArrayList();
  List<Faces> faces = new ArrayList();
  
  public List<Fingerprint> getFingerprints()
  {
    return this.fingerprints;
  }
  
  public void setFingerprints(List<Fingerprint> fingerprints)
  {
    this.fingerprints = fingerprints;
  }
  
  public List<Faces> getFaces()
  {
    return this.faces;
  }
  
  public void setFaces(List<Faces> faces)
  {
    this.faces = faces;
  }
}
