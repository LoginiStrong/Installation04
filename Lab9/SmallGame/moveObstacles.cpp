#include <vector>
#include <string>
using namespace std;

/*definition for the moveObstacles function. It takes in the value of a vector of obstacles.
The function loops through the vector and shifts every element in it forward an index (-1 index)
It then returns the vector.*/
vector<int> moveObstacles(vector<int> & obstacles)
{
	for (int i = 0; i < 29; i++)
	{
		obstacles[i] = obstacles[i + 1];
	}
	return obstacles;
}