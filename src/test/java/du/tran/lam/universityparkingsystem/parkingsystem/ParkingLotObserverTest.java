/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.parkingsystem;

import java.util.ArrayList;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 *
 * @author Lam Tran
 */
public class ParkingLotObserverTest {
  String licensePlate = "JDK-9999";
  String id = "01";
  String phoneNumber = "720-xxx-xxx";
  String firstName = "Ice";
  String lastName = "Bear";
  
  String streetAddress1 = "2199 S University Blvd, ";
  String streetAddress2 = "";
  String city = "Denver, ";
  String state = "CO";
  String zipcode = "80208";
  Address testAddress = new Address (streetAddress1, streetAddress2, city, state,
    zipcode);
  Customer owner = new Customer(id, firstName, lastName, phoneNumber);
   
  Car testCar = new Car (Car.CarType.COMPACT, licensePlate,owner);
  
  String testID = "001";
  ParkingPermit testPermit = new ParkingPermit(testID,testCar);
  java.time.LocalDateTime current = LocalDateTime.now();
  java.time.LocalDateTime expiration = current.plusYears(5);
  ParkingOffice testOffice = new ParkingOffice("testOffice", testAddress);
  ParkingLotObserver testObserver = new ParkingLotObserver(testOffice.tManager);
  ParkingLot testLot = new ParkingLot(id, "testLot", testAddress,21);
  
  public ParkingLotObserverTest() {
  }
  /**
   * Test of vehicleEntry method, of class ParkingLotObserver.
   */
  @Test
  public void testVehicleEntry() {
    System.out.println("vehicleEntry");
    testObserver.vehicleEntry(testPermit);
    assertTrue (testObserver.findPermit(testPermit)!= -1);
  }

  /**
   * Test of vehicleExit method, of class ParkingLotObserver.
   */
  @Test
  public void testVehicleExit() {
    System.out.println("vehicleEntry");
    testObserver.vehicleEntry(testPermit);
    testObserver.vehicleExit(testPermit,testLot);
    assertTrue (testObserver.findPermit(testPermit)== -1);
  }

  /**
   * Test of findPermit method, of class ParkingLotObserver.
   */
  @Test
  public void testFindPermit() {
    System.out.println("vehicleEntry");
    testObserver.vehicleEntry(testPermit);
    assertTrue (testObserver.findPermit(testPermit)!= -1);
  }
  
}
