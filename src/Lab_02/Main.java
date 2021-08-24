package Lab_02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * This program uses multithreads to print out Ping-Pong.
 * It also makes use of 2 classes Ping and pong and
 * uses locks and sleep functions as well.
 * */

public class Main extends Application {

    private String text = "";
    @Override
    public void start(Stage primaryStage) throws Exception{

        StackPane pane = new StackPane();
        Label label = new Label("PingPong");
        label.setFont(Font.font("New Times Roman", FontWeight.BOLD, FontPosture.REGULAR, 25)) ;
        pane.getChildren().add(label);

        //Creating Threads
        new Thread(new ping(label)).start();
        new Thread(new pong(label)).start();

        //Setting the stage and scene
        Scene scene = new Scene(pane, 350,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Multi-threading Exercise");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
