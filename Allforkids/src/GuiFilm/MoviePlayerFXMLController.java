/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFilm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author ElWess
 */
public class MoviePlayerFXMLController implements Initializable {

    @FXML
    private Button btn_back;
    @FXML
    private Button btn_play;
    @FXML
    private Button btn_pause;
    @FXML
    private MediaView moviePlayer;
    
    MediaPlayer mediaPlayer;
    @FXML
    private AnchorPane myVideoAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String urlVideo="D:/Séries/Akame ga Kill/Akame ga Kill! - 01.flv";
        Media media = new Media(urlVideo);
        mediaPlayer = new MediaPlayer(media);
        moviePlayer.setFitWidth(600);
        moviePlayer.setFitHeight(400);
        moviePlayer.setMediaPlayer(mediaPlayer);
        
    }   
    
    public void playMovie(){
        mediaPlayer.play();
    }
    
    public void pauseMovie(){
        mediaPlayer.stop();
    
    }
    public void backMovie(ActionEvent e){
    
    }
    
}
