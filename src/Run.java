

import Factories.ModelFactory;
import Factories.ViewHandler;
import Factories.ViewModelFactory;

import javafx.application.Application;
import javafx.stage.Stage;

public class Run extends Application
{
  /**
   * This class is responsible for initializing all the factory classes (initializer classes) and starting the GUI
   * @param stage Stage GUI
   * @throws Exception exception
   */
  @Override public void start(Stage stage) throws Exception
  {

    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);

    ViewHandler vh = new ViewHandler(vmf);
    vh.start();


  }
}
