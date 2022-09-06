#include "Train.h"

Train::Train(string name_in, int number_in)
{
	trainNumber = number_in;
	trainName = name_in;
}

unsigned int Train::hash(int tablesize)
{
	unsigned int value = trainNumber;
	for (int i = 0; i<trainName.size(); i++)
	{
		value += (trainNumber + 11) * value + trainName[i];
	}
	return value % tablesize;
}

//sets the next node in the linked list
void Train::setNext(Train* nextT)
{
	next = nextT;
}

//gets the next node in the linked list
Train* Train::getNext()
{
	return next;
}


string Train::getName()
{
	return trainName;
}

int Train::getValue()
{
	return trainNumber;
}

ostream & operator << (ostream & out, Train * t)
{
	if (t != NULL)
	{
		out << t->getName() << " " << t->getValue();
	}
	return out;
}

