/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.server;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import du.tran.lam.universityparkingsystem.parkingsystem.*;

/**
 *
 * @author Lam Tran
 */
public class ParkingServiceTest {
    String streetAddress1 = "2199 S University Blvd, ";
    String streetAddress2 = "";
    String city = "Denver, ";
    String state = "CO";
    String zipcode = "80208";
    Address testAddress = new Address (streetAddress1, streetAddress2, city, state,
    zipcode);
    ParkingOffice office = new ParkingOffice("test",testAddress);
    public ParkingServiceTest() {
    }
    

    /**
     * Test of handleInput method, of class ParkingService.
     */
    @Test
    public void testHandleCustomerInput() {
        System.out.println("handleInput");
        InputStream anyInputStream = new ByteArrayInputStream("{\"Command\":\"CUSTOMER\",\"name\":\"Lam\"}".getBytes()); // test json test data into stream and output
        ParkingService instance = new ParkingService(office);
        String expResult = ": ";
        String result = instance.handleInput(anyInputStream);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of handleInput method, of class ParkingService.
     */
    @Test
    public void testHandleCarInput() {
        System.out.println("handleInput");
        InputStream anyInputStream = new ByteArrayInputStream("{\"license\":\"888-888\",\"Command\":\"CAR\",\"customer\":\"Lam\"}".getBytes()); // test json test data into stream and output
        ParkingService instance = new ParkingService(office);
        String expResult = ": ";
        String result = instance.handleInput(anyInputStream);
        assertEquals(expResult, result);
    }
    
}
