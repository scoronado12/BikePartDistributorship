package sample;

/**
 * Sales Invoice is a class that will be used to keep track of each sale that is completed
 * @author Mitchell Bisson
 *
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

public class SalesInvoice {
	
	
	
	String customerName;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    Date time = new Date();
	String employeeName;
	BikePart partSold;
	double totalCost;
	int totalQuantity;
	/**
	 * Constructor for a sales invoice
	 * @param custName ; customer's name
	 * @param employName ; employee's name
	 * @param bp ; Bike part sold
	 * @param quantitySold ; number of parts sold
	 */
	public SalesInvoice(String custName, String employName, BikePart bp, int quantitySold) {
		customerName = custName;
		employeeName = employName;
		partSold = bp;
		totalQuantity = quantitySold;
		totalCost = bp.getPrice() * quantitySold;
	}
	/**
	 * setCustomerName
	 * @param custName ; what the customer's name will be set to
	 */
	public void setCustomerName(String custName) {
		customerName = custName;
	}
	
	/**
	 * setEmployeeName
	 * @param employName ; what the customer's name will be set to
	 */
	public void setEmployeeName(String employName) {
		employeeName = employName;
	}
	
	/**
	 * setPartSold
	 * @param bp ; what the bike part will be set to
	 */
	public void setBikePart(BikePart bp) {
		partSold = bp;
	}
	
	/**
	 * setQuantitySold
	 * @param quantitySold ; what the totalQuantity will be set to
	 */
	public void setQuantitySold(int quantitySold) {
		totalQuantity = quantitySold;
	}
	
	/**
	 * setTotalCost
	 * @param cost ; what the totalCost will be set to
	 */
	public void setTotalCost(double cost) {
		totalCost = cost;
	}
	

}
