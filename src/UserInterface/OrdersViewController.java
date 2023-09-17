package UserInterface;

import Factories.ViewHandler;
import Objects.GamingMerchandise;
import Objects.OrderProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * Controller class for the Access FXML file.
 */
public class OrdersViewController
{

  @FXML private Button deleteButton;
  @FXML  private Button addOrder;
  @FXML  private Button exitButton;

  @FXML private TextField arrivalD;
  @FXML private TextField arrivalM;
  @FXML private TextField arrivalY;

  @FXML private TextField nameF;
  @FXML private TextField priceF;
  @FXML private TextField typeF;
  @FXML private TextField amountF;
  @FXML private TextArea descF;
  @FXML private RadioButton accessoryRadio;
  @FXML private RadioButton videoGameRadio;
  @FXML private RadioButton consoleRadio;
  @FXML Label error;
  @FXML private TableView<OrderProduct> orderTable;
  @FXML private TableColumn<OrderProduct,Double> price;
  @FXML private TableColumn<OrderProduct,String> name;
  @FXML private TableColumn<OrderProduct,String> type;
  @FXML private TableColumn<OrderProduct,Integer> amount;
  @FXML private TableColumn<OrderProduct,String> arrival;
  @FXML private TableColumn<OrderProduct,String> desc;

  private ViewHandler vh;
  private OrdersViewModel viewModel;

  /**
   * Initializer method that binds some of the textfields and labels found in the fxml file to the view model
   * @param orderVM OrdersViewModel
   * @param viewHandler ViewHandler
   */
  public void init(OrdersViewModel orderVM, ViewHandler viewHandler)
  {
    vh=viewHandler;
  viewModel= orderVM;
    orderTable.setItems(viewModel.getOrders());
    name.setCellValueFactory(new PropertyValueFactory<>("name"));
    amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
    type.setCellValueFactory(new PropertyValueFactory<>("type"));
    price.setCellValueFactory(new PropertyValueFactory<>("price"));
    arrival.setCellValueFactory(new PropertyValueFactory<>("arrival"));
    desc.setCellValueFactory(new PropertyValueFactory<>("description"));
    nameF.textProperty().bindBidirectional(viewModel.getNameProperty());
    error.textProperty().bind(viewModel.getErrorProperty());
    descF.textProperty().bindBidirectional(viewModel.getDescProperty());
    arrivalM.textProperty().bindBidirectional(viewModel.getArrivalMProperty());
    arrivalY.textProperty().bindBidirectional(viewModel.getArrivalYProperty());
    arrivalD.textProperty().bindBidirectional(viewModel.getArrivalDProperty());
    priceF.textProperty().bindBidirectional(viewModel.getPriceProperty());
    amountF.textProperty().bindBidirectional(viewModel.getAmountProperty());
    typeF.textProperty().bindBidirectional(viewModel.getTypeProperty());
    updateOrderList();
  }

  /**
   * Calls the updateList method on the view model
   */
  private void updateOrderList()
  {
    viewModel.updateList();
  }

  /**
   * If a product is selected from the table  then calls deleteProduct method on the view model
   * else shows an error in the GUI.
   * @param actionEvent ActionEvent from the GUI.
   */
  public void deleteOrder(ActionEvent actionEvent)
  {
    if(orderTable.getSelectionModel().getSelectedItems().isEmpty()){

      error.textProperty().setValue("Choose an order");


    }else
    {
      TablePosition tp = orderTable.getSelectionModel().getSelectedCells().get(0);
      int row = tp.getRow();
     OrderProduct selectedOP = orderTable.getItems().get(row);


      viewModel.deleteProduct(selectedOP);



    }
  }

  /**
   * Exits the current scene
   * @param actionEvent ActionEvent from the GUI.
   */
  public void exit(ActionEvent actionEvent)
  {
    vh.exit(0);
  }

  /**
   * Decides the type of order being added to the order list depending on the radio button selected, then calls the addOrderProduct
   * method on the view model with the int parameter corresponding to the specific radio button
   * @param actionEvent ActionEvent from the GUI.
   */
  public void addOrder(ActionEvent actionEvent)
  {
    int type=0;
    if(consoleRadio.isSelected())
    {
      type =2;
    }
    else if(videoGameRadio.isSelected()) {type=1;}
    else if(accessoryRadio.isSelected()){type=3;}


      viewModel.addOrderProduct(type);

  }

  /**
   * If there is a order selected from the table, calls the addToStorage method on the view model,
   * if there is no order selected it shows an error message in the GUI.
   * @param actionEvent ActionEvent from the GUI.
   */
  public void addToStorage(ActionEvent actionEvent)
  {
    if (orderTable.getSelectionModel().getSelectedItems().isEmpty())
    {

      error.textProperty().setValue("Choose an order");

    }
    else
    {
      TablePosition tp = orderTable.getSelectionModel().getSelectedCells().get(0);
      int row = tp.getRow();
      OrderProduct selectedOP = orderTable.getItems().get(row);

      viewModel.addToStorage(selectedOP);
    }
  }

  /**
   * Sets a typeF textField invisible
   * @param actionEvent ActionEvent from the GUI.
   */
  public void consoleRadioOn(ActionEvent actionEvent)
  {
    typeF.setVisible(false);

  }
  /**
   * Sets a typeF textField visible
   * @param actionEvent ActionEvent from the GUI.
   */
  public void videoGameRadioOn(ActionEvent actionEvent)
  {
    typeF.setVisible(true);
  }
  /**
   * Sets a typeF textField invisible
   * @param actionEvent ActionEvent from the GUI.
   */
  public void accessoryRadioOn(ActionEvent actionEvent)
  {
    typeF.setVisible(true);
  }
}
