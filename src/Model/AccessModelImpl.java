package Model;

import Objects.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This model implementation is responsible for the logic for logging in the system as an admin.
 */
public class AccessModelImpl implements AccessModel
{

  private Serializator ser;
  private User admin;

  /**
   * Basic constructor initializing the Serializator class and the admin object
   */
  public AccessModelImpl()
  {
    admin = new Admin("admin","admin");
    ser = new Serializator();
  }

  /**
   * Method for logging in the system as an admin.
   * It calls a method on the Serializator class which checks whether the name and password is correct to the one already saved in the config file
   * @param value String name
   * @param value1 String password
   * @return boolean  true if the password and name are correct, false if not
   */
  @Override public boolean login(String value, String value1)
  {boolean bol =ser.checkAdminConfig(new Admin(value,value1),1);


    String text = "Admin account log in :\n";
   admin.log(text);
  return bol;

  }
}
