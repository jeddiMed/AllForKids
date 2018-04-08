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
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

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
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceCategorieQuizz svCQ = new ServiceCategorieQuizz();
        ArrayList<CategorieQuizz> categories = svCQ.showCategorieQuizz();
        for(CategorieQuizz c : categories)
        {   JFXButton quizzButton = new JFXButton(c.getLibelle());
            myFlowPane.getChildren().add(quizzButton);
            quizzButton.setStyle("-fx-background-color: #26A69A; -fx-pref-width:165px;-fx-pref-height:95px;");
            
        }
        myFlowPane.setHgap(3);
        myFlowPane.setVgap(5);
    }    
    
}
