package Objects;

import java.io.Serializable;
/**
 * This class is representing any video game type item that can be found in the shop.
 * It extends the GamingMerchandise class. Has an own Console object, which represents the name of the console that this item can be used on.
 * @author Olivér Izsák
 */
public class VideoGames extends GamingMerchandise implements Serializable
{

  private Console consoleType;

  /**
   * Basic constructor with id
   * @param name String
   * @param price double
   * @param productId int
   * @param description String
   * @param ctype String
   */
  public VideoGames(String name, double price, int productId,
      String description,String ctype)
  {
   super(name,price,description,productId);
    consoleType=new Console(ctype);
  }

  /**
   * Basic constructor without id
   * @param name String
   * @param price double
   * @param description String
   * @param ctype  String
   */
  public VideoGames(String name, double price,
      String description,String ctype)
  {
    super(name,price,description);
    consoleType=new Console(ctype);
  }

public String getExactConsoleType()
{
  return consoleType.getName();
}
public void setExactConsoleType(String name)
{
   consoleType.setName(name);
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
