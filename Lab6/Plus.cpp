#include "Plus.h"

/*defines the abstract operate class that was inherited. It takes in 
the two Number pointers and gets the numbers they contain with the
getNumber() function and adding both of those numbers together.
Finally, we set the second number pointers number to the sum with the setNumber() function
and returning it*/
Number* Plus::operate(Number* num1, Number* num2)
{
	int sum = (num1->getNumber()+num2->getNumber());
	num2->setNumber(sum);
	return num2;
}

//prints out a + if it is called on a Plus object
string Plus::toString()
{
	return "+";
}