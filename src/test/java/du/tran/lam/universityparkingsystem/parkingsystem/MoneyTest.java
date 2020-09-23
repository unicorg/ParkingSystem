package du.tran.lam.universityparkingsystem.parkingsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Lam Tran
 */
public class MoneyTest {
  Money moneyTest = new Money(7,"USD");

  public MoneyTest() {  
  }
  
     /**
   * Test of getMoney method, of class Money.
   */
  @Test
  public void testGetMoney() {
    double expResult = 7;
    assertEquals(expResult, moneyTest.getAmount());
  }

  
  /**
   * Test of setMoney method, of class Money.
   */
  @Test
  public void testSetMoney() {
    moneyTest.setAmount(7);
    assertEquals(7, moneyTest.getAmount());
  }

  /**
   * Test of getCurrencyType method, of class Money.
   */
  @Test
  public void testgetCurrencyType() {
    String result = "USD";
    assertEquals(result, moneyTest.getCurrency());
  }
  
}
