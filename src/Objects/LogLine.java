package Objects;

public class LogLine
{
  /**
   * Composite  for  the Log class.
   * It adds the current date to an action specified in the text
   */
  private String text;
  private DateTime dateTime;

  /**
   * Basic constructor with string containing the logged text
   * @param text String logged text
   */
  public LogLine(String text)
  {
    this.text = text;
    dateTime = new DateTime();
  }

  public String toString()
  {
    return dateTime.getTimestamp() + " : " + text;
  }

}

