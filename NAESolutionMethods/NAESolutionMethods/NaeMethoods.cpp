#pragma once

#include <iostream>
#include<cmath>
#include"Calculation.h"
using namespace std;

double F(double x)
{
	return pow(x, 3) + 18 * x + 83;
}

double DF(double x)
{
	return pow(3 * x, 2) + 18;
}

double MethodChord(double a, double b, double epsilon)
{
	int iter3 = 0;

	while (abs(b - a) > epsilon)
	{
		a = b - (b - a) * F(b) / (F(b) - F(a));
		b = a - (a - b) * F(a) / (F(a) - F(b));
		iter3 =  CalculationMethodChord(iter3);
	}

	cout << "Кількість ітерацій: " << iter3 << endl;

	return b;
}

double MethodNewton(double x, double eps)
{
	int iter4 = 0;

	cout << "x0= " << x;
	
	do {
		x = x - F(x) / DF(x);
		iter4 = CalculationMethodNewton(iter4);

	} while (abs(F(x)) > eps && iter4 < 100);
	
	cout << "Кількість ітерацій: " << iter4 << endl;
	
	return x;
}

double F2(double x) {
	return x * x - 9 * x + 14;
}

double FindRoot(double(*f)(double), double a, double b, double eps, double c) {
	double x;
	int iter2 = 0;

	while ((b - a) / 2 > eps) {
		x = (a + b) / 2;
		//if ((f(a) * f(c)) < 0);
		//else (b = c);

		iter2 = CalculationHalfDivisionMethod(iter2);

	}

	iter2 = CalculationHalfDivisionMethod(iter2);

	cout << "Кількість ітерацій: " << iter2 << endl;

	return 0;
}

double func(double x)
{
	return pow(x, 3) - 3 * sin(x);

}
