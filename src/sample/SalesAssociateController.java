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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Tripp
 */
public class SalesAssociateController implements Initializable {

    @FXML
    private TextArea vanTextArea;
    @FXML
    private Button moveButton;
    @FXML
    private TextField moveTextField;
    @FXML
    private Font x1;
    @FXML
    private Label WelcomeLabel;
    @FXML
    private Label quanLabel;
    @FXML
    private TextField clientTextField;
    @FXML
    private TextField quanTextField;
    @FXML
    private Button addPartButton;
    @FXML
    private Button completeButton;
    @FXML
    private TextArea addPartTextArea;
    @FXML
    private TextArea invoiceTextArea;
    @FXML
    private Font x2;
    @FXML
    private Label nameLabel;
    @FXML
    private Label numLabel;
    @FXML
    private RadioButton nameRadio;
    @FXML
    private RadioButton numberRadio;
    @FXML
    private Label entPromptLabel;
    @FXML
    private TextField searchTextField;
    @FXML
    private Label clientLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleMoveInvButton(ActionEvent event) {
    }

    @FXML
    private void handleAddToSaleArrayAction(ActionEvent event) {
    }

    @FXML
    private void handleCompleteSaleAction(ActionEvent event) {
    }
    
}
