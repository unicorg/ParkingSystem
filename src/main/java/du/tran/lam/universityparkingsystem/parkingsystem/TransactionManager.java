package du.tran.lam.universityparkingsystem.parkingsystem;
/* @author Lam Tran */

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Duration;

/**
 *
 * @author Lam Tran
 */
public class TransactionManager {
  private ArrayList<ParkingTransaction> listOfParkingTransaction = null;
  private ParkingChargeCalculatorFactory pcFactory = new ParkingChargeCalculatorFactory();
  
  //constructor

    /**
     *
     */
  public TransactionManager () {
    listOfParkingTransaction = new ArrayList<>();
  }
  //methods(parameter)

    /**
     *
     * @param dateTransactionStart
     * @param dateTransactionEnd
     * @param permitTransaction
     * @param parkingTransaction
     * @return
     */
  public ParkingTransaction park(LocalDateTime dateTransactionStart, LocalDateTime dateTransactionEnd, 
        ParkingPermit permitTransaction, ParkingLot parkingTransaction) {
    long cost = 0;
    ParkingCalculator transactionCalculator = pcFactory.getCalculator(permitTransaction, dateTransactionStart, dateTransactionEnd);
    cost = transactionCalculator.calculate(permitTransaction, parkingTransaction, dateTransactionStart, dateTransactionEnd);
    Money chargedAmount = new Money(cost,"USD");
    ParkingTransaction newTransaction = new ParkingTransaction(dateTransactionStart,dateTransactionEnd , permitTransaction, parkingTransaction,chargedAmount);
    listOfParkingTransaction.add(newTransaction);
    return newTransaction;
  }
  
    /**
     *
     * @param parkingChargesPermit
     * @return
     */
    public Money getParkingCharges (ParkingPermit parkingChargesPermit) {
      long temp = 0;
    
      for (int i = 0; i < listOfParkingTransaction.size();i++) {
        if (listOfParkingTransaction.get(i).getParkingPermit() == parkingChargesPermit) {
          temp += listOfParkingTransaction.get(i).getChargedAmount().getAmount();
        }
      }
      Money total = new Money(temp,"USD");
      return total;
    }
  
    /**
     *
     * @param parkingChargesCustomer
     * @return
     */
    public Money getParkingCharges (Customer parkingChargesCustomer) {
      long temp = 0;
      for (int i = 0; i < listOfParkingTransaction.size();i++) {
        if (listOfParkingTransaction.get(i).getParkingPermit().getCar().getCustomer() == parkingChargesCustomer) {
            temp += listOfParkingTransaction.get(i).getChargedAmount().getAmount();
        }
      }
      Money total = new Money(temp,"USD");
      return total;
    }
}