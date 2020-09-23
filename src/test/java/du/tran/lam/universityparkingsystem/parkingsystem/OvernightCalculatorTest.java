/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.parkingsystem;

import java.time.LocalDateTime;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 *
 * @author Lam Tran
 */
public class OvernightCalculatorTest {
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
  Customer icebear = new Customer(id, firstName, lastName, phoneNumber);
  
  String testID = "001";
  String licensePlate = "JDK 9999";
  Car testCar = new Car (Car.CarType.SUV, licensePlate, icebear);
  Car discountCar = new Car (Car.CarType.COMPACT, licensePlate, icebear);
  Money chargedAmount = new Money(21,"USD");
  ParkingPermit icebearPermit = new ParkingPermit(testID,testCar);
  ParkingPermit expiredPermit = new ParkingPermit(testID,discountCar);
  ParkingPermit citationPermit = new ParkingPermit(testID,testCar);
  ParkingLot duparkingspot = new ParkingLot("01", "North Pole", address, 4);
  
  LocalDateTime start = LocalDateTime.of(2020,4,20,22,0); //test Monday, 4/20/20 at 10pm
  LocalDateTime end = start.plusHours(3);
  LocalDateTime extendedEnd = start.plusHours(48);
  long timeParked = Duration.between(start,end).toMinutes();
  ParkingCalculator testCalculator = new DailyCalculator();
  
    /**
     *
     */
    public OvernightCalculatorTest() {
  }
   
  /**
   * Test of calculate method, of class OvernightCalculator.
   */
  @Test
  public void testCalculate() {
    
    System.out.println("calculate");
    OvernightCalculator calculateInstance = new OvernightCalculator(testCalculator);
    double expResult = 16; // Park 3 hours is 6 (3 hrs * 2) + lot price (4) + 6 (overnight_fee)
    double result = calculateInstance.calculate(icebearPermit, duparkingspot, start, end); 
    assertEquals(expResult, result);
  }
  
  /**
   * Test of calculate method, of class OvernightCalculator.
   */
  @Test
  public void testCalculateDiscount() {
    
    System.out.println("calculate");
    OvernightCalculator calculateInstance = new OvernightCalculator(testCalculator);
    double expResult = 12; // Park 3 hours is 6 (3 hrs * 2) + lot price (4) + 6 (overnight_fee) - 4(discount)
    double result = calculateInstance.calculate(expiredPermit, duparkingspot, start, end);
    assertEquals(expResult, result);
  }
  
  /**
   * Test of calculate method, of class OvernightCalculator.
   */
  @Test
  public void testCalculateMultipleDayPark() {
    
    System.out.println("calculate");
    OvernightCalculator calculateInstance = new OvernightCalculator(testCalculator);
    double expResult = 34; // Park 48 hours is 16 (flat 16 after 8 hours) + lot price (4) + 6 (overnight_fee) + daily rate 8 (days*4) 
    double result = calculateInstance.calculate(icebearPermit, duparkingspot, start, extendedEnd);
    assertEquals(expResult, result);
  }
}
