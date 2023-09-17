package UserInterface;

import Model.AccessModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * View Model class for binding the controller class.
 */
public class AdminEntryViewModel
{
  private AccessModel accessModel;
  private StringProperty username;
  private StringProperty password1;
  private StringProperty error;

  /**
   * Constructor method that initializes all the bound fields in the GUI as SimpleStringProperty
   * @param accessModel accessModel
   */
  public AdminEntryViewModel(AccessModel accessModel)
  {
    this.accessModel=accessModel;
    username = new SimpleStringProperty();
    password1 = new SimpleStringProperty();
    error = new SimpleStringProperty();
    username.setValue("");
    password1.setValue("");
    error.setValue("");
  }

  /**
   * This method checks whether the login text fields are not empty
   * If they are not empty the login method is called on the model to check the validity of the credentials.
   * @return boolean true if credentials are correct, otherwise false
   */
  public boolean checkCredentials()
  {
    if(username.getValue().equals("") || username.getValue().equals(" "))
    {
      error.setValue("Incorrect username");

    }
    else if(password1.getValue().equals("") || password1.getValue().equals(" ") )
    {
      error.setValue("Incorrect password");
    }
    else error.setValue("DONE");

    if(error.getValue().equals("DONE"))
    {
      if(accessModel.login(username.getValue(),password1.getValue()))
      {username.setValue("");
        password1.setValue("");
        error.setValue("");
        return true;
      }

    }
    error.setValue("Wrong password or username");
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
   * Gets the error StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getErrorProperty()
  {
    return error;
  }


}
