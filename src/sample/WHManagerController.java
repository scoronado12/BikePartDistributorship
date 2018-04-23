/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tripp
 */
public class WHManagerController implements Initializable {
	boolean nameMode = false;
	boolean numberMode = false;

    @FXML
    private TextField textFieldInv;
    @FXML
    private MenuButton menuInvMan;
    @FXML
    private RadioButton radioUpdate;
    @FXML
    private ToggleGroup groupFile;
    @FXML
    private RadioButton radioNewInv;
    @FXML
    private Label labelFilename;
    @FXML
    private TextArea textAreaInv;
    @FXML
    private Button buttonFileAdd;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfPartNo;
    @FXML
    private TextField tfPrice;
    @FXML
    private TextField tfSale;
    @FXML
    private Label labelPrice;
    @FXML
    private Label labelSale;
    @FXML
    private Label labelNo;
    @FXML
    private Label labelName;
    @FXML
    private Label labelQuan;
    @FXML
    private TextField tfQuan;
    @FXML
    private Button buttonMan;
    @FXML
    private CheckBox onSaleCheckBox;
    @FXML
    private MenuButton menuSSA;
    @FXML
    private MenuItem modeSell;
    @FXML
    private MenuItem modeSearch;
    @FXML
    private TextArea searchTextArea;
    @FXML
    private TextField searchTextField;
    @FXML
    private Label searchNumLabel;
    @FXML
    private Label searchNameLabel;
    @FXML
    private Button buttonSearch;
    @FXML
    private Label yourWHLabel;
    @FXML
    private Label WHLabel;
    @FXML
    private TextArea textAreaSort;
    @FXML
    private Button sortButton;
    @FXML
    private MenuButton menuSort;
    @FXML
    private MenuItem byName;
    @FXML
    private MenuItem byNumber;
    @FXML
    private Label urWHLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleFileMode(ActionEvent event) {
        menuInvMan.setText("Inventory File");
        tfName.setVisible(false);
        tfPartNo.setVisible(false);
        tfPrice.setVisible(false);
        tfSale.setVisible(false);
        tfQuan.setVisible(false);
        labelName.setVisible(false);
        labelNo.setVisible(false);
        labelPrice.setVisible(false);
        labelSale.setVisible(false);
        labelQuan.setVisible(false);
        buttonMan.setVisible(false);
        onSaleCheckBox.setVisible(false);
      
        radioNewInv.setVisible(true);
        radioUpdate.setVisible(true);
        labelFilename.setVisible(true);
        textFieldInv.setVisible(true);
        buttonFileAdd.setVisible(true);
    }

    @FXML
    private void HandleManualMode(ActionEvent event) {
        menuInvMan.setText("Manual Input");
        radioNewInv.setVisible(false);
        radioUpdate.setVisible(false);
        labelFilename.setVisible(false);
        textFieldInv.setVisible(false);
        buttonFileAdd.setVisible(false); 
        
        tfName.setVisible(true);
        tfPartNo.setVisible(true);
        tfPrice.setVisible(true);
        tfSale.setVisible(true);
        tfQuan.setVisible(true);
        labelName.setVisible(true);
        labelNo.setVisible(true);
        labelPrice.setVisible(true);
        labelSale.setVisible(true);
        labelQuan.setVisible(true);
        buttonMan.setVisible(true);
        onSaleCheckBox.setVisible(true);
    }

    @FXML
    private void HandleAddButton(ActionEvent event) {
        if (radioNewInv.isSelected() == true) {
            String newFile = textFieldInv.getText();
            //Project2BikePart.readInventory(newFile);
            textAreaInv.appendText("Inventory Added\n");
        }
        else if (radioUpdate.isSelected() == true) {
            String update = textFieldInv.getText();
            //Project2BikePart.moveInventory(update);
            textAreaInv.appendText("Inventory Updated\n");       
        }
    }

    @FXML
    private void HandleManualButton(ActionEvent event) {
        boolean onSale = false;
        if (tfName.getText().isEmpty() == false &&
                tfPartNo.getText().isEmpty() == false &&
                tfPrice.getText().isEmpty() == false &&
                tfSale.getText().isEmpty() == false &&
                tfQuan.getText().isEmpty() == false) {
            String name = tfName.getText();
            int number = Integer.parseInt(tfPartNo.getText());
            double price = Double.parseDouble(tfPrice.getText());
            double sale = Double.parseDouble(tfSale.getText());
            int quant = Integer.parseInt(tfQuan.getText());
            onSale = onSaleCheckBox.isSelected();
            //Project2BikePart.manualEnter(name, number, price, sale, onSale, quant);
            textAreaInv.appendText("Part has been added to your warehouse\n");
        }
        else {
            textAreaInv.appendText("Please be sure to fill all fields.\n");
        }
    }

    @FXML
    private void HandleNameSearch(ActionEvent event) {
    	searchNumLabel.setVisible(false);
    	menuSSA.setText("Alphabetical Search");
    	
    	searchTextArea.setVisible(true);
    	searchTextField.setVisible(true);
    	searchNameLabel.setVisible(true);
    	buttonSearch.setVisible(true);
    	yourWHLabel.setVisible(true);
    	
    	//WHLabel.setText(/*WarehouseMan warehouse*/);
    	WHLabel.setVisible(true);
    }

    @FXML
    private void HandleNumSearch(ActionEvent event) {
    	searchNameLabel.setVisible(false);
    	menuSSA.setText("Numerical Search");
    	
    	searchTextArea.setVisible(true);
    	searchTextField.setVisible(true);
    	searchNumLabel.setVisible(true);
    	buttonSearch.setVisible(true);
    	yourWHLabel.setVisible(true);
    	
    	//WHLabel.setText(/*WarehouseMan warehouse*/);
    	WHLabel.setVisible(true);
    }

    @FXML
    private void HandleSearchButton(ActionEvent event) {
        if (searchNumLabel.isVisible() == true) {
            int targetID = Integer.parseInt(searchTextField.getText());
        } else if (searchNameLabel.isVisible() == true) {
            String targetName = searchTextField.getText();
        }
    }

    @FXML
    private void HandleSortButton(ActionEvent event) {
        ArrayList<String> printList = new ArrayList<>();
        String sortTarget = WhManager.getWarehouse();
        if (nameMode == true) {
            printList = Project2BikePart.sortName(sortTarget);
            textAreaSort.appendText(sortTarget + " sorted alphabetically:\n");
        }
        else if (numberMode == true) {
            printList = Project2BikePart.sortNumber(sortTarget);
            textAreaSort.appendText(sortTarget + " sorted numerically:\n");
        }
        else {
            textAreaSort.appendText("Please choose a sort method.\n");
        }
        for (int i = 0; printList.size() > i; i++) {
            textAreaSort.appendText(printList.get(i) + "\n");
        }
        textAreaSort.appendText("\n");
    }

    @FXML
    private void HandleSortName(ActionEvent event) {
        nameMode = true;
        numberMode = false;
        menuSort.setText("Part Name");
    }

    @FXML
    private void HandleSortNumber(ActionEvent event) {
        numberMode = true;
        nameMode = false;
        menuSort.setText("Part Number");
    }

    @FXML
    private void logOutButtonMethod(ActionEvent event) throws IOException {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage projectStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        projectStage.setScene(homePageScene);
        projectStage.show();
    }
    
}
