/** The BikePart class contains an object called BikePart
 *  that carries the attributes of a bicycle part.
 *  This class attempts to fill the use case of different command lines.
 *  @author scoronado
 *  @since 2018-01-26
 *
 */
package basic;

public class BikePart{

    /**
     * Fields include the following:
     * Name of parts (PartName) as String
     * Item Part Number (partNumber) as int
     * List Price (listPrice) as double
     * Sale Price (salesPrice) as double
     * Weather or not the part is on sale (isOnSale) as boolean
     * Quantity of how much there is
     * ArrayList of Entries
     * double of a finalCost dependent on the isOnSale() Boolean
     */

    protected String partName;
    protected int partNumber;
    protected double listPrice;
    protected double salesPrice;
    protected boolean isOnSale;
    protected int quantity;

    protected double finalCost;


    /**
     * Bike Part Object
     *
     * @param partName   Part Name
     * @param partNumber Part Number (similar to an SKU in a large retailer)
     * @param listPrice  double
     * @param salesPrice double
     * @param isOnSale   true or false boolean
     */


    public BikePart(String partName, int partNumber, double listPrice, double salesPrice, boolean isOnSale, int quantity) {

        this.partName = partName;
        this.partNumber = partNumber;
        this.listPrice = listPrice;
        this.salesPrice = salesPrice;
        this.isOnSale = isOnSale;
        this.quantity = quantity;
    }



    /**
     * getPartNumber() getter method
     *
     * @return partNumber of type int
     */

    public int getPartNumber() {
        return partNumber;
    }

    /**
     * getPartName() getter method
     *
     * @return partName of type String
     */

    public String getPartName() {
        return partName;
    }


    /**
     * setSale() - setter method for selling parts
     *
     * @return void
     */

    public void setSale(boolean isOnSale) {
        this.isOnSale = isOnSale;


    }


    /**
     * isOnSale() getter method
     *
     * @return isOnSale - A boolean of the object BikePart
     */
    public boolean isOnSale() {
        return isOnSale;
    }


    public double getSalesPrice() {
        return salesPrice;
    }

    public double getListPrice() {
        return listPrice;
    }


    /**
     * getPrice() Returns the final Price of a specific object when called.
     *
     * @return final
     */
    public double getPrice() {
        if (isOnSale() == true) {
            finalCost = salesPrice;
        } else {
            finalCost = listPrice;
        }

        return finalCost;
    }

    /**
     * setPrice() sets the cost of an object to display depending on if the object is on sale or not.
     *
     * @param newPrice
     */

    public void setPrice(double newPrice) {
        if (isOnSale() == false) {
            this.listPrice = newPrice;
        } else {
            this.salesPrice = newPrice;
        }
    }


    /**
     * setListPrice() sets a new List Price when called upon
     *
     * @param newPrice
     */
    public void setListPrice(double newPrice) {
        this.listPrice = newPrice;
    }

    /**
     * setSalesPrice()
     * sets a new sales price when called upon
     *
     * @param newPrice
     */

    public void setSalesPrice(double newPrice) {
        this.salesPrice = newPrice;
    }

    /**
     * getQuantity() getter method, sees how much is there of an object
     *
     * @return quantity
     */
    public int getQuantity() { //it works

        return quantity;
    }

    /**
     * sellDecreaseQuantity() should be called when an object gets sold
     */

    public void sellDecreaseQuantity() {

        int newQuantity = this.quantity - 1;
        quantity = newQuantity;

    }

    /**
     * addQuantity() gets called when more of an object gets added
     *
     * @param quant - a quantity that gets added
     * @return newQuantity - the sum of the old quantity and the new one
     */
    public int addQuantity(int quant) {
        int newQuantity = this.quantity + quant;
        return newQuantity;
    }

    /**
     * setQuantity() - overrides accumulator
     */
    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    /**
     * setQuantity( int newQuantity, BikePart bp) - sets a quantity based on the BikePart instance passed with it
     */
    public void setQuantity(int newQuantity, BikePart bp) {
        bp.quantity = newQuantity;
    }


    /**
     * toString() allows for main functions to print out one line of bicycle inventory
     * Not recommended for use in a display method
     *
     * @return BikePart object as a string
     */

    @Override
    public String toString() {

        return partName + "," + partNumber + "," + listPrice + "," + salesPrice + "," + isOnSale + "," + quantity + "\n";
    }


}
