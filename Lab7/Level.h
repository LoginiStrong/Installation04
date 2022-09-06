#pragma once
#include <string>
using namespace std;
class Level
{
private://private data members
	int aNum;//number of arrays for 3d array
	int rows;//number of rows for each array
	int columns;//number of columns for each array
	string mapName;//name of the map taken in
	int*** lArray;//The beginning of the 3d array
	int zStart;//z's starting location
	int xStart;//x's starting location
	int yStart;//y's starting location

//public functions that are described in there .cpp definitions
public:
	Level(string name, int num1, int num2, int num3);
	void setData(int num1, int num2, int num3, int data);
	int getANum();
	int getRows();
	int getColumns();
	int getData(int num1, int num2, int num3);
	string getName();
	void setStart(int z, int x, int y);
	int getZStart();
	int getXStart();
	int getYStart();
};
