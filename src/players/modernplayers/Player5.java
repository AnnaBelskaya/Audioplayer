package players.modernplayers;

import javafx.scene.layout.Pane;
import utils.ModernPlayer;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player5 extends ModernPlayer {

    public Player5(File[] playlist) {
        super(playlist[playlist.length-1], playlist);
    }

    @Override
    public void show(Pane root) {
        reverseThePlayList();
        super.show(root);
    }

    private void reverseThePlayList(){
        List<File> list = Arrays.asList(playlist);
        Collections.reverse(list);
        list.toArray(playlist);
    }

}