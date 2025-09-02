package com.learn.app.concepts.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
class CustomInvalidAgeException extends RuntimeException {

  private String errorCode;

  public CustomInvalidAgeException(String errorCode, String errorMessage) {
    super(errorMessage);
    this.errorCode = errorCode;
  }

  public CustomInvalidAgeException(String msg) {
    super(msg);
  }
}

public class CustomException {

  public static void main(String[] args) {

    try {
      int age = -5; // Example of invalid age
      if (age < 0) throw new CustomInvalidAgeException("SVC-4992", "Age cannot be negative");
    } catch (CustomInvalidAgeException e) {
      System.out.println("Caught CustomInvalidAgeException: " + e.getMessage());
      e.setErrorCode("ERR001");
      System.out.println("Error Code: " + e.getErrorCode());
    }
  }
}
