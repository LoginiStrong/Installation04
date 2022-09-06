#pragma once
#include "Node.h"
#include <iostream>
using namespace std;

/*Declaration of the VerticalList class that his defined in its .cpp file.
The only private member is the node pointer head*/
class VerticalList
{
private:
	Node* head;

public:
	VerticalList();
	void increment();
	VerticalList(const VerticalList& vc);
	~VerticalList();
	const VerticalList& operator=(const VerticalList& rhs);
	void print();
};