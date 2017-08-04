package players;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utils.MainInterface;

public class Main extends Application{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 325;
    private MainInterface mainInterface = new MainInterface();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("MP3 Player");
        primaryStage.setResizable(false);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.getIcons().add(new Image("file:music.png"));
        primaryStage.setScene(new Scene(mainInterface.getRoot()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
