package Factories;

import Objects.Subject;
import UserInterface.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;

/**
 * This  class is responsible for managing all the fxml files, their controllers and their view models for the GUI.
 */
public class ViewHandler
{
  private ViewModelFactory vmf;
  private Scene access;
  private Scene adminAcces;
  private Scene config;
  private Scene main;
  private Scene orders;
  private Scene storage;
  private Scene demand;
  private Scene logs;
private Scene customer;
  private Scene cusDemand;
  private Stage stage;
  private Stage stage2;
  private Stage stage3;
  private Stage stage4;
  private Stage stage5;


  /**
   * Initializes the stages
   *
   * @param vmf view model factory
   */
  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
    stage = new Stage();
    stage2 = new Stage();
    stage3= new Stage();
    stage4=new Stage();
    stage5=new Stage();




  }


  /**
   * Opens the openSystem view
   */
  public void start()
  {

     config();

  }


  /**
   * If the scene(config) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void config()
  {
    FXMLLoader loader = new FXMLLoader();
    if (config == null)
    {
      Parent root = getRootByPath("../UserInterface/ConfigView.fxml",
          loader);
      ConfigViewController cvc = loader.getController();
      cvc.init(vmf.getConfigVM(), this);
      config = new Scene(root);
    }
    stage.setTitle("Create password");
    stage.setScene(config);

    stage.show();
  }

  /**
   * If the scene(access) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void access()
  {
    FXMLLoader loader = new FXMLLoader();
    if (access == null)
    {
      Parent root = getRootByPath("../UserInterface/AccessView.fxml",
          loader);
      AccessViewController avc = loader.getController();
      avc.init(vmf.getAccessVM(), this);
      access = new Scene(root);
    }
    stage.setTitle("GameStop");
    stage.setScene(access);

    stage.show();
  }

  /**
   * If the scene(customer) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openMainCustomer()
  {
    FXMLLoader loader = new FXMLLoader();
    if (customer == null)
    {
      Parent root = getRootByPath("../UserInterface/MainCustomerView.fxml",
          loader);
      MainCustomerViewController mcvc = loader.getController();
      mcvc.init(vmf.getMainCustomerVM(), this);
      customer = new Scene(root);
    }
    stage.setTitle("GameStop");
    stage.setScene(customer);

    stage.show();
  }

  /**
   * If the scene(main) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openMainAdmin()
  {
    FXMLLoader loader = new FXMLLoader();
    if (main == null)
    {
      Parent root = getRootByPath("../UserInterface/MainAdminView.fxml",
          loader);
      MainAdminViewController mvc = loader.getController();
      mvc.init(vmf.getMainAdminVM(), this);
      main = new Scene(root);
    }
    stage.setTitle("GameStop");
    stage.setScene(main);

    stage.show();
  }

  /**
   * If the scene(storage) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openStorage()
  {
    FXMLLoader loader = new FXMLLoader();
    if (storage == null)
    {
      Parent root = getRootByPath("../UserInterface/StorageView.fxml",
          loader);
      StorageViewController svc = loader.getController();
      svc.init(vmf.getStorageVM(), this);
      storage = new Scene(root);
    }
    stage.setTitle("GameStop");
    stage.setScene(storage);

    stage.show();
  }
  /**
   * Returns the root of the object hierarchy.
   *
   * @param path   path to the object
   * @param loader FXMLLoader
   * @return root of the object hierarchy
   */
  private Parent getRootByPath(String path, FXMLLoader loader)
  {
    loader.setLocation(getClass().getResource(path));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }




  /**
   * If the scene(adminAcces) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openAdminEntry()
  {

      FXMLLoader loader = new FXMLLoader();
      if (adminAcces == null)
      {
        Parent root = getRootByPath("../UserInterface/AdminEntryView.fxml",
            loader);
        AdminEntryViewController aevc = loader.getController();
        aevc.init(vmf.getAdminEntryVM(), this);
        adminAcces = new Scene(root);
      }
      stage.setTitle("Create password");
      stage.setScene(adminAcces);

      stage.show();
    }

  /**
   * If the scene(orders) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openOrders()
  {
    FXMLLoader loader = new FXMLLoader();
    if (orders == null)
    {
      Parent root = getRootByPath("../UserInterface/OrdersView.fxml",
          loader);
      OrdersViewController ovc = loader.getController();
      ovc.init(vmf.getOrderVM(), this);
      orders= new Scene(root);
    }
    stage2.setTitle("Orders");
    stage2.setScene(orders);

    stage2.show();
  }

  /**
   * If the scene(demand) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openDemand()
  {
    FXMLLoader loader = new FXMLLoader();
    if (demand == null)
    {
      Parent root = getRootByPath("../UserInterface/DemandView.fxml",
          loader);
      DemandViewController dvc = loader.getController();
      dvc.init(vmf.getDemandVM(), this);
      demand= new Scene(root);
    }
    stage3.setTitle("Demands");
    stage3.setScene(demand);

    stage3.show();
  }

  /**
   * If the scene(logs) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openAdminLogs()
  {
    FXMLLoader loader = new FXMLLoader();
    if (logs == null)
    {
      Parent root = getRootByPath("../UserInterface/AdminLogsView.fxml",
          loader);
      AdminLogsViewController alvc = loader.getController();
      alvc.init(vmf.getAdminLogVM(), this);
      logs= new Scene(root);
    }
    stage4.setTitle("Logs");
    stage4.setScene(logs);

    stage4.show();
  }

  /**
   * If the scene(cusDemand) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openCustomerDemands()
  {
    FXMLLoader loader = new FXMLLoader();
    if (cusDemand == null)
    {
      Parent root = getRootByPath("../UserInterface/CustomerDemandView.fxml",
          loader);
      CustomerDemandViewController cdvc = loader.getController();
      cdvc.init(vmf.getCustomerDemandVM(), this);
      cusDemand= new Scene(root);
    }
    stage5.setTitle("Demands");
    stage5.setScene(cusDemand);

    stage5.show();
  }

  /**
   * This method is responsible for exiting from a stage specified by the parameter
   * @param m int if 0 then closes stage 2 if 1 closes stage 3, if 2 closes stage 4, if 3 closes stage 5
   */
  public void exit(int m)
  { if(m==0)
  {
    stage2.close();
  }
  else if(m==1)
  {
    stage3.close();
  }
  else if(m==2)
  {
    stage4.close();
  }
  else if(m==3)
  {
    stage5.close();
  }

  }
}
