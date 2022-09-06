//This is the algorithm for the Shortest Job First
#include <iostream>
using namespace std;

void sjfScheduler(int arrival[], int burst[], int priority[])
{
	cout << "This is the shortest job first scheduler" << endl;
	int length = sizeof(arrival) + 1;
	//cout << length;
	for (int i = 0; i < length; i++)
	{
		cout << arrival[i] << "    " << burst[i] << "    " << priority[i] << endl;
	}
}