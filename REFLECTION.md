# Reflection

## Reflection Update 1

## FRI 2017-11-17 @ 11:55 PM EST

1. **DONE:** We figured out how to successully push and pull updates to and from GitHub. We switched out the starter code with a retro menu screen for our application. Right now our home screen only contains a background and text. We also made plans to meet up over break to work on parts of the project.

2. **TODO:** Before our next reflection update, we plan to have the functionality of our application working up to the running of the game. This includes allowing the user to continue from the home screen and choose which game they would like to play. Along with this, we will have our menu bar working. We plan on making our application include Tetris and Recursive Minesweeper.

3. **PROB:** We had trouble figuring out how to properly use GitHub. We had to figure out what is actually being commited each time and how to have aceess to the other person's updates. We did figure this out and we are able to push and pull updates as needed. Also, we had trouble figuring out when we can meet in person, but we figured out times we could meet, so we are ready to go for the rest of the project.


## Reflection Update 2

## TUES 2017-11-28 @ 11:55 PM EST

1. **DONE:** As of now, we have the basic layout of our Arcade application. The intro screen now includes a gif of a moving retro background (It was working, but we are currently modifying it). When the user clicks on the screen, a new scene appears which prompts the user to select the game they would like to play (Tetris or Minesweeper). We also have the beginning scene for Minesweeper, along with all the images we plan to use downloaded and added into our resources folder. For Tetris, we have beginning scene, however it is not displaying the way we want it to. We have some functionality working on the menu bar including "Exit" and "Back".

2. **TODO:** Before the next reflection update, we plan to have the scenes completely finished for Tetris and Minesweeper. We also plan on having Minesweeper essentially finished since we already have alot of the code available from project 1, we just need to use recursion to handle cases when the user clicks on a 0 tile. We want to have Tetris to the point that tiles are flowing down the screen. Furthermore, we will hopefully allow input from the user to dictate movement and orientation of each tile.

3. **PROB:** The majority of the problems we have run into involve laying things out correctly on each scene. Many times, we find ourselves adding an excessive number of parent panes in order to get things in the place we want them which makes our code very messy. We are also having trouble relocating nodes within a pane. Finally, adding gifs to the scene have caused several problems in our intro scene.


## Reflection Update 3

## TUES 2017-12-05 @ 11:55 PM EST

1. **DONE:** We have completed the layout of both Minesweeper and Tetris. As of right now, the Minesweeper game has a complete layout with some functionality in each square of the grid. Currently, when you click on each unclicked square it changes to the image of a clicked square. We have all methods needed to add the rest of the functionality of the game. Along with this, we have developed a working recursive method to display zero squares adjacent to the clicked square. For tetris, we have completed the layout and it currently displays the level that the game is on, the player's score, and the next tile that will fall in the playing field. 

2. **TODO:** By the next due date, we will have our arcade app finished and fully functioning. We need to implement the methods from Minesweeper into the GUI actions. We also need to handle cases when the user wins the game and loses the game. Our biggest challenge will be finishing Tetris. We still need to have a way to take the next tile and make it start falling from the top of the playing field at a constant rate. We also need to implement an algorithm to calculate the user's score and update the current level of the game. Lastly, we will allow our app to keep track of the highscores for each game and display the highscore from within the menu of each game.

3. **PROB:** Most of our problems still stem from laying nodes out correctly on the scene. We have also run into some issues in figuring out how to implement methods from Project 1 into our Minesweeper game. We still have not figured how to get tiles to smoothly transition from the top of the screen to the bottom. Finally, we do not know how to allow our app to keep track of previous highscores when the app is closed then reopened.


## Reflection Update 4

## TUES 2017-12-12 @ 8:00 AM EST

1. **DONE:** We have completely finished Tetris and Minesweeper! The intro screen includes an animation with our team name and team member names. The main menu page includes the game options and allows the user to choose one or the other. Minesweeper correctly uses recursion to display all tiles surrounding a clicked 0 and its neighboring 0's. Additionally, the scoring mechanics for Minesweeper can be found in the Help/Control menu. Tetris correctly allows the user to rotate and move tiles and remove rows when they are full. Both games successfully run to completion, and display the user's score at the end. The menu bar allows users to return to the main menu of the application and begin a new game, exit the application, and get help for how to play the game. We are very proud of how are application turned out, and we are still getting a toomuchsauceexception:)

2. **TODO:** This is the final due date of our project. Moving on, we may add more games to our application, or add more features to our existing games. One implementation we would like to add to Tetris is to allow the player to save a tile and use it later.

3. **PROB:** For Minesweeper, we had trouble implementing our recursive method for revealing neighboring 0's. We kept running into a StackOverFlow error, but eventually figured out what was going wrong and fixed it. For tetris, the problems we ran into involved moving tiles on the board. We solved this by constantly checking the spaces in the direction the tile was to move in order to make sure every move is legal. Furthermore, we had trouble rotating tiles, however we figured out we could use the transformation of vectors algorithm from linear algebra very efficiently to allow successful rotations.