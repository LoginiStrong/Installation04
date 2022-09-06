//getboard function definition
#include <string>
#include <vector>
using namespace std;

/*This is the definition for the getboard function. It takes in two arguements
one is the players position as an integer and the other is the value of the 
vector holding the obstacles. Throughout the function a string is being built that
will display the board.*/
string getboard(int pos, vector<int> & obstacles)
{
	string firstRow = "B";

	for (int i = 0; i < 30; i++)
	{
		
//referencing the value obstacles holds.(zero means to print a zero)
		if (obstacles[i] == 0)
		{
			firstRow += "0";
		}

//references the player position to print out the current position
		else if (i == pos)
		{
			firstRow += "P";
		}
		else
		{
			firstRow += " ";
		}
		
	}

//building a string that is returned to the main
	firstRow += "E";
	string secRow = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	string board = firstRow;
	board += "\n";
	board += secRow;
	board += "\n";
	return board;
}