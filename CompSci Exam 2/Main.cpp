#include <iostream>
#include <string>
#include <vector>
#include "ElectricTrain.h"
#include "FlyingTrain.h"
using namespace std;


int main()
{
	//a variable for choosing which train to make
	int choice;

	//variables that will be passed into the train constructors and the travel function
	int time;
	string name;
	int speed;

	bool condition = true;//boolean that maintains the while loop until 4 is entered

	vector<Train*> t;//vector of train pointers that we will be adding train's child pointers to

	//while loop that keeps program running until it is quitted
	while (condition == true)
	{
		//menu for the user
		cout << "What would you like to do?\n1. Add a train\n2. Travel Trains\n3. Print Trains\n4. Quit.\n>> ";

		//users choice that is put through the switch statement
		int userInput = 0;
		cin >> userInput;

		//switch stamement that runs a case selected by userInput
		switch (userInput)
		{

		/*case 1 adds a type of train based on the users input. If 1 is selected we gather a name and speed for the 
		train and make a FlyingTrain. If a 2 is entered do the same but we use an ElectricTrain constructor. We then add
		thatobject to the vector of trains.*/
		case 1:
			cout << "What type of Train would you like to add?\n1. Flying\n2. Electric\n>> ";
			cin >> choice;
			if (choice == 1)
			{
				cout << "What is the name and speed of this train\n>> ";
				FlyingTrain* fT;
				cin >> name >> speed;
				fT = new FlyingTrain(name, speed);
				t.push_back(fT);
			}
			else
			{
				cout << "What is the name and speed of this train\n>> ";
				ElectricTrain* eT;
				cin >> name >> speed;
				eT = new ElectricTrain(name, speed);
				t.push_back(eT);
			}
			break;

		/*case 2 gathers a time (units) from the user and inserts that into the travel function.
		The Travel function is called on every train in the train vector by using for loop to move them all.*/
		case 2:
			cout << "How far should the trains travel?\n>> ";
			cin >> time;
			for (int i = 0; i < t.size(); i++)
			{
				t[i]->Travel(time);
			}
			cout << "All the trains have traveled " << time << " units\n";
			break;

		/*case 3 uses a for loop and calls toString on each train in the vector, printing out each trains 
		specific toString.*/
		case 3:
			for (int i = 0; i < t.size(); i++)
			{
				t[i]->toString();
			}
			cout << endl;
			break;

		//changes the condition to false and ends the loop (program)
		case 4:
			condition = false;
			break;

		//default just in "case" haha
		default:
			break;
		}
	}
	for (int i = 0; i < t.size(); i++)
	{
		delete t[i];
	}
}