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
public class ParkingChargeCalculatorFactoryTest {
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
  ParkingPermit discountPermit = new ParkingPermit(testID,discountCar);
  ParkingPermit citationPermit = new ParkingPermit(testID,testCar);
  ParkingLot duparkingspot = new ParkingLot("01", "North Pole", address, 4);
  
  LocalDateTime start = LocalDateTime.of(2020,4,20,12,0); //test Monday, 4/20/20 at 12pm
  LocalDateTime end = start.plusHours(3);
  LocalDateTime extendedEnd = start.plusHours(48);
  long timeParked = Duration.between(start,end).toMinutes();
  ParkingChargeCalculatorFactory testFactory = new ParkingChargeCalculatorFactory();
    public ParkingChargeCalculatorFactoryTest() {
    }
    

    /**
     * Test of getCalculator method, of class ParkingChargeCalculatorFactory.
     */
    @Test
    public void testDailyRateCalculation() {
      ParkingCalculator dailyRateInstance = testFactory.getCalculator( icebearPermit,start,end);
      long result = dailyRateInstance.calculate(icebearPermit, duparkingspot, start, end);
      long expResult = 10; // 4 + 6 (3 hrs * 2 per hour)
      assertEquals(expResult, result);
    }
    
    /**
     * Test of getCalculator method, of class ParkingChargeCalculatorFactory.
     */
    @Test
    public void testOvernightWithCitation() {
      citationPermit.setCitations(1);
      ParkingCalculator overnightInstance = testFactory.getCalculator( citationPermit,start,extendedEnd);
      long result = overnightInstance.calculate(citationPermit, duparkingspot, start, extendedEnd);
      long expResult = 46; // Park 48 hours is 16 (flat 16 after 8 hours) + lot price (4) + 6 (overnight_fee) + daily rate 8 (days*4) + 12 (citation cost)
      assertEquals(expResult, result);
    }
    /**
     * Test of getCalculator method, of class ParkingChargeCalculatorFactory.
     */
    @Test
    public void testDailyRateWithCitation() {
      citationPermit.setCitations(1);
      ParkingCalculator dailyRateWithCitationInstance = testFactory.getCalculator( citationPermit,start,end);
      long result = dailyRateWithCitationInstance.calculate(citationPermit, duparkingspot, start, end);
      long expResult = 22; // 4 + 6 (3 hrs * 2 per hour) + 12 (citation cost)
      assertEquals(expResult, result);
    }
    
   /**
     * Test of getCalculator method, of class ParkingChargeCalculatorFactory.
     */
    @Test
    public void testOvernight() {
      ParkingCalculator overnightInstance = testFactory.getCalculator( icebearPermit,start,extendedEnd);
      long result = overnightInstance.calculate(icebearPermit, duparkingspot, start, extendedEnd);
      long expResult = 34; // Park 48 hours is 16 (flat 16 after 8 hours) + lot price (4) + 6 (overnight_fee) + daily rate 8 (days*4)
      assertEquals(expResult, result);
    }
    
}
