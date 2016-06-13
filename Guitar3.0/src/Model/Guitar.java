package Model;

public class Guitar {

  private String serialNumber;
  private double price;
  GuitarSpec spec;

  
  public Guitar() {
	// TODO Auto-generated constructor stub
}
  public Guitar(String serialNumber, double price, GuitarSpec spec) {
	    this.serialNumber = serialNumber;
	    this.price = price;
	    this.spec = spec;
	  }
public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
}

public void setPrice(double price) {
	this.price = price;
}

public void setSpec(GuitarSpec spec) {
	this.spec = spec;
}

public String getSerialNumber() {
    return serialNumber;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(float newPrice) {
    this.price = newPrice;
  }

  public GuitarSpec getSpec() {
    return spec;
  }
}
