#pragma once
#include <vector>
#include "Train.h"

class hashTable
{
private:
	int numberOfEntries;
	int sizeOfTable;
	vector<Train*> table;

public:
	hashTable();
	void rehash();
	void insert(Train* train);
	void print();
	bool find(Train* t);
	void remove(Train* t);
};

ostream& operator << (ostream& out, vector<Train*> tableVec);
