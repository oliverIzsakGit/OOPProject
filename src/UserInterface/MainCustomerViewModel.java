package UserInterface;

import Model.MainCustomerModel;
import Objects.GamingMerchandise;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
/**
 * View Model class for binding the controller class.
 */
public class MainCustomerViewModel
{
  private MainCustomerModel model;
  private StringProperty search;
  private StringProperty error;
  private ObservableList<GamingMerchandise> products;
  private ArrayList<GamingMerchandise> searchProductList;

  /**
   * Basic constructor
   * @param mainCustomerModel MainCustomerModel
   */
  public MainCustomerViewModel(MainCustomerModel mainCustomerModel)
  {
    model=mainCustomerModel;
    products = FXCollections.observableArrayList();
    searchProductList = new ArrayList<>();

    search= new SimpleStringProperty();
    error= new SimpleStringProperty();
    search.setValue("");
    error.setValue("");
  }

  public ObservableList<GamingMerchandise> getProducts()
  {
    return products;
  }

  /**
   * This method is responsible for updating the products table with the searched products.
   * The search type depends on the int type parameter, if 2, then its a console type search, if 1 its a name search, if 3 it is a max price search
   * @param type int representing the search type {1,2,3}
   * @return ObservableList of Gaming Merchandise
   */
  public ObservableList<GamingMerchandise> getSearchedProducts(int type)
  {
    int tempInt =0;
    String tempConsoleType=null;
    String tempName=null;
    if(search.getValue().equals(""))
    {
      error.setValue("Search field is empty.");
    }
    else
      if(type==2)
      {
        tempConsoleType=  search.getValue();
        searchProductList.clear();
        searchProductList.addAll(model.searchProduct(0,tempConsoleType,null));
        error.setValue("Done :)");
      }
      else if(type==1)
      {
        tempName=  search.getValue();
        searchProductList.clear();
        searchProductList.addAll(model.searchProduct(0,null,tempName));
        error.setValue("Done :)");
      }
      else if(type==3)
      {
        try
        {
          tempInt = Integer.parseInt( search.getValue());
          searchProductList.clear();
          searchProductList.addAll( model.searchProduct(tempInt,null,null));
          error.setValue("Done :)");
        }
        catch (Exception e)
        {
         error.setValue("Error ! wrong input.");
        }
      }
      else {error.setValue("Choose a search option :)");}
      if(error.getValue().equals("Done :)"))
      {
        products.clear();
        products.addAll(searchProductList);
      }

    return products;
  }
  public StringProperty getErrorProperty()
  {
    return error;
  }
  public StringProperty getSearchProperty()
  {
    return search;
  }

  /**
   * Refreshes the table by clearing the current observablelist and calling the updateStoreList method on the view model.
   */
  public void refreshList()
  {
    products.clear();
    ArrayList<GamingMerchandise> temp = model.updateStoreList();
    if(temp!=null)
    {
      products.addAll(temp);
    }
  }

  /**
   * Calls the updateStoreList method on the view model.
   */
  public void updateList()
  { ArrayList<GamingMerchandise> temp = model.updateStoreList();
  if(temp!=null)
  {
    products.addAll(temp);
  }

  }
}
