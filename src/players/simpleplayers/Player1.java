package players.simpleplayers;

import utils.Player;

import java.io.File;

public class Player1 extends Player {
    public Player1(File song) {
        super(song, new File[]{song});
    }
}
