package Objects;

import java.io.*;
import java.util.ArrayList;

/**
 * This class is representing the Admin as a user of the software. It extends the user class.
 * @author Olivér Izsák
 */
public class Admin extends User  implements Serializable
{ public String password;
  public String name;
  private Log logger;
  private BufferedWriter writer;
  private File file; // containing deleted data about demands

  /**
   * Basic constructor for admin
   * @param name String username
   * @param password String password
   */
  public Admin( String name,String password)
  {
    this.password = password;
    this.name = name;
    file = new File("deletedDemands.txt");
  }

  /**
   * Basic get method
   * @return String password
   */
  public String getPassword()
  {
    return password;
  }

  /**
   * Basic  set method for password
   * @param password String password
   */
  public void setPassword(String password)
  {
    this.password = password;
  }

  /**
   * Basic get method for name
   * @return String name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Basic set method for name
   * @param name String name
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Method from the User super class. It is responsible for logging different actions the Admin does.
   * @param text String logged action
   */
  @Override public void log(String text)
  {
    logger = Log.getLogEntryAdmin() ;
    logger.add(text,0);

  }

  /**
   * This method adds a deleted demand to the Admin's deleted demand txt file.
   * @param d Demand to be deleted
   */
  @Override public void addDemand(Demand d)
  {
    try
    {


        writer = new BufferedWriter(new FileWriter(file, true));


      writer.append("Deleted demand: "+ d.getName() + ","+d.getType()+","+d.getAmount()+","+d.getConsoleType()+","+d.getComment()+","+d.getDate());
      writer.newLine();
      writer.flush();
      writer.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
