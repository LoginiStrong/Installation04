#include <iostream>
using namespace std;

int main()
{
//x an y are variables that hold the two numbers the user inputs, as well as the result of the mathematical operation that will happen
	int x, y;
	int result = 0;

//op is short for operator (since I found out operator is a key word) and op holds the operator the user inputs
	char op;

//asterisks is a string that is built upon in a for loop late in this code
	string asterisks = "";

//this string variable will hold the users answer when shoosing to loop throught the program
	string answer;

//a request for calculation printed out to the user
	cout << "Enter a calculation in the form X + Y\n";

/*the entirety of the rest of this code is in a do while loop to run this code at least once.
the loop continues if the user enters y, and the loops ends if n is entered*/
	do
	{

//this is the console getting the users inout for the variables
		cin >> x >> op >> y;
	
//switch statement that chooses cases based on the operator entered	
		switch (op)
		{

//all cases print out their results
//this case will add the two numbers the user entered and hold onto the result
		case '+':
			cout << x << " + " << y << " = " << x + y <<"\n";
			result = x + y;
			break;

//this case will subtract the two numbers the user entered and hold onto the result
		case '-':
			cout << x << " - " << y << " = " << x - y << "\n";
			result = x - y;
			break;

//this case will multiply the two numbers the user entered and hold onto the result
		case '*':
			cout << x << " * " << y << " = " << x * y << "\n";
			result = x * y;
			break;

//this case will divide the two numbers the user entered and hold onto the result
		case '/':
			cout << x << " / " << y << " = " << x / y << "\n";
			result = x / y;
			break;
		}

//an if statement that adds stars equal to the result, unless the result equals 5 or more
		if (result < 5)
		{
			for (int i = 0; i < result; i++)
			{
				asterisks += "*";
			}
		}

//adds 5 starts if result equals 5 or more
		else
		{
			asterisks += "*****";
		}

//prints stars and resets the stringbuilder afterward
		cout << asterisks;
		asterisks = "";

/*asks the user if they want to try another calculation, if the answer is y it loops
back to the start of the do while loop, if it's n the program ends*/
		cout << "\nDo you want to enter another calculation? Enter y or n\n";
		cin >> answer;

//this loop is used to sanatize the users input, making sure it could only be a y or an n
		while (answer != "y" &&  answer != "n")
		{
			cout << "That is not a valid y or n! Please try again";
			cout << "\nDo you want to enter another calculation? Enter y or n\n";
			cin >> answer;
		}
	} while (answer == "y");
}