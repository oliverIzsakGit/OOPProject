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
public class MainAdminViewController
{
  @FXML private Button deleteButton;

  @FXML TextField searchField;

  @FXML Button searchButton;

  @FXML Button demandButton;
  @FXML Button storageButton;
  @FXML Button adminLogsButton;
  @FXML Label error;
  @FXML private TableView<GamingMerchandise> merchTable;
  @FXML private TableColumn<GamingMerchandise,Double> price;
  @FXML private TableColumn<GamingMerchandise,String> desc;
  @FXML private TableColumn<GamingMerchandise,String> name;
  @FXML private TableColumn<GamingMerchandise,Integer> id;

  private ViewHandler vh;
  private MainAdminViewModel viewModel;

  /**
   * Initializer method for binding some of the text fields and labels found in the FXML file.
   * @param mainVM MainAdminViewModel
   * @param viewHandler ViewHandler
   */
  public void init(MainAdminViewModel mainVM, ViewHandler viewHandler)
  {
    viewModel=mainVM;
    vh=viewHandler;
    merchTable.setItems(viewModel.getProducts());
    name.setCellValueFactory(new PropertyValueFactory<>("name"));
    id.setCellValueFactory(new PropertyValueFactory<>("id"));
    desc.setCellValueFactory(new PropertyValueFactory<>("description"));
    price.setCellValueFactory(new PropertyValueFactory<>("price"));
    searchField.textProperty().bindBidirectional(viewModel.getSearchProperty());
    error.textProperty().bind(viewModel.getErrorProperty());

    updateStorageList();
  }

  private void updateStorageList()
  {
    viewModel.updateList();
  }

  public void goStorage(ActionEvent actionEvent)
  {
    vh.openStorage();
  }

  public void checkDemands(ActionEvent actionEvent)
  {
    vh.openDemand();
  }

  public void search(ActionEvent actionEvent)
  {
    merchTable.setItems(viewModel.getSearchedProducts());
  }

  /**
   * This method checks whether a product was chosen for deletion, if yes then calls the deleteProduct method on the view model
   * If not then returns an error through the GUI.
   * @param actionEvent ActionEvent from the GUI.
   */
  public void delete(ActionEvent actionEvent)
  {if(merchTable.getSelectionModel().getSelectedItems().isEmpty()){

    error.textProperty().setValue("Choose a product");


  }else
  {
    TablePosition tp = merchTable.getSelectionModel().getSelectedCells().get(0);
    int row = tp.getRow();
    GamingMerchandise selectedSP = merchTable.getItems().get(row);


    viewModel.deleteProduct(selectedSP);



  }
  }

  /**
   * Calls the refreshList method on the view model
   * @param actionEvent  ActionEvent from the GUI.
   */
  public void refresh(ActionEvent actionEvent)
  {
    viewModel.refreshList();
  }

  /**
   * Exits this scene and opens the access scene.
   * @param actionEvent ActionEvent from the GUI.
   */
  public void exit(ActionEvent actionEvent)
  {
    vh.access();
  }

  /**
   * Opens the adminLogs scene.
   * @param actionEvent  ActionEvent from the GUI.
   */
  public void adminLogs(ActionEvent actionEvent)
  {
    vh.openAdminLogs();
  }
}
