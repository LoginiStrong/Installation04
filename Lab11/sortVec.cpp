#include "sortVec.h"

//Function that creates and returns a sorted list of numbers that is sorted from least to greatest.
vector<int> sortVec(vector<int> vec)
{
	for (int i = 0; i < vec.size(); i++)
	{
		vec[i] = i;
	}
	return vec;
}