package Objects;

import java.beans.PropertyChangeListener;

/**
 * Subject class is responsible for adding/removing listeners to/from  a class.
 */
public interface Subject
{
  void addListener(String eventName, PropertyChangeListener listener);
  void removeListener(String eventName, PropertyChangeListener listener);


}
