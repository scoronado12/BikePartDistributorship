package sample;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/** The Controller defines the JavaFX Objects on the screen and connects them to methods.
 *  This class is also responsible for displaying things to the screen.
 * @author scoronado
 * @since 2018-03-03
 */

public class Controller implements Initializable{

    /**
     * Fields for the various JavaFX objects
     * Observable ArrayList of Warehouses
     */

    //Display Main Tab

    @FXML
    private TextArea bikePartList;
    @FXML
    private ComboBox<Warehouse> displayWh;
    @FXML
    private CheckBox checkSortPartNum;
    @FXML
    private  CheckBox checkSortPartName;

    //Search Part
    @FXML
    private TextField textgetPartName;
    @FXML
    private TextArea detailsOfPart;
    @FXML
    private ComboBox<Warehouse> searchWh;


    //Enter Tab
    @FXML
    private TextField partName;
    @FXML
    private TextField partNumber;
    @FXML
    private TextField listPrice;
    @FXML
    private TextField salesPrice;
    @FXML
    private CheckBox isOnSale;
    @FXML
    private TextField quantity;
    @FXML
    private ComboBox<Warehouse> enterTo;

    //Sell Tab
    @FXML
    private TextField sellPartNumber;
    @FXML
    private TextArea partInfo;
    @FXML
    private ComboBox<Warehouse> warehouseToSellFrom;

    //Import Delivery Tab
    @FXML
    private TextField grabDeliveryFile;
    @FXML
    private TextArea contentsDeliveryFile;
    @FXML
    private ComboBox<Warehouse> importTo;
    //Transfer Tab
    @FXML
    private TextField grabTransferFile;
    @FXML
    private TextArea contentsTransferFile;
    //Create Warehouse Tab
    @FXML
    private TextField warehouseNameField;


    private static ArrayList<Warehouse> warehouseArrayList = new ArrayList<>();
    private static ObservableList<Warehouse> warehouseObservableList = FXCollections.observableList(warehouseArrayList);



//helper methods

    /** initialize() - Runs on Startup
     *
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) throws NullPointerException{
        System.out.println("Launching Bike Part Distributorship");
        try {
            defineOtherWhs();
            reloadWhs();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**reloadWhs() - Loads warehouses listed in WarehouseDB.txt file
     *
     * @throws FileNotFoundException
     */


    @FXML
    void reloadWhs() throws FileNotFoundException{
        System.out.println("Reloading saved warehouses (if any)");

        //loop through Wh names and pulls data from whNameInventory.txt (example)

        for (Warehouse wh : warehouseObservableList){
            System.out.println("Importing contents of " + wh.getWarehouseName() + "Inventory.txt");

            wh.add(fileActions.importRead(wh.getWarehouseName() + "Inventory.txt"));
            /*try {
                fileActions.save("", wh.getWarehouseName() + "Inventory.txt"); //nothing should be in these files at this point
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }


    }




    /** defineOtherWhs() - imports existence of other warehouses
     *
     */


    @FXML
    void defineOtherWhs() throws NullPointerException{
        System.out.println("defineOtherWhs() running");
        try {

            displayWh.setItems(warehouseObservableList);
            warehouseToSellFrom.setItems(warehouseObservableList);
            importTo.setItems(warehouseObservableList);
            enterTo.setItems(warehouseObservableList);
            searchWh.setItems(warehouseObservableList);



            warehouseObservableList.addAll(fileActions.readWhDB("warehouseDB.txt"));





        }catch (FileNotFoundException e){
            System.err.println("Nothing here!");
        }



    }

    /**exitApplication - runs on exit
     *
     * @param event
     */

    @FXML
    public void exitApplication(ActionEvent event){
        Platform.exit();
    }



    /**
     * createWarehouseInstance()
     * helps create a warehouse and displays that on all ComboBoxes
     * @param event - button click
     */


    @FXML
    void createWarehouseInstance (ActionEvent event){

        ArrayList<BikePart> inventory = new ArrayList<>(); //empty inventory
        String whName = warehouseNameField.getText();
        Warehouse wh = new Warehouse(whName, inventory); //create new instance

        warehouseObservableList.add(wh); //add instance to observableList

        warehouseNameField.clear(); //clear text box


        displayWh.setItems(warehouseObservableList);
        warehouseToSellFrom.setItems(warehouseObservableList);
        importTo.setItems(warehouseObservableList);
        enterTo.setItems(warehouseObservableList);
        searchWh.setItems(warehouseObservableList);



    }

    /**Takes in a delivery file to update database
     * Also displays contents of file on screen
     *
     * @param event
     * @throws IOException
     */


    @FXML
    void importDeliveryFile(ActionEvent event) throws IOException {

        String deliveryFile = grabDeliveryFile.getText();
        //collect data
        ArrayList BikePartReads = new ArrayList<>(fileActions.readFile(deliveryFile));
        //collect warehouse

        Warehouse selected = importTo.getSelectionModel().getSelectedItem();
        contentsDeliveryFile.clear();


        for (Object o: BikePartReads){
           //had to do some sort of type casting since we're reaching into one specific warehouse and not many.
            BikePart bp = (BikePart) o;
            if (selected.BikePartList.contains(selected.findBp(bp.getPartNumber()))){
                System.out.println("Found " + bp.getPartName() + " as in " + bp.getPartNumber());

                BikePart replacement = new BikePart(bp.getPartName(),bp.getPartNumber(), bp.getListPrice(), bp.getSalesPrice(), bp.isOnSale(), bp.addQuantity(bp.getQuantity()));
                selected.remove(selected.findBp(bp.getPartNumber())); //remove outdated entry
                System.out.println("Replacing " + bp.getPartName());
                selected.BikePartList.add(replacement);
            } else {
                System.out.println("Adding new " + bp.toString());
                selected.BikePartList.add(bp);

            }
        }

        //show contents of delivery file

        String fileData = fileActions.catFile(deliveryFile);

        contentsDeliveryFile.appendText(fileData);

    }

    /**
     * SellByPartNumber() Sells parts by part number
     * @param event
     */

    @FXML
    void sellByPartNumber(ActionEvent event){

        partInfo.clear();

        int textPartNumber = Integer.parseInt(sellPartNumber.getText());

        Warehouse selection = warehouseToSellFrom.getSelectionModel().getSelectedItem();

        partInfo.appendText(selection.getPartInfoToSell(textPartNumber)); //makes action


        sellPartNumber.clear();


    }

    /**
     * searchParts() - graphically allows the user to display a part
     * Search = Display attributes of a bike part
     * @param event
     */


    @FXML
    void searchParts(ActionEvent event){
        detailsOfPart.clear(); // clear

        String partName = textgetPartName.getText();

        Warehouse selection =  searchWh.getSelectionModel().getSelectedItem();


        detailsOfPart.appendText(selection.getPartInfoToDisplay(partName));

        textgetPartName.clear();


    }


    /**ShowParts() - graphically shows parts in a warehouse
     *
     */

    @FXML
    void showParts(){

        Warehouse showSelection = displayWh.getSelectionModel().getSelectedItem();




        if (checkSortPartNum.isSelected()) {
            bikePartList.clear();
            bikePartList.appendText("Name\tNumber\tListPrice\tSalePrice\tQuantity\tOnSale?\n");

            System.out.println("Checkbox selected: Showing sorted by part number" + showSelection.toString());
            Collections.sort(showSelection.BikePartList, new ComparatorByPartNum());
            bikePartList.appendText(showSelection.printAll());

        } else if (checkSortPartName.isSelected()) {
            bikePartList.clear();
            bikePartList.appendText("Name\tNumber\tListPrice\tSalePrice\tQuantity\tOnSale?\n");
            System.out.println("Checkbox selected: Showing sorted by part name" + showSelection.toString());
            Collections.sort(showSelection.BikePartList, new ComparatorByPartName());
            bikePartList.appendText(showSelection.printAll());
        } else {
            bikePartList.clear();
            bikePartList.appendText("Name\tNumber\tListPrice\tSalePrice\tQuantity\tOnSale?\n");
            System.out.println("Checkbox not selected: showing unsorted " + showSelection.toString());
            bikePartList.appendText(showSelection.printAll());
        }

        
    }

    /**
     * enterPart() graphically takes values to create new BikePart
     * @param event
     */

    @FXML
    void enterPart(ActionEvent event){

        String textPartName = partName.getText();
        int textPartNum = Integer.parseInt(partNumber.getText());
        double textListPrice = Double.parseDouble(listPrice.getText());
        double textSalesPrice = Double.parseDouble(salesPrice.getText());
        boolean saleOrNot = isOnSale.isSelected();
        int textQuantity = Integer.parseInt(quantity.getText());

        Warehouse selection = enterTo.getSelectionModel().getSelectedItem();

        BikePart BpEntry = new BikePart(textPartName, textPartNum, textListPrice, textSalesPrice, saleOrNot, textQuantity);


        if (selection.BikePartList.contains(selection.findBp(textPartNum))){    //if found by partnum then augment quantity and change before adding
            System.out.println("Found by part number in " + selection.toString());

            BpEntry.setQuantity(selection.findBp(textPartNum).getQuantity() + textQuantity);
            BpEntry.setListPrice(textListPrice);
            BpEntry.setSalesPrice(textSalesPrice);
            BpEntry.setSale(saleOrNot);
            selection.remove(selection.findBp(textPartNum)); //remove outdated entry
            selection.add(BpEntry); //add in the new one


        } else {
            System.out.println("adding as-is");
            selection.add(BpEntry); //add as is
        }


        //clear all of that for the next time
        partName.clear();
        partNumber.clear();
        listPrice.clear();
        salesPrice.clear();
        quantity.clear();
        isOnSale.isIndeterminate();
        enterTo.getSelectionModel().clearSelection();


    }

    /** makeTransfer()
     *
     * Connects files with read method
     * Displays contents on the screen
     *
     * @param event
     * @throws FileNotFoundException
     */


    @FXML
    void makeTransfer(ActionEvent event) throws FileNotFoundException {
        String path = grabTransferFile.getText();

        try {
            contentsTransferFile.clear();
            contentsTransferFile.appendText(fileActions.catFile(path));
            fileActions.readForTransfer(path);
            grabTransferFile.clear();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    /** getTheBp() - finds the BikePart in a given warehouse
     *
     * @param partName
     * @param warehouse
     * @return BikePart - can be from any warehouse
     */


    public static BikePart getTheBp(String partName, String warehouse) {


        int i = 0;
        for (Warehouse wh : warehouseObservableList) { //associate source with warehouse object instance
            if (warehouseObservableList.get(i).getWarehouseName().equals(warehouse)) {

                System.out.println("getTheBp: Warehouse is " + wh.toString());

                return wh.findBp(partName);

            } else {
                i++;
            }
        }
        return null;
    }




    /**
     * transferRemove() - decrements BikePart Entry from source
     * @param sourceWh - String
     * @param partName - String
     * @param amountToRemove - int Amount moved
     */



    public static void transferRemove(String sourceWh, String partName, int amountToRemove) {
        int i = 0;
        System.out.println("TransferRemove running");

        for (Warehouse wh : warehouseObservableList) { //associate source with warehouse object instance
            System.out.println(wh.getWarehouseName() + " " + sourceWh);
            if (warehouseObservableList.get(i).getWarehouseName().equals(sourceWh)) {

                System.out.println("Transfer: Source is " + wh.toString());

                System.out.println("Removing " + amountToRemove + " from " + wh.findBp(partName).toString());

                wh.findBp(partName).setQuantity(wh.findBp(partName).getQuantity() - amountToRemove);

                System.out.println("Amount of this object is now " + wh.findBp(partName).getQuantity());

                if (wh.findBp(partName).getQuantity() <= 0) {
                    System.out.println("Transfer: quantity is less than zero, removing from " + wh.toString());
                    wh.remove(wh.findBp(partName));
                }
            }

            i++;
        }

    }

    /** transferAdd() - should be executed after transferRemove()
     * Increments or adds a new BikePart entry to a recipient warehouse
     *
     * @param destinationWh
     * @param partName
     * @param amountToAdd
     *
     */

    public static void transferAdd(BikePart bp, String partName, String destinationWh, int amountToAdd){
        int i = 0;
        for (Warehouse wh : warehouseObservableList) { //associate destination with warehouse object instance
            if (warehouseObservableList.get(i).getWarehouseName().equals(destinationWh)) {

                System.out.println("Transfer: Destination is " + wh.toString());
                if (wh.BikePartList.contains(wh.findBp(partName))) { //if it exists

                    //add on to the existing entry
                    System.out.println("Found it in " + wh.toString() + " updating part.");



                    wh.findBp(partName).setQuantity(wh.findBp(partName).getQuantity() + amountToAdd);


                } else { //it doesn't exist
                    System.out.println("Entering as new part in " + wh.toString());
                    bp.setQuantity(amountToAdd);
                    wh.add(bp);

                }


                break;
            } else {
                i++;
            }
        }



    }

    /** doSaveofWh() - Saves list of Warehouses into a database.
     *  To be run on quit
     *
     * @throws IOException
     */


    public static void doSaveOfWh() throws IOException {

        String warehouses = "";
        int i = 0;
        for (Warehouse wh : warehouseObservableList){
            warehouses += warehouseObservableList.get(i).toString() + "\n";
            i++;
        }

        try {
            fileActions.save(warehouses, "warehouseDB.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**doSaveOfBp() - Saves list of Warehouses into their own respective inventories.
     *
     * @throws IOException
     */

    public static void doSaveOfBp() throws IOException{
        String data = "";
        int i = 0;

        for (Warehouse wh : warehouseObservableList) { //for each wh in the oblist
            for (BikePart bp : warehouseObservableList.get(i).BikePartList) { //loop through their BP_lists

                data += bp.toString();

                fileActions.save(data, wh.toString() + "Inventory.txt"); //change here
            }
            i++;
        }



    }

}
