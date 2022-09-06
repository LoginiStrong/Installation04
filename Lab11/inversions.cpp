#include "inversions.h"

/*This function counts how many inversions are in a vector of integers.
It performs this by simply seeing if whatever is at index i is greater than
what is at index j. If it is we add one to our inversions variable that is returned 
at the completion of the function.*/
int inversions(vector<int> vec)
{
	int inversions = 0;
	for (int i = 0; i < vec.size(); i++)
	{
		for (int j = i; j < vec.size()-1; j++)
		{
			if (vec[i] > vec[j+1])
			{
				inversions++;
			}
		}
	}
	return inversions;
}