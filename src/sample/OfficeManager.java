package sample;
import basic.LoginAccount;
import basic.BikePart;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        super(username, password, firstName, lastName);
    }
	public OfficeManager() {
		
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
	/**
	 * orders the parts needed by generating a file and clearing the ordered list.
	 * @param si
	 */
	public void orderParts(ArrayList<SalesInvoice> si){
		ArrayList<BikePart> bpal = new ArrayList<BikePart>();
		for(int i = 0; i < si.size(); i++) {
			bpal.add(si.get(i).getPartSold());
		}
		toOrder = bpal;
		writeToFile(toOrder);
		clearToOrder();
		
	}
	/**
	 * getOrder() returns the parts that need to be ordered
	 * @return
	 */
	public ArrayList<BikePart> getOrder(){
		return toOrder;
	}
	/**
	 * 
	 * clearToOrder() clears the array list holding the parts that need to be ordered
	 */
	public void clearToOrder() {
		toOrder.clear();
	}
	/**
	 * writeToFile(bp) write the parts that need to be ordered to a file.
	 * @param bp
	 */
	public void writeToFile(ArrayList<BikePart> bp)
	{
		PrintWriter out = null;
		try {
    		out = new PrintWriter(new FileWriter(firstName+lastName+"orderedParts.txt"));
    		for(int i = 0; i < bp.size(); i++)
    		{
    		out.println(bp.get(i));
    		}
    		
        	}
        catch (IndexOutOfBoundsException e) 
    		{
            	System.err.println("IndexOutOfBoundsException: " + e.getMessage());
    		} 
    	catch (IOException e) 
    		{
            	System.err.println("Caught IOException: " + e.getMessage());
    		}
    	out.close();
	}
	@Override
	public String toString(){
		return "OfficeManager: " + firstName +" " +lastName + " " + username;
	}

}
