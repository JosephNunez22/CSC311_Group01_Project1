package edu.farmingdale.csc311_group01_project1;


import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;



public class ColorBarrier {
    private Image mazeImage;
    private Color barrierColor;
    private int maxRow;
    private int maxCol;
    private static final Color PATH_COLOR = Color.WHITE; // 0xffffffff
    private static final int Y_OFFSET = 5; // Add a small offset to align with grid

    public ColorBarrier(Image mazeImage, int maxRow, int maxCol) {
        this.mazeImage = mazeImage;
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        this.barrierColor = Color.BLACK;

        System.out.println("Path color: " + PATH_COLOR);
        System.out.println("Barrier color: " + barrierColor);
    }

    public boolean checkBarrier(int row, int col) {
        if(row >= 0 && row < maxRow && col >= 0 && col < maxCol) {
            double cellWidth = mazeImage.getWidth() / maxCol;
            double cellHeight = mazeImage.getHeight() / maxRow;

            int pixelX = (int)(col * cellWidth);
            int pixelY = (int)(row * cellHeight) + Y_OFFSET; // Add Y_OFFSET here

            System.out.println("Checking position at pixelX: " + pixelX + " pixelY: " + pixelY);

            PixelReader pixelReader = mazeImage.getPixelReader();
            if(pixelX >= 0 && pixelX < mazeImage.getWidth() &&
                    pixelY >= 0 && pixelY < mazeImage.getHeight()) {
                Color color = pixelReader.getColor(pixelX, pixelY);
                //System.out.println("Color at position: " + color);
                return color.equals(PATH_COLOR);
            }
        }
        return false;
    }
}