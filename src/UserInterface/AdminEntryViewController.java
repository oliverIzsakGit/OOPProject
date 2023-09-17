package UserInterface;

import Factories.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 * Controller class for the Access FXML file.
 */
public class AdminEntryViewController
{
  @FXML private Button loginButton;
  @FXML private TextField nameField;
  @FXML private PasswordField passField;
  @FXML private Label error;
  private ViewHandler viewHandler;
  private AdminEntryViewModel adminEntryViewModel;

  /**
   * Initializer method which also binds together some of the text fields in with the view model
   * @param adminEntryVM AdminEntryViewModel
   * @param viewHandler ViewHandler
   */
  public void init(AdminEntryViewModel adminEntryVM, ViewHandler viewHandler)
  {

    this.viewHandler=viewHandler;
    this.adminEntryViewModel=adminEntryVM;
    nameField.textProperty().bindBidirectional(adminEntryViewModel.getUserNameProperty());
    error.textProperty().bind(adminEntryViewModel.getErrorProperty());

    passField.textProperty().bindBidirectional(adminEntryViewModel.getPassword1Property());
  }

  /**
   * Opens the login GUI if the checkCredentials method returns true
   * @param actionEvent ActionEvent from the GUI.
   */
  public void login(ActionEvent actionEvent)
  {
    if(adminEntryViewModel.checkCredentials()){
      viewHandler.openMainAdmin();
    }
  }
}
