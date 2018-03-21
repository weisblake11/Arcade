
package cs1302.arcade.tiles;

import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Pos;

/**
 * This class represents a single grid square on the Tetris playing board
 *
 * @author Blake Weis and Abdul Muqsit
 */
public class Square {

    ImageView iv = new ImageView("TetrisBlocks/BlackBlock.png");
    boolean isFull = false;
    
    /** 
     * The sole constructor of a Square setting its size
     */
    public Square() {
	iv.setFitHeight(30);
	iv.setFitWidth(30);
    }
    

    /**
     * Returns the imageView of a Square
     *
     * @return the ImageView currently in the Square
     */
    public ImageView getIv() {
	return iv;
    }


    /**
     * Sets the state of the Square's property isFull to true
     */
    public void setFull() {
	isFull = true;
    }


    /**
     * Sets the state of the Square's property isFull to false
     */
    public void setEmpty() {
	isFull = false;
    }


    /**
     * Checks to see whether the Square is full, meaning it is occuipied by a tile square
     *
     * @return whether the Square is full or not
     */
    public boolean isFull () {
	return isFull;
    }


    /**
     * Sets the Image of the Square's ImageView
     *
     * @param image    the Image to be set into the ImageView
     */
    public void setIv(Image image) {
	iv.setImage(image);
    }


    /**
     * Returns the Image currently set into the Square's ImageView
     *
     * @return the image in the Square's ImageView
     */
    public Image getImage() {
	return iv.getImage();
    }


    /**
     * Sets the Square to its initial state with isFull equals false and there is no tile square occupying it
     */
    public void resetSquare() {
	Image image = new Image("TetrisBlocks/BlackBlock.png");
	iv.setImage(image);
	isFull = false;;
    }

}