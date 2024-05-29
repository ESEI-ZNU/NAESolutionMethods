#include "NAEsol_met.h"
#include <iostream>
using namespace std;
// Ôóíêö³ÿ, äëÿ ÿêî¿ ìè øóêàºìî êîðåí³
double nonlinearFunction(double x) {
    return x * x * x - 2 * x - 5;
}

// Ïîõ³äíà ôóíêö³¿ äëÿ ìåòîäó äîòè÷íèõ (ìåòîä Íüþòîíà)
double derivativeFunction(double x) {
    return 3 * x * x - 2;
}

// Ìåòîä ïåðåáîðó
double PickingMethod(double a, double b, double step, double epsilon) {
    for (double x = a; x <= b; x += step) {
        if (fabs(nonlinearFunction(x)) < epsilon) {
            return x;
        }
    }
    return a; // ßêùî ðîçâ'ÿçîê íå çíàéäåíî, ïîâåðòàºìî ïî÷àòêîâå çíà÷åííÿ
}

// Ìåòîä ïîëîâèííîãî ä³ëåííÿ (á³ñåêö³¿)
double BisectionMethod(double a, double b, double epsilon) {
    double c;
    while ((b - a) >= epsilon) {
        c = (a + b) / 2;
        if (nonlinearFunction(c) == 0.0)
            break;
        else if (nonlinearFunction(c) * nonlinearFunction(a) < 0)
            b = c;
        else
            a = c;
    }
    return c;
}

// Ìåòîä õîðä
double SecantMethod(double a, double b, double epsilon) {
    double c;
    while (fabs(b - a) >= epsilon) {
        c = b - nonlinearFunction(b) * (b - a) / (nonlinearFunction(b) - nonlinearFunction(a));
        a = b;
        b = c;
    }
    return c;
}

// Ìåòîä äîòè÷íèõ (ìåòîä Íüþòîíà)
double NewtonMethod(double x0, double epsilon) {
    double h = nonlinearFunction(x0) / derivativeFunction(x0);
    while (fabs(h) >= epsilon) {
        h = nonlinearFunction(x0) / derivativeFunction(x0);
        x0 = x0 - h;
    }
    return x0;
}

// Ìåòîä õîðä-äîòè÷íèõ (çì³øàíèé ìåòîä)
double Secant_NewtonMethod(double a, double b, double epsilon) {
    double c;
    while (fabs(b - a) >= epsilon) {
        c = (a * nonlinearFunction(b) - b * nonlinearFunction(a)) / (nonlinearFunction(b) - nonlinearFunction(a));
        if (fabs(nonlinearFunction(c)) < epsilon)
            return c;
        if (nonlinearFunction(a) * nonlinearFunction(c) < 0)
            b = c;
        else
            a = c;
    }
    return c;
}

double IterationsMethod(double x0, double epsilon, int maxiterations) {
    double x1; int iterations = 0;
    while (true) {
        x1 = x0 - 0.01 * nonlinearFunction(x0); // lambda = 0.01 - крок ітерації
        if (fabs(x1 - x0) < epsilon)
            break;
        x0 = x1;
        iterations++;
        if (iterations >= maxiterations) {
            cout << "Досягнуто максимальну кількість ітерацій" << std::endl;
            break;
        }
    }
    return x1;
}
