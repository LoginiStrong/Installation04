#include "FlyingTrain.h"

/*FlyingTrain constructor passes in a name and speed through its parameters and sets the 
corresponding member variables equal to them*/
FlyingTrain::FlyingTrain(string tName, int tSpeed)
{
	name = tName;
	speed = tSpeed;
}

/*Travel is a defined abstrat method from Train that calculates the distance traveled
specifically for FlyingTrain since its distance formula is different from other trains*/
void FlyingTrain::Travel(int time)
{
	distance += (speed * speed)*time;
}

//The toString method just prints what train it is, its name, its speed, and distance travelled.
void FlyingTrain::toString()
{
	cout << "Flying Train: " << name << " speed: " << speed << " distance traveled : " << distance << endl;
}