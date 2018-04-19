package basic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import deprecated.Controller;


/**
 * fileActions class allows the BikePart program to read and write to files.
 * @author scoronado
 * @since 2018-02-06
 */

public class fileActions {
    /**File Saver method
     *
     * @param data - toString() of data to be written to a file
     * @param destinationFile - the file name to be saved to (can be a system path if saved outside Project Directory)
     * @throws IOException - in case the file can not be read
     */
    public static void save(String data, String destinationFile) throws IOException{
        try {
            PrintWriter writer = new PrintWriter(destinationFile, "UTF-8");
            writer.print(data);
            writer.close();
        } catch(IOException e){
            System.out.println("file error!");
        }
    }

    /**
     *
     * @param fileName - String
     * @return whList - observableList of entries from the DataBase
     * @throws FileNotFoundException - if the file doesn't exist
     */

    public static ObservableList<Warehouse> readWhDB(String fileName) throws FileNotFoundException {
        //made similar to method below
        File file = new File(fileName);

        ObservableList<Warehouse> whList = null;
        try {
            Scanner read = new Scanner(file);
            whList = FXCollections.observableArrayList();


            while (read.hasNextLine()) {
                String line = read.nextLine(); //name
                System.out.println("Creating " + line + " warehouse");
                ArrayList<BikePart> inventory = new ArrayList<>();
                whList.add(new Warehouse(line, inventory));


            }
            read.close();


        } catch (FileNotFoundException e) {
            System.err.println("Sorry, file Not Found\nTry again.");
            e.printStackTrace();
        }
        return whList;

    }



    /**readFile() imports a text file to help add to internal structures
     *
     * @param fileName
     * @return retList - an arrayList
     * @throws FileNotFoundException
     */
    public static ArrayList<BikePart> readFile(String fileName) throws FileNotFoundException{
        ArrayList<BikePart> retList = null;
        if (fileName == null || fileName.equals(""))
            return retList;
        File file = new File(fileName);
        try {
            retList = new ArrayList<BikePart>();
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine(); //takes in the line
                String[] parts = line.split(",");
                String partName = parts[0];
                int partNum = Integer.parseInt(parts[1]);
                double price = Double.parseDouble(parts[2]);
                double salesPrice = Double.parseDouble(parts[3]);
                boolean onSale = Boolean.parseBoolean(parts[4]);
                int quantity = Integer.parseInt(parts[5]);


                BikePart bp = new BikePart(partName, partNum, price, salesPrice, onSale, quantity);


                retList.add(bp);

            }
            read.close();
        } catch (FileNotFoundException e) {

        }

        return retList;
    }

    /**catFile() simply prints the contents of a text file to the screen or console
     *
     * It is called catFile because in Unix/Linux, one would cat a file just to see its contents printed out to console.
     *
     * @param fileName
     * @return line - a String that gets concatinated and gets bigger based on amount of lines.
     * @throws FileNotFoundException
     */

    public static String catFile(String fileName) throws FileNotFoundException {

        String line = "";
        if (fileName == null || fileName.equals("")) {
            return "Nothing!";
        } else {

            File file = new File(fileName);
            try {
                Scanner read = new Scanner(file);
                while (read.hasNextLine()) {
                    line += read.nextLine() + "\n";

                }
                read.close();

            } catch (FileNotFoundException e) {
                System.err.println("Sorry, file Not Found\nTry again.");
                e.printStackTrace();
            }

            return line;

        }
    }

    /**readForTransfer(String fileName) - facilitates the transfering of a BikePart to another warehouse
     *
     * @param fileName
     * @throws FileNotFoundException
     */


    public static void readForTransfer(String fileName) {

        String sourceDest = "";
        String itemAmount = "";

        if ((fileName == null) || fileName.equals("")){
            System.out.print("None!");
        } else {
            File file = new File(fileName);
            try{
                Scanner reader = new Scanner(file);
                //always assume that first line specifies details of transfer
                sourceDest = reader.nextLine(); //grab first line as one String
                String sourceDestParts[] = sourceDest.split(","); // sourceDestParts[0] = source; parts[1] = dest; both of String


                while (reader.hasNextLine()){
                    itemAmount = reader.nextLine();
                    String itemAmountParts[] = itemAmount.split(","); // itemAmountParts[0] = itemname (ofString); itemAmountParts[1] = integer
                    int amount = Integer.parseInt(itemAmountParts[1]);
                    String sourceWh = sourceDestParts[0];
                    String destWh = sourceDestParts[1];
                    System.out.println("FileActions.readForTransfer() :Transferring " + amount + " from " + sourceWh + " to " + destWh);
                    String partName = itemAmountParts[0];


                    BikePart bp = Controller.getTheBp(partName, sourceWh);
                    Controller.transferRemove(sourceWh, itemAmountParts[0], amount); //decrement in source
                    Controller.transferAdd(bp,itemAmountParts[0], sourceDestParts[1] ,amount); //increment in destination | transferAdd(bp, partName, destWh, amnt)
                }
            } catch (FileNotFoundException e) {
                System.err.println("Sorry, file Not Found\nTry again.");
                e.printStackTrace();
            }
        }

    }




    /**
     * importRead - imports a File and exports the contents to an arrayList
     * @param fileName
     * @return retList - the ArrayList of BikeParts imported
     * @throws FileNotFoundException
     */


    public static ArrayList<BikePart> importRead(String fileName) throws FileNotFoundException{
        ArrayList<BikePart> retList = null;
        if (fileName == null || fileName.equals(""))
            return retList;
        File file = new File(fileName);
        try {
            retList = new ArrayList<>();
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine(); //takes in the line
                String[] parts = line.split(","); //splits the line in to spots 0-5
                String partName = parts[0];
                int partNum = Integer.parseInt(parts[1]);
                double price = Double.parseDouble(parts[2]);
                double salesPrice = Double.parseDouble(parts[3]);
                boolean onSale = Boolean.parseBoolean(parts[4]);
                int quantity = Integer.parseInt(parts[5]);


                BikePart bp = new BikePart(partName, partNum, price, salesPrice, onSale, quantity);
                retList.add(bp);
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.err.println("Sorry, file Not Found\nTry again.");
            e.printStackTrace();
        }
        return retList;
    }

}

