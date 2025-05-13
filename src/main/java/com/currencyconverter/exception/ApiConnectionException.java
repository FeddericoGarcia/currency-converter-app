package main.java.com.currencyconverter.exception;

public class ApiConnectionException extends RuntimeException {
  public ApiConnectionException(String message) {
    super(message);
  }
}
