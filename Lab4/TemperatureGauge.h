#pragma once
using namespace std;

//functions defined later, temperature is the only member variable
class TemperatureGauge
{
public:
	TemperatureGauge();
	TemperatureGauge(double startTemp);
	double getTempF();
	double getTempC();
	double setTempF(double inputTemp);
private:
	double temperature;
};
