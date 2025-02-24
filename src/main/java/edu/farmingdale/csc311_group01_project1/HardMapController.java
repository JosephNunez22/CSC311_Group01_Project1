package edu.farmingdale.csc311_group01_project1;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

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

    @FXML
    private ImageView robotImage;

    @FXML
    private ImageView mapImage;

    public static GridPane getMazeGrid() {
        return mazeGrid;
    }

    @FXML
    private void initialize() {
        Image mazeImage = mapImage.getImage();
        colorBarrier = new ColorBarrier(mazeImage, MAX_ROW, MAX_COL);

        GridPane.setRowIndex(robotImage, playRow);
        GridPane.setColumnIndex(robotImage, playCol);

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
            NextMap();
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
    private void NextMap(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("easy-Map-Maze.fxml"));
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(fxmlLoader.load());
            EasyMapController controller = fxmlLoader.getController();
            scene2.setOnKeyPressed(controller::Navigation);
            stage2.setTitle("Easy Maze");
            stage2.setScene(scene2);
            stage2.show();
            Stage presentStage = (Stage) mazeGrid.getScene().getWindow();
            presentStage.close();

        }catch(IOException io){
            io.printStackTrace();
        }
    }

}
