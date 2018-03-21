
package cs1302.arcade.tiles;

import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Pos;

/**
 * This class represents a royal blue J-type tetromino
 *
 * @author Blake Weis and Abdul Muqsit
 */
public class RoyalTile extends Tile {

    ImageView block1 = new ImageView("TetrisBlocks/RoyalBlock.png");
    ImageView block2 = new ImageView("TetrisBlocks/RoyalBlock.png");
    ImageView block3 = new ImageView("TetrisBlocks/RoyalBlock.png");
    ImageView block4 = new ImageView("TetrisBlocks/RoyalBlock.png");

    /**
     * The sole constructor of a royal blue J-type tile setting its size and shape
     */
    public RoyalTile() {

        // set sizing of all blocks                                                                                                                                                                                              
        block1.setFitWidth(30);
        block1.setFitHeight(30);
        block2.setFitWidth(30);
        block2.setFitHeight(30);
        block3.setFitWidth(30);
        block3.setFitHeight(30);
        block4.setFitWidth(30);
        block4.setFitHeight(30);

        // add blocks to tile                                                                                                                                                                                                    
        this.add(block1, 0, 0, 1, 1);
        this.add(block2, 0, 1, 1, 1);
        this.add(block3, 1, 1, 1, 1);
        this.add(block4, 2, 1, 1, 1);

        this.setAlignment(Pos.CENTER);
    }


    /**
     * Unused method for rotating a royal blue J-type tile in the next tile stack
     */
    @Override
    public void rotate() {
	super.rotate();
	switch (state) {
	case 1:
	    this.getChildren().remove(block1);
	    this.getChildren().remove(block2);
	    this.getChildren().remove(block3);
	    this.getChildren().remove(block4);
	    this.add(block1, 0, 0, 1, 1);
	    this.add(block2, 0, 1, 1, 1);
	    this.add(block3, 1, 1, 1, 1);
	    this.add(block4, 2, 1, 1, 1);
	    break;
	case 2:
	    this.getChildren().remove(block1);
	    this.getChildren().remove(block2);
	    this.getChildren().remove(block3);
	    this.getChildren().remove(block4);
	    this.add(block1, 0, 0, 1, 1);
	    this.add(block2, 1, 0, 1, 1);
	    this.add(block3, 0, 1, 1, 1);
	    this.add(block4, 0, 2, 1, 1);
	    break;
	case 3:
	    this.getChildren().remove(block1);
	    this.getChildren().remove(block2);
	    this.getChildren().remove(block3);
	    this.getChildren().remove(block4);
	    this.add(block1, 0, 0, 1, 1);
	    this.add(block2, 1, 0, 1, 1);
	    this.add(block3, 2, 0, 1, 1);
	    this.add(block4, 2, 1, 1, 1);
	    break;
	case 4:
	    this.getChildren().remove(block1);
	    this.getChildren().remove(block2);
	    this.getChildren().remove(block3);
	    this.getChildren().remove(block4);
	    this.add(block1, 1, 0, 1, 1);
	    this.add(block2, 1, 1, 1, 1);
	    this.add(block3, 1, 2, 1, 1);
	    this.add(block4, 0, 2, 1, 1);
	    break;
	}
    }

}