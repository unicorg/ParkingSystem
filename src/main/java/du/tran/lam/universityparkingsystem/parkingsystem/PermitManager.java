package du.tran.lam.universityparkingsystem.parkingsystem;

import java.util.ArrayList;
/*@author Lam Tran
 */

/**
 *
 * @author Lam Tran
 */

public class PermitManager {

    /**
     *
     */
    public ArrayList<ParkingPermit> listOfParkingPermit = null;

    /**
     *
     * @return
     */
    public ArrayList<ParkingPermit> getListOfParkingPermit() {
    return listOfParkingPermit;
  }

    /**
     *
     * @param listOfParkingPermit
     */
    public void setListOfParkingPermit(ArrayList<ParkingPermit> listOfParkingPermit) {
    this.listOfParkingPermit = listOfParkingPermit;
  }
    
    /**
     *
     */
    public PermitManager (){
    this.listOfParkingPermit = new ArrayList<>();
  }

    /**
     *
     * @param NewCar
     */
    public void registerCar(Car NewCar){
  String id = Integer.toString(listOfParkingPermit.size());
  ParkingPermit entryPermit = new ParkingPermit(id,NewCar);
  this.listOfParkingPermit.add(entryPermit);}
  
  
}
