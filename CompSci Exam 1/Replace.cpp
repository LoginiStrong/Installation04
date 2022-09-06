#include <vector>
using namespace std;
/*Function that replaces desired values by taking in a vector and its size
and using if statement to reasign values*/
void Replace(vector<int>& vec, int size)
{
	for (int i = 0; i < size; i++)
	{
		if (vec[i] == 3)
		{
			vec[i] = 4;
		}
		else if (vec[i] == 5)
		{
			vec[i] = 4;
		}
		else if (vec[i] == 6)
		{
			vec[i] = 9;
		}
	}
}