package sample;

public class WhManager extends LoginAccount {


    /**
     * Warehouse Manager Constructor
     *
     * @param username  ; username for the account
     * @param password  ; password for the account
     * @param firstName ; creates a first name for the person
     * @param lastName  ; creates a last name for the person
     */
    public WhManager(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }

    public void displayInventory(){

    }

    public void transferInventory(){

    }

    public void updateInventory(){

    }

    /**
     * toString - prints out the object instance as a String
     * @return
     */
    public String toString() { return "Warehouse Manager: " +firstName + " " + lastName + " " + username; }



}
