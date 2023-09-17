package UserInterface;

import Model.MainCustomerModel;
import Objects.*;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * View Model class for binding the controller class.
 */
public class CustomerDemandViewModel
{
  private MainCustomerModel model;
  private StringProperty name;
  private StringProperty error;
  private StringProperty comment;
  private StringProperty amount;
  private StringProperty consoleType;

  private StringProperty arrivalM;
  private StringProperty arrivalD;
  private StringProperty arrivalY;

  /**
   * Basic constructor
   * @param mainCustomerModel MainCustomerModel
   */
  public CustomerDemandViewModel(MainCustomerModel mainCustomerModel)
  {
    model = mainCustomerModel;


    name= new SimpleStringProperty();
    error= new SimpleStringProperty();
    comment= new SimpleStringProperty();
    amount= new SimpleStringProperty();
    consoleType= new SimpleStringProperty();
    arrivalY= new SimpleStringProperty();
    arrivalM= new SimpleStringProperty();
    arrivalD= new SimpleStringProperty();
    name.setValue("");
    error.setValue("");
    amount.setValue("");
    comment.setValue("");
    consoleType.setValue("");
    arrivalY.setValue("");
    arrivalM.setValue("");
    arrivalD.setValue("");
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
  public StringProperty getNameProperty()
  {
    return name;
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }

  public StringProperty getAmountProperty()
  {
    return amount;
  }

  public StringProperty getCommentProperty()
  {
    return comment;
  }

  public StringProperty getConsoleTypeProperty()
  {
    return consoleType;
  }

  /**
   * Checks all the values of text fields and radiobuttons and if they are all filled correctly then calls the addDemand method on the view model.
   * @param type int type of the product that is being demanded by the customer
   */
  public void sendDemand(int type)
  {
    int amounto=0;
    int tempDay = 0;
    int tempMonth = 0;
    int tempYear =0;
    error.setValue("New demand sent");
    if (type==0){error.setValue("Select a console type!");}

    else if((name.getValue().equals("") || arrivalD.getValue().equals("") ||  arrivalY.getValue().equals("") || arrivalM.getValue().equals("") || comment.getValue().equals("") || amount.getValue().equals("") || consoleType.getValue().equals("")) && type!=2)
    {
      error.setValue("Empty field!");
    }
    else if((name.getValue().equals("") || arrivalD.getValue().equals("") ||  arrivalY.getValue().equals("") || arrivalM.getValue().equals("") || comment.getValue().equals("") || amount.getValue().equals("")) && type==2)
    {
      error.setValue("Empty field !");
    }
    try
    {
      amounto= Integer.parseInt(amount.getValue());
      tempDay =Integer.parseInt(arrivalD.getValue());
      tempMonth = Integer.parseInt(arrivalM.getValue());
      tempYear = Integer.parseInt(arrivalY.getValue());
    }
    catch (Exception  e)
    {

      error.setValue("Wrong input in amount field");
    }
    try{
      LocalDate ld = null;LocalDate ldn = null;
      try
      {
         ld = LocalDate.of(tempYear, tempMonth, tempDay);
         ldn = LocalDate.now();
      } 
      catch (Exception e)
      {
       error.setValue("Incorrect date");       
      }
      if(ld.isBefore(ldn)){

        throw new IncorrectDateException("Incorrect date");
      }}
    catch (IncorrectDateException in)
    {

      error.setValue(in.getMessage());
    }
    
    if(error.getValue().equals("New demand sent"))
    {  Demand temp=null ;
      DateTime dt = new DateTime(tempDay,tempMonth,tempYear);

        model.addDemand(name.getValue(),amounto,comment.getValue(),consoleType.getValue(),dt,type);
        name.setValue("");
        error.setValue("");
        amount.setValue("");
        comment.setValue("");
        consoleType.setValue("");
        arrivalY.setValue("");
        arrivalM.setValue("");
        arrivalD.setValue("");




    }

  }
}
