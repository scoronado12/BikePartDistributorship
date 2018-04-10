package sample;

/**
=======

/* branch 'master' of https://github.com/scoronado12/BikePartDistributorship
 * A simple login account with a username and password, as well as a name and email
 * @author Mitchell Bisson
 *
 */
public class LoginAccount extends Person {
	
	protected String username;
	protected String password;
	/**
	 * LoginAccount Constructor
	 * @param username ; username for the account
	 * @param password ; password for the account
	 * @param firstName ; creates a first name for the person
	 * @param lastName ; creates a last name for the person
	 */
	public LoginAccount(String username, String password, String firstName, String lastName) {
	    super(firstName, lastName);
		this.username = username;
		this.password = password;
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
	 * @param username - creates a new username
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
