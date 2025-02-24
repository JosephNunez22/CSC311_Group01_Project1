package edu.farmingdale.csc311_group01_project1;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    private int playRow = startPlayerRow;
    private int playCol = startPlayerCol;

    @FXML
    private static GridPane mazeGrid;

    public static GridPane getMazeGrid() {
        return mazeGrid;
    }

    @FXML
    private ImageView robotImage;

    @FXML
    private ImageView mapImage;

    @FXML
    private void initialize() {
        Image mazeImage = mapImage.getImage();
        colorBarrier = new ColorBarrier(mazeImage, MAX_ROW, MAX_COL);

        GridPane.setRowIndex(robotImage, playRow);
        GridPane.setColumnIndex(robotImage, playCol);
        mazeGrid.requestFocus();

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