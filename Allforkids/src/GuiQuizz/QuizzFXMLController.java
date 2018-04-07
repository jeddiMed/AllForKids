/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiQuizz;

import entity.*;
import Services.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ElWess
 */
public class QuizzFXMLController implements Initializable {
    @FXML
    private TableView<QuizzQuestion> questionList;
    @FXML
    private TableColumn<QuizzQuestion, String> questionCol;
    @FXML
    private TableColumn<QuizzQuestion, String> repICol;
    @FXML
    private TableColumn<QuizzQuestion, String> repIICol;
    @FXML
    private TableColumn<QuizzQuestion, String> repIIICol;
    @FXML
    private TableColumn<QuizzQuestion, String> correctRepCol;
    @FXML
    private TableColumn<QuizzQuestion, CategorieQuizz> catCol;
    @FXML
    private Button add;
    @FXML
    private TextField question;
    @FXML
    private TextField repI;
    @FXML
    private TextField repII;
    @FXML
    private TextField repIII;
    @FXML
    private TextField repCorrect;
    @FXML
    private ComboBox<CategorieQuizz> comboCat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceCategorieQuizz sCQ = new ServiceCategorieQuizz();
        ArrayList<CategorieQuizz> cats = (ArrayList<CategorieQuizz>)sCQ.showCategorieQuizz();
        ObservableList catList = FXCollections.observableArrayList(cats);
        comboCat.setItems(catList);
        ServiceQuizz sQ = new ServiceQuizz();
        ArrayList<QuizzQuestion> questions = (ArrayList<QuizzQuestion>)sQ.showQuestions();
        ObservableList questionsObservable = FXCollections.observableArrayList(questions);
        questionList.setItems(questionsObservable);
        catCol.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        questionCol.setCellValueFactory(new PropertyValueFactory<>("question"));
        repICol.setCellValueFactory(new PropertyValueFactory<>("reponseI"));
        repIICol.setCellValueFactory(new PropertyValueFactory<>("reponseII"));
        //repIIICol.setCellValueFactory(new PropertyValueFactory<>("reponseIII"));
        correctRepCol.setCellValueFactory(new PropertyValueFactory<>("reponseCorrect"));
        this.transferData();
    }    

    @FXML
    private void addQuestion(ActionEvent event) {
        ServiceQuizz svQ = new ServiceQuizz();
        QuizzQuestion question = new QuizzQuestion (this.question.getText(),repI.getText(),repII.getText(),
                                        repIII.getText(),repCorrect.getText(),
                                        comboCat.getSelectionModel().getSelectedItem().getId());
        svQ.insertQuestion(question);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GuiQuizz/quizzFXML.fxml"));
            add.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(QuizzFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void updateQuestion(ActionEvent e){
        ServiceQuizz svQ = new ServiceQuizz();
        QuizzQuestion questionOld = questionList.getSelectionModel().getSelectedItem();
        QuizzQuestion questionNew = new QuizzQuestion (this.question.getText(),repI.getText(),repII.getText(),
                                        repIII.getText(),repCorrect.getText(),
                                        comboCat.getSelectionModel().getSelectedItem().getId());
        svQ.updateQuestion(questionOld, questionNew);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GuiQuizz/quizzFXML.fxml"));
            add.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(QuizzFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @FXML
    private void deleteQuestion(ActionEvent e){
        ServiceQuizz svQ = new ServiceQuizz();
        QuizzQuestion question = questionList.getSelectionModel().getSelectedItem();
        svQ.deleteFilm(question);
        questionList.getItems().remove(questionList.getSelectionModel().getSelectedIndex());
    }
    
    public void transferData(){
        questionList.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle (javafx.scene.input.MouseEvent event){
            QuizzQuestion questionObject = questionList.getSelectionModel().getSelectedItem();
            CategorieQuizz cat = questionList.getSelectionModel().getSelectedItem().getCategorie();
            question.setText(questionObject.getQuestion());
            comboCat.getSelectionModel().select(cat);
            System.out.println(comboCat.getValue());
            repI.setText(questionObject.getReponseI());
            repII.setText(questionObject.getReponseII());
            repIII.setText(questionObject.getReponseIII());
            repCorrect.setText(questionObject.getReponseCorrect());
            }
        });
    }
    
}
