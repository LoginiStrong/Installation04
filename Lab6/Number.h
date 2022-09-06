#pragma once
#include "Token.h"

//class declarations for the Number class, which inherits from the Token parent class.
class Number : public Token
{
private:
	int value;//has a private member variable which holds the value for a number;

public:
	string toString();
	Number(string num);
	int getNumber();
	void setNumber(int num);
};