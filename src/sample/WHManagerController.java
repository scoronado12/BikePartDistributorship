/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

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
        radioSale.setVisible(false);
      
        radioNewInv.setVisible(true);
        radioUpdate.setVisible(true);
        labelFilename.setVisible(true);
        textFieldInv.setVisible(true);
        buttonFileAdd.setVisible(true);
    }

    @FXML
    private void HandleManualMode(ActionEvent event) {
    }

    @FXML
    private void HandleAddButton(ActionEvent event) {
    }

    @FXML
    private void HandleManualButton(ActionEvent event) {
    }

    @FXML
    private void HandleNameSearch(ActionEvent event) {
    }

    @FXML
    private void HandleNumSearch(ActionEvent event) {
    }

    @FXML
    private void HandleSearchButton(ActionEvent event) {
    }

    @FXML
    private void HandleSortButton(ActionEvent event) {
    }

    @FXML
    private void HandleSortName(ActionEvent event) {
    }

    @FXML
    private void HandleSortNumber(ActionEvent event) {
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
