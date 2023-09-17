package Objects;

/**
 * User class is an abstract class that represents the Customer or an Admin, the two possible users that can use the system.
 */
public abstract class User
{


  public abstract void log(String text);
  public abstract void addDemand(Demand d);

}
