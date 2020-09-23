/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.parkingsystem;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Lam Tran
 */
public class ParkingLotObserver extends ParkingObserver {
  private ArrayList<ParkTransaction> listOfActiveParking = null;
  private TransactionManager tManager = null;

    public ParkingLotObserver(TransactionManager aManager) {
    tManager = aManager;
    listOfActiveParking = new ArrayList<>();
    }
    
    public ArrayList<ParkTransaction> getListOfActiveParking() {
      return listOfActiveParking;
    }

    public void setListOfActiveParking(ArrayList<ParkTransaction> listOfActiveParking) {
      this.listOfActiveParking = listOfActiveParking;
    }

    public TransactionManager gettManager() {
      return tManager;
    }

    public void settManager(TransactionManager tManager) {
      this.tManager = tManager;
    }

  
  private class ParkTransaction {
    LocalDateTime timeIn;
    ParkingPermit permitRegistered;
  }
  

   
  @Override
  public void vehicleEntry(ParkingPermit customerPermit) {
      ParkTransaction ptInstance = new ParkTransaction();
      ptInstance.timeIn = LocalDateTime.now();
      ptInstance.permitRegistered = customerPermit;
      listOfActiveParking.add(ptInstance);
    }
  
  @Override 
  public void vehicleExit(ParkingPermit customerPermit, ParkingLot lot) {
    int output = findPermit(customerPermit);
    if(output != -1) {
        ParkTransaction transaction = listOfActiveParking.get(output);
        listOfActiveParking.remove(output);
        tManager.park(transaction.timeIn, LocalDateTime.now(), customerPermit, lot);
    }
  }
  
  public int findPermit(ParkingPermit customerPermit) {
    for (int i = 0; i < listOfActiveParking.size(); i++) {
      if(listOfActiveParking.get(i).permitRegistered.getId().equalsIgnoreCase(customerPermit.getId())) {
        return i;
      }
    }
    return -1;
  }
}
