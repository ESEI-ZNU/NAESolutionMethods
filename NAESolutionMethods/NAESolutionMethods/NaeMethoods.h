#pragma once
double MethodChord(double a, double b, double epsilon);
double MethodNewton(double x, double eps);
double F2(double x);
double FindRoot(double(*f)(double), double a, double b, double eps, double c);
double func(double x);