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
public class TransactionManagerTest {
  
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
  Money chargedAmountPermit = new Money(21,"USD");
  Money chargedAmountCustomer = new Money(42,"USD");
  ParkingPermit nhuPermit = new ParkingPermit(testID,testCar);
  ParkingLot duparkingspot = new ParkingLot("01", "North Pole", address, 4);
  ParkingPermit citationPermit = new ParkingPermit("002", testCar);
  
    /**
     *
     */
    public TransactionManagerTest() {
  }
  
   /**
   * Test of park method, of class TransactionManager. //Daily Calculate charge
   */
  @Test
  public void testPark() {
    TransactionManager TM = new TransactionManager();
    LocalDateTime start = LocalDateTime.of(2020,4,22,7,0); //test Monday, 4/20/20 at 12pm
    LocalDateTime end = start.plusHours(1);
    long result = TM.park(start,end, nhuPermit, 
        duparkingspot).getChargedAmount().getAmount();
    long expectedResult = 6; // base cost(4) + 2 per hour (2) = 6 
    assertEquals(expectedResult,result);
  }
  
  /**
   * Test of park method, of class TransactionManager. //Daily Calculate charge
   */
  @Test
  public void testParkOvernight() {
    TransactionManager TM = new TransactionManager();
    LocalDateTime start = LocalDateTime.of(2020,4,20,22,0); //test Monday, 4/20/20 at 12pm
    LocalDateTime end = start.plusHours(48);
    long result = TM.park(start,end, nhuPermit, 
        duparkingspot).getChargedAmount().getAmount();
    long expectedResult = 34; // Park 48 hours is 16 (flat 16 after 8 hours) + lot price (4) + 6 (overnight_fee) + daily rate 8 (days*4)
    assertEquals(expectedResult,result);
  }
  
  /**
   * Test of park method, of class TransactionManager. //Daily Calculate charge
   */
  @Test
  public void testCitationPark() {
    TransactionManager TM = new TransactionManager();
    LocalDateTime start = LocalDateTime.of(2020,4,22,7,0); //test Monday, 4/20/20 at 12pm
    LocalDateTime end = start.plusHours(3);
    citationPermit.setCitations(1);
    long result = TM.park(start,end, citationPermit, 
        duparkingspot).getChargedAmount().getAmount();
    long expectedResult = 22; //Citation parking is a flat fee of 12 plus parking lot fee(4) + hours *2 (6) = 22
    assertEquals(expectedResult,result);
  }
    
}
