package basic;

import java.util.ArrayList;

/** WarehouseDB - Keeps Track of Warehouse Instances
 * @author scoronado
 */


public class WarehouseDB {


    /** ArrayList of Warehouses to keep track of
     *
     */
    private ArrayList warehouses = new ArrayList<Warehouse>();
    private Warehouse wh;

    /**WarehouseDB
     * Defines what a warehouse should look like
     * @param warehouses ;
     */
    public WarehouseDB(ArrayList warehouses){
        this.warehouses = warehouses;
    }

    /**
     * add(wh) - Inserts a new Warehouse instance into the database
     * @param wh
     */

    public void add(Warehouse wh){
        warehouses.add(wh);
    }

    public void remove(Warehouse wh){
        warehouses.remove(wh)
    }

    public Warehouse getWh(){
        return wh;
    }




}
