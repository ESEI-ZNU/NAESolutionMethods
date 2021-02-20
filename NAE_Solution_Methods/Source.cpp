#include <iostream>
#include<cmath>

using namespace std;

double f(double x) 
{
	return pow(x, 3) + 18 * x + 83;
}

double df(double x) 
{
	return pow(3 * x, 2) + 18;
}

double method_chord(double x_prev, double x_curr, double e)
{
	double x_next = 0;
	double tmp;

	do
	{
		tmp = x_next;
		x_next = x_curr - f(x_curr) * (x_prev - x_curr) / (f(x_prev) - f(x_curr));
		x_prev = x_curr;
		x_curr = tmp;
	} while (abs(x_next - x_curr) > e);

	return x_next;
}

double method_newton(double x, double eps)
{
	int iter = 0;
	cout << "x0= " << x;
	do {
		x = x - f(x) / df(x);
		iter++;
	} while (abs(f(x)) > eps && iter < 100);
	cout << endl << "Iteration(s) : " << iter << endl;
	return x;
}

void select_methods(double &x) {
	double x0, x1, e;

	cout << "Select method for counting(enter number 1 - 6): " << endl;
	cout << "1 - Chord method" << endl;
	cout << "2 - Newton method" << endl;

	int methodNum;
tryAgain: cin >> methodNum;

	switch (methodNum) {
	case 1:
		cout << "You've selected chord method" << endl;
		cout << "Enter x0 and x1:" << endl; 

		cout << "x0 = ";
		cin >> x0;

		cout << endl << "x1 = ";
		cin >> x1;

		cout << endl << "Enter accuracy e = "; 
		cin >> e;

		x = method_chord(x0, x1, e);
		cout << "x = " << x << endl;
		break;
	case 2:
		cout << "You've selected Newton method" << endl;

		cout << endl << "Enter accuracy e = ";
		cin >> e;

		x = method_newton(x, e);
		cout << "x = " << x << endl;
		break;
	default:
		cout << "You've entered wrong number, you should enter numbers from 1 to 6, try again" << endl;
		goto tryAgain;
	}
}

int main() 
{
	double x;

	cout << "Enter value for f(x):\nx = ";
	cin >> x;

	select_methods(x);

	return 0;
}