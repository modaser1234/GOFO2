/***
 * @author Hossam El_Gendy & Modaser
 */
package GOFO;

/***
 * class Person
 */
public class Person {
	private String name;
    private int ID;
    private String password;
    private String email;
    private String phone;
    private String address;
    static int count = 0;

    /***
     * constructor to set name ,email,password,phone,address,ID
     */
    public Person() {
    	name = "";
    	email = "";
    	password = "";
    	phone = "";
    	address = "";
    	count++;
    	ID = count;
    }

    /***
     * constructor to set name ,email,password,phone,address,ID
     * @param _name name of person
     * @param _password password of person
     * @param _email email of person
     * @param _phone phone of person
     * @param _address address of person
     */
    public Person (String _name, String _password, String _email, String _phone, String _address) {
    	name = _name;
    	email = _email;
    	password = _password;
    	phone = _phone;
    	address = _address;
    	count++;
    	ID = count;
    }

    /***
     * set name of person
     * @param _name name of person
     */
    public void setName(String _name)
    {
        name = _name;
    }

    /***
     * set email of person
     * @param _email email of person
     */
    public void setEmail(String _email)
    {
        email = _email;
    }

    /***
     * set password of person
     * @param _password password of person
     */
    public void setPassword(String _password)
    {
        password = _password;
    }

    /***
     * set phone of person
     * @param _phone phone of person
     */
    public void setPhone(String _phone)
    {
        phone = _phone;
    }

    /***
     * set address of person
     * @param _address address of person
     */
    public void setAddress(String _address)
    {
    	address = _address;
    }

    /***
     * get name of person
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /***
     * get ID of person
     * @return ID
     */
    public int getID()
    {
        return ID;
    }

    /***
     * get password of person
     * @return password
     */
    public String getPassword()
    {
        return password;
    }

    /***
     * get email of person
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /***
     * get phone of person
     * @return phone
     */
    public String getPhone()
    {
        return phone;
    }

    /***
     * get address of person
     * @return address
     */
    public String getAddress() {
    	return address;
    }

}
