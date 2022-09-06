/*member variables for the ducks name and height
the methods are explained in the cpp*/
#pragma once
#include <string>
#include <iostream>
using namespace std;
class Duck
{
private:
	string duckName;
	int duckHeight;
public:
	Duck(string name, int height);
	string getName();
	int getHeight();
	void addHeight();
	
};