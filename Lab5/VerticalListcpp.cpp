#include "VerticalList.h"

//Definitions for the functions declared in the VerticalList.h

/*Default VerticalList constructor. The fucntion takes the private head and set the value of the 
node it points to at 10. The value contained in each subsequent node is incremented by 1.
A temporary node pointer is made to point add heads node, which is then used to get and create subsequent
nodes and set their new values.*/
VerticalList::VerticalList()
{
	int numValue = 10;
	head = new Node();
	head->setValue(numValue);
	numValue++;
	Node* temp = head;
	for (int i = 0; i < 9; i++)
	{
		while (temp->getNext() != 0)
		{
			temp = temp->getNext();
		}
		temp->setNext(new Node(numValue, 0));
		numValue++;
	}
}

/*The increment function makes a temporary pointer and points it to heads node. It then
gets the value of the node and adds one to that value. We set the new value in that node and get the
next node in the line of nodes and perform the same operaton on it until all values have been added by one.*/
void VerticalList::increment()
{
	Node* myPtr = head;
	for (int i = 0; i < 10; i++)
	{
		int value = myPtr->getValue();
		value++;
		myPtr->setValue(value);
		myPtr = myPtr->getNext();
	}
}

/*This is a copy constructor that takes in another VerticalList by reference.
The function then makes a temporary pointer for both lists. It then sets the temporary pointer
of the list we're calling on equal to the node of the list we're copying.*/
VerticalList::VerticalList(const VerticalList & vc)
{
	int count = 0;
	head = new Node();
	Node* type = head;
	*head = *(vc.head);
	Node* temp = vc.head;
	for (int i = 0; i < 9; i++)
	{
		temp = temp->getNext();
		Node* next = new Node();
		*next = *(temp);
		if (count == 0)
		{
			head->setNext(next);
			count++;
		}
		else
		{
			type = type->getNext();
			type->setNext(next);
		}
	}
}

/*This is the desconstructor that deallocates every ptr that links the list together.
It does this by moving our pointer starting at head, until there are no more nodes to getNext().*/
VerticalList::~VerticalList()
{
	Node* ptr;
	for (ptr = head; head; ptr = head)
	{
		head = head->getNext();
		delete ptr;
	}
}

/*The equals operator overload takes in a VerticalList we wont to set our courrent (this) VerticalList
equal to. If the memory addresses are not the same it does the same thing our copy constructor.*/
const VerticalList& VerticalList::operator=(const VerticalList& rhs)
{
	int count = 0;
	if (this != &rhs)
	{
		head = new Node();
		Node* type = head;
		*head = *(rhs.head);
		Node* temp = rhs.head;
		for (int i = 0; i < 9; i++)
		{
			temp = temp->getNext();
			Node* next = new Node();
			*next = *(temp);
			if (count == 0)
			{
				head->setNext(next);
				count++;
			}
			else
			{
				type = type->getNext();
				type->setNext(next);
			}
		}
	}
	return *this;
}

//Prints all nodes values untill there are no more nodes to access.
void VerticalList::print()
{
	Node* myPtr = head;
	while (myPtr != 0) 
	{ 
		cout << myPtr->getValue() << " ";
		myPtr = myPtr->getNext(); 
	}
	cout << endl;
}