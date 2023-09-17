package Objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Customer class extends User. This class is responsible for creating demands.
 * @author  Olivér Izsák
 */
public class Customer extends User implements Serializable
{

  private ArrayList<Demand> demandList;
  private Log logger;

  /**
   * basic constructor initializing an arraylist containing demands
   */
  public Customer()
  {

    demandList = new ArrayList<>();

  }


  public ArrayList<Demand> getDemandList()
  {
    return demandList;
  }



  public void setDemandList(ArrayList<Demand> list)
  {
    demandList = list;
  }
  @Override public void log(String text)
  {
    logger = Log.getLogEntryCustomer() ;
    logger.add(text,1);
  }

  /**
   * This method is responsible for adding the chosen demand to the demand list for the admin.
   * This action is also logged.
   * @param d current Demand object
   */
  @Override public void addDemand(Demand d)
  {

    if(demandList==null)
    {
      demandList= new ArrayList<>();
      demandList.add(d);
    }
    else  demandList.add(d);

    log("A customer has created a new demand:\nName: " + d.getName() + "\nType: "
        + d.getType() + "\nAmount: " + d.getAmount() + "\nDate: "
        + d.getDate());
  }
}
