package GOFO;
/**
 * @author Hossam El_Gendy & Modaser
 */
import java.util.Scanner;

/***
 * class PlaygroundOwner
 */
public class PlaygroundOwner extends Person {

	private PaymentService eWallet;
	Scanner input = new Scanner(System.in);

	/***
	 * constructor
	 */
	public PlaygroundOwner()
	{
		eWallet = new PaymentService();
	}

	/***
	 * set balance of Playground owner
	 * @param _balance balance of Playground owner
	 */
	public void setBalance(double _balance)
	{
	 eWallet.setBalance(_balance);;
	}

	/***
	 * get balance
	 * @return eWallet.getBalance()
	 */
	public double getBalance()
	{
	 return eWallet.getBalance();
	}

	/***
	 * add credits
	 * @param value amount of money we  want to deposit
	 */
	public void addCredits(double value)
	{
		eWallet.deposit(value);
	}

	/***
	 * withdraw
	 * @param value amount of money we  want to withdraw
	 */
	public void withdraw(double value)
	{
		eWallet.withdraw(value);
	}

	/***
	 * add a playground
	 */
	public void addPlayground()
	{
		try
		{
			Playground playground = new Playground();
			playground.fillData();
			playground.setOwner(this);
			SystemData.playgrounds.add(playground);
			System.out.println("Playground added successfully.");
			System.out.println("--------------------------------");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	

}
