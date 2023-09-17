package Objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is representing the products ordered but not yet part of the store
 */
public class OrderProduct implements Serializable
{
  private String name;
  private String type;
  private String arrival;
  private int amount;
  private double price;
  private String description;
private Console console;

  /**
   * Basic constructor
   * @param name String
   * @param type String
   * @param arrival String
   * @param amount int
   * @param price double
   * @param d comment
   * @param ctype String console Type
   */
  public OrderProduct(String name, String type, String arrival, int amount,
      double price,String d,String ctype)
  {
    this.name = name;
    this.type = type;
    this.arrival = arrival;
    this.amount = amount;
    this.price = price;
    description=d;
    console = new Console(ctype);
  }
  public Console getConsoleType()
  {
    return console;
  }


  public void setConsoleType(String consoleType)
  {
    this.console= new Console(consoleType);
    description +=  "\nConsole : "+ consoleType+ " \n";
  }
  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
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

  public String getArrival()
  {
    return arrival;
  }

  public void setArrival(DateTime arrival)
  {
    this.arrival = arrival.getSpecificDate();
  }

  public int getAmount()
  {
    return amount;
  }

  public void setAmount(int amount)
  {
    this.amount = amount;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }
}
