package players.simpleplayers;

import utils.Player;

public class Player2 extends Player {

    public Player2(String path, String song) {
        super(path, song, new String[]{song});
    }

    @Override
    protected void playSong() {

    }

    @Override
    public void showCurrentSongName() {
        song = "Error";
        super.showCurrentSongName();
    }
}