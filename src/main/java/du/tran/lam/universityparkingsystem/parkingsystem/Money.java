package du.tran.lam.universityparkingsystem.parkingsystem;

/* * @author Lam Tran */

/**
 *
 * @author Lam Tran
 */


public class Money {
  private long amount;
  private String currency;

  /**
   *
   * @param amount
   * @param currency
   */
  public Money (long amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  /**
   *
   * @return
   */
  public long getAmount() {
    return amount;
  }

  /**
   *
   * @param amount
   */
  public void setAmount(long amount) {
    this.amount = amount;
  }

  /**
   *
   * @return
   */
  public String getCurrency() {
    return currency;
  }

  /**
   *
   * @param currency
   */
  public void setCurrency(String currency) {
    this.currency = currency;
  }
}