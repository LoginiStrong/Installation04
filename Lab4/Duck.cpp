#include "Duck.h"
#include "iostream"
using namespace std;

/*constructs a duck by taking in a nameand height and uses
its member variables to replace their values*/
Duck::Duck(string name, int height)
{
	duckName = name;
	duckHeight = height;
}

//gets the ducks name
string Duck::getName()
{
	return duckName;
} 

//gets the ducks height
int Duck::getHeight()
{
	return duckHeight;
}

//adds one to the ducks height
void Duck::addHeight()
{
	duckHeight++;
}
