#pragma once
#include "Node.h"
#include <string>
#include <vector>
using namespace std;
class Tree
{
private:
	Node* root;
	int depth = 0;
	void Print(string builder, Node* node);
	vector<string> vec;

	void horizontalP(Node* node, int recurseDepth);
public:
	Tree(int num);
	void Insert(int num);
	void Find(int num);
	void Print();
	void horizontalP();
};
