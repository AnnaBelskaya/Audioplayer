package utils;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

import java.io.File;

public abstract class ModernPlayer extends Player {
    protected Label[] labels;

    public ModernPlayer(File song, File[] playlist) {
        super(song, playlist);
    }

    @Override
    public void show(Pane root) {
        super.show(root);
        createPlayList();
    }

    @Override
    protected void showThatListIsEmpty(){}

    protected void createPlayList(){
        labels = new Label[playlist.length];
        int x = 160, y = 10;
        for (int i = 0; i < playlist.length; i++){
            y+=25;
            labels[i] = new Label(playlist[i].getName());
            labels[i].setFont(Font.font("Comic Sans", FontPosture.REGULAR,16));
            labels[i].setTextFill(Paint.valueOf("#8B7355"));
            labels[i].setTranslateX(x);
            labels[i].setTranslateY(y);
            File temp = playlist[i];
            labels[i].setOnMouseClicked(event -> {
                stopPlayingSong();
                this.song = temp;
                playSong();
                removeCurrentSongName();
                super.showCurrentSongName();
            });
        }
        root.getChildren().addAll(labels);
    }

    protected void clearPlaylist(){
        root.getChildren().removeAll(labels);
    }
}