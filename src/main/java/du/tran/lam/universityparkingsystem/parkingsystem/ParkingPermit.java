package du.tran.lam.universityparkingsystem.parkingsystem;

/* @author Lam Tran */
import java.time.LocalDateTime;

/**
 *
 * @author Lam Tran
 */
public class ParkingPermit {
  private String id;
  private Car car;
  private int citations;

  LocalDateTime current = LocalDateTime.now();
  //1 hour = 60 minutes = 60 × 60 seconds = 3600 seconds = 3600 × 1000 milliseconds = 3,600,000 ms.

    /**
     *
     */
  public static final long DAY = 1000 *3600 *24; 
  LocalDateTime expiration = current.plusYears(5);
  
    /**
     *
     * @param id
     * @param car
     */
    public ParkingPermit (String id, Car car){
    this.id = id;
    this.car = car;
    }

    /**
     *
     * @return
     */
    public int getCitations() {
    return citations;
  }

    /**
     *
     * @param citations
     */
    public void setCitations(int citations) {
    this.citations = citations;
  }

    /**
     *
     * @return
     */
    public String getId() {
    return id;
  }

    /**
     *
     * @param id
     */
    public void setId(String id) {
    this.id = id;
  }

    /**
     *
     * @return
     */
    public Car getCar() {
    return car;
  }

    /**
     *
     * @param Car
     */
    public void setCar(Car Car) {
    this.car = Car;
  }

    /**
     *
     * @return
     */
    public LocalDateTime getCurrent() {
    return current;
  }

    /**
     *
     * @param current
     */
    public void setCurrent(LocalDateTime current) {
    this.current = current;
  }

    /**
     *
     * @return
     */
    public LocalDateTime getExpiration() {
    return expiration;
  }

    /**
     *
     * @param expiration
     */
    public void setExpiration(LocalDateTime expiration) {
    this.expiration = expiration;
  } 

  @Override
  public String toString() {
    return "ParkingPermit [id=" + id + ", car=" + car + "]";
  }
}
