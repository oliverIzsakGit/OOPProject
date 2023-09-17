package UserInterface;

import Factories.ViewHandler;
import Objects.DateTime;
import Objects.Demand;
import Objects.OrderProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * Controller class for the Access FXML file.
 */
public class DemandViewController
{
  @FXML private TableView<Demand> demandTable;

  @FXML private TableColumn<Demand,String> name;
  @FXML private TableColumn<Demand,String> type;
  @FXML private TableColumn<Demand,Integer> amount;
  @FXML private TableColumn<Demand,String> comment;
  @FXML private TableColumn<Demand,String> date;


  private ViewHandler vh;
  private DemandViewModel viewModel;

  /**
   * Initializer method that initializes the table containing the customer demands
   * @param demVM DemandViewModel
   * @param viewHandler ViewHandler
   */
  public void init(DemandViewModel demVM, ViewHandler viewHandler)
  {
    vh = viewHandler;
    viewModel = demVM;
    demandTable.setItems(viewModel.getDemands());
    name.setCellValueFactory(new PropertyValueFactory<>("name"));
    amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
    type.setCellValueFactory(new PropertyValueFactory<>("type"));
    date.setCellValueFactory(new PropertyValueFactory<>("date"));
    comment.setCellValueFactory(new PropertyValueFactory<>("comment"));


    updateDemandList();
  }

  /**
   * Calls the updateDemandList method on the view model
   */
  private void updateDemandList()
  {
    viewModel.updateDemandList();
  }

  /**
   * Deletes the selected demand from the table and calls the deleteProduct method on the view model.
   * @param actionEvent ActionEvent from the GUI.
   */
  public void deleteDemand(ActionEvent actionEvent)
  {
    if(demandTable.getSelectionModel().getSelectedItems().isEmpty()){




    }else
    {
      TablePosition tp = demandTable.getSelectionModel().getSelectedCells().get(0);
      int row = tp.getRow();
      Demand selectedD = demandTable.getItems().get(row);


      viewModel.deleteProduct(selectedD);



    }
  }

  /**
   * Exits the current scene
   * @param actionEvent ActionEvent from the GUI.
   */
  public void exit(ActionEvent actionEvent)
  {
    vh.exit(3);
  }

  /**
   * Calls the refreshDemands method on the view model.
   * @param actionEvent  ActionEvent from the GUI.
   */
  public void refresh(ActionEvent actionEvent)
  {
    viewModel.refreshDemands();
  }
}
