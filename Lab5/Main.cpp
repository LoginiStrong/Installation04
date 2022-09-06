#include "Node.h"
#include "VerticalList.h"
#include "PrintNodes.h"
#include <iostream>

int main()
{
//Creating five nodes with their own seperate values
	Node* n1 = new Node(-5, 0);
	Node* n2 = new Node(5, 0);
	Node * n3 = new Node(15, 0);
	Node * n4 = new Node(25, 0);
	Node* n5 = new Node(35, 0);

//Setting each new node as the previous nodes next one
	n1->setNext(n2);
	n2->setNext(n3);
	n3->setNext(n4);
	n4->setNext(n5);

//Prints all the nodes values
	PrintNodes(n1);
	cout << endl;

//Makes a default list1, prints it and then increments it
	VerticalList list1;
	cout << "//original list\n";
	list1.print();
	list1.increment();
	cout << endl;

//Prints out the incremented list
	cout << "//after first increment\n";
	list1.print();
	cout << endl;

/*Uses the copy constructor to make a list2and copy list1 contents into it.
list1 is incremented again and both lists are printed*/
	VerticalList list2 = VerticalList(list1);
	list1.increment();
	cout << "//printing both lists\n";
	list1.print();
	list2.print();
	cout << endl;

/*Creates a list3 and then we use our overloaded equal operator to
set list3 equal to list1. List3 is incremented and we print each list out.*/
	VerticalList list3;
	list3 = list1;
	cout << "//printing all three lists first time\n";
	list3.increment();
	list1.print();
	list2.print();
	list3.print();
	cout << endl;

//Increment all lists and print them out
	cout << "//printing all three lists second time\n";
	list1.increment();
	list2.increment();
	list3.increment();
	list1.print();
	list2.print();
	list3.print();
}
