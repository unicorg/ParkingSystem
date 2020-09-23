package du.tran.lam.universityparkingsystem.parkingsystem;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Customer {
  private String id;
  private String firstName;
  private String lastName;
  private final String name;
  private String phoneNumber;

  @JsonCreator
  public Customer(
      @JsonProperty("id") String id,
      @JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName,
      @JsonProperty("phoneNumber") String phoneNumber) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.name = firstName + " " + lastName;
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Customer)) {
      return false;
    }
    Customer other = (Customer) obj;
    if ((firstName + " " + lastName) == null) {
      return other.name == null;
    } else {
      return name.equals(other.name);
    }
  }

  @Override
  public String toString() {
    return "Customer [name=" + name + "]";
  }
}
