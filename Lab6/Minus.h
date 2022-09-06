#pragma once
#include "Operator.h"

//inherits from Operator
class Minus : public Operator
{
public:
	Number* operate(Number* num1, Number* num2);
	string toString();
};