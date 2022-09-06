#include <vector>
#include <iostream>
using namespace std;

/*A function that does the desired calculations within a vectors
elements and resets the values in the vector to the numbers*/
void Calculate(vector<int>& vec, int size)
{
	//temp vector to place numbers in
	vector<int> tempvec;
	tempvec.resize(size);

	//variables for required calculations
	int sum = 0;
	int exSum = 0;
	int average = 0;
	int total = 0;
	
	//for loop that has else if statements to determine neighboring values
	for (int i = 0; i < size; i++)
	{
		if (i == 0)
		{
			sum = vec[i] + vec[i + 1];
			average = sum / 2;
			total = average - 1;
			tempvec[i] = total;
		}
		else if (i == (size - 1))
		{
			sum = (vec[i] + vec[i - 1]);
			average = sum / 2;
			total = average - 1;
			tempvec[i] = total;
		}
		else
		{
			sum = vec[i] + vec[i - 1];
			
			exSum = sum + vec[i + 1];
			
			average = exSum / 3;
			total = average - 1;
			tempvec[i] = total;
		}

		//putting temp values into the main vector
		for (int i = 0; i < size; i++)
		{
			vec[i] = tempvec[i];
		}
	}
}