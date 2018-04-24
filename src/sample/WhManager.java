package sample;
import basic.BikePart;
import basic.LoginAccount;
import basic.Warehouse;
import basic.fileActions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WhManager extends LoginAccount {


    /**
     * Warehouse Manager Constructor
     *
     * @param username  ; username for the account
     * @param password  ; password for the account
     * @param firstName ; creates a first name for the person
     * @param lastName  ; creates a last name for the person
     * @param Warehouse; The maintained warehouse of the user
     */
    protected static Warehouse wh = new Warehouse();
	private static Scanner read;
	protected String warehouseName;
/**
 * WhManager Object
 * @param username ; username for account
 * @param password ; password for account
 * @param firstName ; user's first name
 * @param lastName ; user's last name
 * @param warehouseName ; name of the warehouse user is managing
 */
    public WhManager(String username, String password, String firstName, String lastName, Warehouse warehouse) {
        super(username, password, firstName, lastName);
    }

    public WhManager() {
    	
    }

	public void displayInventory(){
    	wh.printAll();
    }
    
    public String getWarehouse() {
    	return warehouseName;
    }

    public Warehouse getWh() {
        return wh;
    }
    
    public void transferInventory(Warehouse source, Warehouse destination, BikePart bp, int quantityToMove){


        if (source.BikePartList.contains(bp)){ //if found in source
            //then remove that amount
            System.out.println("Removing " + quantityToMove + " from " + source.toString());
            source.bp.setQuantity(source.bp.getQuantity() - quantityToMove);
        } else {
            System.out.println("BikePart does not exist in " + source.toString());
        }

        if (destination.BikePartList.contains(bp)){

            destination.bp.setQuantity(destination.bp.getQuantity() + quantityToMove);



        } else {
            System.out.println(bp.toString() + " not found in " + destination.toString());
            destination.add(bp); // add into destination wh
            destination.bp.setQuantity(quantityToMove); //change the value
        }




    }
    /**
     * addToInventory manually add a bikepart
     * @param partName
     * @param partNumber
     * @param listPrice
     * @param salesPrice
     * @param isOnSale
     * @param quantity
     */
    public void addToInventory(String partName, int partNumber, double listPrice, double salesPrice, boolean isOnSale, int quantity) {
    	boolean update = false;
    	BikePart bp = new BikePart(partName, partNumber, listPrice, salesPrice, isOnSale, quantity);
    	BikePart exists = wh.findBp(bp.getPartNumber());
		if (exists != null) {
            exists.setQuantity(exists.getQuantity() +
                    bp.getQuantity());
            exists.setPrice(bp.getListPrice());
            exists.setSalesPrice(bp.getSalesPrice());
            exists.setSale(bp.isOnSale());
            update = true;
        }
		if (update == false) {
			wh.smartAdd(bp);
		}
    	wh.add(bp);
    }
    //needs to take in a text file
    public void updateInventory(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        boolean update = false;
        read = new Scanner(file);
        
        while(read.hasNextLine()) {
        	try 
    		{        
    			read = new Scanner(file);
    			while (read.hasNextLine()) {    
    				update = false;
    				String line = read.nextLine();
    				String regExp = "\\s*(\\s|,)\\s*";
    				String[] splits = line.split(regExp);
    				
    				String partName = splits[0];
    				int partNum = Integer.parseInt(splits[1]);
    				double partPrice = Double.parseDouble(splits[2]);
    				double salesPrice = Double.parseDouble(splits[3]);
    				boolean isSale = Boolean.parseBoolean(splits[4]);
    				int quantity = Integer.parseInt(splits[5]);
    				
    				BikePart bp = new BikePart(partName,partNum,partPrice,salesPrice,isSale,quantity);
    				BikePart exists = wh.findBp(bp.getPartNumber());
    				if (exists != null) {
    		            exists.setQuantity(exists.getQuantity() +
    		                    bp.getQuantity());
    		            exists.setPrice(bp.getListPrice());
    		            exists.setSalesPrice(bp.getSalesPrice());
    		            exists.setSale(bp.isOnSale());
    		            update = true;
    		        }
    				if (update == false) {
    					wh.smartAdd(bp);
    				}
    			}						
    		}    
    		catch (FileNotFoundException e) {        
    			e.printStackTrace();
    		}
    	}
    }
    
        
        





    /**
     * toString - prints out the object instance as a String
     * @return
     */
    public String toString() { return "Warehouse Manager: " + firstName + " " + lastName + " " + username; }



}
