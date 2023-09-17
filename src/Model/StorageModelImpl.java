package Model;

import Factories.ProductFactory;
import Objects.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is responsible for managing the storage by creating/deleting/updating new products and orders
 */
public class StorageModelImpl implements  StorageModel
{
  private PropertyChangeSupport support=new PropertyChangeSupport(this);
  private Serializator<GamingMerchandise> ser;
  private Serializator<OrderProduct> ser2;
  private ArrayList<GamingMerchandise> products;
  private ArrayList<GamingMerchandise> productsInStore;
  private ArrayList<OrderProduct> productsInOrder;
  private User admin = new Admin("admin","admin");
  /**
   * Basic constructor for initializing
   */
  public StorageModelImpl()
  {

    ser = new Serializator<>();
    ser2 = new Serializator<>();
    products=new ArrayList<>();
    productsInStore= new ArrayList<>();
    productsInOrder=new ArrayList<>();



  }

  /**
   * This method is responsible for updating all the storage and store bin file
   * @return Arraylist of GamingMerchandise
   */
  public ArrayList<GamingMerchandise> updateList()
  {

    try
    {
      products =ser.deserialize(Serializator.storageList);
    }
    catch (FileNotFoundException e)
    {
      ser.serialize(null,Serializator.storageList);
    }
    catch (IOException e)
    {
      System.out.println("Error with file\n");
    }
    try
    {
      productsInStore = ser.deserialize(Serializator.storeStorage);
    }
    catch (FileNotFoundException e)
    {

      ser.serialize(null,Serializator.storeStorage);
    }
    catch (IOException e)
    {
      System.out.println("Error with file\n");
    }

    if(products==null)
    {
      products=new ArrayList<>();
    }
    if(productsInStore==null)
    {
      productsInStore= new ArrayList<>();
    }
    return products;

  }

  /**
   * This method adds a newly created  product to the store
   * @param selectedGM GamingMerchandise new product
   */
  @Override public void addProductToStore(GamingMerchandise selectedGM)
  {
    if (selectedGM != null)
    {
      productsInStore.add(selectedGM);
      products.remove(selectedGM);

      String text = "Added Product from Storage to Store\n"+ "Product id: "+selectedGM.getId()+"\nProduct name: "+selectedGM.getName();
      admin.log(text);
      ser.serialize(productsInStore,Serializator.storeStorage);
      ser.serialize(products,Serializator.storageList);
    }


  }

  /**
   * This method deletes a chosen product
   * @param selectedGM GamingMerchandise selected product
   */
  @Override public void deleteProduct(GamingMerchandise selectedGM)
  {
    if(selectedGM!=null)
    {
      products.remove(selectedGM);

      String text = "Deleted product from Storage\n"+ "Product id: "+selectedGM.getId()+"\nProduct name: "+selectedGM.getName();
      admin.log(text);
      ser.serialize(products,Serializator.storageList);
    }

  }

  /**
   * This method updates the order list and bin file
   * @return OrderProduct ordered products
   */
  @Override public ArrayList<OrderProduct> updateOrderList()
  {
    try
    {

      productsInOrder=  ser2.deserialize(Serializator.storageOrders);
    }
    catch (FileNotFoundException e)
    {


      ser2.serialize(null,Serializator.storageOrders);

    }
    catch (IOException e)
    {
      System.out.println("Error with file\n");
    }
    if(productsInOrder==null)
    {
      productsInOrder=new ArrayList<>();
    }
    return productsInOrder;
  }

  /**
   * This method deletes the chosen ordered product from the list and the bin file
   * @param selectedOP OrderProduct specific product
   */
  @Override public void deleteOrderProduct(OrderProduct selectedOP)
  {
    productsInOrder.remove(selectedOP);

    String text = "Deleted product from Orders:\n"+ "Product name: "+selectedOP.getName()+"\nProduct amount: "+selectedOP.getAmount()+"\nArrival date: "+selectedOP.getArrival();
    admin.log(text);
    ser2.serialize(productsInOrder,Serializator.storageOrders);
  }




  /**
   * This method adds  ordered products from the Storage to the store.
   * It also calculates their individual price using the amount and the overall price of the order
   * @param selectedOP OrderProduct selected product
   */
  @Override public void addOrderProductToStorage(OrderProduct selectedOP)
  {


    String type = selectedOP.getType();

    GamingMerchandise newProduct=null;
    for (int i =0; i<selectedOP.getAmount();i++)
    {
      if(type.toLowerCase().equals("console"))
      {
        newProduct = ProductFactory.getGamingMerchType(selectedOP.getName(),selectedOP.getPrice()/selectedOP.getAmount(),selectedOP.getDescription(),"C",null);
      }
    else if (type.toLowerCase().equals("videogame") || type.toLowerCase().equals("video game"))
    {
      newProduct = ProductFactory.getGamingMerchType(selectedOP.getName(),selectedOP.getPrice()/selectedOP.getAmount(),selectedOP.getDescription(),"V",selectedOP.getConsoleType().getName());
    }
    else
   {

     newProduct= ProductFactory.getGamingMerchType(selectedOP.getName(),selectedOP.getPrice()/selectedOP.getAmount(),selectedOP.getDescription(),"A",selectedOP.getConsoleType().getName());

   }


      String text= "Added ordered product from Orders to Storage:\n"+ "Product id: "+newProduct.getId()+"\nProduct name: "+newProduct.getName();

      admin.log(text);
      products.add(newProduct);
  }

    productsInOrder.remove(selectedOP);
    ser2.serialize(productsInOrder,Serializator.storageOrders);
    ser.serialize(products,Serializator.storageList);
    support.firePropertyChange("IncomingOrder",null,products); // firing a property change event to the StorageViewModel.

  }

  /**
   * This method adds a new order to the order list and bin file depending on the radio button selected in the GUI.
   * @param value String name of the product
   * @param dateTime DateTime the date of arrival of the product
   * @param tempAmount int amount
   * @param tempPrice double price
   * @param value1 String description
   * @param value2 String console type of the product
   * @param radioButtonType int radiobutton type representing the type of the of the product 1= Video game, 2= console, 3= accessory
   * @return OrderProduct product
   */
  @Override public OrderProduct addOrder(String value, String dateTime, int tempAmount,
      double tempPrice, String value1, String value2, int radioButtonType)
  {
    OrderProduct order =null;
    if(radioButtonType==1)
    {
      order = new OrderProduct(value,"Video Game",dateTime,tempAmount,tempPrice,value1,value2);
      order.setConsoleType(value2);


    }
    else if (radioButtonType==2)
    {
      order = new OrderProduct(value,"Console",dateTime,tempAmount,tempPrice,value1,value2);


    }
    else if(radioButtonType==3)
    {
      order = new OrderProduct(value,"Accessory",dateTime,tempAmount,tempPrice,value1,value2);
      order.setConsoleType(value2);

    }


    productsInOrder.add(order);

    String text = "Added a new order to Orders:\n"+ "Product name: "+order.getName()+"\nProduct amount: "+order.getAmount()+"\nArrival date: "+order.getArrival();

    admin.log(text);
    ser2.serialize(productsInOrder,Serializator.storageOrders);
   return order;
  }

  /**
   * This method creates a specific Gaming Merchandise through the use of the product factory.
   * @param value String name of the product
   * @param pric  double price
   * @param value1 String description
   * @param radioButtonType int determines the type of the Gaming Merchandise that is being created, 1 = VideoGame, 2 = Consoele, 3= Accessory
   * @param value2 String type of the console the product can be used on
   * @return GamingMerchandise product
   */
  @Override public GamingMerchandise addProduct(String value, double pric,
      String value1, int radioButtonType, String value2)
  {
    GamingMerchandise product=null;
    if(radioButtonType==1)
    {
      product  = ProductFactory.getGamingMerchType(value,pric,value1,"V",value2);
    }
    else if (radioButtonType==2)
    {

      product  = ProductFactory.getGamingMerchType(value,pric,value1,"C",null);

    }
    else if(radioButtonType==3)
    {
      product  = ProductFactory.getGamingMerchType(value,pric,value1,"A",value2);

    }

    String text = "Added a new Gaming Merchandise to Storage:\n"+ "Product id: "+product.getId()+"\nProduct name: "+product.getName();
    admin.log(text);
    products.add(product);
    ser.serialize(products,Serializator.storageList);
    return product;
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName,listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName,listener);
  }


}
