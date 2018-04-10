package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    /**
     * Start(Stage primaryStage) - Gives the JavaFX Window certain properties
     * @param primaryStage - the Window
     * @throws Exception
     */
	//mitchell testing
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("project2gui.fxml"));
        primaryStage.setTitle("Bicycle Parts Distributorship - by Stefano Coronado");
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

        System.out.println("Saving Warehouses");
        Controller.doSaveOfWh();
        System.out.println("Saving inventory.");
        Controller.doSaveOfBp();
        System.out.println("Goodbye!");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
