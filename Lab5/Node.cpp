#include "Node.h"

//Definition file of the node class.

//Default constructor for a node that sets both members to 0
Node::Node()
{
	value = 0;
	next = 0;
}

//Constructor for node that takes in a value that the node will reference and if the next node is null
Node::Node(int v, Node *next)
{
	value = v;
	this->next = next;
}

//Function that sets the value of the current node to the value that is passed in
void Node::setValue(int v)
{
	value = v;
}

//Function that returns the value of the node it's called on
int Node::getValue()
{
	return value;
}

//Function that returns the node after the node this fucntion is called on
Node* Node::getNext()
{
	return next;
}

//Function that sets a node as the next node of the node this is called on
void Node::setNext(Node* theNewNext)
{
	next = theNewNext;
}