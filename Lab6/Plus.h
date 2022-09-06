#pragma once
#include "Operator.h"

//inherits from Operator
class Plus : public Operator
{
public:
	Number* operate(Number* num1, Number* num2);
	string toString();
};
