package UserInterface;

import Model.MainAdminModel;
import Objects.DateTime;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * View Model class for binding the controller class.
 */
public class AdminLogsViewModel implements Runnable

{
   private MainAdminModel model;
   private StringProperty time;
   private  ObservableList<String> logs;

  /**
   * Basic constructor
   * @param mainAdminModel MainAdminModel
   */
  public AdminLogsViewModel(MainAdminModel mainAdminModel)
  {
    model = mainAdminModel;
    time = new SimpleStringProperty();
    logs = FXCollections.observableArrayList();



  }

  public ObservableList<String> getLogList()
  {

  return logs;
  }


  public StringProperty getTimeProperty()
  {
    return time;
  }

  /**
   * Updates the log list, by calling getAdminLogs method on the model
   */
  public void updateLog()
  {
    logs.addAll(model.getAdminLogs());
  }

  /**
   * A run method for the new thread
   * This method is for showing the current time every 1 second. (A clock)
   */
  @Override public void run()
  {

      while(true) {
        DateTime constantTime = new DateTime();
        Platform.runLater(() -> {
          time.setValue(constantTime.getTimestamp());
        });


        try
        {
          Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }



  }
}
