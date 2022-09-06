#include <iostream>
#include <vector>
#include "Calculate.h"
#include "Replace.h"
using namespace std;

/*The main that runs the program. Above are the .h files required.
we get N numbers from the user and create a vector of that size.
We make sure the input afterward is a number 0-9. We then call our functions
andprint out the vector to the user*/
int main()
{
	int nNums = 0;
	int chosenNum = 0;
	cout << "Enter N:\n>> ";
	cin >> nNums;
	vector<int> myvector;
	myvector.resize(nNums);
	for (int i = 0; i < nNums; i++)
	{
		cout << "Enter number " << i + 1 << ":\n->>";
		cin >> chosenNum;
		while (chosenNum < 0 || chosenNum > 9)
		{
			cout << "Please enter a number from 0-9\n->>";
			cin >> chosenNum;
		}
		myvector[i] = chosenNum;
		
	}

	//calling the calculate function
	Calculate(myvector, nNums);

	//calling the replace function
	Replace(myvector, nNums);

	//setting all number <0 to 0.
	for (int i = 0; i < nNums; i++)
	{
		if (myvector[i] < 0)
		{
			myvector[i] = 0;
		}
	}

	//printing out the vector
	for (int i = 0; i < nNums; i++)
	{
		cout << myvector[i] << " ";
	}
	cout << "\n";
}