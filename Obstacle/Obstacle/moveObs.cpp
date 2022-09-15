#include <vector>
#include <iostream>
#include <string>
using namespace std;

vector<int> moveObs(vector<int> & obstacles, int & tracker)
{
	if (tracker == 2)
	{
		//obstacles.pop_back();
		
		obstacles.erase(obstacles.begin());
		obstacles.push_back(0);
		//obstacles.resize(30);
		//obstacles.shrink_to_fit();
		
		tracker = 0;
	}
	else
	{
		obstacles.erase(obstacles.begin());
		obstacles.push_back(1);
		//obstacles.resize(30);
		//obstacles.shrink_to_fit();
		
		//tracker = 0;
		tracker++;
	}
	
	return obstacles;
}