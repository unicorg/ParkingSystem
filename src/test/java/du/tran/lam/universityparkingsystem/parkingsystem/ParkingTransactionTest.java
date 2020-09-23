package du.tran.lam.universityparkingsystem.parkingsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Lam Tran
 */
public class ParkingTransactionTest {
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
  ParkingLot duparkingspot = new ParkingLot("01", "North Pole", address, 21);
  
  LocalDateTime current = LocalDateTime.now();
  LocalDateTime end = LocalDateTime.now().plusHours(5);
    
  ParkingTransaction Nhujustparked = new ParkingTransaction ( current,end,nhuPermit, duparkingspot,chargedAmount);
  
  public ParkingTransactionTest() {
  
  }
   /**
   * Test of getChargedAmount method, of class ParkingTransaction.
   */
  @Test
  public void testGetChargedAmount() {
    double result = Nhujustparked.getChargedAmount().getAmount();
    assertEquals(chargedAmount.getAmount(), result);
  }

  /**
   * Test of getParkingPermit method, of class ParkingTransaction.
   */
  @Test
  public void testGetParkingPermit() {
    ParkingPermit result = Nhujustparked.getParkingPermit();
    assertEquals(nhuPermit, result);
  }
  
}
