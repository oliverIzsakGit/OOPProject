package UserInterface;

import Factories.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * Controller class for the Access FXML file.
 */
public class CustomerDemandViewController
{
 @FXML private RadioButton consoleRadio;
 @FXML private RadioButton accessoryRadio;
 @FXML private RadioButton gameRadio;
 @FXML private TextField name;
 @FXML private TextField consoleType;
 @FXML private TextField amount;
 @FXML private TextArea comment;
 @FXML private Label error;
 @FXML private Label ctype;
 @FXML private TextField arrivalD;
 @FXML private TextField arrivalM;
 @FXML private TextField arrivalY;

 private CustomerDemandViewModel model;
 private ViewHandler vh;

 /**
  * Initializer method which also binds together some of the text fields in the fxml file with the view model
  * @param customerDemandVM CustomerDemandViewModel
  * @param viewHandler ViewHandler
  */
  public void init(CustomerDemandViewModel customerDemandVM, ViewHandler viewHandler)
  {
    vh= viewHandler;
    model = customerDemandVM;

   name.textProperty().bindBidirectional(model.getNameProperty());
   error.textProperty().bind(model.getErrorProperty());

   amount.textProperty().bindBidirectional(model.getAmountProperty());
   comment.textProperty().bindBidirectional(model.getCommentProperty());
   consoleType.textProperty().bindBidirectional(model.getConsoleTypeProperty());
   arrivalM.textProperty().bindBidirectional(model.getArrivalMProperty());
   arrivalY.textProperty().bindBidirectional(model.getArrivalYProperty());
   arrivalD.textProperty().bindBidirectional(model.getArrivalDProperty());

  }

 /**
  *Exits the current scene
  * @param actionEvent ActionEvent from the GUI.
  */
 public void back(ActionEvent actionEvent)
  {
    vh.exit(3);
  }

 /**
  * Creates and sends the demand of the customer
  * Type 2 if the demanded product is a console, 3 if an accessory and 1 if a video game.
  * @param actionEvent ActionEvent from the GUI.
  */
  public void sendDemand(ActionEvent actionEvent)
  {int type=0;
   if(consoleRadio.isSelected())
   {
    type =2;
   }
   else if(gameRadio.isSelected()) {type=1;}
   else if(accessoryRadio.isSelected()){type=3;}

   model.sendDemand(type);
  }

 /**
  * This method sets a GamingMerchandise specific textfield visible
  * @param actionEvent ActionEvent from the GUI.
  */
  public void radioGame(ActionEvent actionEvent)
  {
   consoleType.setVisible(true);
   ctype.setVisible(true);
  }
 /**
  * This method sets a GamingMerchandise specific textfield invisible
  * @param actionEvent ActionEvent from the GUI.
  */
  public void radioConsole(ActionEvent actionEvent)
  {
   consoleType.setVisible(false);
   ctype.setVisible(false);
  }
 /**
  * This method sets a GamingMerchandise specific textfield visible
  * @param actionEvent ActionEvent from the GUI.
  */
  public void radioAccessory(ActionEvent actionEvent)
  {
   consoleType.setVisible(true);
   ctype.setVisible(true);
  }
}
