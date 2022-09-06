#include "ElectricTrain.h"

/*ElectricTrain constructor passes in a name and speed through its parameters and sets the
corresponding member variables equal to them*/
ElectricTrain::ElectricTrain(string tName, int tSpeed)
{
	name = tName;
	speed = tSpeed;
}

/*Travel is a defined abstrat method from Train that calculates the distance traveled
specifically for ElectricTrain since its distance formula is different from other trains*/
void ElectricTrain::Travel(int time)
{
	distance = (speed * time);
}

//The toString method just prints what train it is, its name, its speed, and distance travelled.
void ElectricTrain::toString()
{
	cout << "Electric Train: " << name << " speed: " << speed << " distance traveled : " << distance << endl;
}