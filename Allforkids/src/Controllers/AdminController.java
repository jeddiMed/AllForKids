/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ElWess
 */
public class AdminController implements Initializable {

    @FXML
    private AnchorPane addpane;
    @FXML
    private Button btn_dash;
    @FXML
    private Button btn_club;
    @FXML
    private Button btn_livre;
    @FXML
    private AnchorPane content;
    @FXML
    private Button btn_film;
    @FXML
    private Button btn_filmCat;
    @FXML
    private Button btn_jeux;
    @FXML
    private Button btn_evenement;
    @FXML
    private Button btn_commande;
    @FXML
    private Button btn_ecole;
    @FXML
    private Button btn_garderie;
    @FXML
    private Button btn_donation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dashboardButtons();
    }    

    @FXML
    private void handleButtonActionn(ActionEvent event) {
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }
    
    public void dashboardButtons(){
        
          btn_club.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                try {
                    AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("testClubFXML.fxml"));
                    content.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          btn_livre.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                try {
                    AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("testLivreFXML.fxml"));
                    content.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          btn_film.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                try {
                    AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/GuiFilm/filmFXML.fxml"));
                    content.getChildren().clear();
                    content.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          btn_filmCat.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                try {
                    AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                    content.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          btn_jeux.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                try {
                    AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                    content.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          btn_evenement.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                try {
                    AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                    content.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          btn_commande.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                try {
                    AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                    content.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          btn_ecole.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                try {
                    AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                    content.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          btn_garderie.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                try {
                    AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                    content.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          btn_donation.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                try {
                    AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                    content.getChildren().add(newLoadedPane);
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
