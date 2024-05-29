// NAEsolutionmethods.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
#include "NAEsol_met.h"
#include <iostream>
#include <cmath>
#include <chrono>
#include <iomanip> // ��� ������������ fixed � setprecision

using namespace std;
using namespace std::chrono;


int main() {
    setlocale(LC_ALL, "ukr");
    double a, b, step, epsilon; int maxiterations = 1000;
    cout << "������ ��������� �������� ��������� a: ";
    cin >> a;
    cout << "������ ������ �������� ��������� b: ";
    cin >> b;
    cout << "������ ���� ��� ������ ��������: ";
    cin >> step;
    cout << "������ ������� epsilon: ";
    cin >> epsilon;

    // ����� ��������
    auto start = steady_clock::now();
    double root1 = PickingMethod(a, b, step, epsilon);
    auto end = steady_clock::now();
    auto time1 = duration_cast<duration<double>>(end - start);

    // ����� ����������� ������ (�������)
    start = steady_clock::now();
    double root2 = BisectionMethod(a, b, epsilon);
    end = steady_clock::now();
    auto time2 = duration_cast<duration<double>>(end - start);

    // ����� ����
    start = steady_clock::now();
    double root3 = SecantMethod(a, b, epsilon);
    end = steady_clock::now();
    auto time3 = duration_cast<duration<double>>(end - start);

    // ����� �������� (����� �������)
    start = steady_clock::now();
    double root4 = NewtonMethod((a + b) / 2, epsilon);
    end = steady_clock::now();
    auto time4 = duration_cast<duration<double>>(end - start);

    // ����� ����-��������
    start = steady_clock::now();
    double root5 = Secant_NewtonMethod(a, b, epsilon);
    end = steady_clock::now();
    auto time5 = duration_cast<duration<double>>(end - start);

    // ����� ��������
    start = steady_clock::now();
    double root6 = IterationsMethod((a + b) / 2, epsilon,maxiterations);
    end = steady_clock::now();
    auto time6 = duration_cast<duration<double>>(end - start);

    cout << fixed << setprecision(10);//std::fixed ���������� ���������� ������ ��� ����� � ��������� ������. //
    cout << "����� ��������: ����� = " << root1 << ", ��� = " << time1.count() << " ������" << endl;
    cout << "����� ����������� ������: ����� = " << root2 << ", ��� = " << time2.count() << " ������" << endl;
    cout << "����� ����: ����� = " << root3 << ", ��� = " << time3.count() << " ������" << endl;
    cout << "����� �������� (����� �������): ����� = " << root4 << ", ��� = " << time4.count() << " ������" << endl;
    cout << "����� ����-��������: ����� = " << root5 << ", ��� = " << time5.count() << " ������" << endl;
    cout << "����� ��������: ����� = " << root6 << ", ��� = " << time6.count() << " ������" << endl;

    double minTime = time1.count();
    minTime = min(minTime, time2.count());
    minTime = min(minTime, time3.count());
    minTime = min(minTime, time4.count());
    minTime = min(minTime, time5.count());
    minTime = min(minTime, time6.count());
    cout << endl;
    cout << "��������� ��� ���������: " << minTime << " ������" << endl;

    return 0;
}