package sample;

import basic.LoginAccount;
import basic.Warehouse;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {

    /** WarehouseDB
     *  Keeps track of Warehouses
     */

    ArrayList warehouseArrayList = new ArrayList<Warehouse>();

    /**
     * Start(Stage primaryStage) - Gives the JavaFX Window certain properties
     * @param primaryStage - the Window
     * @throws Exception
     */
    
    //Main is to start a login window
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 775, 510));
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


    public static void main(String[] args) {
        //John the sales associate
        SalesAssociate saTripp = new SalesAssociate("tripp", "pass", "John", "Evans");
        LoginAccount.users.add(saTripp);

        WhManager WManMitchell = new WhManager("mitchell", "1234", "Mitchell", "Bisson","BissonWares");
        LoginAccount.users.add(WManMitchell);

        SysAdmin SysAdminStefano = new SysAdmin("scoronado", "password", "Stefano","Coronado");
        LoginAccount.users.add(SysAdminStefano);


        launch(args);
    }
}
