#pragma once
#include "Train.h"

/*FlyingTrain inherits from Train and defines its functions as well as provide its own
constructor. It has three private member variables such as speed, distance, and name.*/
class FlyingTrain : public Train
{
public:
	FlyingTrain(string tName, int tSpeed);
	void Travel(int time);
	void toString();
private:
	int speed;
	int distance = 0;
	string name;
};
