
package cs1302.arcade;

import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.lang.Thread;
import javafx.stage.Stage;

public class Home extends ArcadeApp {
    
    StackPane home = new StackPane();
    ImageView background;
    ImageView title;
    ImageView minesweeper;
    ImageView tetris;
    Timeline timeline;
    static Scene main;

    public Home(Stage stage) {
	background = new ImageView("FixedSpace.gif");
		
	home.getChildren().add(background);
	
	Pane pane = new Pane();
	
	Text click = new Text("CLICK TO START!");
	click.setFont(new Font("ARCADECLASSIC.TTF", 15));
	click.setFill(Color.WHITE);
	click.relocate(300, 400);
	click.setTextAlignment(TextAlignment.CENTER);
	Thread t = new Thread(() -> {flashClick(pane, 0.5, -1);});
	t.setDaemon(true);
	pane.getChildren().add(click);
	t.start();

	Text team = new Text("TooMuchSauceException");
	team.setFont( new Font("ARCADECLASSIC.TTF", 10));
	team.relocate(5, 525);
	team.setFill(Color.WHITE);
	Text name = new Text("Abdul Muqsit and Blake Weis");
	name.setFont( new Font("ARCADECLASSIC.TTF", 10));
	name.relocate(570, 525);
	name.setFill(Color.WHITE);
	pane.getChildren().addAll(team, name);
	home.getChildren().add(pane);

	Menu file = new Menu("File");
	MenuItem exitbutton = new MenuItem("Exit");
	exitbutton.setOnAction(e -> {
		Platform.exit();
		System.exit(0);
	    });
	file.getItems().add(exitbutton);

	Menu options = new Menu("Options");
	Menu help = new Menu("Help");

	MenuBar menubar = new MenuBar(file, options, help);

	minesweeper = new ImageView("MinesweeperIcon.png");
 	minesweeper.setPreserveRatio(true);
	minesweeper.setFitWidth(300);
	minesweeper.setFitHeight(300);
	minesweeper.setOnMouseClicked(event -> {
		Minesweeper minesweeper = new Minesweeper(stage);
	    });

	tetris = new ImageView("TetrisIcon.png");
 	tetris.setPreserveRatio(true);
	tetris.setFitWidth(300);
	tetris.setFitHeight(300);
	tetris.setOnMouseClicked(event -> {
		Tetris tetris = new Tetris(stage);
	    });

	Pane games = new Pane();
	minesweeper.relocate(90, 100);
	tetris.relocate(400, 100);
	
	Scene homeScreen = new Scene(home);
	stage.setScene(homeScreen);
	homeScreen.setOnMouseClicked(event -> {
		timeline.stop();


		background = new ImageView("NoTitleIntro.gif");
		home.getChildren().clear();
		home.getChildren().add(background);

		games.getChildren().addAll(minesweeper, tetris);
		home.getChildren().add(games);

		VBox mainmenu = new VBox();
		mainmenu.getChildren().addAll(menubar, home);

		main = new Scene(mainmenu);
		stage.setScene(main);
		stage.sizeToScene();
	    });
	
    } // Constructor

    public void flashClick(Pane click, double dur, int iter) { 
	EventHandler<ActionEvent> handler = event -> {
	    if(click.isVisible()) {
		click.setVisible(false); 
      	    } // if 
	    else {
		click.setVisible(true);
	    } // else
	};
	KeyFrame keyFrame = new KeyFrame(Duration.seconds(dur), handler);
	timeline = new Timeline();
	if(iter < 0) {
	    timeline.setCycleCount(Timeline.INDEFINITE);
	}
	else {
	    timeline.setCycleCount(iter);
	}
	timeline.getKeyFrames().add(keyFrame);
	timeline.play();

    } // flashClick
} // Home