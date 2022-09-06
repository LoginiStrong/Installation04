#include "randVec.h"

/*This function takes in a seed integer used for randomizing the elements we are 
putting in the vector. It also takes in an integer size that determines the size of the vector.
This function works by making a sorted vector of ints from least to greatest at first, but 
then after we have seeded our random number generator we iterate over our vector with an
iterator and swap numbers randomly.*/
vector<int> randVec(int size, int seed)
{
	vector<int> vec;
	vec.resize(size);
	for (int i = 0; i < vec.size(); i++)
	{
		vec[i] = i;
	}
	srand(seed);
	vector<int>::iterator ptr;
	for (ptr = vec.begin(); ptr != vec.end(); ptr++)
	{
		int  q = rand() % size;
		int tempI = *ptr;
		int tempQ = vec[q];
		*ptr = tempQ;
		vec[q] = tempI;
	}
	return vec;
}