#include <iostream>
#include <fstream> 
#include <string>
#include <vector>
#include <tuple>
#include <algorithm>

using namespace std;

int main()
{
    vector<tuple<char, char>>  tuples;
    ifstream inputFile("coding_qual_input.txt");
    // Check if the file is successfully opened 
    if (!inputFile.is_open()) {
        cerr << "Error opening the file!" << endl;
        return 1;
    }

   string mystring; 

    cout << "File Content: " << endl;
    //cout << inputFile.get();
   while (inputFile) {
       inputFile >> mystring;
       cout << mystring;
       //tuples.push_back(make_tuple(inputFile.get(), (inputFile.get())));
    }

    //while (getline(inputFile, line)) {
    //    cout << line << endl; // Print the current line 
    //}

    //sort(tuples.begin(), tuples.end());

    for (int i = 0; i < tuples.size(); i++)
    {
        //cout << get<0>(tuples[i]) << "  " << get<1>(tuples[i]) << endl;
    }

    inputFile.close();

}