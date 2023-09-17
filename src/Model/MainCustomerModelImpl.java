package Model;

import Objects.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is responsible for searching for products and updating the store product list for the customers.
 */
public class MainCustomerModelImpl implements MainCustomerModel
{
  private ArrayList<GamingMerchandise> products;
  private Serializator<Demand> ser;
  private  Serializator<GamingMerchandise> ser2;
  private User user;
  /**
   * Basic constructor for initializing
   */
  public MainCustomerModelImpl()
  {
    ser= new Serializator();
    user = new Customer();
    ser2= new Serializator<>();

  }

  /**
   * This is a search method for Customers.
   * The actions of this method are logged
   * It consists of 3 different types of searches:
   * Search for products below a certain price
   * Search for products with a specific name
   * Search for products with a specific console type they can be used on
   * @param price int price and below
   * @param tempConsoleType String console type
   * @param name String name of the product
   * @return ArrayList of gaming merchandise
   */
  @Override public ArrayList<GamingMerchandise> searchProduct(int price,
      String tempConsoleType, String name)
  {
    ArrayList<GamingMerchandise> results= new ArrayList<>();
    if(tempConsoleType==null && name==null )
    {
      user.log("User searched for product with the prize of " + price +"\n");

    for(int i =0; i<products.size();i++)
      {
        if(products.get(i).getPrice()<=price)
        {
          results.add(products.get(i));
        }
      }
    }
    else if(name!=null)
    {user.log("User searched for product with the name of " + name +"\n");
      for(int i =0; i<products.size();i++)
      { String temp =products.get(i).getName();
        if((temp.toLowerCase()).equals(name.toLowerCase()))
        {
          results.add(products.get(i));
        }
      }
    }
    else if(tempConsoleType!=null)
    {user.log("User searched for product with the console type of " + tempConsoleType +"\n");
      for(int i =0; i<products.size();i++)
      { String temp =null;
       if(products.get(i) instanceof VideoGames)
       {temp = ((VideoGames)products.get(i)).getExactConsoleType();

         if((temp.toLowerCase()).equals(tempConsoleType.toLowerCase()))
         {
           results.add(products.get(i));
         }
       }
       else if(products.get(i) instanceof  Accessories)
       {temp = ((Accessories)products.get(i)).getConsoleType();

         if((temp.toLowerCase()).equals(tempConsoleType.toLowerCase()))
         {
           results.add(products.get(i));
         }
       }

      }
    }
    return results;
  }

  /**
   * This method updates the store list and the bin file.
   * @return Arraylist of GamingMerchandise
   */
  @Override public ArrayList<GamingMerchandise> updateStoreList()
  {
    try
    {
      products =ser2.deserialize(Serializator.storeStorage);
    }
    catch (FileNotFoundException e)
    {
      ser.serialize(null,Serializator.storeStorage);
    }
    catch (IOException e)
    {
      e.printStackTrace();
      System.out.println("Error with file\n");
    }

    return products;
  }

  /**
   *This adds a new demand to the Customer's demand list and updates the log file too.
   *
   * @param value String name of the product
   * @param amounto int amount of the product
   * @param value1 String comment
   * @param value2 String console type
   * @param dt DateTime time of arrival
   * @param type type of product, 1 = video game, 2 = console, 3= accessory
   */
  @Override public void addDemand(String value, int amounto, String value1,
      String value2, DateTime dt, int type)
  {
    updateList();
    Demand temp = null;
    if (type == 1)
    {
      temp =new Demand(value,"Video Game",amounto,value1,value2,dt);
      temp.setConsoleType(value2);

    }
    else if (type == 2)
    {
      temp =new Demand(value,"Console",amounto,value1,value2,dt);
    }
    else if(type==3)
    {
      temp =new Demand(value,"Accessory",amounto,value1,value2,dt);
      temp.setConsoleType(value2);

    }
    user.addDemand(temp);
    ser.serialize(((Customer) user).getDemandList(),Serializator.customerLogs);
  }



  /**
   * This method updates the demand list and the demands bin file
   */
  private void updateList()
  {ArrayList<Demand> dmnds=new ArrayList<>();
    try
    {
      dmnds= ser.deserialize(Serializator.customerLogs);
    }
    catch (IOException e)
    {
      System.out.println("error with file");
    }
    ((Customer)user).setDemandList(dmnds);
  }
}
