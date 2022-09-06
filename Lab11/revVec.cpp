#include "revVec.h"

/*Function that makes and returns a worst case vector by putting the greatest element
at the beginning and is sorted greatest to least so it has the most possible inversions.*/
vector<int> revVec(int looper, vector<int> reverseVec)
{
	for (int i = reverseVec.size() - 1; i > -1; i--)//reverse for loop to start from the end of the vector
	{
		reverseVec[i] = looper;
		looper++;
	}
	return reverseVec;
}