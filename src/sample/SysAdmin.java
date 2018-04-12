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
        super(username, password, firstName, lastName);
    }


    public void createUser(){

    }

    public void deleteUser(){

    }

    public String toString(){
        return "System Administrator: " + firstName + " " + lastName + " " + username; }
}
