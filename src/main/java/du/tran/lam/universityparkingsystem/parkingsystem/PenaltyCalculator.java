/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.parkingsystem;
import java.time.Duration;
/**
 *
 * @author Lam Tran
 */
public class PenaltyCalculator extends ParkingCalculatorDecorator { 
  PenaltyCalculator(ParkingCalculator aParkingCalculator){
      super(aParkingCalculator);
  };
  
  /**
   *
   * @param permit
   * @param parkingLot
   * @param start
   * @param end
   * @return
   */
  @Override
  public long calculate(ParkingPermit permit, ParkingLot parkingLot, java.time.LocalDateTime start, java.time.LocalDateTime end) {
    checkExpiration(permit,start); // Check if customer parked with expired permit
    return parkingCalculator.calculate(permit,parkingLot,start,end) + (long)(12.0 * permit.getCitations()); 
  } // For each citation recieved on the permit, cost of parking adds 12 dollars per transaction regardless until citations are removed
  
  /**
   *
   * @param customerPermit
   * @param start
   */
  private void checkExpiration(ParkingPermit customerPermit, java.time.LocalDateTime start){
    if(start.isAfter(customerPermit.getExpiration())){
    customerPermit.setCitations(customerPermit.getCitations() + 1);}
  }
}
