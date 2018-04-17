package basic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;

/** This Warehouse Class defines the properties of a Warehouse.
 * A warehouse has an inventory made up of BikeParts.
 * The included methods help manipulate warehouses and the BikeParts stored inside.
 * @author scoronado
 * @since 2018-03-01
 */

public class Warehouse{

    private String warehouseName;

    public BikePart bp;
    public Warehouse wh;
    public ArrayList<BikePart> BikePartList = new ArrayList<>();


    /** Warehouse Object
     * Defines the properties of a warehouse - has a name and inventory of bike parts
     * @param warehouseName
     * @param inventory Inventory
     */

    public Warehouse(String warehouseName, ArrayList<BikePart> inventory){

        this.warehouseName = warehouseName;

        this.BikePartList = inventory;

    }
    
    /**
     * Warehouse Object
     * Default constructor
     */
      public Warehouse(){
      warehouseName = "Default";
     }
      
      /**
       * setName()
       * sets the name of the warehouse
       * @param warehouseName()
       */
      public void setName(String warehouseName) {
    	  this.warehouseName = warehouseName;
      }
      
      
     

    /**getWarehouse()
     *
     * @return a warehouse
     */

    public Warehouse getWarehouse(){
         return wh;
    }

    /**getWarehouseName
     *
     * @return warehouseName - String
     */

    public String getWarehouseName(){
        return warehouseName;
    }

    /**printAll()
     * Prints out everything in the warehouse
     *
     * @return s - String
     */

    public String printAll(){
        String s = "";
        int i = 0;
        for (BikePart bp : BikePartList){
            s += BikePartList.get(i).getPartName() + "\t" + BikePartList.get(i).getPartNumber() + "\t" + BikePartList.get(i).getListPrice() + "\t" + BikePartList.get(i).getSalesPrice() +"\t"+ BikePartList.get(i).getQuantity() +"\t" + BikePartList.get(i).isOnSale()+"\n";
            i++;
        }
        return s;

    }

    /** remove() - removes a BikePart passed in
     *
     * @param bp
     * @return
     */

    public int remove(BikePart bp) {
        BikePartList.remove(bp);

        return BikePartList.size();
    }


    /**getBp() - returns a BikePart
     *
     * @return bp - BikePart
     */
    public BikePart getBp() {
        return bp;
    }


    /** findBp(PartName) - returns a BikePart based the name passed
     *
     * @param partName - String
     * @return i - A BikePart
     */

    public BikePart findBp(String partName) {
        for (BikePart bp : BikePartList) {
            if (bp.getPartName().equals(partName)) {
                return bp;
            }
        }
        return null;
    }

    /** findBp(PartName) - returns a BikePart based the part number passed
     *
     * @param partNumber - int
     * @return i - A BikePart
     */

    public BikePart findBp(int partNumber) {
        for (BikePart bp : BikePartList) {

            if (bp.getPartNumber() == partNumber){
                return bp;
            }
        }
        return null;
    }


    /**
     * Returns the size of the BikePartList
     *
     * @return an int of how big the BikePartList array is
     */

    public int size() {
        return BikePartList.size();
    }


    /**add(ArrayList bikeParts) - adds an arraylist to the inventory
     *
     * @param bikeParts - an ArrayList containing BikeParts
     */

    public void add(ArrayList<BikePart> bikeParts) {
        for (BikePart bp : bikeParts){
            BikePartList.add(bp);
        }
    }


    /**
     * add(bp) Adds an entry to the ArrayList of BikeParts
     *
     * @param bp BikePart Entry
     */

    public int add(BikePart bp) {

        BikePartList.add(bp);

        return BikePartList.size();
    }


    /**
     * getPartInfoToDisplay(partNombre) is used to query a BikePart object based on passing the part name
     *
     * @param partNombre - Part Name as String
     * @return partInfo as string
     */


    public String getPartInfoToDisplay(String partNombre) {
        int i = 0;
        String partInfo = null;

        for (BikePart bp : BikePartList) {
            if (bp.getPartName() != null && bp.getPartName().equals(partNombre)) {

                partInfo = "Part Name: " + BikePartList.get(i).getPartName() + "\nCost: " + BikePartList.get(i).getPrice() + "\nQuantity: " + BikePartList.get(i).getQuantity();
            }
            i++;
        }

        if (partInfo == null) {
            System.err.println("This Bike Part does not exist! \n");
            return partInfo;
        }

        return partInfo;
    }

    /**
     * getPartInfo(partNum) Queries a BikePart object based on passing the part number and decreases quantity
     *
     * @param partNum - PartNumber as int
     * @return partName - as String
     */

    public String getPartInfoToSell(int partNum) {
        int i = 0;
        String partInfo = null;
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date time = new Date();
        for (BikePart bp : BikePartList) {
            if (bp.getPartNumber() != 0 && bp.getPartNumber() == partNum) {

                partInfo = "Part Name: " + BikePartList.get(i).getPartName() + "\nPartCost: " + BikePartList.get(i).getPrice() + "\nOn Sale? " + BikePartList.get(i).isOnSale() + "\nTime Sold: " + dateFormat.format(time) + "\n Quantity Left before sale: " + BikePartList.get(i).getQuantity();
                BikePartList.get(i).sellDecreaseQuantity();

                if (bp.getQuantity() <= 0){
                    System.out.println("Out of this part. Removing...");
                    BikePartList.remove(findBp(partNum));
                }


            }
            i++;
        }

        if (partInfo == null) {

            System.out.println("This Bike Part does not exist!");
            return partInfo;
        }

        return partInfo;

    }


    /**
     * toString - allows the warehouse to be referenced by name
     * @return warehouseName - String
     */
    @Override
    public String toString(){

        return warehouseName;
    }


}


