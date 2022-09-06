#include "Node.h"

Node::Node(int val, Node* l, Node* r)
{
	value = val;
	left = l;
	right = r;
}

int Node::getValue()
{
	return value;
}

Node* Node::getLeft()
{
	return left;
}

Node* Node::getRight()
{
	return right;
}

void Node::setLeft(Node * l)
{
	left = l;
}

void Node::setRight(Node* r)
{
	right = r;
}