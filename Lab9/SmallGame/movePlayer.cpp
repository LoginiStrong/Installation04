#include <iostream>
#include <string>
using namespace std;

/*definition for the movePlayer function that takes in 
a character argument that will process the players move.
The other argument is an integer that holds the value of the players position
and is modified accordingly in the function.*/
void movePlayer(char move, int & position)
{
	
/*the workings of this function are incased in a switch and case
if move is an a the player moves left 1 (but will not go out of bounds). If move
is a d the player moves right one. If move is an f the player moves right 2.*/
	switch (move)
	{
		case 'a':
			if (position > 0)
			{
				position -= 1;
			}
			break;
		case 'd':
			position += 1;
			break;
		case 'f':
			if (position < 28)
			{
				position += 2;
			}
			break;
		default:
			cout << "Please enter a correct command.\n";
			break;
	}
}