package UserInterface;

import Factories.ProductFactory;
import Model.StorageModel;
import Objects.*;
import com.sun.org.apache.xerces.internal.xs.ItemPSVI;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * View Model class for binding the controller class.
 */
public class StorageViewModel
{

  private StorageModel model;
  private ObservableList<GamingMerchandise> products;
  private StringProperty name;
  private StringProperty desc;
  private StringProperty price;
  private StringProperty type;
  private StringProperty error;
  private StringProperty consoleLabel;

  /**
   * Basic constructor
   * It also a listener declaration for the Storage Model class, waiting for "IncomingOrder" event to fire, and according to that updating the  table in the GUI.
   * @param storageModel StorageModel
   */
  public StorageViewModel(StorageModel storageModel)
  {
    model = storageModel;
    products = FXCollections.observableArrayList();
    name= new SimpleStringProperty();
    consoleLabel= new SimpleStringProperty();
    desc = new SimpleStringProperty();
    price = new SimpleStringProperty();
    type = new SimpleStringProperty();
    error = new SimpleStringProperty();
    name.setValue("");
    desc.setValue("");
    price.setValue("");
    type.setValue("");
    consoleLabel.setValue("Console type");

    model.addListener("IncomingOrder",this::RefreshList); // Example of a Observer pattern
    //model.updateList();

  }

  /**
   * This method is called when the listener created in the constructor listens to an event called IncomingOrder
   * then it updates the current table.
   * @param propertyChangeEvent  PropertyChangeEvent fired from the Storage Model class.
   */
  private void RefreshList(PropertyChangeEvent propertyChangeEvent)
  {

    ArrayList<GamingMerchandise> list = (ArrayList<GamingMerchandise>) propertyChangeEvent.getNewValue();
    products.clear();
    products.addAll(list);
  }

  /**
   * Updates the current table and product list by calling the updateList method on the view model
   */
  public void updateList()
  {
    products.addAll(model.updateList());
  }


  public ObservableList<GamingMerchandise> getProducts()
  {
    return products;
  }

  /**
   * This method is responsible for adding a product to the Storage by calling the  addProduct method on the view model
   * having the specific information about the  product as the parameter.
   * @param radioButtonType int type of the gaming merchandise
   */
  public void addProduct(int radioButtonType)
  {
    double pric=0;
    error.setValue("New product added");
    if (radioButtonType==0){error.setValue("Select a product type!");}

    else if((name.getValue().equals("") || desc.getValue().equals("") || price.getValue().equals("") || type.getValue().equals("")) && radioButtonType!=2)
    {
      error.setValue("Fields are empty !");
    }
    else if((name.getValue().equals("") || desc.getValue().equals("") || price.getValue().equals("")) && radioButtonType==2)
    {
      error.setValue("Fields are empty !");
    }
    try
    {
      pric= Double.parseDouble(price.getValue());
    }
    catch (Exception  e)
    {

      error.setValue("Wrong input");
    }
    if(error.getValue().equals("New product added"))
    {  GamingMerchandise product=null ;


      products.add(model.addProduct(name.getValue(),pric,desc.getValue(),radioButtonType,type.getValue()));
      ;
    }


  }
  public StringProperty getNameProperty()
  {
    return name;
  }
  public StringProperty getDescProperty()
  {
    return desc;
  }
  public StringProperty getPriceProperty()
  {
    return price;
  }
  public StringProperty getTypeProperty()
  {
    return type;
  }

  public StringProperty getConsoleProperty()
  {
    return consoleLabel;
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }

  public void addToStore(GamingMerchandise selectedGM)
  {
   if(selectedGM==null){
     error.setValue("Choose a product!");
   }

    products.remove(selectedGM);
    model.addProductToStore(selectedGM);

  }

  public void deleteProduct(GamingMerchandise selectedGM)
  {
    products.remove(selectedGM);
    model.deleteProduct(selectedGM);
  }
}
