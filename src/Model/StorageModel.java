package Model;

import Objects.DateTime;
import Objects.GamingMerchandise;
import Objects.OrderProduct;
import Objects.Subject;

import java.util.ArrayList;

public interface StorageModel extends Subject
{
  default String giveMeCurrentTime()
  {
    DateTime ct= new DateTime();
    return ct.getTimestamp();
  }

  ArrayList<GamingMerchandise> updateList();
  void addProductToStore(GamingMerchandise selectedGM);
  void deleteProduct(GamingMerchandise selectedGM);
  ArrayList<OrderProduct>updateOrderList();
  void deleteOrderProduct(OrderProduct selectedOP);

  void addOrderProductToStorage(OrderProduct selectedOP);
  OrderProduct addOrder(String value, String dateTime, int tempAmount, double tempPrice, String value1, String value2, int radioButtonType);
  GamingMerchandise addProduct(String value, double pric, String value1, int radioButtonType, String value2);
}
