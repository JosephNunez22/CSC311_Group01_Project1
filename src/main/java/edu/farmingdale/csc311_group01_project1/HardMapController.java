package edu.farmingdale.csc311_group01_project1;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class HardMapController {

    /*Starting position
    *
    * **/
    private int playerRow = 9;
    private int playerCol = 1;
    private final int MAX_ROW = 14;
    private final int MAX_COL = 21;

    @FXML
    private GridPane mazeGrid;

    @FXML
    private ImageView robotImage;

    @FXML
    private void initialize(){
        GridPane.setRowIndex(robotImage,playerRow);
        GridPane.setColumnIndex(robotImage,playerCol);
        mazeGrid.requestFocus();
    }
    @FXML
    void navigateIcon(KeyEvent e) {
        int nextRow = playerRow;
        int nextCol = playerCol;

        switch(e.getCode()){
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
        if(nextCol == MAX_COL && (nextRow == 8||nextRow == 9)){
            System.out.print("you win");
            GridPane.setRowIndex(robotImage,playerRow);
            GridPane.setColumnIndex(robotImage,playerCol);
        } else if (nextRow > 0 && nextRow < MAX_ROW && nextCol > 0 && nextCol < MAX_COL){
            GridPane.setRowIndex(robotImage,nextRow);
            GridPane.setColumnIndex(robotImage,nextCol);
            playerRow = nextRow;
            playerCol = nextCol;
        }
    }

}
