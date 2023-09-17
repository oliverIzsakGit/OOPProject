package Model;

import Objects.Admin;
import Objects.Serializator;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;

/**
 * This class is responsible for creating different kind of access to the system depending on the state of the config file.
 * If the config file is not found or it's contents do not match the contents of the origin admin object,it will ask the user for
 * creating a password and name.
 */
public class ConfigModelImp implements ConfigModel
{

  private Serializator ser;
  private Admin origin;
  /**
   * Basic constructor for initializing
   */
  public ConfigModelImp()
  {
    origin = new Admin("NILL","NILL");
    ser = new Serializator();
  }

  /**
   * Checks whether the user should get access to the account creation or not
   * @return boolean if true then no access to account creation, if false then account creation access
   */
  @Override public boolean isAccess()
  {
    System.out.println(ser.checkAdminConfig(origin,0));
    return  ser.checkAdminConfig(origin,0);
  }

  /**
   * This method creates the new account and gives access to the admin account.
   * @param name String name
   * @param pass String password
   * @return boolean if false then access was denied, if true then access was accepted
   */
  @Override public boolean createAccess(String name, String pass)
  {
boolean access = false;
      Admin temp = new Admin(name,pass);

      try
      {
        ser.writeToFile(temp);
        access= true;
      }
      catch(FileNotFoundException f)
      {
        f.printStackTrace();
        access=false;

      }
      catch (IOException ioe)
      {
        ioe.printStackTrace();
        access=false;
      }

      return access;

  }

}
