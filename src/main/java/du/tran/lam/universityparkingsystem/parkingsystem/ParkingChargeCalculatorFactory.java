/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.parkingsystem;
import java.time.LocalDateTime;
import java.time.Duration;
/**
 *
 * @author Lam Tran
 */
public class ParkingChargeCalculatorFactory {
  
  public ParkingChargeCalculatorFactory() {}
  
  public ParkingCalculator getCalculator(ParkingPermit permit, LocalDateTime start, LocalDateTime end) {
    if(permit.getCitations() > 0) {
      if (start.getHour() >= 21 || end.getHour() >=21 || Duration.between(start,end).toDays() > 0) {
        ParkingCalculator calculator = new PenaltyCalculator(new OvernightCalculator(new DailyCalculator()));
        return calculator;
      }
      else {
        ParkingCalculator calculator = new PenaltyCalculator(new DailyCalculator());
        return calculator;
      }
    }
    else if (start.getHour() >= 21 || end.getHour() >=21 || Duration.between(start,end).toDays() > 0) {
      ParkingCalculator calculator = new OvernightCalculator(new DailyCalculator());
      return calculator;
    }
    else {
      ParkingCalculator calculator = new DailyCalculator();
      return calculator;
    }
  }
}
