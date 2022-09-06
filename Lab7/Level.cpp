#include "Level.h"

/*Constructs (stores) a level by taking in the levels name
and the size of the 3d array it will be stored in. A 3d array is
then created with the dimensions taking from the arguement. The name
and dimensions are stored in our corresponding private members.*/
Level::Level(string name, int num1, int num2, int num3)
{
	mapName = name;
	aNum = num1;
	columns = num2;
	rows= num3;

	lArray = new int** [num1];
	for (int i = 0; i < num1; i++)
	{
		lArray[i] = new int* [num3];
		for (int j = 0; j < num3; j++)
		{
				lArray[i][j] = new int[num2];
		}
	}	
}

//sets the element at the given index to the data we want to input
void Level::setData(int num1, int num2, int num3, int data)
{
	lArray[num1][num2][num3] = data;
}

//accessor that returns the number of arrays
int Level::getANum()
{
	return aNum;
}

//accessor that returns the number of rows
int Level::getRows()
{
	return rows;
}

//accessor that returns the number of columns
int Level::getColumns()
{
	return columns;
}

//returns the data at a certain array index
int Level::getData(int num1, int num2, int num3)
{
	return lArray[num1][num2][num3];
}

//accessor that returns the name of the level
string Level::getName()
{
	return mapName;
}

//sets the starting locations
void Level::setStart(int z, int x, int y)
{
	zStart = z;
	xStart = x;
	yStart = y;
}

//accessor that returns z's starting location
int Level::getZStart()
{
	return zStart;
}

//accessor that returns x's starting location
int Level::getXStart()
{
	return xStart;
}

//accessor that returns y's starting location
int Level::getYStart()
{
	return yStart;
}