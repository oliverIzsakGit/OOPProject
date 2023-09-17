package UserInterface;

import Model.StorageModel;
import Objects.*;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
/**
 * View Model class for binding the controller class.
 */
public class OrdersViewModel
{

  public StringProperty desc;
  private StorageModel model;
  private ObservableList<OrderProduct> products;
  private StringProperty name;
  private StringProperty amount;
  private StringProperty price;
  private StringProperty type;
  private StringProperty error;
  private StringProperty arrivalM;
  private StringProperty arrivalD;
  private StringProperty arrivalY;

  /**
   * Basic constructor method
   * @param model StorageModel
   */
  public OrdersViewModel(StorageModel model)
  {
    this.model=model;
    products = FXCollections.observableArrayList();
    name= new SimpleStringProperty();
    arrivalM= new SimpleStringProperty();
    arrivalY= new SimpleStringProperty();
    arrivalD= new SimpleStringProperty();
    amount = new SimpleStringProperty();
    price = new SimpleStringProperty();
    type = new SimpleStringProperty();
    error = new SimpleStringProperty();
    desc = new SimpleStringProperty();

    name.setValue("");
    amount.setValue("");
    price.setValue("");
    type.setValue("");
    arrivalY.setValue("");
    arrivalM.setValue("");
    arrivalD.setValue("");
    desc.setValue("");
  }

  public StringProperty getNameProperty()
  {
    return name;
  }
  public StringProperty getAmountProperty()
  {
    return amount;
  }
  public StringProperty getPriceProperty()
  {
    return price;
  }
  public StringProperty getTypeProperty()
  {
    return type;
  }

  public StringProperty getArrivalMProperty()
  {
    return arrivalM;
  }
  public StringProperty getArrivalDProperty()
  {
    return arrivalD;
  }
  public StringProperty getArrivalYProperty()
  {
    return arrivalY;
  }
  public StringProperty getDescProperty()
  {
    return desc;
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }

  /**
   * Calls the updateOrderList method on the view model, and updates the current table with it.
   */
  public void updateList()
  {
    products.addAll(model.updateOrderList());
  }

  public ObservableList<OrderProduct> getOrders()
  {
    return products;
  }

  /**
   * Deletes the chosen product by calling the deleteOrderProduct on the view model.
   * @param selectedOP  ActionEvent from the GUI.
   */
  public void deleteProduct(OrderProduct selectedOP)
  {  products.remove(selectedOP);
    model.deleteOrderProduct(selectedOP);
  }

  /**
   * Adds a new ordered product to the table.
   * Depending on the radioButtonType int parameter it adds a videogame if 1, a console if 2, and an accessory if 3.
   * @param radioButtonType int representing the ordered product's GamingMerchandise type
   */
  public void addOrderProduct(int radioButtonType)
  {double tempPrice=0;
  int tempAmount=0;
  int tempDay = 0;
  int tempMonth = 0;
  int tempYear =0;


    error.setValue("New order added");
        if (radioButtonType==0){error.setValue("Select a product type!");}
    else if((name.getValue().equals("") || amount.getValue().equals("") || price.getValue().equals("") || type.getValue().equals("") ||
    arrivalD.getValue().equals("") || arrivalM.getValue().equals("") || arrivalY.getValue().equals("")) && radioButtonType!=2)
    {
      error.setValue("There is any empty field !");
    }
    else if((name.getValue().equals("") || amount.getValue().equals("") || price.getValue().equals("") ||
        arrivalD.getValue().equals("") || arrivalM.getValue().equals("") || arrivalY.getValue().equals("")) && radioButtonType==2)
    {
      error.setValue("There is any empty field !");
    }

     else
        {
          try
          {
            tempPrice = Double.parseDouble(price.getValue());
            tempAmount = Integer.parseInt(amount.getValue());
            tempDay = Integer.parseInt(arrivalD.getValue());
            tempMonth = Integer.parseInt(arrivalM.getValue());
            tempYear = Integer.parseInt(arrivalY.getValue());
          }
          catch (Exception e)
          {

            error.setValue("Wrong input");
          }
            try{
            LocalDate ld = LocalDate.of(tempYear,tempMonth,tempDay);
            LocalDate ldn = LocalDate.now();

            if(ld.isBefore(ldn)){

                throw new IncorrectDateException("Incorrect date");
            }}
            catch (IncorrectDateException in)
            {

              error.setValue(in.getMessage());
            }

        }
    if(error.getValue().equals("New order added"))
    {
      DateTime dt = new DateTime(tempDay,tempMonth,tempYear);
      String dateTime = dt.getSpecificDate();


      products.add(model.addOrder(name.getValue(),dateTime,tempAmount,tempPrice,desc.getValue(),type.getValue(),radioButtonType));
      name.setValue("");
      amount.setValue("");
      price.setValue("");
      type.setValue("");
      arrivalY.setValue("");
      arrivalM.setValue("");
      arrivalD.setValue("");
      desc.setValue("");


    }


  }

  /**
   * Adds the chosen product to the storage by calling the addOrderProductToStorage method on the view model.
   * @param selectedOP chosen OrderProduct
   */
  public void addToStorage(OrderProduct selectedOP)
  {
    products.remove(selectedOP);
    model.addOrderProductToStorage(selectedOP);
  }
}
