package edu.farmingdale.csc311_group01_project1;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

public class HardMapController {

    /*Starting position
     *
     * **/
    private int startPlayerRow = 9;
    private int startPlayerCol = 1;
    private final int MAX_ROW = 15;
    private final int MAX_COL = 22;
    private ColorBarrier colorBarrier;
    private int cell_size = 40;
    private int playRow = startPlayerRow;
    private int playCol = startPlayerCol;

    @FXML
    private GridPane mazeGrid;

    @FXML
    private ImageView robotImage;

    @FXML
    private ImageView mapImage;

    @FXML
    private void initialize() {
        Image mazeImage = mapImage.getImage();
        colorBarrier = new ColorBarrier(mazeImage, MAX_ROW, MAX_COL);

        //GridPane.setRowIndex(robotImage, playRow);
        //GridPane.setColumnIndex(robotImage, playCol);
        robotImage.setX(27);
        robotImage.setY(263);
        mazeGrid.requestFocus();

        //robotImage.setFitWidth(cell_size);
        //robotImage.setFitHeight(cell_size);
        //mazeGrid.add(robotImage, 9, 1);

        int [][] path = {
                {27,263},{55,263},{55,148},
                {276,148},{276,91},
                {332,91},{332,320},
                {387,320},{387,205},
                {498,205},{498,91},
                {553,91},{553,263},
                {581,263}
        };
        /*int[][] path = {
                {9,1},{9,2},
                {5,2},{5,10},
                {3,10},{3,12},
                {11,12},{11,14},
                {7,14},{7,18},
                {3,18},{3,20},
                {8,20}
        };*/
        //create and animate character
        HardMazePath pathAnimation = new HardMazePath(mazeGrid, robotImage);
        pathAnimation.animatePath(path);
    }

    @FXML
    void navigateIcon(KeyEvent e) {
        int nextRow = playRow;
        int nextCol = playCol;

        switch (e.getCode()) {
            case UP:
                nextRow--;
                break;
            case DOWN:
                nextRow++;
                break;
            case LEFT:
                nextCol--;
                break;
            case RIGHT:
                nextCol++;
                break;
            default:
                return;
        }

        System.out.println("Attempting to move to row: " + nextRow + " col: " + nextCol);

        // Check for win condition
        if (nextCol == MAX_COL && (nextRow == 8 || nextRow == 9)) {
            System.out.print("you win");
            GridPane.setRowIndex(robotImage, playRow);
            GridPane.setColumnIndex(robotImage, playCol);
        }
        // Check if move is within bounds
        else if (nextRow > 0 && nextRow <= MAX_ROW && nextCol > 0 && nextCol <= MAX_COL) {
            if (colorBarrier.checkBarrier(nextRow, nextCol)) {
                // Valid move - update position
                playRow = nextRow;
                playCol = nextCol;
                GridPane.setRowIndex(robotImage, playRow);
                GridPane.setColumnIndex(robotImage, playCol);
            } else {
                // Hit barrier - stay in current position
                System.out.println("Hit a barrier - can't move there");
                // Don't reset to start, just stay where we are
            }
        } else {
            // Out of bounds - stay in current position
            System.out.println("invalid move: row: " + nextRow + ", col: " + nextCol);
            // Don't reset to start, just stay where we are
        }
    }

}