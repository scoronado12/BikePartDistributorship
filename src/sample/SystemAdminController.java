/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import basic.LoginAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tripp
 */
public class SystemAdminController implements Initializable {

    @FXML
    private MenuButton AcctTypeMenu;
    @FXML
    private TextArea acctStatusTextArea;
    @FXML
    private TextField lastTextField;
    @FXML
    private TextField firstTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField createUserTextField;
    @FXML
    private TextField createPassTextField;
    @FXML
    private Button createButton;
    @FXML
    private Label wHManLabel;
    @FXML
    private TextField wHSATextField;
    @FXML
    private Label salesAssoLabel;
    @FXML
    private MenuItem HandleResetMode;
    @FXML
    private MenuItem HandleDeleteMode;
    @FXML
    private Label UserLabel;
    @FXML
    private Label PassLabel;
    @FXML
    private Label rPassNewLabel;
    @FXML
    private TextField userTextField;
    @FXML
    private TextField passTextField;
    @FXML
    private TextField rPassNewTextField;
    @FXML
    private Button rPassButton;
    @FXML
    private TextArea manStatusTextArea;
    @FXML
    private Button deleteAcctButton;
    @FXML
    private CheckBox confDelCheckBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleOfficeMan(ActionEvent event) {
    	wHSATextField.setVisible(false);
    }

    @FXML
    private void HandleSalesAsso(ActionEvent event) {
    	wHSATextField.setVisible(true);
    	wHSATextField.setPromptText("Sales Van");
    }

    @FXML
    private void HandleWareHouseMan(ActionEvent event) {
    	wHSATextField.setVisible(true);
    	wHSATextField.setPromptText("Warehouse");
    }

    @FXML
    private void handleCreateAccount(ActionEvent event) {
    	
    	//Sales Associate Account Creator
    	if (salesAssoLabel.isVisible() == true) {
    		if (firstTextField.getText().isEmpty() == false &&
        			lastTextField.getText().isEmpty() == false &&
        			emailTextField.getText().isEmpty() == false &&
        			userTextField.getText().isEmpty() == false &&
        			passTextField.getText().isEmpty() == false &&
        			wHSATextField.getText().isEmpty() == false) {
        		String firstName = firstTextField.getText();
        		String lastName = lastTextField.getText();
        		String email = emailTextField.getText();
        		String username = userTextField.getText();
        		String password = passTextField.getText();
        		String van = wHSATextField.getText();
    			WhManager sA = new WhManager(username, password, firstName,
    					lastName, van);
    			int size = LoginAccount.add(sA);
        		acctStatusTextArea.appendText("User: " + username + 
        				" Account Type: Sales Associate ~ Created\n");
        	}
    		else {
    			acctStatusTextArea.appendText("Please Populate All Fields.\n");
    		}
    	}
    	
    	//Warehouse Manager Account Creator
    	if (wHManLabel.isVisible() == true) {
    		if (firstTextField.getText().isEmpty() == false &&
        			lastTextField.getText().isEmpty() == false &&
        			emailTextField.getText().isEmpty() == false &&
        			userTextField.getText().isEmpty() == false &&
        			passTextField.getText().isEmpty() == false &&
        			wHSATextField.getText().isEmpty() == false) {
        		String firstName = firstTextField.getText();
        		String lastName = lastTextField.getText();
        		String email = emailTextField.getText();
        		String username = userTextField.getText();
        		String password = passTextField.getText();
        		String warehouse = wHSATextField.getText();
        		
    			WhManager wM = new WhManager(username, password, firstName,
    					lastName, warehouse);
    			int size = LoginAccount.add(wM);
        		acctStatusTextArea.appendText("User: " + username + 
        				" Account Type: Warehouse Manager ~ Created\n");
        	}
    		else {
    			acctStatusTextArea.appendText("Please Populate All Fields.\n");
    		}
    	}
    	
    	//Office Manager Account Creator
    	else {
    		if (firstTextField.getText().isEmpty() == false &&
    				lastTextField.getText().isEmpty() == false &&
    				emailTextField.getText().isEmpty() == false &&
    				userTextField.getText().isEmpty() == false &&
    				passTextField.getText().isEmpty() == false) {
    			String firstName = firstTextField.getText();
    			String lastName = lastTextField.getText();
    			String email = emailTextField.getText();
    			String username = userTextField.getText();
    			String password = passTextField.getText();
    			
    			OfficeManager oM = new OfficeManager(username, password,
    					firstName, lastName);
    			int size = LoginAccount.add(oM);
        		acctStatusTextArea.appendText("User: " + username + 
        				" Account Type: Office Manager ~ Created\n");
    		
    		}
    	}
    }

    @FXML
    private void handleResetMode(ActionEvent event) {
    	deleteAcctButton.setVisible(false);
    	confDelCheckBox.setVisible(false);
    	
    	rPassNewLabel.setVisible(true);
    	rPassNewTextField.setVisible(true);
    	rPassButton.setVisible(true);
    	manStatusTextArea.setVisible(true);
    }

    @FXML
    private void handleDeleteMode(ActionEvent event) {
    	rPassNewLabel.setVisible(false);
    	rPassNewTextField.setVisible(false);
    	rPassButton.setVisible(false);
    	
    	deleteAcctButton.setVisible(true);
    	confDelCheckBox.setVisible(true);
    	manStatusTextArea.setVisible(true);
    	
    }
    
    @FXML
    private void handleResetButton(ActionEvent event) {
    	String username = userTextField.getText();
    	String pass = passTextField.getText();
    }

    @FXML
    private void handleDeleteButton(ActionEvent event) {
    	String username = userTextField.getText();
    	String pass = passTextField.getText();
    	LoginAccount cannedEmployee = LoginAccount.verify(username, pass);
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        System.out.println("Logging out and loading Login Window");
        Parent homePageParent = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        projectStage.setScene(homePageScene);
        projectStage.show();
    }
    
}
