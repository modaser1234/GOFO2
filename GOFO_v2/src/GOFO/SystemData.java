/***
 * @author Hossam El_Gendy & Modaser
 */
package GOFO;
import java.util.ArrayList;

//This class is the data base for our system.

/***
 * class SystemData
 */
public class SystemData {
	/***
	 * list of players
	 */
	public static ArrayList<Player> players = new ArrayList<Player>();
	/***
	 *list of PlaygroundOwners
	 */
	public static ArrayList<PlaygroundOwner> owners = new ArrayList<PlaygroundOwner>();
	/***
	 * list of playgrounds
	 */
	public static ArrayList<Playground> playgrounds = new ArrayList<Playground>();
}
