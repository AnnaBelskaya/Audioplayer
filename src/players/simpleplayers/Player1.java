package players.simpleplayers;

import utils.Player;

public class Player1 extends Player {
    public Player1(String path, String song) {
        super(path, song, new String[]{song});
    }
}
