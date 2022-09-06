#pragma once
#include <vector>
#include <iostream>
using namespace std;

/*Train is the parent class of both train types. It is an abstract class and contains 2 abstract methods.
one is a toString() ("print function") and the other is a travel function since both child classes will
need it but they both calculate distance differently.*/
class Train
{
public:
	virtual void toString() = 0;
	virtual void Travel(int time) = 0;
};