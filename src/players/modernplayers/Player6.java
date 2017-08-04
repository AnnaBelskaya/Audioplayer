package players.modernplayers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import players.Main;
import utils.ModernPlayer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player6 extends ModernPlayer {
    private Image shufflePicture = new Image("file:shuffleButton.png");
    private ImageView shuffleButton = new ImageView(shufflePicture);

    @Override
    public void show(Pane root) {
        root.getChildren().addAll(addShuffleButton());
        super.show(root);
    }

    public Player6(String path, String[] playlist) {
        super(path, playlist[0], playlist);
    }

    public void shuffle(){
        List<String> list = Arrays.asList(playlist);
        Collections.shuffle(list);
        list.toArray(playlist);
    }

    public ImageView addShuffleButton(){
        shuffleButton.setTranslateX(430);
        shuffleButton.setTranslateY(Main.HEIGHT-130);
        shuffleButton.setOnMouseClicked(event -> {
            shuffle();
            clearPlaylist();
            createPlayList();
        });
        return shuffleButton;
    }
}