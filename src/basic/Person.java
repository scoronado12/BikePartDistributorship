package basic;
/**
 * Person, a simple class that will be the main super class for loginAccount and its subclasses
 * @author Mitchell Bisson
 *
 */
public class Person {
	/**
	 * Fields include the following:
	 * String firstName
	 * String lastName
	 * String email, dependant on the user's name
	 */
	protected String firstName;
	protected String lastName;
	protected String email;
	
	/**
	 * Person Object
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = firstName.substring(0,1) + lastName + "@bikeparts.com";
	}

	public Person() {

	}

	/**
	 * getName() - returns
	 * @return full name
	 */
	public String getName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * getFirstName
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * getLastName
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * setFirstName
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * setLastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * getEmail()
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * setEmail
	 * @param email - as String
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**toString - prints out the object as a string
	 *
	 * @return
	 */
	public String toString(){ return firstName + " " + lastName + " " + email; }

}
