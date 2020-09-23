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

/**
 *
 * @author Lam Tran
 */
public class PenaltyCalculatorTest {
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
  
  LocalDateTime start = LocalDateTime.of(2020,4,20,12,0); //test Monday, 4/20/20 at 12pm
  LocalDateTime end = start.plusHours(3);
  long timeParked = Duration.between(start,end).toMinutes();
  ParkingCalculator testCalculator = new DailyCalculator();
    
  
  public PenaltyCalculatorTest() {
  }
  /**
   * Test of calculate method, of class   PenaltyCalculator.
   */
  @Test
  public void testCalculate() {
    System.out.println("calculate");
      PenaltyCalculator instance = new PenaltyCalculator(testCalculator);
    double expResult = 10.0; // expect 0 additional cost for non-citation permit + 4(lot price) + 6(3 * 2 hourly rate)
    double result = instance.calculate(icebearPermit, duparkingspot, start, end);
    assertEquals(expResult, result);
  }
  
    /**
   * Test of calculate method, of class   PenaltyCalculator.
   */
  @Test
  public void testCalculateCitationCost() {
    System.out.println("calculate");
    citationPermit.setCitations(1);
      PenaltyCalculator instance = new PenaltyCalculator(testCalculator);
    double expResult = 22.0; // expect 12 dollar (12 * number of citations) additional cost for non-citation permit + 4(lot price) + 6(3 * 2 hourly rate)
    double result = instance.calculate(citationPermit, duparkingspot, start, end);
    assertEquals(expResult, result);
  }
  
}