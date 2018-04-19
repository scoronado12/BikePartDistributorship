/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    }

    @FXML
    private void HandleSalesAsso(ActionEvent event) {
    }

    @FXML
    private void HandleWareHouseMan(ActionEvent event) {
    }

    @FXML
    private void handleCreateAccount(ActionEvent event) {
    }

    @FXML
    private void handleResetButton(ActionEvent event) {
    }

    @FXML
    private void handleDeleteButton(ActionEvent event) {
    }
    
}
