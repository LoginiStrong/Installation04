#include "iostream"
#include "Pond.h"
using namespace std;

/*this method takes in the name of the duck the user wants to fly
and checks if it is in the vector. If it is it call addHeight*/
void Pond::flyDuck(string userName)
{
	for (int i = 0; i < ducks.size(); i++)
		if (userName == ducks[i].getName())
		{
			ducks[i].addHeight();
		}
}

//default constructor for pond
Pond::Pond()
{

}

/*this method adds a duck to the vector of ducks. It takes in
the name and height of the duck and constructs it, as well as push
it into the array*/
void Pond::addDuck(string name, int height)
{
	Duck newDuck = Duck(name, height);
	ducks.push_back(newDuck);
}

/*This method prints out all the ducks with their heights out of the vector
of ducks. This is done by calling getName and getHeight on each duck in the vector*/
void Pond::printPond()
{
	for (int i = 0; i < ducks.size(); i++)
	{
		cout << "name: " << ducks[i].getName() << " at height " << ducks[i].getHeight() << endl;
	}
}