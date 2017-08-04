package players.modernplayers;

import utils.ModernPlayer;

import java.io.File;

public class Player4 extends ModernPlayer {

    public Player4(File[] playlist) {
        super(playlist[playlist.length-1], playlist);
    }
}
