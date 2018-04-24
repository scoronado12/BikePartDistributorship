/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import basic.Warehouse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tripp
 */
public class OfficeManagerController implements Initializable {

    @FXML
    private TextArea checkStockTextArea;
    @FXML
    private TextField findUnitsTextField;
    @FXML
    private Button locateLessButton;
    @FXML
    private TextField manInvStartTextField;
    @FXML
    private TextField manInvEndTextField;
    @FXML
    private Font x1;
    @FXML
    private TextField clientNameTextField;
    @FXML
    private Button SearchInvButton;
    @FXML
    private TextArea ManageInvTextArea;
    @FXML
    private TextField salesAssoTextField;
    @FXML
    private TextField commStartTextField;
    @FXML
    private TextField commEndTextField;
    @FXML
    private Button genPaycheckButton;
    @FXML
    private TextArea paycheckTextArea;
    @FXML
    private MenuButton menuSSA;
    @FXML
    private MenuItem nameSearch;
    @FXML
    private MenuItem numSearch;
    @FXML
    private TextArea searchTextArea;
    @FXML
    private TextField searchTextField;
    @FXML
    private Label partNumLabel;
    @FXML
    private Label partNameLabel;
    @FXML
    private Button buttonSearch;
    @FXML
    private Label databaseLabel;
    @FXML
    private ComboBox<Warehouse> warehousesComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        warehousesComboBox.setItems(Main.warehouseDB);
    }    

    @FXML
    private void HandleCheckStockButton(ActionEvent event) {
    	int minStock = Integer.parseInt(findUnitsTextField.getText());
    }

    @FXML
    private void HandleSearchInvoicesButton(ActionEvent event) {
    	String client = clientNameTextField.getText();
    }

    @FXML
    private void HandleGeneratePaycheck(ActionEvent event) {

        String salesAsso = salesAssoTextField.getText();
    }

    @FXML
    private void HandleNameSearch(ActionEvent event) {
    	partNumLabel.setVisible(false);
    	menuSSA.setText("Alphabetical Search");
    	
    	searchTextArea.setVisible(true);
    	searchTextField.setVisible(true);
    	partNameLabel.setVisible(true);
    	buttonSearch.setVisible(true);
    	databaseLabel.setVisible(true);
    	warehousesComboBox.setVisible(true);
    	
    	
    	//TODO Combo Box population - fill with warehouses
        /*
         * This is done in initialize
         * - Stefano
         */
    	}

    @FXML
    private void HandleNumSearch(ActionEvent event) {
    	partNameLabel.setVisible(false);
    	menuSSA.setText("Numerical Search");
    	
    	searchTextArea.setVisible(true);
    	searchTextField.setVisible(true);
    	partNumLabel.setVisible(true);
    	buttonSearch.setVisible(true);
    	databaseLabel.setVisible(true);
    	warehousesComboBox.setVisible(true);
    	
    	
    	//TODO Combo Box population - fill with warehouses
    }

    @FXML
    private void HandleSearchButtonAction(ActionEvent event) {
    	if (partNumLabel.isVisible() == true) {
    		int targetID = Integer.parseInt(searchTextField.getText());

    	}
    	else if (partNameLabel.isVisible() == true) {
    		String targetName = searchTextField.getText(); 
    	}
    }

    @FXML
    private void logOutButtonMethod(ActionEvent event) throws IOException {
        System.out.println("Logging out and loading Login Window");
        Parent homePageParent = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        projectStage.setScene(homePageScene);
        projectStage.show();
    }
    
}
