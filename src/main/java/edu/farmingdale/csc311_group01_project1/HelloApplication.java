package edu.farmingdale.csc311_group01_project1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hard-Map-Maze.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        HardMapController controller = fxmlLoader.getController();

        scene.setOnKeyPressed(controller::navigateIcon);
        stage.setTitle("Maze Game!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}