#pragma once
#include "Number.h"

/*Number constructor that converts a string passed into its parameter to an integer
* and sets it as the value the number holds.*/
Number::Number(string num)
{
	value = stoi(num);
}

/*toString function that was inherited from the Token parent class that was abstract
and is defined in this function. This function converts the value the number holds into
a string and returns it.*/
string Number::toString()
{
	string svalue = to_string(value);
	return svalue;
}

//this function returns
int Number::getNumber()
{
	return value;
}

void Number::setNumber(int num)
{
	value = num;
}