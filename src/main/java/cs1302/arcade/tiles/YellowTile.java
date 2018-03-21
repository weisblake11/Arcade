
package cs1302.arcade.tiles;

import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Pos;

/**
 * This class represents a yello O-type tetromino
 */
public class YellowTile extends Tile {

    ImageView block1 = new ImageView("TetrisBlocks/YellowBlock.png");
    ImageView block2 = new ImageView("TetrisBlocks/YellowBlock.png");
    ImageView block3 = new ImageView("TetrisBlocks/YellowBlock.png");
    ImageView block4 = new ImageView("TetrisBlocks/YellowBlock.png");

    /**
     * The sole constructor for a yellow O-type tile setting its size and shape
     */
    public YellowTile() {

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
        this.add(block2, 1, 0, 1, 1);
        this.add(block3, 0, 1, 1, 1);
        this.add(block4, 1, 1, 1, 1);

        this.setAlignment(Pos.CENTER);
    }


    /**
     * Unused method for rotating a yellow O-type tile in the next tile stack
     */
    @Override
    public void rotate() {
	super.rotate();
	switch (state) {
	case 1:
	case 2:
	case 3:
	case 4:
	    break;
	}
    }

}