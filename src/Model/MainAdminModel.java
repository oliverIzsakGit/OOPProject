package Model;

import Objects.GamingMerchandise;
import Objects.Subject;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface MainAdminModel
{
  public ArrayList<GamingMerchandise> updateList();
  ArrayList<GamingMerchandise> searchProduct(int tempInt, String o);
  void deleteProduct(GamingMerchandise selectedSP);
  ArrayList<String> getAdminLogs();
}
