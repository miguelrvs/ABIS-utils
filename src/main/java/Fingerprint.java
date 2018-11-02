package VariableObjects;

public class Fingerprint
{
  int fingerPosition = 0;
  int impressionType = 0;
  Image image = new Image();
  
  public int getFingerPosition()
  {
    return this.fingerPosition;
  }
  
  public void setFingerPosition(int fingerPosition)
  {
    this.fingerPosition = fingerPosition;
  }
  
  public int getImpressionType()
  {
    return this.impressionType;
  }
  
  public void setImpressionType(int impressionType)
  {
    this.impressionType = impressionType;
  }
  
  public Image getImage()
  {
    return this.image;
  }
  
  public void setImage(Image image)
  {
    this.image = image;
  }
}
