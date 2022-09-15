#include "GetBoard.h"
#include <vector>
#include <iostream>
#include <string>
using namespace std;

void moveFunction(char move, int& Pos)
{
	if (move == 'a')
	{
		Pos--;
	}
	else if (move == 'd')
	{
		Pos++;
	}
	else if (move == 'f')
	{
		Pos+=2;
	}
}