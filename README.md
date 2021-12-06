# Brick_Destroy

----------------------Refactors-----------------------------------

1)MVC Pattern:
-I refactor each class into Model-View-Control Pattern.

i)Player Class:
-"Player" class will act as the model in the MVC design pattern.
-I added a "PlayerController" class and move all the method in Player
 class to the PlayerControlle class. PlayerController class will 
 act as the controller of Player class.
-I added a "PlayerView" class which will act as the view of "Player"
 class.

ii)Ball Class:

iii) Debug Console Class:
- "DebugPanel" class will act as the model in MVC design pattern.
- "DebugConsole" class will act as the view of "DebugPanel" class.
- I added a "DebugController" class which will be the controller of 
  "DebugPanel" class.


2)New Classes:
-Extracted move method from Player class and Brick class to one
 interface class called Move.
-Added a Speed abstract class and extract "setSpeed", "setXSpeed",
 "setYSpeed", "reverseX", "reverseY", "getSpeedX" and "getSpeedY" methods
 from Ball class into the abstract class.
-Added a Colour abstract class and extract "setInnerColour", "getInnerColour",
 "setBorderColour" and "getBorderColour" from Brick class and Ball clas.

3)Package Organised:
-I have organised all the classes into their own relevant packages.
 For example, Player class is put in a package call player.
*Reason of organising the class to it own packages is to group related class
 into one package to let other user to find the code easily.

4)Deleted, Changed and New Method or Variable:
i)Steel Class:
-I deleted "impact" method in "Steel" class.
-I added "updateBrick" and "repair" method to update and reset the steel 
 brick whenever the user restart the game.
-I changed the "setImpact" method to make the steel brick show crack whenever
 the ball hit it.
*Reason of doing this change is because in original brick destroy game, the steel
 brick doesn't show crack whenever the ball hit it.

-Deleted "rnd" variable because it is not used.


5) Encapsulation or changed Access Modifier:
i)Ball class:
-I change the "up", "down", "left" and "right" variable in Ball class
 from public to private. After that I created get method for 
 each of these private variables.
*Reason of changing these variable to private variable so that other class
 can't change their value accidentally or intentionally.

ii) Brick Class:
-I changed the "brickFace" variable to protected and added get method for
 it.
*Reason of changing it to protected is beacause other class from other packages 
 can't change it values accidentally or intentionally.

6)Extracted Class:
-I extracted "Crack" class in "Brick" class to it own class.

7)Refactor to other Design Pattern:
i)Crack Class:
- In "makeCrack" method, I refactor the switch statement to Factory design
  pattern.







----------------------Additions------------------------------------


1)Added instruction menu.
2)Added new level.
3) I change the reset ball speed to fix value.
-change beacuse the speed is randomize
4) added crack onto steel brick.
-doesn't show crack
5) change the start ball speed to fix value.
 -change beacuse the speed is randomize

