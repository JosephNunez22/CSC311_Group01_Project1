package edu.farmingdale.csc311_group01_project1;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class EasyMapController {
    private int CarRow = 1;
    private int CarCol = 0;
    private final  int MAX_ROW = 15;
    private final  int MAX_COL = 20;

    @FXML
    private GridPane maze2grid;

    @FXML
    private ImageView carImage;
    @FXML
    private void initialize() {
        GridPane.setRowIndex(maze2grid, CarRow);
        GridPane.setColumnIndex(maze2grid, CarCol);
        maze2grid.requestFocus();
    }
    @FXML
    void Navigation(KeyEvent event){
        int nextRow = CarRow;
        int nextCol = CarCol;

        switch(event.getCode()){
            case UP: nextRow--;
                break;
            case DOWN: nextRow++;
                break;
            case LEFT: nextCol--;
                break;
            case RIGHT: nextCol++;
                break;
            default: return;
        }
        if(nextRow == 15||nextRow == 16){
            System.out.print("you have won the Maze game!");
            GridPane.setRowIndex(carImage, CarRow);
            GridPane.setColumnIndex(carImage,CarCol);
        } else if (nextRow > 0 && nextRow < MAX_ROW && nextCol > 0 && nextCol < MAX_COL){
            GridPane.setRowIndex(carImage,nextRow);
            GridPane.setColumnIndex(carImage,nextCol);
            CarRow = nextRow;
            CarCol = nextCol;
        }
    }

}

