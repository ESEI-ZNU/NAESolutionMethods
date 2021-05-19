#pragma once

#include <iostream>
#include "Calculation.h"

int iter = 0;

int iter2 = 0;

int iter3 = 0;

int iter4 = 0;

double timeInSeconds;

int CalculationBruteForce(int& iter)
{
	++iter;
	return iter;
}

int CalculationHalfDivisionMethod(int& iter2)
{
	++iter2;
	return iter2;;
}

int CalculationMethodChord(int& iter3)
{
	++iter3;
	return iter3;
}

int CalculationMethodNewton(int& iter4)
{
	++iter4;
	return iter4;;
}


