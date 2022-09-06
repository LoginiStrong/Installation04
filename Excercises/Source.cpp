#include <iostream>
using namespace std;

int main()
{
	int x = 5;
	int y = 10;
	int z = 3;

	if (x < y < z)
	{
		cout << "Sorted" << endl;
	}
	else
		cout << "Not sorted" << endl;
}