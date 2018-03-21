
package cs1302.arcade.tiles;

import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Pos;

/**
 * This class represents a green S-type tetromino
 *
 * @author Blake Weis and Abdul Muqsit
 */
public class GreenTile extends Tile {

    ImageView block1 = new ImageView("TetrisBlocks/GreenBlock.png");
    ImageView block2 = new ImageView("TetrisBlocks/GreenBlock.png");
    ImageView block3 = new ImageView("TetrisBlocks/GreenBlock.png");
    ImageView block4 = new ImageView("TetrisBlocks/GreenBlock.png");

    /**
     * The sole constructor for a green S-type tile setting its size and shape
     */
    public GreenTile() {

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
        this.add(block1, 1, 0, 1, 1);
        this.add(block2, 2, 0, 1, 1);
        this.add(block3, 0, 1, 1, 1);
        this.add(block4, 1, 1, 1, 1);

        this.setAlignment(Pos.CENTER);
    }


    /**
     * Unused method for rotating a green S-type tile setting its size and shape
     */
    @Override
    public void rotate() {
	super.rotate();
	switch (state) {
	case 1:
	case 3:
	    this.getChildren().remove(block1);
	    this.getChildren().remove(block2);
	    this.getChildren().remove(block3);
	    this.getChildren().remove(block4);
	    this.add(block1, 1, 0, 1, 1);
	    this.add(block2, 2, 0, 1, 1);
	    this.add(block3, 0, 1, 1, 1); 
	    this.add(block4, 1, 1, 1, 1);
	    break;
	case 2:
	case 4:
	    this.getChildren().remove(block1);
	    this.getChildren().remove(block2);
	    this.getChildren().remove(block3);
	    this.getChildren().remove(block4);
	    this.add(block1, 0, 0, 1, 1);
	    this.add(block2, 0, 1, 1, 1);
	    this.add(block3, 1, 1, 1, 1);
	    this.add(block4, 1, 2, 1, 1);
	    break;
	}
    }

}