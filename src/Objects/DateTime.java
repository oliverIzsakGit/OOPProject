package Objects;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A date class created for logging.
 * @author Olivér Izsák
 */
public class DateTime implements Serializable
{
  private Date date;
  private String specificDate;

  /**
   * Basic constructor for the current date.
   */
  public DateTime()
  {
    date = Calendar.getInstance().getTime();
  }

  /**
   * Consturctor for a specific date
   * @param day int day
   * @param month int month
   * @param year int year
   */
  public DateTime(int day, int month, int year)
  {
    specificDate= day + "/"+month + "/"+year;
  }

  /**
   * Returns the current date in a format
   * @return String current date in a format
   */
  public String getTimestamp()
  {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    return sdf.format(date);
  }

  /**
   * Returns a specific  date if there was one initialized by the constructor with parameters.
   * @return specific date in String
   */
  public String getSpecificDate()
  {
    return specificDate;
  }
}