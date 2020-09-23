package du.tran.lam.universityparkingsystem.parkingsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Lam Tran
 */
public class PermitManagerTest {
  String streetAddress1 = "2199 S University Blvd, ";
  String streetAddress2 = "";
  String city = "Denver, ";
  String state = "CO";
  String zipcode = "80208";
  Address address = new Address (streetAddress1, streetAddress2, city, state,
  zipcode);
  
  String id = "01";
  String phoneNumber = "720-xxx-xxx";
  String firstName = "Ice";
  String lastName = "Bear";
  Customer nhu = new Customer(id, firstName, lastName, phoneNumber);
  
  String testID = "001";
  String licensePlate = "JDK 9999";
  Car testCar = new Car (Car.CarType.SUV, licensePlate, nhu);
  Money chargedAmount = new Money(21,"USD");
  ParkingPermit nhuPermit = new ParkingPermit(testID,testCar);
  
  PermitManager pManager = new PermitManager();
  public PermitManagerTest() {

  }
  
   /**
   * Test of registerCar method, of class PermitManager.
   */
  @Test
  public void testRegisterCar() {
    pManager.registerCar(testCar);
    assertEquals(testCar, pManager.listOfParkingPermit.get(0).getCar());
    
    
  }
  
}
