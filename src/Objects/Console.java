package Objects;

import java.io.Serializable;
/**
 * This class is representing any Console type item that can be found in the shop.
 * It extends the GamingMerchandise class.
 * @author Olivér Izsák
 */
public class Console extends GamingMerchandise implements Serializable
{

  /**
   * Basic constructor with id
   * @param name String name of the product
   * @param id int id of the product
   * @param price double price of the product
   * @param description String description of the product
   */
  public Console(int id, String name, double price, String description)
  {
    super(name,price,description,id);
  }
  /**
   * Basic constructor without id
   * @param name String name of the product
   * @param price double price of the product
   * @param description String description of the product
   */
  public Console( String name, double price, String description)
  {
    super(name,price,description);
  }

  /**
   * Basic constructor for other GamingMerchandise that can be used on a specific console.
   * @param name String name of the product
   */
  public Console(String name)
  {
    super(name,null,null);

  }

  /**
   * This method is not used since Console doesn't have another console type.
   * @param consoleType String name of the console
   */
  @Override public void setConsoleType(String consoleType)
  {

  }

}
