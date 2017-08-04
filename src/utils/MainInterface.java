package utils;

import javafx.scene.control.Label;
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
    Label[] labels = new Label[6];

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

    private Label[] addLabels (){
        int x = 20, y = 10;
        for (int i = 0; i < 6; i++){
            y+=40;
            labels[i] = new Label("player " + (i+1));
            labels[i].setFont(Font.font("Comic Sans", FontPosture.ITALIC,18));
            labels[i].setTextFill(Paint.valueOf("#D3D3D3"));
            labels[i].setTranslateX(x);
            labels[i].setTranslateY(y);
            switch (i){
                case 0:
                    labels[i].setOnMouseClicked(event -> {
                        changeThePlayer();
                        labels[0].setFont(Font.font("Comic Sans", FontPosture.ITALIC,20));
                        labels[0].setTextFill(Paint.valueOf("#FF69B4"));
                        simplePlayers[0].show(root);
                    });
                    break;
                case 1:
                    labels[i].setOnMouseClicked(event -> {
                       changeThePlayer();
                        labels[1].setFont(Font.font("Comic Sans", FontPosture.ITALIC,20));
                        labels[1].setTextFill(Paint.valueOf("#FF69B4"));
                        simplePlayers[1].show(root);
                    });
                    break;
                case 2:
                    labels[i].setOnMouseClicked(event -> {
                        changeThePlayer();
                        labels[2].setFont(Font.font("Comic Sans", FontPosture.ITALIC,20));
                        labels[2].setTextFill(Paint.valueOf("#FF69B4"));
                        modernPlayers[0].show(root);
                    });
                    break;
                case 3:
                    labels[i].setOnMouseClicked(event -> {
                        changeThePlayer();
                        labels[3].setFont(Font.font("Comic Sans", FontPosture.ITALIC,20));
                        labels[3].setTextFill(Paint.valueOf("#FF69B4"));
                        modernPlayers[1].show(root);
                    });
                    break;
                case 4:
                    labels[i].setOnMouseClicked(event -> {
                        changeThePlayer();
                        labels[4].setFont(Font.font("Comic Sans", FontPosture.ITALIC,20));
                        labels[4].setTextFill(Paint.valueOf("#FF69B4"));
                        modernPlayers[2].show(root);
                    });
                    break;
                case 5:
                    labels[i].setOnMouseClicked(event -> {
                        changeThePlayer();
                        labels[5].setFont(Font.font("Comic Sans", FontPosture.ITALIC,20));
                        labels[5].setTextFill(Paint.valueOf("#FF69B4"));
                        modernPlayers[3].show(root);
                    });
                    break;
            }
        }
        return labels;
    }

    private void changeThePlayer(){
        for (int i = 0; i < simplePlayers.length; i++) {
            try {
                simplePlayers[i].stopPlayingSong();
            } catch (NullPointerException e) { }
        }

        for (int i = 0; i < modernPlayers.length; i++) {
            try {
                modernPlayers[i].stopPlayingSong();
            } catch (NullPointerException e) { }
        }

        root.getChildren().clear();
        root.getChildren().add(addBackgroundImage());
        root.getChildren().addAll(addLabels());
    }
}
