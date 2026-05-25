package mypackage;

class FuncPoly { //Клас містить допоміжну функцію для обчислення значення полінома.

    public static double polynom(double x, int count, double polynomCoefficients[]) { //Обчислює значення полінома для заданого значення x та масиву коефіцієнтів.

        double polynom = 0;

        for (int i = count; i > 0; i--) {

            polynom = polynomCoefficients[i] * Math.pow(x, i) + polynom;

        }

        return polynom;

    }
}
