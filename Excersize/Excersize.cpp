#include <iostream>
#include <vector>
#include <exception>
using namespace std;

bool w(vector<int> y)
{
	int z = 0;
	for (int i = 0; i < y.size(); i++)
		z += y.at(i);
	if (z > 20)
		return false;
	return true;
}
void f(int* r, bool a)
{
	if (*r == 14 && a)
		*r = 11;
	else if (*r == 14 && !a)
		*r = 1;
	else if (*r > 10)
		*r = 10;
}
int main()
{
	int seed;
	cout << "Please enter a random integer for the seed ";
	cin >> seed;
	srand(seed);
	char n, c;
	do {
		vector <int> x;
		int p = 0;
		int* h = &p;
		p = rand() % 14 + 1;
		f(h, true);
		x.push_back(p);
		int t = 0;
		do {
			p = rand() % 14 + 1;
			if (t <= 10)
				f(h, true);
			else
				f(h, false);
			x.push_back(p);
			cout << "you have " << endl;
			t = 0;
			for (int i = 0; i < x.size(); i++) {
				t += x.at(i);
				cout << x.at(i) << " ";
			}
			cout << endl;
			if (w(x)) {
				cout << "Another?" << endl;
				cin >> c;
			}
		} while (w(x) && c == 'y');
		int o = rand() % 20;
		if (w(x) && o < t)
			cout << "You win! :)" << endl;
		else if (w(x) && o > t) {
			cout << "You got beat :(" << endl;
			cout << "Other person had " << o << endl;
		}
		else if (w(x) && o == t)
			cout << "You tied :/" << endl;
		else
			cout << "You lose. :(" << endl;
		cout << "again? y or n" << endl;
		cin >> n;
	} while (n == 'y');
	cin.ignore(1);
	return 0;
}
