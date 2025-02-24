package edu.farmingdale.csc311_group01_project1;

import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class HardMazePath {

    //private int cell_size;
    private GridPane pane;
    private ImageView character;

    HardMazePath(GridPane pane, ImageView character) {
        this.pane = pane;
        this.character = character;
    }

    public void animatePath(int[][] path){
        Path charactersPath = new Path();
        //set starting point for character
        int startX = path[0][0];
        int startY = path[0][1];
        charactersPath.getElements().add(new MoveTo(path[0][0], path[0][1]));

        //iterate through path coordinates by using LineTo
        for(int i = 1; i < path.length; i++){
            int [] c = path[i];
            int x = c[0];
            int y = c[1];
            charactersPath.getElements().add(new LineTo(x, y));
        }
        charactersPath.setStroke(Color.RED);
        charactersPath.setStrokeWidth(2);
        charactersPath.setTranslateX(character.getX());
        //charactersPath.setTranslateY(character.getY());
        //charactersPath.setScaleX(1.5);
        //charactersPath.setScaleY(-.3);

        pane.getChildren().add(charactersPath);

        javafx.animation.PathTransition pt = new javafx.animation.PathTransition();

        //duration
        pt.setDuration(Duration.seconds(30));
        //setting node (character)
        pt.setNode(character);
        //setting path
        pt.setPath(charactersPath);
        //setting orientation
        pt.setOrientation(PathTransition.OrientationType.NONE);
        pt.play();

    }
}
