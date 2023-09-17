package UserInterface;

import Factories.ViewHandler;

import Objects.GamingMerchandise;
import Objects.VideoGames;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
/**
 * Controller class for the Access FXML file.
 */
public class StorageViewController
{
  @FXML private Button addProductButton;
  @FXML  private Button deleteButton;
  @FXML  private Button Orders;
  @FXML   private Button backButton;
  @FXML  private Button addToStoreButton;
  @FXML private RadioButton radioAccess;
  @FXML private RadioButton radioConsole;
  @FXML private RadioButton  radioVideoGame;
  @FXML TextField descF;
  @FXML TextField nameF;
  @FXML TextField priceF;
  @FXML TextField typeF;
  @FXML Label error;
  @FXML Label consoleLabel;
  @FXML private TableView<GamingMerchandise> productTable;
  @FXML private TableColumn<GamingMerchandise,Double> price;
  @FXML private TableColumn<GamingMerchandise,String> desc;
  @FXML private TableColumn<GamingMerchandise,String> name;
  @FXML private TableColumn<GamingMerchandise,Integer> id;

  private ViewHandler vh;
  private StorageViewModel viewModel;
  /**
   * Initializer method that binds some of the textfields and labels found in the fxml file to the view model
   * @param storageVM StorageViewModel
   * @param viewHandler ViewHandler
   */
  public void init(StorageViewModel storageVM, ViewHandler viewHandler)
  {
    viewModel=storageVM;
    vh=viewHandler;
    productTable.setItems(viewModel.getProducts());
    name.setCellValueFactory(new PropertyValueFactory<>("name"));
    id.setCellValueFactory(new PropertyValueFactory<>("id"));
    desc.setCellValueFactory(new PropertyValueFactory<>("description"));

    price.setCellValueFactory(new PropertyValueFactory<>("price"));
    nameF.textProperty().bindBidirectional(viewModel.getNameProperty());
    error.textProperty().bind(viewModel.getErrorProperty());
    consoleLabel.textProperty().bind(viewModel.getConsoleProperty());
    priceF.textProperty().bindBidirectional(viewModel.getPriceProperty());
    descF.textProperty().bindBidirectional(viewModel.getDescProperty());
    typeF.textProperty().bindBidirectional(viewModel.getTypeProperty());
    updateStorageList();
  }

  /**
   * Updates the table by calling the updateList method on the view model.
   */
  private void updateStorageList()
  {
    viewModel.updateList();
  }

  /**
   * Checks the chosen product from the table and calls the addToStore method on the view model with the chosen product as parameter.
   * If there is no chosen product the parameter given is null.
   * @param actionEvent ActionEvent from the GUI.
   */
  public void addToStore(ActionEvent actionEvent)
  {
    if(productTable.getSelectionModel().getSelectedItems().isEmpty()){

          viewModel.addToStore(null);


    }else
    {
      TablePosition tp = productTable.getSelectionModel().getSelectedCells().get(0);
      int row = tp.getRow();
      GamingMerchandise selectedGM = productTable.getItems().get(row);


      viewModel.addToStore(selectedGM);



    }
  }

  /**
   * Checks which of the radio buttons is selected and depending on that calls the addProduct method with the parameter representing the
   * selected radio button. 2 = console, 1 = video game, 3 = accessory.
   * @param actionEvent ActionEvent from the GUI.
   */
  public void addProduct(ActionEvent actionEvent)
  { int type=0;
    if(radioConsole.isSelected())
    {
       type =2;
    }
    else if(radioVideoGame.isSelected()) {type=1;}
    else if(radioAccess.isSelected()){type=3;}

    viewModel.addProduct(type);
  }

  /**
   * Checks which product is selected from the table, and calls the deleteProduct method on the view model with the chosen product
   * as parameter. If there is no product chosen it shows an error message in the GUI.
   * @param actionEvent  ActionEvent from the GUI.
   */
  public void deleteProduct(ActionEvent actionEvent)
  {if(productTable.getSelectionModel().getSelectedItems().isEmpty()){

    error.textProperty().setValue("Choose a product");


  }else
  {
    TablePosition tp = productTable.getSelectionModel().getSelectedCells().get(0);
    int row = tp.getRow();
    GamingMerchandise selectedGM = productTable.getItems().get(row);


    viewModel.deleteProduct(selectedGM);



  }

  }

  /**
   * Opens the openOrders scene through the viewhandler
   * @param actionEvent ActionEvent from the GUI.
   */
  public void checkOrders(ActionEvent actionEvent)
  {
    vh.openOrders();
  }

  /**
   * Opens the openMainAdmin scene through the viewhandler.
   * @param actionEvent ActionEvent from the GUI.
   */
  public void goBack(ActionEvent actionEvent)
  {
    vh.openMainAdmin();
  }
  /**
   * Sets a typeF textField and consoleLabel label visible
   * @param actionEvent ActionEvent from the GUI.
   */
  public void radioVideoGame(ActionEvent actionEvent)
  {
    typeF.setVisible(true);
    consoleLabel.setVisible(true);
  }
  /**
   * Sets a typeF textField and consoleLabel label invisible
   * @param actionEvent ActionEvent from the GUI.
   */
  public void radioConsole(ActionEvent actionEvent)
  {
    typeF.setVisible(false);
    consoleLabel.setVisible(false);
  }
  /**
   * Sets a typeF textField and consoleLabel label invisible
   * @param actionEvent ActionEvent from the GUI.
   */
  public void radioAccess(ActionEvent actionEvent)
  {
    typeF.setVisible(true);
    consoleLabel.setVisible(true);
  }
}
