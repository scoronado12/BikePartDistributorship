package sample;


import basic.LoginAccount;

import java.awt.*;
import java.io.IOException;
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

import basic.Warehouse;
import basic.BikePart;
import basic.fileActions;

/** Controls the LoginWindow.fxml
 *  Replaces old project2gui.fxml
 */

public class LoginController implements Initializable{


    @FXML
    public TextField userNameField;

    @FXML
    public PasswordField passwordField;

    @FXML
    void loginAction(ActionEvent e) throws Exception{

        String userName;
        String password;

        userName = userNameField.getText();
        password = passwordField.getText();

        LoginAccount la = LoginAccount.verify(userName, password);

        if (la == null){
            System.out.println("User name or password is incorrect.");
        }

        else if (la instanceof OfficeManager){
            Parent homePageParent = FXMLLoader.load(getClass().getResource("OfficeManager.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            projectStage.setScene(homePageScene);
            projectStage.show();
        }

        else if (la instanceof WhManager){

            Parent homePageParent = FXMLLoader.load(getClass().getResource("WHManager.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            projectStage.setScene(homePageScene);
            projectStage.show();

        }
        else if (la instanceof SalesAssociate){

            Parent homePageParent = FXMLLoader.load(getClass().getResource("SalesAssociate.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            projectStage.setScene(homePageScene);
            projectStage.show();

        }
        else if (la instanceof SysAdmin){

            Parent homePageParent = FXMLLoader.load(getClass().getResource("SysAdmin.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            projectStage.setScene(homePageScene);
            projectStage.show();
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}