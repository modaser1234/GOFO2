package GOFO;
/***
 * @author Hossam El_Gendy & Modaser
 */
import java.util.Scanner;

/***
 * class Player
 */
public class Player extends Person {
	private PaymentService eWallet;
	Scanner input = new Scanner(System.in);

	/***
	 * constructor
	 */
	public Player()
	{
		eWallet = new PaymentService();
	}

	/***
	 * set balance of player
	 * @param _balance balance of player
	 */
	public void setBalance(double _balance)
	{
	 eWallet.setBalance( _balance);;
	}

	/***
	 * get balance of player
	 * @return eWallet.getBalance()
	 */
	public double getBalance()
	{
	 return eWallet.getBalance();
	}

	/***
	 * add credits
	 * @param value money that will be deposit
	 */
	public void addCredits(double value)
	{
		eWallet.deposit(value);
	}

	/***
	 * withdraw
	 * @param value value of money to withdraw
	 */
	public void withdraw(double value)
	{
		eWallet.withdraw(value);
	}

	/***
	 *
	 */
	public void bookPlayground()
	{
		String playgroundName;
		System.out.println("Enter the playground name:");
		playgroundName = input.next();
		//search for playground.
		boolean exists = false;
		int playgroundIndex = 0;
		for(int i = 0; i < SystemData.playgrounds.size(); i++)
		{
			if (SystemData.playgrounds.get(i).getName().equals(playgroundName))
			{
				playgroundIndex = i;
				exists = true;
				break;
			}
		}
		if(!exists) {
			System.out.println("There is no playground with that name.");
			return;
		}
		//display available hours and price for the playground
		SystemData.playgrounds.get(playgroundIndex).displayAvailableSlots();
		System.out.println("The price/hour is: " + SystemData.playgrounds.get(playgroundIndex).getPrice());
		int start, end;
		System.out.println("Enter the start time of your booking (24 hour format):");
		start = input.nextInt();
		System.out.println("Enter the end time of your booking (24 hour format):");
		end = input.nextInt();
		
		//make sure time is entered properly.
		if (end <= start)
		{
			System.out.println("Time not entered properly!. Make sure end time is greater than start time.");
			return;
		}
		//calculate money.
		double bookingPrice = SystemData.playgrounds.get(playgroundIndex).getPrice() * (end - start);
		if(getBalance() < bookingPrice)
		{
			System.out.println("Sorry, you don't have enough balance. Maximum withdraw is " + getBalance());
			return;
		}
		try
		{
			//book the time slot.
			SystemData.playgrounds.get(playgroundIndex).bookTimeSlot(start, end);
			//transfer money.
			this.withdraw(bookingPrice);
			SystemData.playgrounds.get(playgroundIndex).getOwner().addCredits(bookingPrice);
			System.out.println("You have successfully booked this playground from " + start + " to " + end + ", you paid " + bookingPrice);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
	
}
