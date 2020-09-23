package du.tran.lam.universityparkingsystem.server;

import java.io.InputStream;
import du.tran.lam.universityparkingsystem.parkingsystem.Car;
import du.tran.lam.universityparkingsystem.parkingsystem.Customer;
import du.tran.lam.universityparkingsystem.parkingsystem.ParkingOffice;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParkingService {
  protected final ParkingOffice parkingOffice;
  protected ObjectMapper objectMapper = new ObjectMapper();

  public ParkingService(ParkingOffice parkingOffice) {
    this.parkingOffice = parkingOffice;
  }

  protected String handleInput(InputStream in) {
    try {
      @SuppressWarnings("resource")
      // The input stream will be closed when we disconnect
      Map<String, String> jsonMap = objectMapper.readValue(in, Map.class);
      String command = jsonMap.get("Command");
      jsonMap.remove("Command");
      String json = objectMapper.writerWithDefaultPrettyPrinter()
              .writeValueAsString(jsonMap);
      return performCommand(command, json);
      } catch (IOException ex) {
          Logger.getLogger(ParkingService.class.getName()).log(Level.SEVERE, null, ex);
      }
    return null;
  }

  //Modified to take in command and json 
  private String performCommand(String command, String json) {
    String matched = "";
    try {
    switch (command) {
      case "CUSTOMER":
          //deserialize json into customer instance
        return "customer " + parkingOffice.register(objectMapper.readValue(json, Customer.class)).toString() + "was registered";
      case "CAR":
          //deserialize json into car instance
        return "car " + parkingOffice.register(objectMapper.readValue(json, Car.class)).toString() + "was registered";
      case "PARK":
        matched = "park";
        break;
      case "CHARGES":
        matched = "charges";
        break;
      default:
        matched = "unknown";
    }
    } catch (IOException ex) {
          Logger.getLogger(ParkingService.class.getName()).log(Level.SEVERE, null, ex);
      }
    matched += ": ";
    return matched;
  }

}
