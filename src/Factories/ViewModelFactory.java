package Factories;

import UserInterface.*;

/**
 * This class is responsible for creating all instances of the view models that can be found in the UserInterface package using lazy instantiation
 * It also has a get method for each model to return the instance of it
 */
public class ViewModelFactory
{

  private ModelFactory model;
  private AccessViewModel accessViewModel;
  private MainAdminViewModel mainAdminViewModel;
  private DemandViewModel demandViewModel;
  private StorageViewModel storageViewModel;
  private ConfigViewModel configViewModel;
  private AdminEntryViewModel adminEntryViewModel;
  private OrdersViewModel ordersViewModel;
  private AdminLogsViewModel adminLogViewModel;
  private MainCustomerViewModel mainCustomerViewModel;
  private CustomerDemandViewModel customerDemand;

  public ViewModelFactory(ModelFactory mf)
  {
    model = mf;

  }


  public AccessViewModel getAccessVM()
  {
    if (accessViewModel == null)
    {
      accessViewModel = new AccessViewModel(model.getAccessModel());
    }
    return accessViewModel;
  }
  public AdminEntryViewModel getAdminEntryVM()
  {
    if (adminEntryViewModel == null)
    {
      adminEntryViewModel = new AdminEntryViewModel(model.getAccessModel());
    }
    return adminEntryViewModel;
  }
  public ConfigViewModel getConfigVM()
  {
    if (configViewModel == null)
    {
      configViewModel = new ConfigViewModel(model.getConfigModel());
    }
    return configViewModel;
  }
  public MainAdminViewModel getMainAdminVM()
  {
    if (mainAdminViewModel == null)
    {
      mainAdminViewModel = new MainAdminViewModel(model.getMainAdminModel());
    }
    return mainAdminViewModel;
  }
  public StorageViewModel getStorageVM()
  {
    if (storageViewModel == null)
    {
      storageViewModel = new StorageViewModel(model.getStorageModel());
    }
    return storageViewModel;
  }

  public OrdersViewModel getOrderVM()
  {
   if(ordersViewModel==null)
   {
     ordersViewModel= new OrdersViewModel(model.getStorageModel());
   }
    return ordersViewModel;
  }

  public DemandViewModel getDemandVM()
  {
    if(demandViewModel==null)
    {
      demandViewModel= new DemandViewModel(model.getDemandModel());
    }
    return demandViewModel;
  }

  public AdminLogsViewModel getAdminLogVM()
  {
    if(adminLogViewModel==null)
    {
      adminLogViewModel= new AdminLogsViewModel(model.getMainAdminModel());
    }
    return adminLogViewModel;

  }

  public MainCustomerViewModel  getMainCustomerVM()
  {
    if(mainCustomerViewModel ==null)
    {
      mainCustomerViewModel = new MainCustomerViewModel(model.getMainCustomerModel());
    }
    return mainCustomerViewModel;
  }

  public CustomerDemandViewModel  getCustomerDemandVM()
  {
    if(customerDemand ==null)
    {
      customerDemand = new CustomerDemandViewModel(model.getMainCustomerModel());
    }
    return customerDemand;
  }
}