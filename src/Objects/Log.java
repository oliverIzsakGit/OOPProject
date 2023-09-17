package Objects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class is responsible for logging all actions within the program.
 * Uses singleton so there is only one instance of it.
 */
public class Log
{
  private static Log UINSTANCE;
  private static Log AINSTANCE;
  private LogLine logLine;
  private static final Lock lock = new ReentrantLock();

  private BufferedWriter writer;
  private File cFile;
  private File aFile;

  /**
   * Basic constructor for CustomerLogs
   */
  private Log()
  {
    cFile = new File("CustomerLogs.txt");

  }

  /**
   * Basic constructor for AdminLogs
   * @param s String nothing
   */
  private Log(String s)
  {
    aFile = new File("AdminLogs.txt");
  }

  /**
   * Returns the instance of the Customer log
   * @return Log
   */
  public static Log getLogEntryCustomer()
  {
    if (UINSTANCE == null)
    {
      synchronized (lock)
      {
        if (UINSTANCE == null)
          UINSTANCE = new Log();
      }
    }
    return UINSTANCE;
  }

  /**
   * Returns the instance of the Admin log
   * @return Log
   */
  public static Log getLogEntryAdmin()
  {
    if (AINSTANCE == null)
    {
      synchronized (lock)
      {
        if (AINSTANCE == null)
          AINSTANCE = new Log("Admin");
      }
    }
    return AINSTANCE;
  }

  /**
   * Appends the log containing information about the action to either the admin log txt file or customer log txt file.
   * Depending on the user parameter, if it is 1 then it will append to customer logs, if 0 then to admin logs.
   * @param log String logged action
   * @param user int if 0 = admin, if 1 = customer
   */
  public synchronized void add(String log,int user)
  {
    if (log == null || "".equals(log))
      return;
  logLine = new LogLine(log);
    try
    {

      if(user==1)
      {
        writer = new BufferedWriter(new FileWriter(cFile, true));
      }
      if(user==0)
      {
        writer = new BufferedWriter(new FileWriter(aFile, true));
      }

      writer.append(logLine.toString());
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
