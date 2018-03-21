
package cs1302.arcade.tiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import java.util.Random;
import cs1302.arcade.*;

/**
 * This clas represents a single TileSquare of a Tetris Tile. 
 * Every Tetris Tile is composed of four TileSquares
 *
 * @author Blake Weis and Abdul Muqsit
 */
public class TileSquare {

    Image image;
    public int row;
    public int col;
    Square[][] gameArray;


    /**
     * The sole constructor of a TileSquare setting its color and adding it to the board at the specified position
     *
     * @param color        the color of the TileSquare
     * @param gameArray    the board on which to add the TileSquare
     * @param row          the row of the board on which to add the TileSquare
     * @param col          the column of the board on which to add the TileSquare
     */
    public TileSquare(String color, Square[][] gameArray, int row, int col) {
	this.row = row;
	this.col = col;
	String s = "TetrisBlocks/" + color + "Block.png";
	image = new Image(s);
	this.gameArray = gameArray;
    }


    /**
     * Checks to see whether Square to the left of the TileSquare is available
     *
     * @return whether or not the TileSquare can move to the left
     */
    public boolean canMoveLeft() {
	if (col-1>=0 && gameArray[row][col-1].isFull()==false) {
	    return true;
	} else {
	    return false;
	}
    }


    /**
     * Checks to see whether the Square to the right of the TileSquare is available
     *
     * @return whether or not the TileSquare can move to the right
     */
    public boolean canMoveRight() {
	if (col+1<=9 && gameArray[row][col+1].isFull()==false) {
	    return true;
	} else {
	    return false;
	}
    }


    /**
     * Checks to see whether the Square to below the TileSquare is availble
     *
     * @return whether or not the TileSquare can move down
     */
    public boolean canMoveDown() {
	if (row+1<=19 && gameArray[row+1][col].isFull()==false) {
	    return true;
	} else {
	    return false;
	}
    }
    
    /**
     * Returns the Image set inside the TileSquare
     *
     * @return the image inside the TileSquare
     */
    public Image getImage() {
	return image;
    }

}