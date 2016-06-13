package Model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

  private List inventory;

  public Inventory() {
    inventory = new LinkedList();
  }
  
  public void addGuitar(String serialNumber, double price,
		  GuitarSpec spec) {
    Guitar guitar = new Guitar(serialNumber, price, spec);
    inventory.add(guitar);
  }

  public Guitar get(String serialNumber) {
    for (Iterator i = inventory.iterator(); i.hasNext(); ) {
    	Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }

  public List search(GuitarSpec searchSpec) {
    List matchingGuitars = new LinkedList();
    for (Iterator i = inventory.iterator(); i.hasNext(); ) {
    	Guitar guitar = (Guitar)i.next();
      if (guitar.getSpec().matches(searchSpec))
        matchingGuitars.add(guitar);
    }
    return matchingGuitars;
  }
}
