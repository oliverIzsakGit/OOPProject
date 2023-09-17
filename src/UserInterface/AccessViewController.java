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
public class AccessViewController
{
  @FXML private Button adminButton;
  @FXML private Button customerButton;
  private ViewHandler viewHandler;
  private AccessViewModel accessViewModel;

  /**
   * Initializer method
   * @param accessVM AccessViewModel
   * @param viewHandler ViewHandler
   */
  public void init(AccessViewModel accessVM, ViewHandler viewHandler)
  {

    this.viewHandler=viewHandler;
    this.accessViewModel= accessVM;
  }

  /**
   * Opens the customer GUI
   * @param actionEvent ActionEvent from the GUI.
   */
  public void openCustomer(ActionEvent actionEvent)
  {
    viewHandler.openMainCustomer();
  }

  /**
   * Opens the admin GUI
   * @param actionEvent ActionEvent from the GUI.
   */
  public void openAdmin(ActionEvent actionEvent)
  {
    viewHandler.openAdminEntry();
  }
}
