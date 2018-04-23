package sample;


import basic.LoginAccount;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/** Simple Login Window Controller
 *
 *
 */

public class LoginController implements Initializable{

    /**
     *
     */
    @FXML
    public TextField userNameField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public Label incorrectMsg;

    /**
     * loginAction
     * Pulls the username and password and opens up the respective Controller.
     * @param event - Button Click
     * @throws Exception - FXML loading depends on exception if something goes wrong
     */

    @FXML
    void loginAction(ActionEvent event) throws Exception{

        String userName;
        String password;

        userName = userNameField.getText();
        password = passwordField.getText();

        LoginAccount la = LoginAccount.verify(userName, password);


        if (la == null){
            System.out.println("User name or password is incorrect.");
            incorrectMsg.setVisible(true);
            passwordField.clear();
        }

        else if (la instanceof OfficeManager){
            System.out.println("Logging in " + userName + " as Office Manager");
            
            Main.accountTransfer(la);
            Parent homePageParent = FXMLLoader.load(getClass().getResource("OfficeManager.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            projectStage.setScene(homePageScene);
            projectStage.show();
        }

        else if (la instanceof WhManager){
            System.out.println("Logging in " + userName + " as Warehouse Manager");

            Main.accountTransfer(la);
            Parent homePageParent = FXMLLoader.load(getClass().getResource("WHManager.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            projectStage.setScene(homePageScene);
            projectStage.show();

        }
        else if (la instanceof SalesAssociate){
            System.out.println("Logging in " + userName + " as SalesAssociate");
            
            Main.accountTransfer(la);
            Parent homePageParent = FXMLLoader.load(getClass().getResource("SalesAssociate.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            projectStage.setScene(homePageScene);
            projectStage.show();

        }
        else if (la instanceof SysAdmin){
        	System.out.println("Logging in " + userName + " as SysAdmin");
        	
        	Main.accountTransfer(la);
            System.out.println("Logging in " + userName + " as SysAdmin");
            Parent homePageParent = FXMLLoader.load(getClass().getResource("SystemAdmin.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            projectStage.setScene(homePageScene);
            projectStage.show();
        }


    }

    /**
     * Initialize
     * To be Run upon loading
     * @param location
     * @param resources
     */


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
