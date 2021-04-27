#include <iostream>
#include<cmath>

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
	while (abs(b - a) > epsilon)
	{
		a = b - (b - a) * F(b) / (F(b) - F(a));
		b = a - (a - b) * F(a) / (F(a) - F(b));
	}

	return b;
}

double MethodNewton(double x, double eps)
{
	int iter = 0;
	cout << "x0= " << x;
	do {
		x = x - F(x) / DF(x);
		iter++;
	} while (abs(F(x)) > eps && iter < 100);
	cout << endl << "Iteration(s) : " << iter << endl;
	return x;
}
