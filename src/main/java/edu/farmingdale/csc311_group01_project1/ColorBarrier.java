package edu.farmingdale.csc311_group01_project1;


import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;



public class ColorBarrier {
    private Image mazeImage;
    private Color barrierColor;
    private int maxRow;
    private int maxCol;

    public ColorBarrier(Image mazeImage, int barrierColorX, int barrierColorY, int maxRow, int maxCol) {
        this.mazeImage = mazeImage;
        this.maxRow = maxRow;
        this.maxCol = maxCol;


        //scans image for color barrier
        PixelReader pixelReader = mazeImage.getPixelReader();
        if(barrierColorX > 0 && barrierColorX < mazeImage.getWidth() && barrierColorY > 0 && barrierColorY < mazeImage.getHeight() ) {
            this.barrierColor = pixelReader.getColor(barrierColorX, barrierColorY);
        } else{
            throw new IllegalArgumentException("barrierColorX or barrierColorY must be out of bounds");
        }
    }


    public boolean checkBarrier(int row, int col) {
       if(row >= 0 && row < maxRow && col >= 0 && col < maxCol){
           int pixelX = col * (int)(mazeImage.getWidth()/maxCol);
           int pixelY = row * (int)(mazeImage.getHeight()/maxRow);

           System.out.println("checking barriers at pixelX: " + pixelX + " pixelY: " + pixelY);

           PixelReader pixelReader = mazeImage.getPixelReader();
           if(pixelX >= 0 && pixelX < mazeImage.getWidth() && pixelY >= 0 && pixelY < mazeImage.getHeight()){
               Color color = pixelReader.getColor(pixelX,pixelY);
               System.out.println("Barrier color: " + barrierColor + ", Current color: " + color);
               return !color.equals(barrierColor);
           }

       }
       return true;
    }
}
