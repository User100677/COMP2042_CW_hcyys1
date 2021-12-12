# Brick_Destroy

---------------------------REFACTORS-----------------------------------

##1)MVC Pattern:
I have converted all the classes in the project to MVC design pattern. 
Every single class will have their own controller, model and view class.
Let take "Player" class for an example. "Player" class itself will be the 
model class which store all the data. After that I created a controller class
call "PlayerController" class and move all the methods and data initialization
in "Player" class to this class. The "PlayerController" class will access all the data in "Player" class through 
gettter and setter method. After that, I created a view class call "PlayerView" class which 
it job is to draw out the player to the screen. The view class can only access the data from 
model class through the controller class. So from this point onwards, other class can only access the 
player data through "PlayerController" class. For those class who have inherited classs, I make controller class
for each of the child and parent class, but the parent class will only have view class.
Take "Ball" class for an example. The "Ball" class will have "BallController" class and 
"BallView" class but the the child class which is the "RubberBall" class will only have 
"RubberBallController" class.

##2)Encapsulation:
I turn all the variables in each and every class to private method so that the other class will not
be able to access it directly. After that I created getter and setter method for the variables.

##3)Other Design pattern: 
Inside the "CrackCOntroller" class, there is a method call "makeCrack(Point2D point, int direction)" 
and inside this method there is a switch statement which produce different start point and end point which depends 
on the directions of the crack. I convert these statement to Factory Design Pattern. I make a interface class call "Direction" 
to store the "setStartLocation()" and "setEndLocation()" method. After that I created "DirectionUp", "DirectionDown", "DirectionLeft" 
and "DirectionRight" classes to implement these method. After that I created "DirectionFactory" class to produce the 
instances of this classes to the "CrackController" class. The reason I use the Factory Design pattern here to make the code look cleaner.


##4)Package Organization: 
I have organised all the classes into their own relevant packages. For example, Player class is put in a package call player.
Reason of organising the class to it own packages is to group related class into one package to let other user to find the code easily.

##5)Extracted class and method to a new class:
i)Move Abstract Class:
Extracted move method from "Player" class, "Brick" class and "Wall" class to one interface class called "Move". I did this extraction to hide
the move method.

ii)Speed Abstract Class:
Added a Speed abstract class and extract "setSpeed", "setXSpeed", "setYSpeed", "reverseX", "reverseY", "getSpeedX" and "getSpeedY" methods
from Ball class into this abstract class. I did this extraction to reduce the amount of code in the "Ball" class.	

iii)Colour abstrct class:
Added a Colour abstract class and extract "setInnerColour", "getInnerColour","setBorderColour" and "getBorderColour" from Brick class and Ball clas. 
I did this extraction to reduce the amount of code in the "Ball" class and "Brick" class.

iv)Brick Class:
I extracted inner class "Crack" class in "Brick" class to its own class. Reason of extracting this inner class to it own class is to make the "Brick" class
easy to read and cleaner.

v)BallAmount Class:
I extracted "getBallCount", "isBallLost", "ballEnd" and "resetBallCount" method from "Wall" class and into "BallAmount" class which I created. I extracted
these method to it own class because these method doesn't belong in "Wall" class.
 
vi)LevelCreation Class: 
I extracted "makeSingleTypeLevel" method, "makeChessboardLevel" method and "makeLevels" method from "Wall Class" to it own class call "LevelCreation" class.
I extracted these method to it own class because these method doesn't belong in "Wall" class.

vii)CreateBrickType Class:
I extracted "makeBrick" method from "Wall" class to it own class call "CreateBrickType". I extracted these method to it own class because these method doesn't belong in "Wall" class.

viii)LevelProgression Class:
I extracted "nextLevel" method and "hasLevel" method from "Wall" class to it own class I created call "LevelProgression". I extracted these method to it own class because these method doesn't
 belong in "Wall" class.

ix)PauseMenu Class:
I extracted "drawMenu", "obscureGameBoard" and "drawPauseMenu" method from "GameBoard" class to it own class call "PauseMenu" class which this class purpose is to draw out the pause menu screen.
I extracted these method to it own class because these method doesn't belong in "Wall" class.

##6)Deleted, Changed and New Method or Variable:
i)SteelController Class:
-I deleted "impact" method in "Steel" class.
-I added "updateBrick" and "repair" method to update and reset the steel 
 brick whenever the user restart the game.
-I changed the "setImpact" method to make the steel brick show crack whenever
 the ball hit it.
*Reason of doing this change is because in original brick destroy game, the steel
 brick doesn't show crack whenever the ball hit it.

-Deleted "rnd" variable because it is not used.
-Deleted "STEEL_PROBABILITY" variable because it is not used.

ii)Wall Class:
-I deleted "rnd" variable in the wall class because it is not used.

iii)Brick Class:
-Deleted "MIN_CRACK","DEF_CRACK_DEPTH" and "DEF_CRACK_DEPTH" variable
 in "Brick" class because they are not used.

iv)CrackController class:
I change the randomizer in the "randomInBounds" method and "randomPoint" method to only ramdomize positive integer in "CrackController" class
by adding "& Integer.MAX_VALUE".

v)WallController class:
-In the constructor of this class, I change the starting speed of the ball to a fixed value which is(3, -3). 
-In the "ballReset" method, I change the speed of the ball to a fixed value which is (3, -3).
*Reasons of changing the speed to a fixed value is because in the original code, the speed value of the ball is randomize, so everytime the player open the game the ball is in different
speed.

------------------------------ADDITION-------------------------------------------------

##1)Instruction Menu Screen:
I added a new button onto the home menu screen call "instruction". Once the player clicked this button, the screen will change from home menu screen to instruction menu screen where this 
screen show the Player on how to play the game. 

##2)Additional levels:
I added three more levels to the game.
-The fifth level consist of all steel bricks.
-For the sixth and last level, I created a new brick type call gold brick which is in the "Gold" brick class in brick package. The strength of the brick is set to 4 which is the hardest brick of all the
 brick type in the game.
-The sixth level consist of gold brick and steel brick which is places in chessboard pattern.
-For the last level, all bricks type are gold and there are additional two more layer of gold bricks.

##3)Score

