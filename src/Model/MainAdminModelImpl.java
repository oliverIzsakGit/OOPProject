package Model;

import Objects.*;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is responsible for deleting and searching products in the store as an admin
 */
public class MainAdminModelImpl implements MainAdminModel
{
  private ArrayList<GamingMerchandise> products;
  private Serializator<GamingMerchandise> ser;
  private File adminLogsFile = new File("AdminLogs.txt");
  private User admin = new Admin("admin","admin");

  /**
   * Basic constructor for initializing
   */
  public MainAdminModelImpl()
  {
    ser= new Serializator();
    products=new ArrayList<>();

  }

  /**
   * Method responsible for updating the products in the store
   * It updates the global arraylist of GamingMerchandise and the store bin file.
   * @return Arraylist of GamingMerchandise
   */
  @Override public ArrayList<GamingMerchandise> updateList()
  {

    try
    {
      products =ser.deserialize(Serializator.storeStorage);
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
   * Search function for a specific product.
   * The admin can search for a product with an id or with the name of the product.
   * @param tempInt id of the searched product
   * @param o name of the searched product
   * @return Arraylist of GamingMerchandise
   */
  @Override public ArrayList<GamingMerchandise> searchProduct(int tempInt,
      String o)
  {ArrayList<GamingMerchandise> results= new ArrayList<>();
    if(o==null )
    {
      for(int i =0; i<products.size();i++)
      {
        if(products.get(i).getId()==tempInt)
        {
          results.add(products.get(i));
        }
      }
    }
    else if(tempInt==0)
    {
      for(int i =0; i<products.size();i++)
      { String temp =products.get(i).getName();
        if((temp.toLowerCase()).equals(o.toLowerCase()))
        {
          results.add(products.get(i));
        }
      }
    }
    return results;
  }

  /**
   * It deletes the chosen product from the store and from the bin file.
   * The action is also logged
   * @param selectedSP selected GamingMerchandise
   */
  @Override public void deleteProduct(GamingMerchandise selectedSP)
  {
    products.remove(selectedSP);

    String text = "Deleted product from the Store:\n"+ "Product id: "+selectedSP.getId()+"\nProduct name: "+selectedSP.getName();
    admin.log(text);
    ser.serialize(products,Serializator.storeStorage);
  }

  /**
   * It returns the contents of the log file which keeps track of admin's actions.
   * @return arraylist of strings
   */
  @Override public ArrayList<String> getAdminLogs()
  {ArrayList<String> log = new ArrayList<>();
    Scanner fileReader = null;
    try
    {
      fileReader = new Scanner(adminLogsFile);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    while (fileReader.hasNextLine()) {
      String text = fileReader.nextLine();
      log.add(text);
    }
    fileReader.close();

    return log;
  }


}
