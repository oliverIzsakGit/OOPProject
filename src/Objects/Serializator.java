package Objects;

import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;

import java.io.*;
import java.util.ArrayList;

/**
 * A generic type serializator for serializing objects.
 * @param <T> generic object type
 */
public class Serializator<T> {

  public static String storeStorage="store.bin";
  private T t;
  public static String configFile ="config.bin";
  public static String customerLogs="demands.bin";
  public static String storageList = "storage.bin";
  public static String storageOrders = "orders.bin";

  /**
   * This method serializes an arraylist of a specific object
   * @param type Arraylist of a specific object
   * @param path String path of the file
   */
  public void serialize(ArrayList<T> type, String path){
    try{
      FileOutputStream file = new FileOutputStream(path);
      ObjectOutputStream out = new ObjectOutputStream(file);

      out.writeObject(type);

      out.close();
      file.close();
      System.out.println("Object serialized");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("Object not serialized");
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Object not serialized");
    }
  }


  /**
   * This method deserializes an arraylist of a specific object
   * @throws  IOException if there is something wrong while opening or closing file.
   * @param path String path of the file
   * @return ArrayList of the specified object.
   */
  public ArrayList<T> deserialize(String path) throws IOException
  {
    ArrayList<T> list = new ArrayList<T>();

    try {
      FileInputStream file = new FileInputStream(path);
      ObjectInputStream in = new ObjectInputStream(file);

      list = (ArrayList<T>) in.readObject();

      if(list ==null){

      }
      in.close();
      file.close();
      System.out.println("Deserialized");
    }


    catch (ClassNotFoundException c) {
      System.out.println("ClassNotFoundException while deserializing");
    }

    return list;
  }

  /**
   * This method is specifically designed to write an object to a file.
   * @param ob object
   * @throws FileNotFoundException if file not found
   * @throws IOException if something went wrong with I/O
   */
  public void writeToFile(Admin ob) throws FileNotFoundException, IOException
  {
    ObjectOutputStream writeToFile = null;


    try
    {
      FileOutputStream fileOutStream = new FileOutputStream(configFile);
      writeToFile = new ObjectOutputStream(fileOutStream);



      writeToFile.writeObject((Object)ob);
    }
    finally
    {
      if (writeToFile != null)
      {
        try
        {
          writeToFile.close();
        }
        catch (IOException e)
        {
          System.out.println("IO Error closing file " + configFile);
        }
      }
    }
  }

  /**
   * This method is for checking the validity of the config file when starting the program as an admin.
   * @param origin original admin credentials
   * @param type type is 0 if the config file has been corrupted,deleted or it is not present. type 1 if just checking for log in.
   * @return boolean true if success, false is failure.
   */
  public boolean checkAdminConfig(Admin origin,int type)
  { boolean bol=false;
    Object obj = null;
    ObjectInputStream readFromFile = null;
    FileInputStream fileInStream;

    try
    {
      fileInStream = new FileInputStream(configFile);
    }
    catch (FileNotFoundException f)
    {


      try{writeToFile(origin);}

      catch(IOException i)
      {
        System.out.println("IOException in config\n");
      }

      bol = false;

    }
    try
    {
      fileInStream = new FileInputStream(configFile);
      readFromFile = new ObjectInputStream(fileInStream);
      try
      {
        obj = readFromFile.readObject();
        Admin a = (Admin)obj;
        if(type==0)
        {
          System.out.println("name: " +a.getName()+ "\n pass: "+ a.getPassword());
          if((a.getName().equals("NILL") && a.getPassword().equals("NILL")))
          {
            System.out.println("name: " +a.getName()+ "\n pass: "+ a.getPassword());
            bol=false;
          }
          else bol=true;
        }
       if(type==1)
       {
         if(a.getName().equals(origin.getName()) && a.getPassword().equals(origin.getPassword()))
         {

           bol = true;
         }
       }


      }
      catch (EOFException eof)
      {
        System.out.println("error");
      }
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (readFromFile != null)
      {
        try
        {
          readFromFile.close();
        }
        catch (IOException e)
        {
          System.out.println("IO Error closing file " + configFile);
        }
      }
    }

    return bol;
  }


}