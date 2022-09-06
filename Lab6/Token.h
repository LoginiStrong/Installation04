#pragma once
#include <string>
using namespace std;

//The total parent class of all other classes in this project. It has an abstract toString method
class Token
{
public:
	virtual string toString() = 0;
};