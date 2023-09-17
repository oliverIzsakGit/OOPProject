package UserInterface;

import Model.MainAdminModel;
import Objects.GamingMerchandise;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
/**
 * View Model class for binding the controller class.
 */
public class MainAdminViewModel
{
  private MainAdminModel model;
  private ObservableList<GamingMerchandise> products;

  private ArrayList<GamingMerchandise> searchProductList;
  private StringProperty search;
  private StringProperty error;

  /**
   * Basic constructor
   * @param mainModel MainAdminModel
   */
  public MainAdminViewModel(MainAdminModel mainModel)
  {
    model=mainModel;
    products = FXCollections.observableArrayList();
    searchProductList = new ArrayList<>();

    search= new SimpleStringProperty();
    error= new SimpleStringProperty();
    search.setValue("");
    error.setValue("");

  }

  public StringProperty getErrorProperty()
  {
    return error;
  }
  public StringProperty getSearchProperty()
  {
    return search;
  }

  public ObservableList<GamingMerchandise> getProducts()
  {
    return products;
  }

  /**
   * It refreshes the table with the products that contain the same id or name as given by the admin
   * Shows error message if search field is empty.
   * @return ObservableList GamingMerchandise
   */
  public ObservableList<GamingMerchandise> getSearchedProducts()
  {  int tempInt =0;
     String tempString=null;
    if(search.getValue().equals(""))
    {
      error.setValue("Search field is empty.");
    }
    else
      try
      {
        tempInt = Integer.parseInt( search.getValue());
        searchProductList.clear();
       searchProductList.addAll( model.searchProduct(tempInt,null));
      }
      catch (Exception e)
      {
        tempString=  search.getValue();
        searchProductList.clear();
            searchProductList.addAll(model.searchProduct(0,tempString));

      }
      products.clear();
      products.addAll(searchProductList);
    return products;
  }

  /**
   * Updates the current table and the list of products
   */
  public void updateList()
  {
    ArrayList<GamingMerchandise> temp = model.updateList();
    if(temp!=null)
    {
      products.addAll(temp);
    }

  }

  /**
   * Refreshes the table and list of products
   */
  public void refreshList()
  {
    products.clear();


    ArrayList<GamingMerchandise> temp = model.updateList();
    if(temp!=null)
    {
      products.addAll(temp);
    }


  }

  /**
   * This method is responsible for deleting the chosen product from the table and the product list.
   * @param selectedSP chosen GamingMerchandise
   */
  public void deleteProduct(GamingMerchandise selectedSP)
  {
    products.remove(selectedSP);
    model.deleteProduct(selectedSP);
  }
}
