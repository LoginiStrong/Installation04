#include "TemperatureGauge.h"
using namespace std;

//default constructor
TemperatureGauge::TemperatureGauge()
{
	temperature = 0;
}

//constructor for user inout
TemperatureGauge::TemperatureGauge(double startTemp)
{
	setTempF(startTemp);
}

//returns temperature in F
double TemperatureGauge::getTempF()
{
	return temperature;
}

//returns temperature in C
double TemperatureGauge::getTempC()
{
	double formula = 5.0 / 9.0;
	double difference = temperature - 32.0;
	return difference * formula;
}

/*takes in a temp from the user, checks it, and
then sets the new temperature in F*/
double TemperatureGauge::setTempF(double inputTemp)
{
	temperature = inputTemp;
	if (temperature <= -30.0)
	{
		temperature = -30.0;
	}
	else if (temperature >= 180.0)
	{
		temperature = 180.0;
	}
	return temperature;
}

