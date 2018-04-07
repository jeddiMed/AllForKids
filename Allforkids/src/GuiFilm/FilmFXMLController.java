/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFilm;

import Services.ServiceCategorieFilm;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import Services.ServiceFilm;
import entity.CategorieFilm;
import entity.Film;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import Services.ServiceCategorieFilm;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ElWess
 */
public class FilmFXMLController implements Initializable {

    @FXML
    private TextField titre;
    @FXML
    private TextField duree;
    @FXML
    private ComboBox<CategorieFilm> comboCat = new ComboBox<CategorieFilm>();
    @FXML
    private TextArea description;
    @FXML
    private Button add;
    @FXML
    private TableView<Film> filmList;
   @FXML
    private TableColumn<Film, Integer> idCol;
   @FXML
    private TableColumn<Film, String> titreCol;
   @FXML
    private TableColumn<Film, Integer> dureeCol;
   @FXML
    private TableColumn<Film, String> descriptionCol;
   @FXML
    private TableColumn<Film, CategorieFilm> categorieCol;
   private Button backButton;
    int idCat;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button refresh;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titre.setStyle("-fx-text-inner-color: #193a5a;");
        ServiceCategorieFilm sv = new ServiceCategorieFilm();
        ArrayList<CategorieFilm> cats = (ArrayList<CategorieFilm>) sv.showCategorie();
        ObservableList catsObservable = FXCollections.observableArrayList(cats);
        comboCat.setItems(catsObservable);
        ServiceFilm svF = new ServiceFilm();
        ArrayList<Film> films = (ArrayList<Film>) svF.showFilms();
        ObservableList filmsObservable = FXCollections.observableArrayList(films);
        filmList.setItems(filmsObservable);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        titreCol.setCellValueFactory(new PropertyValueFactory<>("titre"));
        dureeCol.setCellValueFactory(new PropertyValueFactory<>("duree"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        categorieCol.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        this.transferData();
    }
    @FXML
    public void ajouterFilm (ActionEvent event){
    ServiceFilm sv = new ServiceFilm();
    Film film = new Film(titre.getText(), Integer.parseInt(duree.getText()),comboCat.getSelectionModel().getSelectedItem().getId() , description.getText());
    sv.insertFilm(film);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("filmFXML.fxml"));
            add.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FilmFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void afficherFilm(ActionEvent event){
            try {
            Parent root = FXMLLoader.load(getClass().getResource("affichageFilmFXML.fxml"));
            add.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FilmFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 

    /*public void handleButtonAction(ActionEvent event) {     //load FXML in an AnchorPane 
        
            System.out.println("This button works !");
        try {
            AnchorPane newLoadedPane =  FXMLLoader.load(getClass().getResource("affichageFilmFXML.fxml"));
            content.getChildren().add(newLoadedPane);
        } catch (IOException ex) {
            Logger.getLogger(FilmFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    @FXML
    public void deleteMovie (ActionEvent event){
    ServiceFilm sv = new ServiceFilm();
    Film film = filmList.getSelectionModel().getSelectedItem();
    sv.deleteFilm(film);
    filmList.getItems().remove(filmList.getSelectionModel().getSelectedItem());
    }
        
    @FXML
    public void refreshTable(ActionEvent event){
                try {
            Parent root = FXMLLoader.load(getClass().getResource("filmFXML.fxml"));
            refresh.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FilmFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void transferData(){
    filmList.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){
    @Override
    public void handle (javafx.scene.input.MouseEvent event){
    Film film = filmList.getSelectionModel().getSelectedItem();
    CategorieFilm cat = filmList.getSelectionModel().getSelectedItem().getCategorie();
    titre.setText(film.getTitre());
    comboCat.getSelectionModel().select(cat);
    duree.setText(String.valueOf(film.getDuree()));
    duree.setText(String.valueOf(film.getDuree()));
    description.setText(film.getDescription());
        
    }
    });
    }
    
    @FXML
    public void updateMovie(ActionEvent e){
    ServiceFilm sv = new ServiceFilm();
    Film filmOld =filmList.getSelectionModel().getSelectedItem();
    Film filmNew = new Film(titre.getText(), Integer.parseInt(duree.getText()),
                         comboCat.getSelectionModel().getSelectedItem().getId() , description.getText());
    sv.updateFilm(filmOld, filmNew);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("filmFXML.fxml"));
            add.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FilmFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
