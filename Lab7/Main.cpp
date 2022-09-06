#include <vector>
#include <string>
#include <iostream>
#include <fstream>
#include <map>
#include "Level.h"
using namespace std;

//map of pair string and level that we will map levels and their names with
map<string, Level*> levelMap;

//function that reads a file entered and stroes its contents in a level
Level* readLevel(string fileName)
{
	/*Below are variables that we pass into our level
	constructor and our setStart functions, as well as
	the amount of times (for loops) we set data into each part of our array*/
	string name;
	int aSize;
	int rSize;
	int cSize;
	int zStart;
	int xStart;
	int yStart;

	//input file stream to read data into our levels from a desired file
	ifstream inFile;
	inFile.open(fileName);

	inFile >> name;
	inFile >> aSize;
	inFile >> cSize;
	inFile >> rSize;
	Level* lev = new Level(name, aSize, cSize, rSize);//constructor

	for (int i = 0; i < aSize; i++)
	{
		for (int j = 0; j < rSize; j++)
		{
			for (int k = 0; k < cSize; k++)
			{
				int data;
			/*variable that holds the elementsa nd is
			used in our later function to set an element
			in our array as this piece of data*/
				inFile >> data;
				lev->setData(i, j, k, data);
			}
		}
	}
	inFile >> zStart;
	inFile >> yStart;
	inFile >> xStart;
	lev->setStart(zStart, yStart, xStart);
	inFile.close();
	//our map which we use to map the file name to the level
	levelMap[fileName] = lev;
	return lev;
}

//this function outputs the contents of a level to a new file
void writeLevel(string oFile, Level* level)//passes in new file name to output our level arguement into
{
	//output file stream since we are writing to a file
	ofstream outFile;
	outFile.open(oFile, ios::out | ios::ate);//ate since we aren't appending

	//using accessors to get the sizes of each dimension of the levels array and the names
	int aSize = level->getANum();
	int rSize = level->getRows();
	int cSize = level->getColumns();

	//writing the name and sizes out to our new file
	outFile << level->getName() << endl << endl;//all endl are for formatting
	outFile << aSize << endl;
	outFile << cSize << endl;
	outFile << rSize << endl << endl << endl;

	//using for loops to write the data at each array index to the file in the same order
	for (int i = 0; i < aSize; i++)
	{
		for (int j = 0; j < rSize; j++)
		{
			for (int k = 0; k < cSize; k++)
			{
				outFile << level->getData(i, j, k) << " ";
			}
			outFile << endl;
		}
		outFile << endl;
	}

	//writes the starting locations to the new file
	outFile << level->getZStart() << " ";
	outFile << level->getXStart() << " ";
	outFile << level->getYStart() << " ";
	outFile.close();
}

int main()
{
	//vector of strings that hold the file names
	vector<string> fName = { "level1.txt", "level2.txt", "level3.txt" };
	ifstream inFile;//inout file stream for part I
	for (int i = 0; i < 3; i++)
	{
		/*Part I of the lab where we open a file with an inout stream
		and read each files name into a variable and print it out*/
		string name;
		inFile.open(fName[i]);
		inFile >> name;
		inFile.close();
		cout << name << endl;
		
		//reading (storing) the file contents by their names that are in our vector
		readLevel(fName[i]);
		
	}
	//an iterator that iterates through a map of string and Level*'s
	map<string, Level*>::const_iterator itr;

	//variable used purely for if statements so the output file names are correct
	int check = 0;

	/*for loop that uses an iterator to iterate through our maps contents and writes them
	to their new corresponding output file.*/
	for (itr = levelMap.begin(); itr != levelMap.end(); itr++)
	{
		pair<string, Level*> p = *itr;//temp pair so we can use .second on it to get the Level* since it is a pair
		if (check == 0)
		{
			writeLevel("level1.txt_OUT", p.second);
		}
		else if (check == 1)
		{
			writeLevel("level2.txt_OUT", p.second);
		}
		else if (check == 2)
		{
			writeLevel("level3.txt_OUT", p.second);
		}
		check++;
	}
	readLevel("level1.txt_OUT");//verifying the our output is readable
}