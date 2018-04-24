package sample;

/**
 * Sales Invoice is a class that will be used to keep track of each sale that is completed
 * @author Mitchell Bisson
 *
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import basic.BikePart;

public class SalesInvoice {

	
	String customerName;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    Date time = new Date();
	String employeeName;
	BikePart partSold;
	double totalCost;
	int totalQuantity;

	ArrayList<SalesInvoice> soldBikeParts = new ArrayList<SalesInvoice>();
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

	/**
	 * getCustomerName
	 * @return customerName ; returns customer name
	 */
	public String getCustomerName() {
		return customerName;
	}
	
	/**
	 * getEmployeeName
	 * @return employeeName ; returns employee name
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	
	/**
	 * getTime
	 * @return time ; returns the time of the sale
	 */
	public String getTime() {
		return dateFormat.format(time);
	}
	
	/**
	 * getPartSold
	 * @return partSold ; returns the part sold
	 */
	public BikePart getPartSold() {
		return partSold;
	}
	
	/**
	 * getTotalCost
	 * @return totalCost ; returns total cost
	 */
	public double getTotalCost() {
		return totalCost;
	}
	
	/**
	 * getTotalQuantity
	 * @return totalQuantity ; returns total quantity sold
	 */
	public int getTotalQuantity() {
		return totalQuantity;
	}
	
	public String toString() {
		return "The customer's name was " + customerName +". \n The employee who sold the part's name was " + employeeName + ".  \nThe transaction took place at " + dateFormat.format(time) +".  \nThere were " + totalQuantity + " " + partSold.getPartName() + "s sold.  \nThe total cost of this transaction was $" + totalCost + ".";
	}

}
