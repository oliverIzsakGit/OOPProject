package Factories;

import Model.*;
import UserInterface.MainCustomerViewModel;

/**
 * This class is responsible for creating all instances of the model implementations that can be found in the model package using lazy instantiation
 * It also has a get method for each model to return the instance of it
 */
public class ModelFactory
{
  private AccessModel accessModel;
  private MainAdminModel mainAdminModel;
  private StorageModel storageModel;
  private ConfigModel configModel;
  private DemandModel demandModel;
  private MainCustomerModel customerModel;



  public AccessModel getAccessModel()
  {
    if (accessModel == null)
    {
      accessModel = new AccessModelImpl();
    }
    return accessModel;
  }
  public ConfigModel getConfigModel()
  {
    if (configModel == null)
    {
      configModel = new ConfigModelImp();
    }
    return configModel;
  }


  public MainAdminModel getMainAdminModel()
  {
    if (mainAdminModel == null)
    {
      mainAdminModel =new MainAdminModelImpl();
    }
    return mainAdminModel;
  }

  public StorageModel getStorageModel()
  {
    if (storageModel == null)
    {
      storageModel = new StorageModelImpl();
    }
    return storageModel;
  }

  public DemandModel getDemandModel()
  {
    if (demandModel== null)
    {
      demandModel= new DemandModelImpl();
    }
    return demandModel;
  }

  public MainCustomerModel getMainCustomerModel()
  {
    if (customerModel== null)
    {
      customerModel= new MainCustomerModelImpl();
    }
    return customerModel;
  }
}
