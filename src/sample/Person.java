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
	 * Constructor
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = firstName.substring(0,1) + lastName + "@bikeparts.com";
	}
	
	/**
	 * getName
	 * returns full name
	 */
	public String getName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * getEmail
	 * returns email
	 */
	public String getEmail() {
		return email;
	}

}
