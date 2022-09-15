#include "GetBoard.h"
#include "moveFunction.h"
#include "moveObs.h"
#include <vector>
#include <iostream>
#include <string>
using namespace std;

int main()
{
	char choice;
	int playerPos = 1;
	bool condition = true;
	vector<int> obstacles;
	int tracker = 0;
	for (int i = 29; i > 0; i--)
	{
		obstacles.push_back(1);
	}
	obstacles.push_back(0);
		while (condition == true)
		{
			string board = GetBoard(playerPos);
			cout << board;
			cin >> choice;
			moveFunction(choice, playerPos);
			cout << endl;
			for (int i = 0; i < 30; i++)
			{
				cout << obstacles.at(i);
			}
			cout << endl;
			obstacles = moveObs(obstacles, tracker);
		}
}