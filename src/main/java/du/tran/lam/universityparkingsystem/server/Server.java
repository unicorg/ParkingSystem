package du.tran.lam.universityparkingsystem.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;
import du.tran.lam.universityparkingsystem.parkingsystem.Address;
import du.tran.lam.universityparkingsystem.parkingsystem.ParkingOffice;
import java.net.UnknownHostException;
import java.util.logging.Level;

public class Server implements Runnable{
  static {
    System.setProperty(
        "java.util.logging.SimpleFormatter.format", "%1$tc %4$-7s (%2$s) %5$s %6$s%n");
  }

  private static final Logger logger = Logger.getLogger(Server.class.getName());

  private final int PORT = 7777;
  
  private final ParkingService service;
  
  private Thread runningThread = null;
      
  protected boolean isStopped = true;
  
  private ServerSocket serverSocket = null;
  
  public Server(ParkingService service)  {
    this.service = service;
  }

  @Override
  public void run() {
      try {
          logger.info("Starting server: " + InetAddress.getLocalHost().getHostAddress());
      } catch (UnknownHostException ex) {
          Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
      }
    runningThread = Thread.currentThread();
    try {
      openServerSocket();
      serverSocket.setReuseAddress(true);
      while (isStopped) {
        Socket client = serverSocket.accept();
        new Thread(
          new ClientHandler (
              client, "ThreadedServer", service)
        ).start();
      }
    } catch (IOException ex) {
          Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  
  private void openServerSocket() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 7777", e);
        }
    }
  
  private synchronized boolean isStopped() {
      return isStopped;
  }

  public synchronized void stop(){
    isStopped = !isStopped;
      try {
        serverSocket.close();
      } catch (IOException e) {
          throw new RuntimeException("Error closing server", e);
      }
  }


  /**
   * Run this as:
   * $ java ict4300.week8.server.Server
   */
  public static void main(String[] args) throws Exception {
    ParkingOffice parkingOffice = new ParkingOffice("Office", new Address("1234 Test street", "", "Aurora", "Colorado", "80011"));
    ParkingService service = new ParkingService(parkingOffice);

    new Server(service).run();
  }
}
