#include <iostream>
#include "getboard.h"
#include "movePlayer.h"
#include "moveObstacles.h"
#include <string>
#include <vector>
using namespace std;

//This is the main that executes the program
int main()
{
	
//here a condition variable is created so that when the game is over the condition changes to false and exits the program
	bool condition = true; 
	
//edgestatement is used to process valid input and counter is used to count if an obstacle should be made
		int edgestatement = 0;  
		int counter = 1;

//here a vector of size 30 is created, 1 is the value for elements 1-29 and 0 is the value for element 30
		vector<int> myvector;
		myvector.resize(30);
		for (int i = 0; i < 29; i++)
		{
			myvector[i] = 1;
		}
		myvector[29] = 0;

//value that holds the players position
		int playerPosition = 0;

//printing the default board
		cout << getboard(playerPosition, myvector);

//loop that incases the rest of the program. Only exits when game ends
		while (playerPosition < 29 && playerPosition > -1 && condition == true)
		{

//user input is taken in and held in the input variable
			char input;
			cout << "->> ";
			cin >> input;

//the player is moved if it is a valid input
			movePlayer(input, playerPosition);

//if statements that regulate valid input and keeps parts of the program from running if there is improper inputs
			if (playerPosition != 0 && edgestatement == 0)
			{
				
				
					if (input == 'a' || input == 'd' || input == 'f')
					{

//the obstacles in the vector are moved
						moveObstacles(myvector);
					}
				
			}
			
//loop that checks if the player hits an object and game overs if so
				for (int i = 0; i < 29; i++)
				{
					if (myvector[i] == 0 && playerPosition == i)
					{
						cout << getboard(playerPosition, myvector);
						cout << "You collided with an obstacle! Try again next time!";
						condition = false;
					}
				}

//if statements that regulate valid input and keeps parts of the program from running if there is improper inputs
				if (playerPosition != 0 && edgestatement == 0)
				{
					
						if (input == 'a' || input == 'd' || input == 'f')
						{

//checks to see if an obstacle should be made and places it into the vector
							if (counter == 3)
							{
								myvector[29] = 0;
								counter = 0;
							}
							else
							{
								myvector[29] = 1;
							}

//adds one to count after every correct input
							counter++;
						}
					
				}
				if (edgestatement == 1)//only if statement that resets the edgestatement if the player moves away from edge of board
				{
					edgestatement--;
				}
//only prints out other boards if the game isn't finished
				if (condition == true)
				{
					cout << getboard(playerPosition, myvector);
				}

//adds one to edgestatement if the player is at the edge of the board
				if (playerPosition == 28 && edgestatement == 0)
				{
					edgestatement++;
				}

//win statement
			if (playerPosition >= 29)
			{
				cout << "You win!";
			}
		}
	}
