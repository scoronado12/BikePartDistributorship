package basic;

import java.util.ArrayList;

/**
=======

/* branch 'master' of https://github.com/scoronado12/BikePartDistributorship
 * A simple login account with a username and password, as well as a name and email
 * @author Mitchell Bisson
 *
 */
public class LoginAccount extends Person {

	protected ArrayList users = new ArrayList<LoginAccount>(); //database of users
	protected String username;
	protected String password;
	protected Person person;
	
	/**
	 * LoginAccount Constructor
	 * @param username ; username for the account
	 * @param password ; password for the account
	 */
	public LoginAccount(String username, String password, String firstName, String lastName) {
		super(firstName, lastName);
		this.username = username;
		this.password = password;
		
	}

	/** add() - Adds a enry to the ArrayList of usernames
	 *
	 * @param user
	 * @return size as int
	 */

	public int add(LoginAccount user){
		users.add(user);
		return users.size();
	}

	
	/**
	 * getUsername()
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * setUsername
	 * @param username ; creates a new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * getPassword
	 * @return username
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * setPassword
	 * @param password - changes the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
