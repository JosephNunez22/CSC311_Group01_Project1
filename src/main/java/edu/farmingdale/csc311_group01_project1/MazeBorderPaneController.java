package edu.farmingdale.csc311_group01_project1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MazeBorderPaneController {



    @FXML
    BorderPane mainMazeBorderPane;

    @FXML
    HBox ButtonsHBox;

    @FXML
    Button animateHardMapButton;

    @FXML
    Button animateEasyMapButton;

    @FXML
    Button gameInfoButton;

    @FXML
    public void gameInfoButtonAction(ActionEvent event) {

    }

    public void animateHardMap(Button animateHardMapButton, ImageView characterImage) {

        characterImage.setX(27);
        characterImage.setY(263);

        int[][] path = {
                {20, 280}, {50, 280}, {50, 140},
                {318, 140}, {318, 70},
                {390, 70}, {390, 345},
                {460, 345}, {460, 210},
                {595, 210}, {595, 80},
                {665, 80}, {665, 265},
                {695, 265}
        };

        ButtonsHBox.setSpacing(10);
        ButtonsHBox.setAlignment(Pos.CENTER);
        ButtonsHBox.getChildren().add(animateHardMapButton);

        this.animateHardMapButton.setOnAction(e -> {
            HardMazePath pathAnimation = new HardMazePath(HardMapController.getMazeGrid(), characterImage);
            pathAnimation.animatePath(path);
        });
    }
}
