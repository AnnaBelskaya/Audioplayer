package utils;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import players.modernplayers.Player3;
import players.modernplayers.Player4;
import players.modernplayers.Player5;
import players.modernplayers.Player6;
import players.simpleplayers.Player1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import players.simpleplayers.Player2;

import java.io.File;

public class MainInterface {
    private String generalPath = "E:\\Java\\GoIt\\Music\\";
    private File folder1 = new File(generalPath + "Season1\\");
    private File folder2 = new File(generalPath + "Season2\\");
    private File folder3 = new File(generalPath + "Season3\\");
    private File song1 = new File(generalPath+ "01 - Main Title.mp3");

    private File[] season1 = folder1.listFiles();
    private File[] season2 = folder2.listFiles();
    private File[] season3 = folder3.listFiles();

    private Player[] simplePlayers = new Player[]{
            new Player1(song1),
            new Player2(song1)};

    private ModernPlayer[] modernPlayers = new ModernPlayer[]{
            new Player3(season1),
            new Player4(season1),
            new Player5(season2),
            new Player6(season3)

    };

    private Pane root = new Pane();
    private Label[] labels = new Label[6];

    public Pane getRoot() {
        root.getChildren().add(addBackgroundImage());
        root.getChildren().addAll(addLabels());
        return root;
    }

    private ImageView addBackgroundImage(){
        Image image = new Image("file:MP3Interface.jpg");
        ImageView backgroundImage = new ImageView(image);
        return backgroundImage;
    }

    private VBox addLabels (){
        for (int i = 0; i < 6; i++){
            labels[i] = new Label("player " + (i+1));
            labels[i].setFont(Font.font("Comic Sans", FontPosture.ITALIC,18));
            labels[i].setTextFill(Paint.valueOf("#D3D3D3"));
            int index = i;
            if (i > 1) {
                labels[i].setOnMouseClicked(e -> labelClicked(index, index-2));
            } else {
                labels[i].setOnMouseClicked(e -> labelClicked(index, index));
            }
        }

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setTranslateX(20);
        vBox.setTranslateY(50);
        vBox.getChildren().addAll(labels);

        return vBox;
    }

    private void changeThePlayer(){
        for (int i = 0; i < simplePlayers.length; i++)
            simplePlayers[i].stopPlayingSong();
        for (int i = 0; i < modernPlayers.length; i++)
            modernPlayers[i].stopPlayingSong();
        root.getChildren().clear();
        root.getChildren().add(addBackgroundImage());
        root.getChildren().addAll(addLabels());
    }

    private void labelClicked(int i, int j){
        changeThePlayer();
        labels[i].setFont(Font.font("Comic Sans", FontPosture.ITALIC,20));
        labels[i].setTextFill(Paint.valueOf("#FF69B4"));
        modernPlayers[j].show(root);
    }
}
