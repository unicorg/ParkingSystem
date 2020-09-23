/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.server;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import du.tran.lam.universityparkingsystem.parkingsystem.ParkingOffice;
import du.tran.lam.universityparkingsystem.parkingsystem.Address;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lam Tran
 */
public class ServerTest {
  String streetAddress1 = "2199 S University Blvd, ";
  String streetAddress2 = "";
  String city = "Denver, ";
  String state = "CO";
  String zipcode = "80208";
  Address address = new Address (streetAddress1, streetAddress2, city, state,
      zipcode);
  ParkingOffice office = new ParkingOffice("OfficeName",address);
  ParkingService service = new ParkingService(office);
  private static final String SERVER = "localhost";
  private static final int PORT = 7777;
  private static final int PORT2 = 7778;
    
  public ServerTest() {
  }
    class TestConnect implements Runnable {
        int port = 0;
        TestConnect(int portValue) {
        this.port = portValue;
        }
        public void run() {
            try {
                testConnectPort();
            } catch (IOException ex) {
                Logger.getLogger(ServerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void testConnectPort () throws IOException {
           InetAddress host;
            try {
                host = InetAddress.getByName(SERVER);
                Socket link = new Socket(host, port);
            } catch (UnknownHostException ex) {
                Logger.getLogger(ServerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Successfuly connection");
        }
     
  }
    
  @Test
  public void testThreadedServer() throws Exception {
    Thread server = new Thread(
        new Server(service));
    server.start();
    Thread connect1 = new Thread(new TestConnect(PORT));
    Thread connect2 = new Thread(new TestConnect(PORT2));
    connect1.start();
    connect2.start();
    server.stop();
    connect1.stop();
    connect2.stop();
  }
  
  
  
}
