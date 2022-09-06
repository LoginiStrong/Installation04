/*member variable/object is the vector of ducks
the methods are explained in the cpp*/
#pragma once
#include <vector>
#include "Duck.h"
#include <string>
using namespace std;

class Pond
{
private:
	vector<Duck> ducks;
public:
	Pond();
	void addDuck(string name, int heigth);
	void printPond();
	void flyDuck(string name);
};