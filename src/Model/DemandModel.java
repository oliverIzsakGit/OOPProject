package Model;

import Objects.Demand;

import java.util.ArrayList;

public interface DemandModel
{

  ArrayList<Demand> updateDemandList();
  void deleteDemand(Demand selectedD);

}
