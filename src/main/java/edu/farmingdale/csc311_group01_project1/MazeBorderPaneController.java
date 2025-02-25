package edu.farmingdale.csc311_group01_project1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javax.swing.*;
import java.io.IOException;

public class MazeBorderPaneController {

    @FXML
    private HBox ButtonsHBox;
    @FXML
    private Button animateEasyMapButton;
    @FXML
    private Button animateHardMapButton;
    @FXML
    private Button easyMap;
    @FXML
    private Button gameInfoButton;
    @FXML
    private Button hardMap;
    @FXML
    private BorderPane mainMazeBorderPane;



    @FXML
    void animateEasyMapBtnClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("easy-Map-Maze.fxml"));
            Parent newCenter = loader.load();
            EasyMapController controller = loader.getController();
            mainMazeBorderPane.setCenter(newCenter);
            controller.animateEasyMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void animateHardMapBtnClicked(ActionEvent event) {
        try {
            // Load the new layout from an FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hard-Map-Maze.fxml"));
            Parent newCenter = loader.load();
            HardMapController controller = loader.getController();
            // Set the loaded node as the center of the BorderPane
            mainMazeBorderPane.setCenter(newCenter);
            controller.animateHardMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void easyMapBtnClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("easy-Map-Maze.fxml"));
            Parent newCenter = loader.load();
            EasyMapController controller = loader.getController();
            mainMazeBorderPane.setCenter(newCenter);
            newCenter.setOnKeyPressed(controller::Navigation);
            newCenter.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gameInfoButtonClicked(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "W: UP, S: DOWN, A: LEFT, D: RIGHT.", "Controls", JOptionPane.INFORMATION_MESSAGE);

    }

    @FXML
    void hardMapBtnClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hard-Map-Maze.fxml"));
            Parent newCenter = loader.load();
            mainMazeBorderPane.setCenter(newCenter);
            newCenter.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
