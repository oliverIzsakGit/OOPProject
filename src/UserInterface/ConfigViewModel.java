package UserInterface;

import Model.ConfigModel;
import Objects.Subject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
/**
 * View Model class for binding the controller class.
 */
public class ConfigViewModel
{
  private PropertyChangeSupport support;
  private ConfigModel configModel;
  private StringProperty username;
  private StringProperty password1;
  private StringProperty password2;
  private StringProperty error;

  /**
   * Basic constructor
   * @param configModel ConfigModel
   */
  public ConfigViewModel(ConfigModel configModel)
  {
    support = new PropertyChangeSupport(this);
    this.configModel=configModel;
    username = new SimpleStringProperty();
    password1 = new SimpleStringProperty();
    password2 = new SimpleStringProperty();
    error = new SimpleStringProperty();
    username.setValue("");
    password1.setValue("");
    password2.setValue("");
    error.setValue("");
  }

  /**
   * This method decides if the user who is opening the program should get access to create account function or to access scene
   * @return boolean true if access, false if account scene
   */
  public boolean isAccess()
  {
    return configModel.isAccess();
  }

  /**
   * This method checks whether the credentials given for the account are coherent.
   * By checking if the passwords match, and checking that there is nothing left empty.
   * @return boolean true if credentials are coherent, false if not
   */
  public boolean checkCredentials()
  {
    if(username.getValue().equals("") || username.getValue().equals(" "))
    {
      error.setValue("Incorrect username");

    }
    else if(password1.getValue().equals("") || password1.getValue().equals(" ") || password2.getValue().equals("") || password2.getValue().equals(" "))
    {
      error.setValue("Incorrect password");
    }
    else if (!(password1.getValue().equals(password2.getValue())))
    {
      error.setValue("The passwords do not match.");
    }
    else error.setValue("DONE");

    if(error.getValue().equals("DONE"))
    {
      if(configModel.createAccess(username.getValue(),password1.getValue()))
      {
        return true;
      }

    }
    return false;
  }
  /**
   * Gets the username StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getUserNameProperty()
  {
    return username;
  }

  /**
   * Gets the password1 StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getPassword1Property()
  {
    return password1;
  }

  /**
   * Gets the password2 StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getPassword2Property()
  {
    return password2;
  }


  /**
   * Gets the error StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getErrorProperty()
  {
    return error;
  }

}
