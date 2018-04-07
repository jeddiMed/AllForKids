/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids;


import Services.ServiceCategorieQuizz;
import Services.ServiceQuizz;
import entity.CategorieQuizz;
import entity.QuizzQuestion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ElWess
 */
public class Allforkids extends Application {
    
   @Override
    public void start(Stage primaryStage) {
        
        Parent parent = null;
        Stage stage = new Stage();
        
       try {
           //parent = FXMLLoader.load(getClass().getResource("moviePlayerFXML.fxml"));
           parent = FXMLLoader.load(getClass().getResource("/GuiQuizz/quizzFXML.fxml"));
       } catch (IOException ex) {
           Logger.getLogger(Allforkids.class.getName()).log(Level.SEVERE, null, ex);
       }
               
            Scene scene1 = new Scene(parent);        
            primaryStage.setTitle("All For Kids");
            primaryStage.setScene(scene1);
            primaryStage.show();
    
    
//        ServiceQuizz sQ = new ServiceQuizz();
//        ServiceCategorieQuizz sCQ = new ServiceCategorieQuizz();
//        QuizzQuestion quizzQ = new QuizzQuestion("okey","prop1","prop2","prop3","repCorrect",2);
//        CategorieQuizz catQuizz = new CategorieQuizz("Science");
//        ArrayList<QuizzQuestion> listQuestions = sQ.showQuestions();
//        System.out.println(listQuestions);
//        System.out.println("DONE!!!!");
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
