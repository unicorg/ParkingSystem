package du.tran.lam.universityparkingsystem.parkingsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;


public class ParkingOffice {

  
  //instances variables  
  String name;
  public ArrayList<Customer> listOfCustomers = null;
  public ArrayList<ParkingLot> listOfParkingLots = null;
  Address address = null; 
  Customer foundCustomer = null;
  PermitManager pManager = null;
  ParkingPermit foundPermit = null;
  ParkingLot foundParkingLot = null;
  TransactionManager tManager = null;
  ParkingCalculator parkingCalculatorInstance = null;
  ParkingLotObserver parkingObserver = null;

  
  public ParkingOffice(String name, Address address) {
    this.name = name;
    this.address = address;
    listOfCustomers = new ArrayList<>();
    listOfParkingLots = new ArrayList<>();
    tManager = new TransactionManager();
    pManager = new PermitManager();
    parkingObserver = new ParkingLotObserver(tManager);
  }

  public String getParkingOfficeName() {
    return name;
  }

  public Customer register(Customer customer) {
    if (!listOfCustomers.contains(customer)) {
      listOfCustomers.add(customer);
    }
    return customer;
  }

  public Car register(Car car) {
    pManager.registerCar(car);
    return car;
  }

    /**
   *
   * @param newParkingLot
   */
  public void registerParkingLot(ParkingLot newParkingLot) {
    newParkingLot.register(parkingObserver);
    listOfParkingLots.add(newParkingLot);} 
  
  /**
   *
   * @param customername
   * @return
   */
  public Boolean findCustomer(String customername) {
    for (int i = 0; i < listOfCustomers.size(); i++) {
    if((listOfCustomers.get(i).getName()).equalsIgnoreCase(customername)) {
      foundCustomer = listOfCustomers.get(i);
      return true;
    }
    }
    return false;
  }

  /**
   *
   * @return
   */
  public Customer returnFoundCustomer() {
    return this.foundCustomer;
  }
  
  /**
   *
   * @param licenseplate
   * @return
   */
  public Boolean findPermit(String licenseplate) {
    for (int i = 0; i < pManager.listOfParkingPermit.size(); i++) {
      if(pManager.listOfParkingPermit.get(i).getCar().getLicensePlate().equalsIgnoreCase(licenseplate)){
        foundPermit = pManager.listOfParkingPermit.get(i);
        return true;
      }
    }
    return false;
  }

  /**
   *
   * @return
   */
  public ParkingPermit returnFoundPermit() {
    return this.foundPermit;
  }
  
  /**
   *
   * @param ParkingLotName
   * @return
   */
  public Boolean findParkingLot(String ParkingLotName){
    for (int i = 0; i < pManager.listOfParkingPermit.size(); i++) {
      if(listOfParkingLots.get(i).getParkingLotName().equalsIgnoreCase(ParkingLotName)) {
        foundParkingLot = listOfParkingLots.get(i);
        return true;
      }
    }
    return false;
  }
  
  /**
   *
   * @param Permit
   * @param parkingLot
   * @param start
   * @param end
   */
  public void park(ParkingPermit Permit, ParkingLot parkingLot, java.time.LocalDateTime start, java.time.LocalDateTime end) {
    tManager.park(start,end, Permit, parkingLot);
  }

  /**
   *
   * @return
   */
  public ParkingLot returnFoundParkingLot() {
    return this.foundParkingLot;
  }
}

