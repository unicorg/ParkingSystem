/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.parkingsystem;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Lam Tran
 */
public class ParkingLotTest {
  
  public ParkingLotTest() {
  }
  
  String licensePlate = "JDK 9999";
  String id = "01";
  String phoneNumber = "720-xxx-xxx";
  String firstName = "Ice";
  String lastName = "Bear";
  
  String streetAddress1 = "2199 S University Blvd, ";
  String streetAddress2 = "";
  String city = "Denver, ";
  String state = "CO";
  String zipcode = "80208";
  Address address = new Address (streetAddress1, streetAddress2, city, state,
  zipcode);
  
  String parkingLotName = "North Pole";
  long price = 21;
  
  Customer owner = new Customer(id, firstName, lastName, phoneNumber);
   
  Car testCar = new Car (Car.CarType.COMPACT, licensePlate,owner );
  
  String testID = "001";
  ParkingPermit testPermit = new ParkingPermit(testID,testCar);
  
  ParkingLot parkingLot = new ParkingLot(id, parkingLotName, address,price);
  ParkingOffice testOffice = new ParkingOffice("office", address);
  ParkingLotObserver testObserver = new ParkingLotObserver(testOffice.tManager);
  
  /**
   * Test of getId method, of class ParkingLot.
   */
  @Test
  public void testGetId() {
    System.out.println("get/set Id");
    String expResult = id;
    parkingLot.setId(id);
    String result = parkingLot.getId();
    assertEquals(expResult, result);
  }


  /**
   * Test of getParkingLotName method, of class ParkingLot.
   */
  @Test
  public void testGetParkingLotName() {
    System.out.println("get/set ParkingLotName");
    String expResult = parkingLotName;
    parkingLot.setParkingLotName(parkingLotName);
    String result = parkingLot.getParkingLotName();
    assertEquals(expResult, result);
  }

  /**
   * Test of getParkingLotAddress method, of class ParkingLot.
   */
  @Test
  public void testGetParkingLotAddress() {
    System.out.println("get/set ParkingLotAddress");
    parkingLot.setParkingLotAddress(address);
    assertEquals(address, parkingLot.getParkingLotAddress());
  }

  /**
   * Test of getPrice method, of class ParkingLot.
   */
  @Test
  public void testGetPrice() {
    System.out.println("getPrice");
    long expResult = price;
    parkingLot.setPrice(price);
    double result = parkingLot.getPrice();
    assertEquals(expResult, result);
  }
  
  /**
   * Test of getPrice method, of class ParkingLot.
   */
  @Test
  public void testRegisterObserver() {
    System.out.println("testRegister");
    parkingLot.register(testObserver);
  }
  
  /**
   * Test of getPrice method, of class ParkingLot.
   */
  @Test
  public void testNotifyObservers() {
    System.out.println("testNotifyObservers");
    parkingLot.carExit(testPermit);
  }
  
}
