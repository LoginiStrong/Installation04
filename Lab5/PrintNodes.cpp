#include "PrintNodes.h"

/*This function takes in a node and prints the node value
and loops through 4 more times printing each next nodes value.*/
void PrintNodes(Node* node)
{
	int count = 0;
	while (count != 5)
	{
		cout << node->getValue() << " ";
		node = node->getNext();
		count++;
	}
}