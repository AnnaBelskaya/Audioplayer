package players.modernplayers;

import utils.ModernPlayer;

public class Player4 extends ModernPlayer {

    public Player4(String path,String[] playlist) {
        super(path, playlist[playlist.length-1], playlist);
    }
}
