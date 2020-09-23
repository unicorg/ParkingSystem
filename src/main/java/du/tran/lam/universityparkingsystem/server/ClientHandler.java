/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.server;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lam Tran
 */
public class ClientHandler implements Runnable{
    protected Socket client = null;
    protected String serverText   = null;
    protected ParkingService service = null;
    
    private static final Logger logger = Logger.getLogger(ClientHandler.class.getName());

    public ClientHandler(Socket clientSocket, String serverText, ParkingService mainService) {
        this.client = clientSocket;
        this.serverText   = serverText;
        this.service = mainService;
    }

    @Override
    public void run() {
      try (PrintWriter pw = new PrintWriter(client.getOutputStream())) {
      String output;
      try {
        output = service.handleInput(client.getInputStream());
      } catch (RuntimeException ex) {
        ex.printStackTrace();
        output = ex.getMessage();
      }

      pw.println(output);
      //pw.println("end");
      pw.flush();

    } catch (IOException e) {
      logger.log(Level.WARNING, "Failed to read from client.", e);
    } finally {
      try {
        client.close();
      } catch (IOException e) {
        logger.log(Level.WARNING, "Failed to close client socket.", e);
      }
    }
  }
}