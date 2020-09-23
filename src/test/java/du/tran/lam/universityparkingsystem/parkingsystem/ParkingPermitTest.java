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
public class ParkingPermitTest {
  
  public ParkingPermitTest() {
  }
  public static final long DAY = 1000 *3600 *24;
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
  Address CustomerAddress = new Address (streetAddress1, streetAddress2, city, state,
    zipcode);
  Customer owner = new Customer(id, firstName, lastName, phoneNumber);
   
  Car testCar = new Car (Car.CarType.COMPACT, licensePlate,owner );
  
  String testID = "001";
  ParkingPermit testPermit = new ParkingPermit(testID,testCar);
  java.time.LocalDateTime current = LocalDateTime.now();
  java.time.LocalDateTime expiration = current.plusYears(5);

  /**
   * Test of getId method, of class ParkingPermit.
   */
  @Test
  public void testGetId() {
    assertEquals(testPermit.getId(), testID);
  }

  /**
   * Test of getCar method, of class ParkingPermit.
   */
  @Test
  public void testGetCar() {
    assertEquals(testPermit.getCar(), testCar);
  }

  
}
