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
public class ParkingOfficeTest {
  
  public ParkingOfficeTest() {
  }
    String parkingOfficeName = "University of Denver";
     
    String POstreetAddress1 = "12692 East 69th Ave ";
    String POstreetAddress2 = "";
    String POcity = "Commerce City ";
    String POstate = "CO";
    String POzipcode = "80022";
    Address TestPOAddress = new Address (POstreetAddress1, POstreetAddress2, POcity, POstate,
    POzipcode);
    
    String CstreetAddress1 = "1234 Whatever You want Street ";
    String CstreetAddress2 = "";
    String Ccity = "Rude City ";
    String Cstate = "CO";
    String Czipcode = "80249";
    Address TestCAddress = new Address (CstreetAddress1, CstreetAddress2, Ccity, Cstate,
    Czipcode);
    
    ParkingOffice TestOffice = new ParkingOffice(parkingOfficeName, TestPOAddress);
  
    Customer IceBear = new Customer ("01","Ice", "Bear",
    "720-xxx-xxx");
    
    Car IceCar = new Car(Car.CarType.COMPACT, "123-444",IceBear);
    ParkingLot TestParkingLot = new ParkingLot("1", "North Pole", TestCAddress, 21);

  
  /**
   * Test of getParkingOfficeName method, of class ParkingOffice.
   */

  public void testGetParkingOfficeName() {
    String expResult = "University of Denver";
    String result = TestOffice.getParkingOfficeName();
    assertEquals(expResult, result);
  }

  /**
   * Test of registerCustomer method, of class ParkingOffice.
   */
  @Test
  public void testRegisterCustomer() {
    TestOffice.register(IceBear);
    String result = TestOffice.listOfCustomers.get(0).getName();
    assertEquals("Ice Bear", result );
  }
  
  /**
   * Test of registerCar method, of class ParkingOffice.
   */
  @Test
  public void testRegisterCar() {
    ParkingPermit testPermit = new ParkingPermit("0", IceCar);
    TestOffice.register(IceCar);
    ParkingPermit output = TestOffice.pManager.listOfParkingPermit.get(0);
    assertEquals(testPermit.getCar(), output.getCar());
  }

  /**
   * Test of registerParkingLot method, of class ParkingOffice.
   */
  @Test
  public void testRegisterParkingLot() {
    TestOffice.registerParkingLot(TestParkingLot);
    assertEquals("North Pole", TestOffice.listOfParkingLots.get(0).getParkingLotName());
  }
  
  @Test
  public void testfindPermit()
  {
    TestOffice.register(IceCar);
    assertEquals(true, TestOffice.findPermit("123-444"));
    assertEquals(false,TestOffice.findPermit("696-696"));
  }
  
  @Test
  public void testFindParkingLot()
  {
    TestOffice.registerParkingLot(TestParkingLot);
    assertEquals(true, TestOffice.findParkingLot("North Pole"));
    assertEquals(false, TestOffice.findParkingLot("Nhu's ParkingLot"));
  }
  
}
