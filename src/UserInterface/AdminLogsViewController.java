package UserInterface;

import Factories.ViewHandler;
import Model.MainAdminModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
/**
 * Controller class for the Access FXML file.
 */
public class AdminLogsViewController
{
  private AdminLogsViewModel model;
  private ViewHandler vh;
 @FXML private ListView<String> logList;
 @FXML private Label time;

  /**
   * Initializer which binds together some of the textfields found in the fxml file
   * It also start a new thread for a clock
   * @param logsVM AdminLogsViewModel
   * @param viewHandler ViewHandler
   */
  public void init( AdminLogsViewModel logsVM, ViewHandler viewHandler)
  {
    model = logsVM;
    vh= viewHandler;
    logList.setItems(model.getLogList());
    time.textProperty().bind(model.getTimeProperty());
    model.updateLog();
    Thread timeThread = new Thread(logsVM);
    timeThread.start();



  }

}
