package sample;

/**\
 * A simple login account with a username and password, as well as a name and email
 * @author Mitchell Bisson
 *
 */
public class LoginAccount extends Person {
	
	protected String username;
	protected String password;
	
	public LoginAccount(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		super(firstName, lastName);
	}

}
