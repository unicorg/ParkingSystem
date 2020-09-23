package du.tran.lam.universityparkingsystem.parkingsystem;

import java.util.ArrayList;
/* @author Lam Tran */

/**
 *
 * @author Lam Tran
 */


public class ParkingLot implements ParkingActor {
  private String id;
  private String parkingLotName;
  private Address parkingLotAddress ;
  private long price;
  public ArrayList<ParkingObserver> listOfObservers = null;
  
  /**
   *
   * @param id
   * @param parkingLotName
   * @param parkingLotAddress
   * @param price
   */
  public ParkingLot (String id, String parkingLotName, Address parkingLotAddress, long price) {
    this.id = id;
    this.parkingLotName = parkingLotName;
    this.parkingLotAddress = parkingLotAddress;
    this.price = price; 
    listOfObservers = new ArrayList<>();
  }

  /**
   *
   * @return
   */
  public String getId() {
    return id;
  }

  /**
   *
   * @param id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   *
   * @return
   */
  public String getParkingLotName() {
    return parkingLotName;
  }

  /**
   *
   * @param parkingLotName
   */
  public void setParkingLotName(String parkingLotName) {
    this.parkingLotName = parkingLotName;
  }

  /**
   *
   * @return
   */
  public Address getParkingLotAddress() {
    return parkingLotAddress;
  }

  /**
   *
   * @param parkingLotAddress
   */
  public void setParkingLotAddress(Address parkingLotAddress) {
    this.parkingLotAddress = parkingLotAddress;
  }

  /**
   *
   * @return
   */
  public long getPrice() {
    return price;
  }

  /**
   *
   * @param price
   */
  public void setPrice(long price) {
  this.price = price;
  }
  
  public void notifyObservers(){
      
  }
  
  @Override
  public void register(ParkingObserver parkingObserverToRegister){
      listOfObservers.add(parkingObserverToRegister);
  }
  
  public void carExit(ParkingPermit customerPermit) {
      for(int i = 0; i < listOfObservers.size(); i++) {
        listOfObservers.get(i).vehicleExit(customerPermit, this);
      }
  }
}
