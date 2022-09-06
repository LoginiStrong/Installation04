#include "Minus.h"

/*defines the abstract operate class that was inherited. It takes in
the two Number pointers and gets the numbers they contain with the
getNumber() function and subtracting num2 from num1.
Finally, we set the second number pointers number to the sum with the setNumber() function
and returning it*/
Number* Minus::operate(Number* num1, Number* num2)
{
	int difference = (num1->getNumber() - num2->getNumber());
	num2->setNumber(difference);
	return num2;
}

//prints out a - if it is called on a Minus object
string Minus::toString()
{
	return "-";
}