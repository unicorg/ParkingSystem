package du.tran.lam.universityparkingsystem.parkingsystem;

import java.time.LocalDateTime;
/** @author Lam Tran*/
public class ParkingTransaction {
  private LocalDateTime start;
  private LocalDateTime end;
  private ParkingPermit permit;
  private ParkingLot parkingLot;
  Money chargedAmount;
  
    /**
     *
     * @param start
     * @param end
     * @param permit
     * @param parkingLot
     * @param chargedAmount
     */
    public ParkingTransaction (LocalDateTime start,LocalDateTime end, ParkingPermit permit, ParkingLot parkingLot, Money chargedAmount){
    this.start = start;
    this.end = end;
    this.parkingLot = parkingLot;
    this.permit = permit;
    this.chargedAmount = chargedAmount;
  }

    /**
     *
     * @return
     */
    public LocalDateTime getStart() {
    return start;
  }

    /**
     *
     * @param start
     */
    public void setStart(LocalDateTime start) {
    this.start = start;
  }

    /**
     *
     * @return
     */
    public LocalDateTime getEnd() {
    return end;
  }

    /**
     *
     * @param end
     */
    public void setEnd(LocalDateTime end) {
    this.end = end;
  }

    /**
     *
     * @return
     */
    public ParkingPermit getPermit() {
    return permit;
  }

    /**
     *
     * @param permit
     */
    public void setPermit(ParkingPermit permit) {
    this.permit = permit;
  }

    /**
     *
     * @return
     */
    public ParkingLot getParkingLot() {
    return parkingLot;
  }

    /**
     *
     * @param parkingLot
     */
    public void setParkingLot(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }

    /**
     *
     * @return
     */
    public ParkingPermit getParkingPermit(){
    return this.permit;
  }
  
    /**
     *
     * @return
     */
    public Money getChargedAmount() {
    return chargedAmount;
  }

    /**
     *
     * @param chargedAmount
     */
    public void setChargedAmount(Money chargedAmount) {
    this.chargedAmount = chargedAmount;
  }
}
