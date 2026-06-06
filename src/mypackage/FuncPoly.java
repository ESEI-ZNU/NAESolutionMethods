package mypackage;

/**
 * Клас для обчислення значення полінома в заданій точці.
 *
 * @author Vladislav
 * @version 1.0
 */

class FuncPoly {

    /**
     * Обчислює значення полінома для заданого значення x.
     *
     * @param x значення аргументу
     * @param polynomCoefficients масив коефіцієнтів полінома
     * @return значення полінома в точці x
     */

    public static double polynom(double x, double[] polynomCoefficients) {

        double polynom = 0;

        for (int i = polynomCoefficients.length - 1; i >= 0; i--) {

            polynom += polynomCoefficients[i] * Math.pow(x, i);

        }

        return polynom;
    }
}
