#include "Tree.h"
#include <iostream>
using namespace std;

//The tree constructor takes in a num and creates the root node of the tree with the value taken in. Adds one to depth for later purposes
Tree::Tree(int num)
{
	root = new Node(num, nullptr, nullptr);
	depth++;
}

//Insert inserts nodes and their values according to BST rules
void Tree::Insert(int num)
{
	int tDepth = 1; //variable for temporary depth so we dont add a depth we already counted
	Node* parent = root;//temp root/parent node
	Node* child = nullptr; //child node we are going to define by BST

	//while loop that adds the node based on BST. Our temp depth is also calculated as we progress the tree
	while (child == nullptr)
	{
		if (num < parent->getValue() && parent->getLeft() == nullptr)
		{
			child = new Node(num, nullptr, nullptr);
			parent->setLeft(child);
			tDepth++;
		}
		else if (num < parent->getValue())
		{
			parent = parent->getLeft();
			tDepth++;
		}
		else if (num > parent->getValue() && parent->getRight() == nullptr)
		{
			child = new Node(num, nullptr, nullptr);
			parent->setRight(child);
			tDepth++;
		}
		else if (num > parent->getValue())
		{
			parent = parent->getRight();
			tDepth++;
		}

		//this if statement makes sure that if we moved to multiple children at the same depth we don't cumulatively add depth
		if (tDepth > depth)
		{
			depth = tDepth;
		}
	}

	//creating the size of our vector of strings for horizontal print
	vec.resize(depth+1);
	for (int i = 0; i < vec.size(); i++)
	{
		vec[i] = "";
	}
}

//Finds a number passed into the parameter, if not found it returns -1
void Tree::Find(int num)
{
	Node* temp = root;

	//progresses the tree by BST until we find the node or reach null
	while (temp != NULL)
	{
		cout << temp->getValue() << " ";
		if (temp->getValue() == num)
		{
			cout << num << endl;
			return;
		}
		else if (num < temp->getValue())
		{
			temp = temp->getLeft();
		}
		else if (num > temp->getValue())
		{
			temp = temp->getRight();
		}
	}
	cout << -1 << endl;
}

//this recursive function prints a built string of dashes with a value marking certain nodes and their depths in the tree. It is also private
void Tree::Print(string builder, Node* node)
{
	if (node == NULL)
	{
		return;
	}

	Print(builder + "--", node->getRight());

	cout << builder << node->getValue() << endl; //prints only after return so it comes out relatively in order

	Print(builder + "--", node->getLeft());
}

//public print method done just so I dont have to make more functions for the main
void Tree::Print()
{
	Print("", root);
}

//public horizontal print that calls the recursive private function and prints out the contents of the vector
void Tree::horizontalP()
{
	horizontalP(root, 1);//1 is our starter depth since we wanna start at the root

	for (int i = 0; i < vec.size(); i++)
	{
		cout << vec[i] << endl;
	}
}

//private horizontal print function
void Tree::horizontalP(Node* node, int recurseDepth)
{
	string blanks;//delcared insid ethe function so it refreshes to a blank string
	for (int i = 0; i < depth; i++)//builds the non-white are based on how deep we are in the tree
	{
		blanks += "     ";
	}

		//As we get deeper the amount of children multiply by 2 and we shift the print over 2 every time leading to this wierd algorithm
		blanks = blanks.substr(0, (blanks.size()) / ((recurseDepth)*2)-2);

		if (recurseDepth <= depth && node != NULL)
		{
			vec[recurseDepth] += (blanks + " " + to_string(node->getValue()) + blanks);//adding our new string to the vector
			recurseDepth++;//getting deeper so we add 1
			horizontalP(node->getLeft(), recurseDepth);
			horizontalP(node->getRight(), recurseDepth);
		}
		else if (node == NULL && recurseDepth <= depth)
		{
			vec.at(recurseDepth) += (blanks + "  " + blanks);
		}
}
