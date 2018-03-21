
package cs1302.arcade.tiles;

import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.lang.Thread;


/**
 * This abstract class represents a tetromino in Tetris
 */
public abstract class Tile extends GridPane {

    int state = 1;
    int[] location = new int[2];
    
    /**
     * Keeps track of the rotation state of a Tile
     */
    public void rotate() {
	if (state == 4) {
	    state = 1;
	} else {
	    state++;
	}
    }

}