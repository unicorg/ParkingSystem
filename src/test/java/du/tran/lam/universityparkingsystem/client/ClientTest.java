/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.client;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lam Tran
 */
public class ClientTest {
    public ClientTest() {
    }
    
    /**
     * Test of runCommand method, of class Client.
     */
    @Test
    public void testRunCustomerCommand() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Lam");
        System.out.println("runCommand");
        String command = "CUSTOMER";
        String expResult = "{\"Command\":\"CUSTOMER\",\"name\":\"Lam\"}"; // check that output from runcommand is the json file format response to CUSTOMER command
        String result = Client.runCommand(command, map);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of runCommand method, of class Client.
     */
    @Test
    public void testRunCarCommand() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("license", "888-888");
        map.put("customer", "Lam");
        System.out.println("runCommand");
        String command = "CAR";
        String expResult = "{\"license\":\"888-888\",\"Command\":\"CAR\",\"customer\":\"Lam\"}"; // check that output from runcommand is the json file format response to CAR command
        String result = Client.runCommand(command, map);
        assertEquals(expResult, result);
    }
    
}
