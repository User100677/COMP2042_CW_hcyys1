# Brick_Destroy

----------------------Refactors-----------------------------------

1)MVC Pattern:
-I refactor each class into Model-View-Control Pattern.

i)Player Class:
-Player class will act as the model in the MVC design pattern.
-I added a PlayerController class and move all the method in Player
 class to the PlayerControlle class. PlayerController class will 
 act as the controller of Player class.
-I added a PlayerView class which will act as the view of Player
 class.

ii)

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

4)Deleted Method:

5) Encapsulation:
-I change the "up", "down", "left" and "right" variable in Ball class
 from public to private. After that I created a set and get method for 
 each of these private variables.




----------------------Additions------------------------------------


1)Added instruction menu.
2)Added new level.
3) I change the reset ball speed to fix value.
4) added crack onto steel brick.
5) change the start ball speed to fix value.

