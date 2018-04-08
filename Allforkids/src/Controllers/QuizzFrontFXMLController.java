/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import Services.*;
import com.jfoenix.controls.JFXButton;
import entity.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ElWess
 */
public class QuizzFrontFXMLController implements Initializable {

    @FXML
    private HBox myHBox;
    @FXML
    private FlowPane myFlowPane;
    @FXML 
    private ArrayList<QuizzQuestion> questions; 
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceCategorieQuizz svCQ = new ServiceCategorieQuizz();
        ArrayList<CategorieQuizz> categories = svCQ.showCategorieQuizz();
        categories.forEach((CategorieQuizz c) -> {
            
            JFXButton quizzButton = new JFXButton(c.getLibelle());
            myFlowPane.getChildren().add(quizzButton);
            quizzButton.setStyle("-fx-background-color: #26A69A; -fx-pref-width:165px;-fx-pref-height:95px;");
            quizzButton.setOnAction((ActionEvent event) -> {
                try {
                    ServiceQuizz svQ = new ServiceQuizz();
                    ArrayList<QuizzQuestion> questions;
                    questions = svQ.showSameCategorieQuestions(c);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/GuiQuizz/SingleQuizzFXML.fxml"));
                    Parent root = loader.load();
                    SingleQuizzFXMLController singleQuestion = loader.getController();
                    singleQuestion.getQuestionsList(questions);
                    Scene scene = new Scene(root);
                    Stage Mystage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Mystage.setScene(scene);
                }catch (IOException ex) {
                    Logger.getLogger(QuizzFrontFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        });
        myFlowPane.setHgap(3);
        myFlowPane.setVgap(5);
    }    
    
}
