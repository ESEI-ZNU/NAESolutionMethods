package mypackage;

class FuncPoly { //Клас містить допоміжну функцію для обчислення значення полінома.

    public static double polynom(double x, double[] polynomCoefficients) {

        double polynom = 0;

        for (int i = polynomCoefficients.length - 1; i >= 0; i--) {

            polynom += polynomCoefficients[i] * Math.pow(x, i);

        }

        return polynom;
    }
}
