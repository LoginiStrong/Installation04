#include <string>;
#include <array>;
#include <vector>;
#include <iostream>;
#include "printMenu.h"
#include "add.h"
using namespace std;

int main()
{
/*Part 1
//integer variables holding 0's
	int aInt = 0;
	int bInt = 0;

//integer pointers pointing at the adress of the integer variables
	int* aPtr = &aInt;
	int* bPtr = &bInt;

//dereferencing both pointers and changing the values each integer variable holds
	*aPtr = 8;
	*bPtr = 11;

//printing out the values the variables hold by derefeencing the pointers
	cout << "aptr: " << *aPtr << "\n";
	cout << "bptr: " << *bPtr << "\n";

//prints the addresses each pointer is pointing at
	cout << "aptr: " << aPtr << "	bptr: " << bPtr << "\n";

//switches the address each pointer is pointing at
	aPtr = &bInt;
	bPtr = &aInt;

//printing out the values the variables hold by derefeencing the pointers
	cout << "aptr: " << *aPtr << "\n";
	cout << "bptr: " << *bPtr << "\n";

//prints the addresses each pointer is pointing at
	cout << "aptr: " << aPtr << "	bptr: " << bPtr << "\n";
*/	

/*Part 2
//creating a vector of character pointers
	vector<char*> myvector;

//this for loop pushes characters into the vector, adding 1 everytime so it is a list of the alphabet
	for (int i = 0; i < 26; i++)
	{
		myvector.push_back(new char('a'+i));
		
	}

//prints the contents of the vector at i by dereferencing the vector (pointer) 
	for (int i = 0; i < 26; i++)
	{
		cout << *myvector.at(i);
		cout << "\n";
	}

//deletes the contents of the vector for every element
	for (int i = 0; i < 26; i++)
	{
		delete myvector.at(i);
	}
*/

/*Part 3
//creating the columns of the 2d array
	int** numbers = new int* [15];

//using a nested for loop to fill the elements of the 2d array
	for (int i = 0; i < 15; i++)
	{

//creating the rows of the 2d array
		int* secNum = new int[15];
			for (int j = 0; j < 15; j++)
			{

//incremently increasing the umber value of each element in the array
				secNum[j] = i + j;
			}
			numbers[i] = secNum;
	}

//using a basic nested for loop to print out the 2d array
	for (int i = 0; i < 15; i++)
	{
		for (int j = 0; j < 15; j++)
		{
			cout << numbers[i][j] << " ";
		}
		cout << "\n";
	}

//for loop that goes through every element of the array and deletes them
	for (int i = 0; i < 15; i++)
	{
		delete numbers[i];
	}

//code that deletes the array once it is finished with
	delete[] numbers;
*/


//newInput is the variable that holds the users index choice throughout the code
	int newInput = 0;

//setValue is only use in case s for the user to set a value of an index
	int setValue = 0;

//these variables are for when the user chooses to add two indexs together in case w
	int index1 = 0;
	int index2 = 0;

//condition that keeps the code running until the user enters q to end the program
	bool condition = true;

//variable that holds the users choice of action, which is used in the switch statement 
	char userInput;

//creating a vector of int pointers and then pushing 10 new integers into the vector
	vector<int*> vectorOfPtrs;
	for (int i = 0; i < 10; i++)
	{
		vectorOfPtrs.push_back(new int );
	} 

//loop that doesnt end unless q is entered 
	while (condition == true)
	{

//calling the printMenu function (explained in its .cpp file)
		printMenu();

//the input that will be used throughout the switch and case statements
		cin >> userInput;
		switch (userInput)
		{


/*case that allows the user to enter a new value at a selected index
there are if statements that prevent the user from entering indexes out
of range and set a value at an index that is null*/
		case 's':
			cout << "--> ";
			cin >> newInput;
			cout << "--> ";
			cin >> setValue;
				if (newInput < 0 || newInput > 9)
				{
				cout << "Index is out of range!\n";
				}
				if (vectorOfPtrs.at(newInput) == NULL)
				{
					cout << "index " << newInput << " is null\n";
				}
				else
				*vectorOfPtrs[newInput] = setValue;
			break;

//case statement that prints out a selected index. It will not allow the user to print a null index or an index out of range
		case 'p':
			cout << "--> ";
			cin >> newInput;
				if (newInput < 0 || newInput > 9)
				{
					cout << "Index is out of range!\n";
				}
				if (vectorOfPtrs.at(newInput) == NULL)
				{
					cout << "index " << newInput << " is null\n";
				}
				else
				cout << *vectorOfPtrs[newInput] << "\n";
			break;

/*case statement that deletes a value at a selected index and sets the value equal to null
the statement doesn't allow the user to delete a null index or an index out of range*/
		case 'd':
			cout << "--> ";
			cin >> newInput;
				if (newInput < 0 || newInput > 9)
				{
					cout << "Index is out of range!\n";
				}
				else if (vectorOfPtrs.at(newInput) == NULL)
				{
					cout << "index " << newInput << " is null\n";
				}
				else
				{
					delete vectorOfPtrs.at(newInput);
					vectorOfPtrs.at(newInput) = NULL;
				}
			break;

/*case statement that allows the user to activate a piece of memory that has been deleted and
set to null. The statement does not allow the user to activate already active memory
or memory at an index out of range.*/
		case 'i':
			cout << "--> ";
			cin >> newInput;
			if (newInput > 9 || newInput < 0)
			{
				cout << "Index out of range!\n";
			}
			else if (vectorOfPtrs.at(newInput) != NULL)
			{
				cout << "index " << newInput << " has already been instantiated\n";
			}
			else
			{
				vectorOfPtrs.at(newInput) = new int;
				cout << "index " << newInput << " is active memory\n";
			}
			break;

/*case statement that adds two indexes together and replaces both indexes values with that singular sum
The statement does not allow the user to add null values or indexes that are out of range*/
			case 'w':
				cout << "--> ";
				cin >> index1;
				cout << "--> ";
				cin >> index2;
					if (index1 > 9 || index1 < 0)
					{
						cout << "Index out of range!\n";
					}
					if (index2 > 9 || index2 < 0)
					{
						cout << "Index out of range!\n";
					}
					else if (vectorOfPtrs.at(index1) == NULL || vectorOfPtrs.at(index2) == NULL)
					{
						cout << "Can't add null values\n";
					}
					else
					{
						add(vectorOfPtrs.at(index1), vectorOfPtrs.at(index2));
					}
				break;

/*case statement that deletes each value in the vector of pointers and set each to null.
Finally the condition is set to false and the program ends*/
			case 'q':
				for (int i = 0; i < 10; i++)
				{
					delete vectorOfPtrs.at(i);
					vectorOfPtrs[i] = NULL;
					condition = false;
				}
				break;

//default statement incase the user enters an incorrect case
			default:
				cout << "Please enter a correct menu option\n";
				break;
		}

	}
}
