package Model;

import Objects.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is responsible for saving, updating and deleted demands for the admins.
 */
public class DemandModelImpl implements DemandModel
{
  private Serializator ser;
  private ArrayList<Demand> demands;
  private User admin = new Admin("admin","admin");
  /**
   * Basic constructor for initializing
   */
  public DemandModelImpl()
  {
    ser = new Serializator();
  }

  /**
   * This method updates  the demand list and the demands bin file
   * @return an arraylist of demand objects found in the file
   */
  @Override public ArrayList<Demand> updateDemandList()
  {
    try
    {
      demands =ser.deserialize(Serializator.customerLogs);

    }
    catch (FileNotFoundException e)
    {

      ser.serialize(null,Serializator.customerLogs);
    }
    catch (IOException e)
    {
      e.printStackTrace();
      System.out.println("Error with file\n");
    }
    System.out.println("demands: "+ demands);
    return demands;
  }

  /**
   * This method deletes a specific demand from the list and the demand bin file
   * @param selectedD selected Demand
   */
  @Override public void deleteDemand(Demand selectedD)
  {
    demands.remove(selectedD);
     admin.addDemand(selectedD);
    String text = "Deleted demand:\n"+ "Demand name: "+selectedD.getName()+"\nDemand date: "+selectedD.getDate();
    admin.log(text);
    ser.serialize(demands,Serializator.customerLogs);
  }
}
