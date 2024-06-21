package fr.ippon.mill.error.domain;

public class AssertionException extends RuntimeException {

  public AssertionException(String message) {
    super(message);
  }
}
