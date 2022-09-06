#include "hashTable.h"

//the hashtable constructor that sizes our vector of trains to 2 by default and sets entires to 0
hashTable::hashTable()
{
	numberOfEntries = 0;
	sizeOfTable = 2;
	table.resize(sizeOfTable);
}

/*reshash is called in insert under certaain coonditions and it puts all of the train*'s from our table into a temporary
vector that we use to put into our new resized table with insert*/
void hashTable::rehash()
{
	vector<Train*> tempVec;
	for (int i = 0; i < table.size(); i++)
	{
		Train* temp = table.at(i);
		Train* next;
		while (temp != NULL)
		{
			tempVec.push_back(temp);
			next = temp->getNext();
			temp->setNext(NULL);//unlinking the lists
			temp = next;
		}
	}
	sizeOfTable = sizeOfTable*2;
	numberOfEntries = 0;
	table.clear();
	table.resize(sizeOfTable);
	for (int i = 0; i < tempVec.size(); i++)
	{
		insert(tempVec.at(i));
	}
}

/*insert uses find to see if the train we are adding is already in the table and then adds it to a index based on hash.
If there is something at that index we make it the next thin in the linked list and set our inserted train as the "head".*/
void hashTable::insert(Train* train)
{
	if (find(train) == false)
	{
		int index = train->hash(sizeOfTable);
		if (table.at(index) == nullptr)
		{
			table.at(index) = train;
			numberOfEntries++;
		}
		else
		{
			train->setNext(table.at(index));
			table.at(index) = train;
			numberOfEntries++;
			
		}
		if (numberOfEntries > (sizeOfTable * 2))//is called if more elements than sizex2 are added
		{
			rehash();
		}
	}
}

/*This is the overloaded cout operator that prints the index we are at in the vector and what is all contained
(the list) at the index.*/
ostream & operator << (ostream & out, vector<Train*> tableVec)
{
	for (int i = 0; i < tableVec.size(); i++)
	{
		out << i << ": ";
		Train* temp = tableVec.at(i);
		while (temp != NULL)
		{
				out << temp << "   ";
				temp = temp->getNext();
		}
		out << endl;
	}
	return out;
}

//print invokes our overloaded << operator on our table
void hashTable::print()
{
	cout << table;
}

/*the find function takes in the train we want to find and loops through our
table and its lists calling accessors on each train seeing if their components are the same.
If we found it we return true, else we return false.*/
bool hashTable::find(Train* t)
{
	for (int i = 0; i < table.size(); i++)
	{
		Train* temp = table.at(i);
		while (temp != NULL)
		{
			if (temp->getName() == t->getName() && temp->getValue() == t->getValue())
			{
				return true;
			}
			else
			{
				temp = temp->getNext();
			}
		}
	}
	return false;
}

/*remove calls find in order to see if the train passed into it is actually located in our table,
if it is we relocate it and perform one of several case statements to remove it. We have to remove it by deleting the train*
and setting either the previous node to point to: another pointer, a null pointer, or make the element at the index null.*/
void hashTable::remove(Train* t)
{
	if (find(t) == true)
	{
		for (int i = 0; i < table.size(); i++)
		{
			Train* temp = table.at(i);
			Train* prev = temp;
			while (temp != NULL)
			{
				if (temp->getName() == t->getName() && temp->getValue() == t->getValue())
				{
					if (temp == table.at(i) && temp->getNext() == NULL)
					{
						delete table.at(i);
						table.at(i) = NULL;
						return;
					}
					else if (temp->getNext() == NULL)
					{
						delete temp;
						temp = NULL;
						prev->setNext(temp);
						return;
					}
					else if (temp == table.at(i))
					{
						table.at(i) = temp->getNext();
						delete temp;
						temp = NULL;
						return;
					}
					else
					{
						prev->setNext(temp->getNext());
						delete temp;
						temp = NULL;
						return;
					}
				}
				else
				{
					prev = temp;
					temp = temp->getNext();
				}
			}
		}
	}
	else
	{
		cout << "Not in the table";
		return;
	}
}