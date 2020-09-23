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
public class CustomerTest {
  
  public CustomerTest() {
  }
  String id = "01";
  String phoneNumber = "720-xxx-xxx";
  String firstName = "Ice";
  String lastName = "Bear";
  
  String streetAddress1 = "2199 S University Blvd, ";
  String streetAddress2 = "";
  String city = "Denver, ";
  String state = "CO";
  String zipcode = "80208";
  Customer customer = new Customer(id, firstName, lastName, phoneNumber);
   

  /**
   * Test of getCustomerName method, of class Customer.
   */
  @Test
  public void testGetCustomerName() {
    
    String expResult = firstName + " " + lastName;
    String result = customer.getName();
    assertEquals(expResult, result);
  }
}
