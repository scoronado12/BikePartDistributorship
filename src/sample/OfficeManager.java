package sample;

import java.util.ArrayList;
public class OfficeManager extends LoginAccount {
	
	/**
     * OfficeManager Constructor
     *
     * @param username  ; username for the account
     * @param password  ; password for the account
     * @param firstName ; creates a first name for the person
     * @param lastName  ; creates a last name for the person
     */
	
	public OfficeManager(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }
	
	public double generatePaycheck(SalesAssociate sa) {
		double totalPaycheck = 0.0;
		double moneyPerSale = 0.0;
		
		ArrayList<SalesInvoice> si = sa.getTotalSales();
		
		for(int i = 0; i < si.size(); i++) {
			moneyPerSale = si.get(i).getTotalCost;
			totalPaycheck = moneyPerSale * 0.15;
		}
		return totalPaycheck;
	}

}
