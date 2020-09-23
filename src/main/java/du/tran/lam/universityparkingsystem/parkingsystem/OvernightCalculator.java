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
public class OvernightCalculator extends ParkingCalculatorDecorator {
  private static final int OVERNIGHT_FEE = 6;
  public OvernightCalculator(ParkingCalculator aParkingCalculator){
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
  public long calculate(ParkingPermit permit, ParkingLot parkingLot, LocalDateTime start, LocalDateTime end) {
    long baseCost = (Duration.between(start,end).toDays()*4);
    return parkingCalculator.calculate(permit,parkingLot,start,end) + baseCost + OVERNIGHT_FEE;
  }
}

