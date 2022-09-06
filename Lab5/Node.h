#pragma once
using namespace std;

/*Node declartion class which are defined in its .cpp file.
THe only private members in this class are a node and and integer.
The integer haold the value a node references, while the node is just a reference*/
class Node
{ 
private:
	int value;
	Node* next;

public:
	Node();
	Node(int v, Node* next);
	void setValue(int v);
	int getValue();
	Node* getNext();
	void setNext(Node* theNewNext); 
};