/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.parkingsystem;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Lam Tran
 */
public class AddressTest {
  
  public AddressTest() {
  }
  
  String streetAddress1 = "2199 S University Blvd, ";
    String streetAddress2 = "";
    String city = "Denver, ";
    String state = "CO";
    String zipcode = "80208";
    Address address = new Address (streetAddress1, streetAddress2, city, state,
    zipcode);

  /**
   * Test of get & setStreetAddress1 method, of class Address.
   */
  @Test
  public void testGetSetStreetAddress1() {
    System.out.println("get/setStreetAddress1");
    String expResult = streetAddress1;
    address.setStreetAddress1(streetAddress1);
    String result = address.getStreetAddress1();
    assertEquals(expResult, result);
  }    

  /**
   * Test of get & setStreetAddress2 method, of class Address.
   */
  @Test
  public void testGetSetStreetAddress2() {
    System.out.println("get/setStreetAddress2");
    address.setStreetAddress2(streetAddress2);
    String expResult = streetAddress2;
    String result = address.getStreetAddress2();
    assertEquals(expResult, result);
  }

  /**
   * Test of getCity method, of class Address.
   */
  @Test
  public void testGetSetCity() {
    System.out.println("getSetCity");
    address.setCity(city);
    String expResult = city;
    String result = address.getCity();
    assertEquals(expResult, result);
  }

  /**
   * Test of getState method, of class Address.
   */
  @Test
  public void testGetState() {
    System.out.println("getSetState");
    address.setState(state);
    String expResult = state;
    String result = address.getState();
    assertEquals(expResult, result);
  }


  /**
   * Test of getZipcode method, of class Address.
   */
  @Test
  public void testGetZipcode() {
    System.out.println("getSetZipcode");
    address.setZipcode(zipcode);
    String expResult = zipcode;
    String result = address.getZipcode();
    assertEquals(expResult, result);
  }
  
}
