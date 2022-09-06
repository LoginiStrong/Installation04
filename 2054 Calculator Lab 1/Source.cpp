#include <iostream>
using namespace std;

int main()
{
	int x, y;
	char op;
	cout << "Enter a calculation in the form X + Y\n";
	cin >> x >> op >> y;

	switch (op)
	{
	case '+' :
		cout << x + " + " + y + " = " + x+y;
		break;
	case '-' :
		cout << x + " - " + y;
	}
}