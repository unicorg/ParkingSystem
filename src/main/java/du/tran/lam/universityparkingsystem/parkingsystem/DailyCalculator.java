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
public class DailyCalculator implements ParkingCalculator {
  
  DailyCalculator(){
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
  public long calculate(ParkingPermit permit, ParkingLot parkingLot, LocalDateTime start, LocalDateTime end){
    long timeParked = Duration.between(start,end).toMinutes();
    double cost = getHoursParked(timeParked, parkingLot) * getDayofWeek(start);
    if(permit.getCar().getType()== Car.CarType.COMPACT) {
      return (long)cost - 4;
    }
    else {
        return (long)cost;
    }
  }
  
  /**
    *
    * @param timeParked
    * @param parkingLot
    * @return
    */
  public double getHoursParked(long timeParked, ParkingLot parkingLot){ 
    long baseCost = parkingLot.getPrice();
    if(timeParked < 15) {
      return 0; } // Less than 15 minute parking is free
    if(timeParked > 15 && timeParked < 60){
      return 1 + baseCost;
    }
    long hoursParked = timeParked/60;
    if(hoursParked > 8) { //After certain number of hours, parking is a flat rate
      return 16 + baseCost;
    }//Flat 16 dollars plus base lot cost
    return baseCost + (hoursParked * 2); //For every hour, cost of parking is 2 per hour + base lot cost
  } 
  
  /**
   *
   * @param start
   * @return
   */
  public double getDayofWeek(LocalDateTime start){
    double dayRate = 1;
    switch(start.getDayOfWeek()){
      case SUNDAY: 
        dayRate = 0;
        break;
      case MONDAY: case TUESDAY: case WEDNESDAY: case THURSDAY: case FRIDAY: 
        break;
      case SATURDAY: 
        return .9;
      default:
        break;
      }
    return dayRate;
  }
}
