package players.simpleplayers;

import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import players.Main;
import utils.Player;

import java.io.File;

public class Player2 extends Player {

    public Player2(File song) {
        super(song, new File[]{song});
    }

    @Override
    protected void playSong() {

    }

    @Override
    public void showCurrentSongName() {
        songName = new Text("Playing: Error");
        songName.setFont(Font.font("Verdana", FontPosture.ITALIC,13));
        songName.setFill(Paint.valueOf("#D3D3D3"));
        songName.setTranslateX(Main.WIDTH/2-40);
        songName.setTranslateY(Main.HEIGHT-47);
        root.getChildren().add(songName);
    }
}