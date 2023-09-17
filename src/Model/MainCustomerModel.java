package Model;

import Objects.DateTime;
import Objects.Demand;
import Objects.GamingMerchandise;
import Objects.Subject;

import java.util.ArrayList;
import java.util.Collection;

public interface MainCustomerModel
{


   ArrayList<GamingMerchandise> searchProduct(int i, String tempConsoleType, String name);
  ArrayList<GamingMerchandise> updateStoreList();

  void addDemand(String value, int amounto, String value1, String value2, DateTime dt, int type);
}
