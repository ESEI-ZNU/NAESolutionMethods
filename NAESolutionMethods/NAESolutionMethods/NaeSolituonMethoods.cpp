#include <iostream> 
#include<cmath>
#include<cstdlib>
#include <ctime> 
#include"NaeMethoods.h"
#include"Calculation.h"
using namespace std;

/// <summary>
/// The main function
/// </summary>
/// <returns>
/// The code
/// </returns>
int main()
{
	setlocale(LC_ALL, "ru");

	int number,value;
	float c;
	double a = 0, b=1, x = 0, y = 0;
	double x0, x1, e;
	int n;
	int iter = 0;
	double timeInSeconds;

TryAgain:cout << "Choose a method:\n1)Brute force method;\n2)Half division method;\n3)Chord method;\n4)Tangent method;" << endl;
	cin >> number;
	

	if (number == 1)
	{

		clock_t startTime = clock(); 

		cout << "___________" << endl;
		cout << "Brute force method:" << endl;
		cout << "___________" << endl;


		cout << "e = ";

		cin >> e;

		cout << "a = ";
		cin >> a;

		cout << "b = ";
		cin >> b;

		cout << "x = " << MethodPerebora(e,a,b);

		clock_t endTime = clock();
		clock_t clockTicksTaken = endTime - startTime;
		timeInSeconds = clockTicksTaken / (double)CLOCKS_PER_SEC;

		cout << "\nNumber of seconds: " << timeInSeconds << endl;
	}
	else if (number == 2)
	{
		clock_t startTime = clock();

		cout << "___________" << endl;
		cout << "Half division method:" << endl;
		cout << "___________" << endl;
		int iter2 = 0;
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
				iter2 = CalculationHalfDivisionMethod(iter2);
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
		
		clock_t endTime = clock();
		clock_t clockTicksTaken = endTime - startTime;
		timeInSeconds = clockTicksTaken / (double)CLOCKS_PER_SEC;
		cout << "Number of Iteration = " << iter2 << endl;
		cout << "Number of seconds: " << timeInSeconds << endl;
	}
	else if (number == 3)
	{
		clock_t startTime = clock();

		cout << "___________" << endl;
		cout << "Chord method:" << endl;
		cout << "___________" << endl;

		cout << "Enter x0 and x1:" << endl;

		cout << "x0 = ";
		cin >> x0;

		cout << endl << "x1 = ";
		cin >> x1;

		cout << endl << "Enter accuracy e = ";
		cin >> e;

		x = MethodChord(x0, x1, e);
		cout << "x = " << x << endl;
		clock_t endTime = clock();
		clock_t clockTicksTaken = endTime - startTime;
		timeInSeconds = clockTicksTaken / (double)CLOCKS_PER_SEC;

		cout << "Number of seconds: " << timeInSeconds << endl;
	}
	else if (number == 4)
	{
		clock_t startTime = clock();

		cout << "___________" << endl;
		cout << "Tangent method:" << endl;
		cout <<"___________" << endl;

	
		cout << endl << "Enter accuracy e = ";
		cin >> e;

		x = MethodNewton(x, e);
		cout << "x = " << x << endl;
		clock_t endTime = clock();
		clock_t clockTicksTaken = endTime - startTime;
		timeInSeconds = clockTicksTaken / (double)CLOCKS_PER_SEC;

		cout << "Number of seconds: " << timeInSeconds<< endl;
	}
	
	cout << "Please enter:\n1)Proceed;\n2)Complete;" << endl;
	cin >> value;

	if (value == 1)
		goto TryAgain;
	else
		cout << "Program completed";

	return 0;
}