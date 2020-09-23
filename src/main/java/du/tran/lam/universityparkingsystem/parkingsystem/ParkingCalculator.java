/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du.tran.lam.universityparkingsystem.parkingsystem;;
/**
 *
 * @author Lam Tran
 */

public interface ParkingCalculator {
  /**
   *
   * @param Permit
   * @param parkingLot
   * @param start
   * @param end
   * @return
   */
  public abstract long calculate(ParkingPermit Permit, ParkingLot parkingLot, java.time.LocalDateTime start, java.time.LocalDateTime end);
}
