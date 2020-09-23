package du.tran.lam.universityparkingsystem.parkingsystem;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
  private final String licensePlate;
  private final Customer owner;

  @JsonCreator
  public Car( 
      @JsonProperty("type") CarType Type,
      @JsonProperty("license") String license, 
      @JsonProperty("customer") Customer customer) {
    this.Type = Type;
    this.licensePlate = license;
    this.owner = customer;
  }

  public String getLicensePlate() {
    return licensePlate;
  }
  

  public Customer getCustomer() {
    return owner;
  }
  
  /**
     *
     * @return
     */
    public CarType getType() {
    return Type;
  }

    /**
     *
     * @param Type
     */
    public void setType(CarType Type) {
    this.Type = Type;
  }

  @Override
  public String toString() {
    return "Car [license=" + licensePlate + ", customer=" + owner + "]";
  }
  
      /**
     *
     */
    public enum CarType {
      COMPACT, 
      SUV; } CarType Type;
}

