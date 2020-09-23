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
public class CarTest {
  
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
  Customer owner = new Customer(id, firstName, lastName, phoneNumber);
   
  Car compactCar = new Car (Car.CarType.COMPACT, licensePlate,owner );
  Car SUVCar = new Car (Car.CarType.SUV, licensePlate,owner);
  
  
  public CarTest() {
  }
  
    /**
    * Test of getCarType method, of class Car.
     */
    @Test
    public void testGetCarTypeCompact() {
    assertEquals(Car.CarType.COMPACT, compactCar.getType());
    }
    /**
    * Test of getCarType method, of class Car.
     */
    @Test     
    public void testGetCarTypeSUV() {
    assertEquals(Car.CarType.SUV, SUVCar.getType());
    }
    /**
    * Test of getLicensePlate method, of class Car.
     */
    @Test
     public void testGetLicensePlate() {
      String expResult = "JDK-9999";
      assertEquals(expResult, compactCar.getLicensePlate());
    }
     /**
    * Test of getOwner method, of class Car.
     */
    @Test
    public void testGetOwner(){
      assertEquals(owner, compactCar.getCustomer());
    }
  
}
