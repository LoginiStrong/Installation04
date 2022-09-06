#include "Node.h"
#include "Tree.h"
#include <iostream>
using namespace std;

int main()
{
	Tree tree = Tree(8);
	tree.Insert(4);
	tree.Insert(2);
	tree.Insert(1);
	tree.Insert(6);
	tree.Insert(12);
	tree.Insert(10);
	tree.Insert(9);
	tree.Insert(11);
	tree.Insert(14);
	tree.Find(12);
	tree.Print();
	tree.horizontalP();

}