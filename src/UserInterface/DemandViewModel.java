package UserInterface;

import Model.DemandModel;
import Model.StorageModel;
import Objects.Demand;
import Objects.OrderProduct;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
/**
 * View Model class for binding the controller class.
 */
public class DemandViewModel
{


  private DemandModel model;
  private ObservableList<Demand> demands;

  /**
   * Basic constructor
   * @param model DemandModel
   */
  public DemandViewModel(DemandModel model)
  {
    this.model = model;
    demands = FXCollections.observableArrayList();
  }

  public ObservableList<Demand> getDemands()
  {
    return demands;
  }

  /**
   * Updates the demand list by calling the updateDemandList method on the model
   */
  public void updateDemandList()
  {
    ArrayList<Demand> dmns= null;
    if((dmns = model.updateDemandList())==null)
    {

    }
    else
    {

      demands.addAll(dmns);
    }
  }

  /**
   * Deletes a product from the demand list and calls the deleteDemand method on the model-
   * @param selectedD selected Demand
   */
  public void deleteProduct(Demand selectedD)
  {
    demands.remove(selectedD);
    model.deleteDemand(selectedD);
  }

  /**
   * Calls the updateDemandList method on the model.
   */
  public void refreshDemands()
  {
    demands.clear();
    ArrayList<Demand> dmns= null;
    if((dmns = model.updateDemandList())==null)
    {

    }
    else
    {
      demands.addAll(dmns);
    }

  }
}
