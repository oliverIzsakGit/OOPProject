package Objects;

import java.io.Serializable;

/**
 * This class is representing any accessory type item that can be found in the shop.
 * It extends the GamingMerchandise class. Has an own Console object, which represents the name of the console that this item can be used on.
 * @author Olivér Izsák
 */
public class Accessories extends GamingMerchandise implements Serializable
{

  private Console consoleType;


  /**
   * Basic constructor with id
   * @param name String name of the product
   * @param id int id of the product
   * @param price double price of the product
   * @param description String description of the product
   * @param ctype Console the type of console the product was made for
   */
  public Accessories(String name, int id, double price, String description,String ctype)
  {
    super(name,price,description,id);

    consoleType= new Console(ctype);
  }

  /**
   * Basic constructor without id.
   * @param name String name of the product
   * @param price double price of the product
   * @param description String description of the product
   * @param ctype Console the type of console the product was made for
   */
  public Accessories(String name, double price, String description,String ctype)
  {
   super(name,price,description);
    consoleType= new Console(ctype);
  }

  /**
   * This methods return the name of the Console this accessory can be used on.
   * @return String name of the console
   */
  public String getConsoleType()
  {
    return consoleType.getName();
  }

  /**
   * This method is repsonsible for setting the name of the Console this product can be used on
   * and also adding this information to the product's description
   * @param consoleType String containing the name of the console
   */
  @Override public void setConsoleType(String consoleType)
  {
    this.consoleType = new Console(consoleType);
    super.setDescription(super.getDescription()+"\nConsole : "+ consoleType+ " \n");
  }


}
