#include "Minus.h"
#include "Plus.h"
#include "Number.h"
#include <vector>
#include <iostream>

int main()
{
	int count = 0;//variable used to see if the vector should hold a number (count == 0) or operator (count == 1)
	bool check = true;//variable used to see if a correctly ordered vector was created

	vector<Token*> s;//vector of Token pointers

	//prompting and gathering a users input for calculation as a string
	cout << "Enter a list of tokens, terminate by entering ;\n>>";
	string input;
	cin >> input;

	//loop continues untill a ; is found in the string
	while (input != ";")
	{

//series of if and else if statements that push back and object of the corresponding type entered into our vector.
			if (input == "+")
			{
				Plus* newOp = new Plus();
				s.push_back(newOp);
			}
			else if (input == "-")
			{
				Minus* newOp = new Minus();
				s.push_back(newOp);
			}
			else if (input != "+" && input != "-")
			{
				Number* num = new Number(input);
				s.push_back(num);
			}
			cin >> input;
	}

	//for loop that checks if the correct object type is in its correct order if not check is false
		for (int i = 0; i < s.size(); i += 2)
		{
			if (typeid(*(s.at(i))).name() != typeid(Number).name())
			{
				check = false;
			}
			if (i + 2 == s.size())
			{
				if (typeid(*(s.at(i + 1))).name() != typeid(Operator).name())
				{
					check = false;
				}
			}
		}
	//if the size of the vector is not 3 we make check false
	if (s.size() == 1 || s.size() == 2)
	{
		check = false;
	}

	//We call our to string function on every element in the vector
	for (int i = 0; i < s.size(); i++)
	{
		cout << s.at(i)->toString();
		cout << " ";
	}
	cout << endl;

	//if check is false so is the expression and we do not perform operations on the sequence
	if (check == false)
	{
		cout << "Not a valid expression";
	}

	/*else we typecast the elements to their corresponding typesand call our operate
	method on our operator pointer  with the corresponding number pointers.*/
	else
	{
		for (int i = 0; i < (s.size()-1); i = i+2)
		{
			Operator* op = (Operator*)(s[i+1]);
			Number* num1 = (Number*)(s[i]);
			Number* num2 = (Number*)(s[i+2]);
			op->operate(num1, num2);
		}

	//we get the element at the end of the vector and print it since it is our answer now
		int length = s.size();
		length--;
		cout << "Answer is " << (s.at(length))->toString();
	}
	
	//we delete all the elements (pointers) contained inside our vector
	for (int i = 0; i < s.size(); i++)
	{
		delete s[i]; 
	}
}

