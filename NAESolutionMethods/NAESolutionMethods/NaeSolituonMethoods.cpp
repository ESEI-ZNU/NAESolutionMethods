#include <iostream>
#include<cmath>
#include<cstdlib>
#include <ctime>
#include"NaeMethoods.h"
#include"Calculation.h"
using namespace std;

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


TryAgain:cout << "Оберiть рiвняння:\n1)Методом перебору;\n2)Методом половинного дiлення;\n3)Методом хорд;\n4)Методом дотичних;" << endl;
	cin >> number;
	

	if (number == 1)
	{
		cout << "___________" << endl;
		cout << "Методом перебору:" << endl;
		cout << "___________" << endl;

		clock_t startTime = clock();

		cout << "n = ";

		cin >> n;

		y = func(a);

		for (int i = 1; i <= n; i++)

		{

			x = a + i * (b - a) / (n + 1);

			if (func(x) < y)

				y = func(x);

			iter = CalculationBruteForce(iter);
		}

		iter = CalculationBruteForce(iter);

		cout << "Кількість ітерацій: " << iter << endl;


		cout << "e = " << (b - a) / (n + 1) << endl;

		cout << "x = " << x << endl;

		cout << "y = " << y << endl;

		clock_t endTime = clock();
		clock_t clockTicksTaken = endTime - startTime;
		timeInSeconds = clockTicksTaken / (double)CLOCKS_PER_SEC;

		cout << "Кількість секунд: " << timeInSeconds << endl;
	}
	else if (number == 2)
	{
		clock_t startTime = clock();

		cout << "___________" << endl;
		cout << "Методом половинного дiлення:" << endl;
		cout << "___________" << endl;

		cout << "interval= "; cin >> x;
		cout << "a ="; cin >> a;
		cout << "b ="; cin >> b;
		cout << "c ="; cin >> c;

		//Поиск решения:
		x = FindRoot(F2, a, b, x, c);
		cout << "x = " << (a + b) / 2 << endl;
		if (b = c)
			cout << true << endl;
		else (a = c);
		cout << false << endl;
		clock_t endTime = clock();
		clock_t clockTicksTaken = endTime - startTime;
		timeInSeconds = clockTicksTaken / (double)CLOCKS_PER_SEC;

		cout << "Кількість секунд: " << timeInSeconds << endl;
	}
	else if (number == 3)
	{
		clock_t startTime = clock();

		cout << "___________" << endl;
		cout << "Методом хорд:" << endl;
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

		cout << "Кількість секунд: " << timeInSeconds << endl;
	}
	else if (number == 4)
	{
		clock_t startTime = clock();

		cout << "___________" << endl;
		cout << "Методом дотичних:" << endl;
		cout <<"___________" << endl;

		cout << endl << "Enter accuracy e = ";
		cin >> e;

		x = MethodNewton(x, e);
		cout << "x = " << x << endl;
		clock_t endTime = clock();
		clock_t clockTicksTaken = endTime - startTime;
		timeInSeconds = clockTicksTaken / (double)CLOCKS_PER_SEC;

		cout << "Кількість секунд: " << timeInSeconds<< endl;
	}
	
	cout << "Нажмiть:\n1)Продовжити;\n2)Завершити;" << endl;
	cin >> value;

	if (value == 1)
		goto TryAgain;
	else
		cout << "Программа завершена";

	return 0;
}