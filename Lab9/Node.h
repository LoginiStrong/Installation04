#pragma once

class Node
{
private:
	int value;
	Node* left;
	Node* right;

public:
	Node(int val, Node* l, Node* r);
	int getValue();
	Node* getLeft();
	Node* getRight();
	void setLeft(Node* l);
	void setRight(Node* r);
};
