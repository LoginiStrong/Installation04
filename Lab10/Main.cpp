using namespace std;
#include "Train.h"
#include "hashTable.h"

int main()
{
	Train* t1 = new Train("4-4-2", 343);
	Train* t2 = new Train("2-8-0", 344);
	Train* t3 = new Train("4-0-4", 345);
	Train* t4 = new Train("2-8-0", 1);
	Train* t5 = new Train("2-8-0", 2);
	Train* t6 = new Train("2-8-0", 3);
	Train* t7 = new Train("12-0-0", 42);
	Train* t8 = new Train("12-0-12", 84);
	Train* t9 = new Train("2-2", 2);
	Train* t10 = new Train("4-4", 4);
	hashTable table = hashTable();
	table.print();
	table.insert(t1);
	table.insert(t2);
	table.insert(t3);
	table.print();
	table.insert(t1);
	table.insert(t2);
	table.insert(t3);
	table.print();
	table.insert(t4);
	table.insert(t5);
	table.insert(t6);
	table.insert(t7);
	table.insert(t8);
	table.insert(t9);
	table.insert(t10);
	table.print();
	table.remove(t1);
	table.remove(t2);
	table.remove(t3);
	table.print();
}