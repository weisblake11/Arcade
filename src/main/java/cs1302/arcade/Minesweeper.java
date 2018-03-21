package cs1302.arcade;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.lang.Thread;
import javafx.stage.Modality;

public class Minesweeper {

    GridPane grid = new GridPane();
    int[][] board = new int[16][30];
    Image[][] images = new Image[16][30];
    StackPane stack = new StackPane();
    boolean stop = false;
    ImageView smiley; 
    Timeline timeline;
    Text score;

    /**
     * Constructs a Minesweeper Game object. This also sets up the board and the smiley button.
     *
     * @param stage - the stage that is being modified to show the game.
     */
    public Minesweeper(Stage stage) {
	for(int i =0; i < 16; i++) {
            for(int j = 0; j < 30; j++) {
                board[i][j] = 10;
            } // for                                                                                                                                                       
        } // for  
	ImageView background = new ImageView("mTest.png");
	background.setPreserveRatio(true);
	background.setFitWidth(720);

	stack.getChildren().add(background);

	setMines();
	setGrid();

       	Pane group = new Pane();
	group.getChildren().add(grid);
	grid.relocate(13, 74);

	smiley = new ImageView("Minesweeper/Smiley.png");
        smiley.setFitWidth(40);
        smiley.setFitHeight(40);
	
        smiley.setOnMouseClicked(e -> {
		timeline.stop();
		score.setText("381");
		for(int i =0; i < 16; i++) {
		    for(int j = 0; j < 30; j++) {
			board[i][j] = 10;
		    } // for                                                                                                                                            
		} // for                 
		smiley.setImage(new Image("Minesweeper/Smiley.png"));
		setMines();
		setGrid();
		stop = false;
            });
        group.getChildren().add(smiley);
        smiley.relocate(340, 17);

	score = new Text("381");
	score.relocate(645, 35);
	score.setFont(new Font("ARCADE_N.TTF", 26));

	Thread t = new Thread(() -> {startTime();});
	t.setDaemon(true);
	t.start();

	group.getChildren().add(score);

	stack.getChildren().add(group);
	
        Menu file = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> {
                Platform.exit();
                System.exit(0);
            });

        MenuItem back = new MenuItem("Back");
        back.setOnAction(e -> {
                stage.setScene(Home.main);
            });
        file.getItems().add(back);
        file.getItems().add(exit);
	
	Menu help = new Menu("Help");

	MenuItem controls = new MenuItem("Controls");
	controls.setOnAction(e -> {
		showHelp();
	    });
	help.getItems().add(controls);

        MenuBar menuBar = new MenuBar(file, help);

        VBox screen = new VBox(menuBar, stack);
	
	Scene minesweeper = new Scene(screen);
	stage.setScene(minesweeper);
	stage.setTitle("Arcade: Minesweeper");
	
    } // Constructor

    public void showHelp() {
	Stage help = new Stage();
	help.initModality(Modality.APPLICATION_MODAL);
	
	Text text = new Text("Controls: \n · Left-click an empty square to reveal it\n · Right-click an empty square to flag it\n\n Scoring:\n · The scoring is determined by the following formula:\n\n score = (rows*columns) - (number of mines) - time spent ");
	text.setTextAlignment(TextAlignment.LEFT);
	text.setFont(new Font(10));

	HBox hbox = new HBox();

	hbox.getChildren().add(text);
	hbox.setAlignment(Pos.CENTER);
	hbox.setPadding(new Insets(10));
	hbox.setSpacing(10);

	Scene scene = new Scene(hbox);

	help.setMaxHeight(275);
	help.setMaxWidth(475);
	help.setTitle("Controls");
	help.setResizable(false);
	help.setScene(scene);
	help.sizeToScene();
	help.show();
    } // showHelp
    /**
     * Starts the countdown on the score. The starts off at the highest possible score, which is the number of squares minus the number of mines. Then this score is decreased by one every second.
     */
    public void startTime() {
	EventHandler<ActionEvent> handler = event -> {
	    Integer i = Integer.parseInt(score.getText()) - 1;
	    score.setText(i.toString());
	};
	KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), handler);
	timeline = new Timeline();
	timeline.setCycleCount(Timeline.INDEFINITE);
	timeline.getKeyFrames().add(keyFrame);
    } //startTime


    /**
     * Sets the GUI grid for Minesweeper
     */
    public void setGrid() {
        for(int i = 0; i < (16); i++) { //16                                                                                                                                 
            for(int j = 0; j < 30; j++) { // 30

                ImageView square = new ImageView("Minesweeper/Unopened.png");

                if(board[i][j] == 0) {
                    square.setImage(new Image("Minesweeper/Opened.png"));
                } // UnOpened

                if(board[i][j] == 1) {
                    square.setImage(new Image("Minesweeper/1.png"));
                }

                if(board[i][j] == 2) {
                    square.setImage(new Image("Minesweeper/2.png"));
                }

                if(board[i][j] == 3) {
                    square.setImage(new Image("Minesweeper/3.png"));
                }

                if(board[i][j] == 4) {
                    square.setImage(new Image("Minesweeper/4.png"));
                }

                if(board[i][j] == 5) {
                    square.setImage(new Image("Minesweeper/5.png"));
                }

                if(board[i][j] == 6) {
                    square.setImage(new Image("Minesweeper/6.png"));
                }

                if(board[i][j] == 7) {
                    square.setImage(new Image("Minesweeper/7.png"));
                } 

                if(board[i][j] == 8) {
                    square.setImage(new Image("Minesweeper/8.png"));
                } 

                if(board[i][j] == 9) {
                    square.setImage(new Image("Minesweeper/Flag.png"));
                } 

                if(board[i][j] == 10) {
                    square.setImage(new Image("Minesweeper/Unopened.png"));
                } 

		if(board[i][j] == 11) {
                    square.setImage(new Image("Minesweeper/Unopened.png"));
                } // Hidden Mine

		if(board[i][j] == 12) {
		    square.setImage(new Image("Minesweeper/Flag.png"));
		} // Flagged mine		

		if(board[i][j] == 13) {
		    square.setImage(new Image("Minesweeper/RedMine.png"));
		} // A mine that has been clicked on
		if(board[i][j] == 14) {
		    square.setImage(new Image("Minesweeper/Mine.png"));
		} // Visible Mine Shown when losing
                grid.add(square, j, i, 1, 1);

                square.setOnMouseClicked(new EventHandler<MouseEvent>() {

                        @Override
                            public void handle(MouseEvent event) {
                            timeline.play();
			    MouseButton button = event.getButton();
                            if(button==MouseButton.PRIMARY && stop == false){
				makeMove(grid.getRowIndex(square), grid.getColumnIndex(square));
                            } // if                                                                                                                                          
                            else if(button==MouseButton.SECONDARY && stop == false){
				if(board[grid.getRowIndex(square)][grid.getColumnIndex(square)] == 11) {
				    board[grid.getRowIndex(square)][grid.getColumnIndex(square)] = 12;
				    square.setImage(new Image("Minesweeper/Flag.png"));
				}
				else if(board[grid.getRowIndex(square)][grid.getColumnIndex(square)] == 12) {
				    board[grid.getRowIndex(square)][grid.getColumnIndex(square)] = 11;
				    square.setImage(new Image("Minesweeper/Unopened.png"));
				}
				else if(board[grid.getRowIndex(square)][grid.getColumnIndex(square)] == 9) {
				    board[grid.getRowIndex(square)][grid.getColumnIndex(square)] = 10;
				    square.setImage(new Image("Minesweeper/Unopened.png"));
				}				
				else {
				    board[grid.getRowIndex(square)][grid.getColumnIndex(square)] = 9;
				    square.setImage(new Image("Minesweeper/Flag.png"));
				}
				if(checkWin()) {
				    smiley.setImage(new Image("Minesweeper/WinFace.png"));
				    stop = true;
				    timeline.stop();
				}
                            } // else if                                                                                                                                    
                        } // EventHandler                                                                                                                                   
                    }); // square lambda                                                                                                                                 
            } // for                                                                                                                                                        
	} // for                                                                                                                                                           
    } //setGrid                             

    /**
     * Checks if the selected sqaure is in the bounds of the board.
     * 
     * @param i - the selected row
     * @param j - the selected column
     * @return true if the selected square is in bounds, false otherwise. 
     */
    public boolean isInBounds(int i, int j) {
	if(i < 16 && i > -1 && j < 30 && j > -1) {
	    return true;
	}
	else {
	    return false;
	}
    }
    /**
     * Checks all the adjacent squares and counts how mines are surrounding the selected square. 
     * If a square has zero adjacent mines, the method is recursively called to its surrounding squares.
     *
     * @param i - the selected row
     * @param j - the selected column
     */
    public void checkAdjacent(int i, int j) {
	if(isInBounds(i, j) && (board[i][j] == 10)) {
	    int sum = 0;
	    if(isInBounds(i+1, j) && (board[i+1][j] == 11 || board[i+1][j] == 12)) {
		sum++;
	    }
	    if(isInBounds(i-1, j) && (board[i-1][j] == 11 || board[i-1][j] == 12)) {
		sum++;
	    }	
	    if(isInBounds(i, j+1) && (board[i][j+1] == 11 || board[i][j+1] == 12)) {
		sum++;
	    }
	    if(isInBounds(i, j-1) && (board[i][j-1] == 11 || board[i][j-1] == 12)) {
		sum++;
	    } 
	    if(isInBounds(i+1, j+1) && (board[i+1][j+1] == 11 || board[i+1][j+1] == 12)) {
		sum++;
	    }
	    if(isInBounds(i-1, j-1) && (board[i-1][j-1] == 11 || board[i-1][j-1] == 12)) {
		sum++;
	    } 
	    if(isInBounds(i-1, j+1) && (board[i-1][j+1] == 11 || board[i-1][j+1] == 12)) {
		sum++;
	    }
	    if(isInBounds(i+1, j-1) && (board[i+1][j-1] == 11 || board[i+1][j-1] == 12)) {
		sum++;
	    }	
	    board[i][j] = sum;
	    
	    if(sum == 0) {
		checkAdjacent(i+1, j+1);
		checkAdjacent(i-1, j-1);
		checkAdjacent(i, j+1);
		checkAdjacent(i, j-1);
		checkAdjacent(i+1, j);
		checkAdjacent(i-1, j);
		checkAdjacent(i-1, j+1);		
		checkAdjacent(i+1, j-1);
	    } // recursive calls
	} // if
	return;
    } // checkAdjacent

    /**
     * Generates 99 randomly placed mines.
     */
    public void setMines() {
	for(int i = 0; i < 99; i++) {
	    int col = (int) (30*Math.random());
	    int row = (int) (16*Math.random());
	    if(board[row][col] != 11) {
		board[row][col] = 11;
	    } // if
	    else {
		i--;
	    }
	} // for
    } // setGrid
    
    /**
     * Takes the inputted sqaure that the user selected and does the appropriate action for that selected sqaure.
     *
     * @param i - the selected row
     * @param j - the selected column
     */
    public void makeMove(int i, int j) {
	if(board[i][j] != 11 && board[i][j] != 12) {
	    checkAdjacent(i,j);
	    setGrid();
	} //if
	else { 
	    board[i][j] = 13;
	    stop = true;
	    for(int row = 0; row < 16; row++) {
		for(int col = 0; col < 30; col++) {
		    if(board[row][col] == 11) {
			board[row][col] = 14;
		    } //if
		}
	    } //for
	    setGrid();
	    smiley.setImage(new Image("Minesweeper/SadFace.png"));
	    timeline.stop();
	} // else
    } // makeMove

    /**
     * Checks to see if the player has flagged all the mines and no other squares. If so, returns true.
     *
     * @return true if all mines are flagged and no other squares are flagged
     */
    public boolean checkWin() {
	int count = 0;
	for(int i = 0; i < 16; i++) {
	    for(int j = 0; j < 30; j++) {
		if(board[i][j] == 12) {
		    count++;
		}
	    } // for
	} // for
	if(count == 99) {
	    return true;
	}
	return false;
    } // checkWin
       
} // Minesweeper