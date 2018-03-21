
package cs1302.arcade.tiles;

import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Pos;

/**
 * This method represents the area in the Tetris application that displays the next tile 
 * to be added to the playing board
 *
 * @author Blake Weis adn Abdul Muqsit
 */
public class NextTileStack extends StackPane {

    int currentTileType;
    ImageView emptySpace;
    Tile tile;

    /**
     * The sole constructor for a nextTileStack based on the next tile
     *
     * @param type    the numeric representation of the type of the next tile
     */
    public NextTileStack(int type) {
	currentTileType = type;

	emptySpace = new ImageView();
	emptySpace.setFitWidth(150);
	emptySpace.setFitHeight(150);
	getChildren().add(emptySpace);
	
	switch (type) {
	case 0: 
	    tile = new RedTile();
	    break;
        case 1:
            tile = new BlueTile();
            break;
        case 2:
            tile = new RoyalTile();
            break;
        case 3:
            tile = new YellowTile();
            break;
        case 4:
            tile = new GreenTile();
            break;
        case 5:
            tile = new OrangeTile();
            break;
        case 6:
            tile = new PinkTile();
	    break;
	}
	
	getChildren().add(tile);
    }


    /**
     * Sets the next tile to be displayed
     *
     * @param type    the type of tile to be displayed
     */
    public void setTile(int type) {
	getChildren().remove(tile);
	switch (type) {
	case 0:
	    tile = new RedTile();
	    break;
	case 1: 
	    tile = new BlueTile();
	    break;
	case 2:
	    tile = new RoyalTile();
	    break;
	case 3: 
	    tile = new YellowTile();
	    break;
	case 4:
	    tile = new GreenTile();
	    break;
	case 5:
	    tile = new OrangeTile();
	    break;
	case 6: 
	    tile = new PinkTile();
	    break;
	}
	getChildren().add(tile);
	currentTileType = type;
    }


    /**
     * Returns the type of tile currently displayed 
     *
     * int numeric representation of the tile
     */
    public int getCurrentType() {
	return currentTileType;
    }
}