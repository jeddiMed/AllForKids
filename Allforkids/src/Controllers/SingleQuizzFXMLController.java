/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import entity.*;
import Services.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ElWess
 */
public class SingleQuizzFXMLController implements Initializable {

    @FXML
    private Label categorieLabel;
    @FXML
    private Label questionLabel;
    @FXML
    private VBox myVBox;
    @FXML
    private JFXCheckBox checkboxI;
    @FXML
    private JFXCheckBox checkboxII;
    @FXML
    private JFXCheckBox checkboxIII;
    @FXML
    private JFXButton submitButton;
    private int compteur = 0;
    @FXML
    private Label categorieLabel1;
    @FXML
    private Label numQuestion;
    private int qNum;
    @FXML
    private JFXButton backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        myVBox.setSpacing(3);
    }
    public void getQuestionsList( ArrayList<QuizzQuestion> questionsCategory){
        QuizzQuestion q = questionsCategory.get(compteur);
        System.out.println(compteur);
        qNum = compteur+1;
        numQuestion.setText("Question n°"+qNum);
        questionLabel.setText(q.getQuestion());
        categorieLabel.setText(q.getCategorie().getLibelle());
        checkboxI.setText(q.getReponseI());
        checkboxII.setText(q.getReponseII());
        checkboxIII.setText(q.getReponseIII());
        
    
    }
    @FXML
    public void backButton(ActionEvent e){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GuiQuizz/QuizzFrontFXML.fxml"));
            backButton.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SingleQuizzFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
