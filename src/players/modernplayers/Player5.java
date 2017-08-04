package players.modernplayers;

import javafx.scene.layout.Pane;
import utils.ModernPlayer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player5 extends ModernPlayer {

    public Player5(String path, String[] playlist) {
        super(path, playlist[playlist.length-1], playlist);
    }

    @Override
    public void show(Pane root) {
        reverseThePlayList();
        super.show(root);
    }

    private void reverseThePlayList(){
        List<String> list = Arrays.asList(playlist);
        Collections.reverse(list);
        list.toArray(playlist);
    }

}