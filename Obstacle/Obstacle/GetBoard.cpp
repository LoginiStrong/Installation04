#include "GetBoard.h"
#include <vector>
#include <iostream>
#include <string>
using namespace std;

string GetBoard(int Pos)
{
	vector<string> Layer1, Layer2;
	for (int i = 0; i < 30; i++)
	{
		Layer1.push_back("X");
		Layer2.push_back(" ");
		if (Pos == i)
		{
			Layer2.at(i) = "P";
		}
	}
	Layer1.push_back("X");
	Layer1.push_back("X");
	string board = "B";
	for (int i = 0; i < 30; i++)
	{
		board += Layer2.at(i);
	}
	board += "E\n";
	for (int i = 0; i < 32; i++)
	{
		board += Layer1.at(i);
	}
	return board;
}
