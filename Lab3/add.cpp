#include <vector>
#include <iostream>
using namespace std;

//the sum variable is used to put the sum of two other variables into it, as well as set both variables values to sums new value
int sum = 0;

//arguments taken in are two dereferenced pointer values that are then added together and replaced with the new sum
void add(int* & first, int* & second)
{
	sum = *first + *second;
	*first = sum;
	*second = sum;
}