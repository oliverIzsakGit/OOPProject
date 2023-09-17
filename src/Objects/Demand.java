package Objects;

import java.io.Serializable;

/**
 * This class represents a demand created by customers
 */
public class Demand implements Serializable
{
  private String name;
  private String type;
  private String date;
  private int amount;
  private String comment;
  private Console console;

  /**
   * Basic constructor
   * @param name string
   * @param type string
   * @param amount int
   * @param d String comment
   * @param ctype String constole type
   * @param dt DateTime date of arrival
   */
  public Demand(String name, String type, int amount,
     String d,String ctype,DateTime dt)
  {
    this.name = name;
    this.type = type;
    this.amount = amount;
    comment=d;
    console = new Console(ctype);
    date = dt.getSpecificDate();

  }



  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public String getDate()
  {
    return date;
  }

  public void setDate(DateTime date)
  {
    this.date = date.getSpecificDate();
  }

  public int getAmount()
  {
    return amount;
  }

  public void setAmount(int amount)
  {
    this.amount = amount;
  }

  public String getComment()
  {
    return comment;
  }

  public void setComment(String comment)
  {
    this.comment = comment;
  }

  public Console getConsoleType()
  {
    return console;
  }
  /**
   * This method is repsonsible for setting the name of the Console this product can be used on
   * and also adding this information to the product's description
   * @param consoleType String containing the name of the console
   */
  public void setConsoleType(String consoleType)
  {
    this.console= new Console(consoleType);
    comment +=  "\nConsole : "+ consoleType+ " \n";
  }

}
