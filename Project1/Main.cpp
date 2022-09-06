#include <iostream>
#include "SJF.h"
using namespace std;

int main()
{
	int arrival[5];
	int burst[5];
	int priority[5];
	for (int i = 0; i < 5; i++)
	{
		arrival[i] = i;
		burst[i] = i;
		priority[i] = i;
	}
	for (int i = 0; i < 5; i++)
	{
		cout << arrival[i];
		cout << burst[i];
		cout << priority[i];
	}
	sjfScheduler(arrival, burst, priority);
	
}