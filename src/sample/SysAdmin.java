package sample;

public class SysAdmin extends LoginAccount {
    /**
     * System Administrator Constructor
     *
     * @param username  ; username for the account
     * @param password  ; password for the account
     * @param firstName ; creates a first name for the person
     * @param lastName  ; creates a last name for the person
     */
    public SysAdmin(String username, String password, String firstName, String lastName) {
        super(username, password);
    }

    /**
     * createUser - creates a new user
     * @param newUser
     */
    public void createUser(LoginAccount newUser){
        System.out.println("Creating user " + newUser.getUsername());
        users.add(newUser);
    }

    /**
     * deleteUser() - removes a user from the list of Users
     * @param firedUser
     */
    public void deleteUser(LoginAccount firedUser){
        System.out.println("Removing user " + firedUser.getUsername());
        users.remove(firedUser);
    }

    public String toString(){
        return "System Administrator: " + firstName + " " + lastName + " " + username; }
}
