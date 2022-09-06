#pragma once
#include "Token.h"
#include "Number.h"

//class declaration for the Operator class, which inherits from the Token parent class.
class Operator : public Token
{
public:
	virtual Number* operate(Number* num1, Number* num2) = 0; //abstract operate class that takes in two Number pointers and returns a Number pointer
};
