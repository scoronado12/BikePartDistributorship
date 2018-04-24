package sample;

import basic.LoginAccount;
import basic.Warehouse;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    /** WarehouseDB
     *  Keeps track of Warehouses
     */
    public static ObservableList<Warehouse> warehouseDB;
    public static LoginAccount currentUser = new LoginAccount();


    /**
     * Start(Stage primaryStage) - Gives the JavaFX Window certain properties
     * @param primaryStage - the Window
     * @throws Exception
     */
    
    //Main is to start a login window
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        primaryStage.setTitle("Bicycle Part Distributorship");
        primaryStage.setScene(new Scene(root, 475, 510));
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> System.out.println("Stage is closing")); //added in later on to handle saving and exiting
    }

    /**Stop() - Overridden method that runs upon exiting
     *
     * @throws IOException
     */

    @Override
    public void stop() throws IOException {
        //primaryStage.close();
    }

    /** main() - Establishes some predefined users to get started
     *
     * @param args
     */


    public static void main(String[] args) {


        //John the sales associate
        SalesAssociate saTripp = new SalesAssociate("tripp", "pass", "John", "Evans", "SalesVan1");
        LoginAccount.users.add(saTripp);

        //Mitchell the warehouse Manager
        WhManager WManMitchell = new WhManager("mitchell", "1234", "Mitchell", "Bisson","BissonWares");
        LoginAccount.users.add(WManMitchell);
        warehouseDB.add(WManMitchell.getWh());

        WhManager johnDoe = new WhManager("jdoe", "password", "John", "Doe", "DoesWH");
        LoginAccount.users.add(johnDoe);

        //Sysadmin Stefano
        SysAdmin SysAdminStefano = new SysAdmin("scoronado", "password", "Stefano","Coronado");
        LoginAccount.users.add(SysAdminStefano);

        //Office manager gusty
        OfficeManager gusty = new OfficeManager("gusty", "bike", "Gusty", "Cooper");
        LoginAccount.users.add(gusty);


        launch(args);
    }

	public static void accountTransfer(LoginAccount la) {
		currentUser = la;
	}
	public static LoginAccount getCurrentUser() {
		return currentUser;
	}
}
