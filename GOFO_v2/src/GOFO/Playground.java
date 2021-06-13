/***
 * @author Hossam El_Gendy & Modaser
 */
package GOFO;
import java.util.ArrayList;
import java.util.Scanner;

/***
 * class Playground
 */
public class Playground {
	private String name;
	private PlaygroundOwner owner;
	private String location;
	private double pricePerHour;
	private int cancelationPeriod;
	private ArrayList<Integer> availableHoursStart; //hold only the start time of each available hour in the playground.
	Scanner input = new Scanner(System.in);

	/***
	 * constructor
	 */
	public Playground()
	{
		availableHoursStart = new ArrayList<Integer>();
	}

	/***
	 * set cancelation period
	 * @param time time of cancelition period
	 */
	public void setCancelationPeriod(int time)
	{
	    cancelationPeriod = time;
	}

	/***
	 * get cancelation period
	 * @return cancelationPeriod
	 */
	public int getCancelationPeriod()
	{
	    return cancelationPeriod;
	}

	/***
	 * set owner of playground
	 * @param _owner owner of the playground
	 */
	public void setOwner(PlaygroundOwner _owner)
	{
	    owner = _owner;
	}

	/***
	 * get owner of playground
	 * @return owner
	 */
	public PlaygroundOwner getOwner()
	{
		return owner;
	}

	/***
	 * set name of playground
	 * @param _name name of playground
	 * @throws Exception to ensure the name of playground is unique.
	 */
	//the playground name has to be unique.
	public void setName(String _name) throws Exception
	{
		boolean exists = false;
		for(int i = 0; i < SystemData.playgrounds.size(); i++)
		{
			if (SystemData.playgrounds.get(i).getName().equals(_name))
			{
				exists = true;
				break;
			}
		}
		if(exists) {
			throw new Exception("This name already exists.");
		}
		else {
			name = _name;
		}
	}

	/***
	 * get name of playground
	 * @return name
	 */
	public String getName()
	{
	    return name;
	}

	/***
	 * set Location of playground
	 * @param _location location of playground
	 */
	public void setLocation(String _location)
	{
	    location = _location;
	}

	/***
	 * get Location of playground
	 * @return  location
	 */
	public String getLocation()
	{
	    return location;
	}

	/***
	 * set Price per hour
	 * @param price price per hour
	 */
	public void setPrice(double price)
	{
	    pricePerHour = price;
	}

	/***
	 * get price per hour
	 * @return pricePerHour
	 */
	public double getPrice()
	{
	    return pricePerHour;
	}

	/***
	 * set available hours
	 * @param begin begin of available hour
	 * @param end end of available hour
	 */
	public void setAvailableHours(int begin, int end)
	{
		for(int i = begin; i < end; i++)
		{
			availableHoursStart.add(i);
		}
	}

	/***
	 * display available slots
	 */
	public void displayAvailableSlots()
	{
		System.out.println("Free time Slots:");
		for(int i = 0; i < availableHoursStart.size(); i++)
		{
			System.out.println(availableHoursStart.get(i) + " to " + (availableHoursStart.get(i) + 1));
		}
	}

	/***
	 * book time slot
	 * @param begin begin of time slot
	 * @param end end of time slot
	 * @throws Exception to ensure the time slot is available.
	 */
	public void bookTimeSlot(int begin, int end) throws Exception
	{
		for(int i = begin; i < end; i++)
		{
			if(!availableHoursStart.contains(i))
			{
				throw new Exception("This time slot is not available!");
			}
		}
		int beginIndex = 0;
		for(int i = 0; i < availableHoursStart.size(); i++)
		{
			if(availableHoursStart.get(i) == begin)
			{
				beginIndex = i;
				break;
			}
		}
		for(int i = begin; i < end; i++)
		{
			availableHoursStart.remove(beginIndex);
		}
	}

	/***
	 *
	 * @throws Exception to ensure the name of playground is unique.
	 */
	public void fillData() throws Exception
	{
		System.out.println("Enter the playground name:");
		setName(input.next());
		System.out.println("Enter the playground location");
		location = input.next();
		System.out.println("Enter the playground price/hour");
		pricePerHour = input.nextDouble();
		System.out.println("Enter the playground cancelation period in hours");
		cancelationPeriod = input.nextInt();
		int open, close;
		System.out.println("when does the playground open? (24 hour format)");
		open = input.nextInt();
		System.out.println("when does the playground close? (24 hour format)");
		close = input.nextInt();
		while (open >= close)
		{
			System.out.println("Time not entered properly!. Make sure close time is after open time.");
			System.out.println("when does the playground open? (24 hour format)");
			open = input.nextInt();
			System.out.println("when does the playground close? (24 hour format)");
			close = input.nextInt();
		}
		setAvailableHours(open, close);
	}

}
