package UserInterface;

import Factories.ViewHandler;
import Objects.GamingMerchandise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * Controller class for the Access FXML file.
 */
public class MainCustomerViewController
{
  @FXML private Button searchButton;
  @FXML private Button refreshButton;
  @FXML private TextField searchF;
  @FXML private Label error;
  @FXML private RadioButton nameRadio;
  @FXML private RadioButton priceRadio;
  @FXML private RadioButton consoleTypeRadio;
  @FXML private TableView<GamingMerchandise> productTable;
  @FXML private TableColumn<GamingMerchandise,Double> price;
  @FXML private TableColumn<GamingMerchandise,String> desc;
  @FXML private TableColumn<GamingMerchandise,String> name;
  @FXML private TableColumn<GamingMerchandise,String> productType;

  private MainCustomerViewModel model;
  private ViewHandler vh;

  /**
   * Initializer method
   * @param mainCustomerVM MainCustomerViewModel
   * @param viewHandler ViewHandler
   */
  public void init(MainCustomerViewModel mainCustomerVM, ViewHandler viewHandler)
  {
    model=mainCustomerVM;
    vh=viewHandler;
    productTable.setItems(model.getProducts());
    name.setCellValueFactory(new PropertyValueFactory<>("name"));
    productType.setCellValueFactory(new PropertyValueFactory<>("productType"));
    desc.setCellValueFactory(new PropertyValueFactory<>("description"));
    price.setCellValueFactory(new PropertyValueFactory<>("price"));
    searchF.textProperty().bindBidirectional(model.getSearchProperty());
    error.textProperty().bind(model.getErrorProperty());

    updateStorageList();
  }

  /**
   * Calls the updateList method on the view model
   */
  private void updateStorageList()
  {
    model.updateList();
  }

  /**
   * Calls the refreshList method on the view model
   * @param actionEvent ActionEvent from the GUI.
   */
  public void refresh(ActionEvent actionEvent)
  {
    model.refreshList();
  }

  /**
   * Calls the openCustomerDemands method on the view model
   * @param actionEvent ActionEvent from the GUI.
   */
  public void createDemand(ActionEvent actionEvent)
  {
    vh.openCustomerDemands();
  }

  /**
   * This method creates an int value depending on the current radio button selected and calls the
   * getSearchedProducts method on the view model.
   * @param actionEvent ActionEvent from the GUI.
   */
  public void searchForProduct(ActionEvent actionEvent)
  {
    int type=0;
    if(consoleTypeRadio.isSelected())
    {
      type =2;
    }
    else if(nameRadio.isSelected()) {type=1;}
    else if(priceRadio.isSelected()){type=3;}


    model.getSearchedProducts(type);
  }

}
