package edu.farmingdale.csc311_group01_project1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class EasyMapController {
    private int CarRow = 1;
    private int CarCol = 0;
    private final  int MAX_ROW = 15;
    private final  int MAX_COL = 20;
    private ColorBarrier colorBarrier;

    @FXML
    private GridPane maze2grid;

    @FXML
    private ImageView carImage;
    @FXML
    private void initialize() {
        GridPane.setRowIndex(maze2grid, CarRow);
        GridPane.setColumnIndex(maze2grid, CarCol);
        maze2grid.requestFocus();
        Platform.runLater(() -> {
            if (maze2grid != null) {
                maze2grid.requestFocus();
            }
        });

    }
    @FXML
    void Navigation(KeyEvent event){
        int nextRow = CarRow;
        int nextCol = CarCol;

        switch(event.getCode()){
            case W:nextRow--;


                break;
            case S:nextRow++;


                break;
            case A:nextCol--;


                break;
            case D:nextCol++;


                break;
            default: return;
        }
        System.out.println("Attempting to move to row: " + nextRow + " col: " + nextCol);
        if(nextCol >= 16 && (nextRow == 15||nextRow == 16)){
            System.out.print("you have won the Maze game!");
            GridPane.setRowIndex(carImage, CarRow);
            GridPane.setColumnIndex(carImage,CarCol);
            showWinMessage();
        } else if (nextRow > 0 && nextRow <= MAX_ROW && nextCol > 0 && nextCol <= MAX_COL) {
            GridPane.setRowIndex(carImage,nextRow);
            GridPane.setColumnIndex(carImage,nextCol);
            CarRow = nextRow;
            CarCol = nextCol;
        }
    }

    public void animateEasyMap(){
        if(maze2grid == null || carImage == null){
            System.out.println("Initialize gridpane or imageview");
        }

        int[][] path = {
                {60,60},{60,470},
                {275,470},{275,280},
                {480,280},{480,65},
                {660,65},{660,480}
        };


        MazePath pathAnimation = new MazePath(maze2grid, carImage);
        pathAnimation.animatePath(path);

    }

    @FXML
    private void showWinMessage() {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Congratulations!");
            alert.setHeaderText(null);
            alert.setContentText("You won the game!");
            alert.showAndWait();
        });

    }

}

