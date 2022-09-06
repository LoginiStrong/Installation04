#include "TemperatureGauge.h"
#include "Duck.h"
#include "Pond.h"
#include <iostream>
using namespace std;

int main()
{
	//Part 1
	//constructor with no arguements
	TemperatureGauge num1;
	//print default F and C value
	cout << num1.getTempF() << endl;
	cout << num1.getTempC() << endl;

	//constructor with 120 arguement
	TemperatureGauge num2 = 120;

	//print out 120 arguement in F and C values
	cout << num2.getTempF() << endl;
	cout << num2.getTempC() << endl;

	//set the first object to -80 and 180 and print them
	cout << num1.setTempF(-80) << endl;
	cout << num1.setTempF(180) << endl;

	//set temp to 59.5 and convert it to C  
	num1.setTempF(59.5);
	cout << num1.getTempC() << endl;

	//set each object equal to eachother
	num2 = num1;

	//set num2 eqaul to 33 and convert it to C
	num2.setTempF(33);
	cout << num1.getTempC() << endl;
	
	//Part 2
	/*Below I creat a pond object and several variables that will be used for
	user input and maintaining loops*/
	Pond duckPond;

	string name;//user input
	int height = 0;
	int userInput = 0;

	bool num1Check = false;//loops
	bool condition = true;

	//loop  that won't break until case 4 is chosen
	while (condition == true)
	{
		
	//getting the users input and using IO for user input as well as printing the menu
		cout << "What would you like to do?\n1. Add a duck.\n2. Fly a duck.\n3. print the pond.\n4. Quit.\n>> ";
		cin >> userInput;
		if (cin.fail())
		{
			cin.clear();
			cin.ignore(INT_MAX, '\n');
		}

	//switch statement that takes in user input for the menu
		switch (userInput)
		{

	/*case 1 uses IO for sanitization and takes in a name and a height for a duck
	it uses the addDuck method for this*/
			case 1:
				do
				{
					cout << "What is the name & flying height of your duck?\n>> ";
					cin >> name >> height;
					if (cin.fail())
					{
						cin.clear();
						cin.ignore(INT_MAX, '\n');
						cout << "Please enter a name and a number with a space in between.\n";
						num1Check = true;
					}
					else
					{
						duckPond.addDuck(name, height);
						num1Check = false;
					}
				} while (num1Check == true);
				break;

	/*case 2 takes in the name of the duck the user wants to fly and
	calls the flyDuck method*/
			case 2:
				cout << "What is the name of the duck you wish to fly?\n>> ";
				cin >> name;
				duckPond.flyDuck(name);
				break;

	/*case 3 prints the pond using the printPond method*/
			case 3:
				duckPond.printPond();
				break;

	/*case 4 ends the program*/
			case 4:
				condition = false;
				break;

	/*if no case is fullfilled it will ask for correct input*/
			default:
				cout << "Please enter a number 1-4.\n";
				break;
		}
	}
}