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
public abstract class ParkingObserver {
    public abstract void vehicleEntry(ParkingPermit customerPermit);
    public abstract void vehicleExit(ParkingPermit customerPermit, ParkingLot lot);
}
