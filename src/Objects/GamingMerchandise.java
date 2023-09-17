package Objects;

import java.io.Serializable;

/**
 * Abstract class for different GamingMerchandise, it is also a super class for 3 other objects.
 */
public abstract class GamingMerchandise implements Serializable

{
  private String name;
  private Double price;
  private String description;
  private int id;

  /**
   * Basic constructor
   * @param name String
   * @param price double
   * @param description String
   * @param id int
   */
  public GamingMerchandise(String name, Double price, String description, int id)
  {
    this.name = name;
    this.price= price;
    this.description = description;
    this.id= id;

  }

  /**
   * Basic constructor without id
   * @param name String
   * @param price double
   * @param description String
   */
  public GamingMerchandise(String name, Double price, String description)
  {
    this.name = name;
    this.price= price;
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

  public Double getPrice()
  {
    return price;
  }

  public void setPrice(Double price)
  {
    this.price = price;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  /**
   * Abstract method for setting the console type of a VideoGame or an Accessory
   * @param consoleType String
   */
  public abstract void setConsoleType(String consoleType);

}
