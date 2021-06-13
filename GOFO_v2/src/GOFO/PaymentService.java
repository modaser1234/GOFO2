/***
 @author Hossam El_Gendy & Modaser
 */
package GOFO;

/***
 * class PaymentService
 */
public class PaymentService {
	private double balance;

	/***
	 * constructor to set balance with 0
	 */
	public PaymentService() {
		balance = 0;
	}

	/***
	 *set balance
	 * @param _balance balance
	 */
	public void setBalance(double _balance) {
		balance = _balance;
	}

	/***
	 * get balance
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}

	/***
	 * withdraw
	 * @param value of money to withdraw
	 */
	public void withdraw(double value){
		if(value > balance)
	       {
			   System.out.println("Sorry, you don't have enough balance. Maximum withdraw is " + balance);
	       }
	       else
	       {
	           balance = balance - value;
	       }
	}

	/***
	 * deposit
	 * @param value value of money to deposit
	 */
	public void deposit(double value)
    {
        balance = balance + value;
    } 
	

}
