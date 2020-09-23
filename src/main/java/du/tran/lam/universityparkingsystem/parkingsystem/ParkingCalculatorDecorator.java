/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.parkingsystem;

import java.time.LocalDateTime;

/**
 *
 * @author Lam Tran
 */
abstract class ParkingCalculatorDecorator implements ParkingCalculator {
  protected ParkingCalculator parkingCalculator;
    
  public ParkingCalculatorDecorator(ParkingCalculator aParkingCalculator) {
      parkingCalculator = aParkingCalculator;
  }
  
  public long calculate(ParkingPermit Permit, ParkingLot parkingLot, LocalDateTime start, LocalDateTime end){
    return parkingCalculator.calculate(Permit, parkingLot, start, end);
  }
}
