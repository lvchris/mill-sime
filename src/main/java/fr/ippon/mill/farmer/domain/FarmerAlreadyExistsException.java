package fr.ippon.mill.farmer.domain;

public class FarmerAlreadyExistsException extends Exception {

  public FarmerAlreadyExistsException(String email) {
    super(String.format("Farmer with email \"%s\" already exists", email));
  }

}
