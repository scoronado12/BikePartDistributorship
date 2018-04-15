package sample;
import basic.LoginAccount;
import basic.BikePart;

import java.util.ArrayList;
/**
 * OfficeManager class
 * @author Mitchell Bisson
 *
 */
public class OfficeManager extends LoginAccount {
	
	/**
     * OfficeManager Constructor
     *
     * @param username  ; username for the account
     * @param password  ; password for the account
     * @param firstName ; creates a first name for the person
     * @param lastName  ; creates a last name for the person
     */
	
	//ArrayList of BikeParts needed to be ordered
	ArrayList<BikePart> toOrder = new ArrayList<BikePart>();
	
	public OfficeManager(String username, String password, String firstName, String lastName) {
        super(username, password);
    }
	/**
	 * generatePaycheckAndOrderParts ; a method that generates a paycheck, orders the parts that have been sold,
	 * and clears the SalesAssociate's totalSales, so he can't be paid for the same sales twice.
	 * 
	 * @param sa ; the SalesAssociate that is getting paid
	 * @return totalPaycheck ; returns the total amount the SalesAssociate is paid
	 */
	public double generatePaycheckAndOrderParts(SalesAssociate sa) {
		double totalPaycheck = 0.0;
		double moneyPerSale = 0.0;
		
		ArrayList<SalesInvoice> si = sa.getTotalSales();
		
		for(int i = 0; i < si.size(); i++) {
			moneyPerSale = si.get(i).getTotalCost();
			totalPaycheck = moneyPerSale * 0.15;
		}
		orderParts(si);
		sa.resetSales();
		return totalPaycheck;
	}
	
	public void orderParts(ArrayList<SalesInvoice> si){
		ArrayList<BikePart> bpal = new ArrayList<BikePart>();
		for(int i = 0; i < si.size(); i++) {
			bpal.add(si.get(i).getPartSold());
		}
		toOrder = bpal;
	}
	
	public ArrayList<BikePart> getOrder(){
		return toOrder;
	}
	
	public void clearToOrder() {
		toOrder.clear();
	}

}
