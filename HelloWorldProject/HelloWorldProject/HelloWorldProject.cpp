#include <iostream>
using namespace std;

int main()
{
	int x, y;
	cout << "Enter two numbers seperated by a space and press enter\n";
	cout << ": ";
	cin >> x >> y;
	if (x == y)
	{
		cout << "x equals y!\n";
	}

/*the error located here was that this if statement was if (x = y) ...
the problem with this is it replaces the value that x holds to the value that y holds
rather than comparing x's value to y's. if (x == y)*/
	if (x == y)
	{
		cout << "x is y!\n";
	}
	if (x == y)
	{
		cout << "x is still y!\n";
	}
}