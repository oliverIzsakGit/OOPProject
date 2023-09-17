package UserInterface;

import Factories.ViewHandler;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;
/**
 * Controller class for the Access FXML file.
 */
public class ConfigViewController
{
  @FXML private Button createButton;
  @FXML private PasswordField passField1;
  @FXML private PasswordField passField2;
  @FXML private Label errorField;
  @FXML private TextField nameField;


  private ViewHandler viewHandler;
  private ConfigViewModel configViewModel;
  /**
   * Initializer method which also binds together some of the text fields in the fxml file with the view model
   * @param configVM ConfigViewModel
   * @param viewHandler ViewHandler
   */
  public void init(ConfigViewModel configVM, ViewHandler viewHandler)
  {
    configViewModel= configVM;
    this.viewHandler= viewHandler;
    Platform.runLater(this::isAccess);
    nameField.textProperty().bindBidirectional(configViewModel.getUserNameProperty());
    errorField.textProperty().bind(configViewModel.getErrorProperty());

    passField1.textProperty().bindBidirectional(configViewModel.getPassword1Property());
    passField2.textProperty().bindBidirectional(configViewModel.getPassword2Property());
  }

  /**
   * This method checks whether the access scene should be open, if the isAccess method that is called on the view model, returns true
   */
  public void isAccess()
{

  if (configViewModel.isAccess())
  {
    viewHandler.access();
  }
}

  /**
   * This method checks whether the access scene should be open, if the checkCredentials method that is called on the view model, returns true
   * @param actionEvent ActionEvent from the GUI.
   */
  public void createAdmin(ActionEvent actionEvent)
  {
    if(configViewModel.checkCredentials())
    {
      viewHandler.access();
    }

  }
}
