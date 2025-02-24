package edu.farmingdale.csc311_group01_project1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Parent root = FXMLLoader.load(HelloApplication.class.getResource("maze-boarder-pane.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("maze-boarder-pane.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HardMapController controller = fxmlLoader.getController();

        scene.setOnKeyPressed(controller::navigateIcon);
        //controller.animateIcon();
        stage.setTitle("Maze Game!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}