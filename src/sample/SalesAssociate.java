package sample;

import java.util.ArrayList;
import basic.LoginAccount;
import basic.Warehouse;
import basic.BikePart;

public class SalesAssociate extends LoginAccount {
	
	protected static Warehouse wh = new Warehouse();
	
    /**
     * SalesAssociate Constructor
     *
     * @param username  ; username for the account
     * @param password  ; password for the account
     * @param firstName ; creates a first name for the person
     * @param lastName  ; creates a last name for the person
     */

	//ArrayList to keep track of each sale
	ArrayList<SalesInvoice> totalSales = new ArrayList<SalesInvoice>();
	
    public SalesAssociate(String username, String password, String firstName, String lastName, String salesVan) {
        super(username, password, firstName, lastName);
        wh.setName(salesVan);
        
    }
    
    /**
     * sell Method ; when a SalesAssociate sells a part, adds the salesInvoice generated to totalSales
     * 
     * @param customerName ; name of the customer the part is sold to
     * @param partSold ; the BikePart that is sold
     * @param quantitySold ; the total amount of the part sold
     */
    public void sell(String customerName, BikePart partSold, int quantitySold) {
    	String associateName = firstName + lastName;
    	SalesInvoice newSale = new SalesInvoice(customerName, associateName, partSold, quantitySold);
    	totalSales.add(newSale);
    }
    
    public ArrayList<SalesInvoice> getTotalSales(){
    	return totalSales;
    }
    
    public void resetSales() {
    	totalSales.clear();
    }
    
    public static String getSalesVan() {
    	return salesVan;
    }

    @Override
    public String toString() {
        return "SalesAssociate " + firstName + " " + lastName + " " + username + " " + email; }
}
