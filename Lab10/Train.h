#ifndef TRAIN_H
#define TRAIN_H

#include <string>
#include <iostream>
using namespace std;

class Train
{
private:
	Train* next;//is the next node in the linked list

	//I made these private since they were public (bad practice)
	string trainName;
	int trainNumber;
public:
	
	Train(string name_in, int number_in);
	unsigned int hash(int tablesize);
	void setNext(Train* nextT);//mutator
	Train* getNext();//accessor
	string getName();//accessors for good practice
	int getValue();
};




ostream & operator << (ostream & out, Train * t);

#endif