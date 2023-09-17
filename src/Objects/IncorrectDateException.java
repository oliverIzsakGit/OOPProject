package Objects;

public class IncorrectDateException extends Exception {
  /**
   * Returns a specified exception
   * @param message String exception
   */
  public IncorrectDateException(String message) {
    super(message);
  }
}
