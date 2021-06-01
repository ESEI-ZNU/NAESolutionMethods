#pragma once

#include <iostream>
#include<cmath>
#include"Calculation.h"
using namespace std;

/// A function that helps find the value of an expression 
/// <summary>
/// 
/// double F
/// 
/// </summary>
/// <param name="x">
/// 
/// x - borders
/// 
/// </param>
/// 
/// <returns>
/// 
/// a -  the  result of the equation
/// 
/// 
/// </returns>

double F(double x)
{
	double a = pow(x, 3) + 18 * x + 83;
	return a;
}



/// A function that helps find the value of an expression 
/// <summary>
/// 
///  double DF
/// 
/// </summary>
/// <param name="x">
/// 
/// x - borders
/// 
/// </param>
/// <returns>
/// 
///	a - the  result of the equation
/// 
/// </returns>

double DF(double x)
{
	double a = pow(3 * x, 2) + 18;
	return a;
}

///Realize the chord method
/// <summary>
///		
/// double MethodChord
/// 
/// </summary>
/// <param name="x">
/// 
/// double a - coordinate x0
/// double b - coordinate x1
/// double epsilon - precision
/// 
/// </param>
/// 
/// <returns>
/// 
/// b - the final result of the equation
/// 
/// </returns>

double MethodChord(double a, double b, double epsilon)
{
	int iter3 = 0;

	while (abs(b - a) > epsilon)
	{
		a = b - (b - a) * F(b) / (F(b) - F(a));
		b = a - (a - b) * F(a) / (F(a) - F(b));
		iter3 = CalculationMethodChord(iter3);
	}

	cout << "Number of iterations: " << iter3 << endl;

	return b;
}

///Realize the Newton method
/// <summary>
/// 
/// double MethodNewton
/// 
/// </summary>
/// <param name="x">
/// 
///  x - coordinate origin
/// eps - precision
/// 
/// </param>
/// 
/// <returns>
/// 
///  x - the final result of the equation
/// 
/// </returns>

double MethodNewton(double x, double eps)
{
	int iter4 = 0;

	cout << "x0= ";
	cin >> x;

	do {
		x = x - F(x) / DF(x);
		iter4 = CalculationMethodNewton(iter4);

	} while (abs(F(x)) > eps && iter4 < 100);

	cout << "Number of iterations: " << iter4 << endl;

	return x;
}

///The function called in the Half division method function
/// <summary>
/// 
/// double F2
/// 
/// </summary>
/// <param name="x">
/// 
/// x - coordinate
/// 
/// </param>
/// 
/// <returns>
/// 
/// a - the result of the equation
/// 
/// </returns>

double F2(double x) {
	double a = pow(x, 3) + 18 * x + 83;
	return a;
}


/// A function that helps find the value of an expression in Brute force method:
/// <summary>
/// 
/// double func
/// 
/// </summary>
/// <param name="x">
/// 
/// x - coordinate x
/// 
/// </param>
/// 
/// <returns>
/// 
/// a - returns the specified equation
/// 
/// </returns>

double func(double x)
{
	int a = pow(x, 3) + 18 * x + 83;
	return a;

}

/// A function that helps find the value of an expression in MethodPerebora:
/// <summary>
/// 
/// double MethodPerebora
/// 
/// </summary>
/// <param name="x">
/// 
/// e - precision
/// 
/// a - coordinate a
/// 
/// b - coordinate b
/// 
/// </param>
/// 
/// <returns>
/// 
/// a - returns the specified equation
/// 
/// </returns>
double MethodPerebora(double e,double a,double b) {

	int iter = 0;

	for (double x = a; x <= 5.0; x += e)
	{
		double temp = fabs(F(x));
		if (b > temp)
		{
			iter = CalculationBruteForce(iter);
			b = temp;
			a = x;
		}
		
	}
	cout << "Numbers of iteration: " << iter << endl;
	return a;
}