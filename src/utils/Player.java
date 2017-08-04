package utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import players.Main;

import java.io.File;

public abstract class Player {
    protected Text songName;
    protected Pane root;

    public String path;
    public String song;
    public String[] playlist;

    protected Media hit;
    protected MediaPlayer mediaPlayer;


    public Player(String path, String song, String[] playlist) {
        this.path = path;
        this.song = song;
        this.playlist = playlist;
    }

    protected void playSong(){
        hit = new Media(new File(path + song).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void stopPlayingSong(){
        try {
            mediaPlayer.stop();
        } catch (NullPointerException ex) { }
    }

    public void show(Pane root){
        this.root = root;
        showCurrentSongName();
        showThatListIsEmpty();
        root.getChildren().addAll(playSongButton());
    }

    public ImageView playSongButton(){
        Image image = new Image("file:playbutton.png");
        ImageView playButton = new ImageView();
        playButton.setImage(image);
        playButton.setTranslateX(Main.WIDTH/2-110);
        playButton.setTranslateY(Main.HEIGHT-87);
        playButton.setOnMouseClicked(event -> {
            stopPlayingSong();
            playSong();
        });
        return playButton;
    }

    protected void showCurrentSongName(){
        songName = new Text("Playing: " + song);
        songName.setFont(Font.font("Verdana", FontPosture.ITALIC,13));
        songName.setFill(Paint.valueOf("#D3D3D3"));
        songName.setTranslateX(Main.WIDTH/2-40);
        songName.setTranslateY(Main.HEIGHT-47);
        root.getChildren().add(songName);
    }

    protected void removeCurrentSongName(){
        root.getChildren().remove(songName);
    }

    protected void showThatListIsEmpty(){
        Text allTitles = new Text("There is no playlist");
        allTitles.setFont(Font.font("Verdana", FontPosture.ITALIC,13));
        allTitles.setTranslateX(250);
        allTitles.setTranslateY(130);
        root.getChildren().add(allTitles);
    }
}