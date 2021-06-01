#include <iostream>

using namespace std;

double F(double x)
{
	double a = pow(x, 3) + 18 * x + 83;
	return a;
}


double F2(double x) {
	double a = pow(x, 3) + 18 * x + 83;
	return a;
}

double MethodPerebora(double e, double a, double b) {

	int iter = 0;

	for (double x = a; x <= 5.0; x += e)
	{
		double temp = fabs(F(x));

		if (b > temp)
		{
			b = temp;
			a = x;
		}

	}
	cout << "Numbers of iteration: " << iter << endl;
	return a;
}

int main()
{
	int number;
	float c;
	double a = 0, b = 1, x = 0;
	double  e;

TryAgain:cout << "Choose a method:\n1)Brute force method;\n2)Half division method;" << endl;
	cin >> number;

	if (number == 1)
	{
		cout << "___________" << endl;
		cout << "Brute force method:" << endl;
		cout << "___________" << endl;


		cout << "e = ";

		cin >> e;

		cout << "a = ";
		cin >> a;

		cout << "b = ";
		cin >> b;

		cout << "x = " << MethodPerebora(e, a, b);
	}
	else if (number == 2)
	{

		cout << "___________" << endl;
		cout << "Half division method:" << endl;
		cout << "___________" << endl;

		cout << "a = ";
		cin >> a;
		cout << "b = ";
		cin >> b;

		cout << "e = ";
		cin >> e;

		if (F2(a) * F2(b) < 0)
		{
			cout << "The convergence condition is satisfied" << endl;

			while (1)
			{
				x = (a + b) / 2;
				if (fabs(F2(x)) < e)//precision condition
					break;
				if (F2(a) * F2(x) <= 0)
				{
					b = x;
				}
				else
				{
					a = x;
				}

			}
			cout << "Root x = " << x << endl;

		}
		else
		{
			cout << "Convergence condition is not satisfied" << endl;
		}

	}

}

