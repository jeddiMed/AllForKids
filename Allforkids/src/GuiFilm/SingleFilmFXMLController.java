/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFilm;

import Services.*;
import entity.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author ElWess
 */
public class SingleFilmFXMLController implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private Label descLabel;
    @FXML
    private WebView myYoutube;
    
    private String videoUrl;
    private String codeIntegration;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceFilm sv = new ServiceFilm();
        ArrayList<Film> films = (ArrayList<Film>) sv.showFilms();
        Film film = films.get(7);
        String watch = "/watch?v=";
        String embed ="/embed/";
        videoUrl = film.getCode_integ();
        titleLabel.setText(film.getTitre());
        descLabel.setText(film.getDescription());
        descLabel.setPrefWidth(900);
        descLabel.setWrapText(true);
        videoUrl = videoUrl.replace(watch,embed);
        codeIntegration = "<iframe width=\"1250\" height=\"600\" src=\"" +videoUrl+"\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        WebEngine myEngine = myYoutube.getEngine();
        myEngine.loadContent(codeIntegration);
        
    }    
    
}
