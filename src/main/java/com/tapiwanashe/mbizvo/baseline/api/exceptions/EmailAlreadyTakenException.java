package com.tapiwanashe.mbizvo.baseline.api.exceptions;

public class EmailAlreadyTakenException extends RuntimeException {
  public EmailAlreadyTakenException(String message) {
    super(message);
  }
}
