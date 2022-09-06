#include "Card.h"
//defines card classes functions

//card constructor that passes in a number and sets the cards value to that number
Card::Card(int num)
{
	value = num;
}

//accessor that returns the value of a card object
int Card::getValue()
{
	return value;
}