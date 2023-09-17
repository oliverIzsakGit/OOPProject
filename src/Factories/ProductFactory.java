package Factories;
import Objects.Accessories;
import Objects.Console;
import Objects.GamingMerchandise;
import Objects.VideoGames;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for creating GamingMerchandise products without making too many objects to take up place
 * With flyweight method it only creates 1 instance of a specific object and it always returns the same object whenever it is created later on
 *
 */
public class ProductFactory
{
    private static Map<String,GamingMerchandise> merchType = new HashMap<>();

  /**
   * This static method can be called whenever a GamingMerchandise object is created while the program is running.
   * It creates an instance if the object with a same name is not found in the hashmap.
   * If it is already found in the hashmap the instance of that object is returned.
   * @param name String name
   * @param price double price
   * @param description String comment
   * @param type String type of the product
   * @param consoleType String type of the console it can be used on
   * @return GamingMerchandise object
   */
  public static GamingMerchandise getGamingMerchType(String name,double price,String description,String type,String consoleType) {
    GamingMerchandise result = merchType.get(name);
    if (result == null) {

      if(type.equals("V"))
      {
        result = new VideoGames(name,price,merchType.size()+1,description,consoleType);
        result.setConsoleType(consoleType);
      }
      else if(type.equals("A")){
        result = new Accessories(name,merchType.size()+1,price,description,consoleType);
        result.setConsoleType(consoleType);
      }else if(type.equals("C"))
      {
        result = new Console(merchType.size()+1,name,price,description);
      }

      merchType.put(name, result);
    }
    return result;
  }

}
