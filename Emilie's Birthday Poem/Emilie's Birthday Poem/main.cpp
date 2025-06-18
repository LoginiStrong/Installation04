#include <iostream>
#include <fstream>
#include <cmath>
using namespace std;

int main()
{
	ofstream MyFile("Emilie's Birthday Poem.txt");

	MyFile << "Every day I am in disbelief of the gift you are to me\n";
	MyFile << "Music with you is more than sounds, it's a place\n";
	MyFile << "Imperfections are what make us perfect for one another\n";
	MyFile << "Love is what I find in every little thing about you\n";
	MyFile << "Inspiration and purpose are what you breathe into me\n";
	MyFile << "Even in the darkest of depths I find myself in, you are the light of my life\n";
	MyFile << "\t\tI love you with all my heart,\n\t\t\tYour Logan\n\n";

    int size = 10; // Adjust for size of the heart
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j <= 4 * size; ++j) {
            double d1 = sqrt(pow(i - size, 2) + pow(j - size, 2));
            double d2 = sqrt(pow(i - size, 2) + pow(j - 3 * size, 2));

            if (d1 < size + 0.5 || d2 < size + 0.5) {
                MyFile << "*";
            }
            else {
                MyFile << " ";
            }
        }
        MyFile << endl;
    }
    for (int i = 1; i < 2 * size; ++i) {
        for (int j = 0; j < i; ++j) {
            MyFile << " ";
        }
        for (int j = 0; j < 4 * size + 1 - 2 * i; ++j) {
            MyFile << "*";
        }
        MyFile << endl;
    }
    return 0;
}