package sample;

public class SalesAssociate extends LoginAccount {
    /**
     * SalesAssociate Constructor
     *
     * @param username  ; username for the account
     * @param password  ; password for the account
     * @param firstName ; creates a first name for the person
     * @param lastName  ; creates a last name for the person
     */
    public SalesAssociate(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }

    @Override
    public String toString() {
        return "SalesAssociate " + firstName + " " + lastName + " " + username + " " + email; }
}
