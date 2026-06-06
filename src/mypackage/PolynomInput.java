package mypackage;

import java.util.Scanner;
/**
 * Клас призначений для введення степеня полінома
 * та його коефіцієнтів.
 *
 * @author Vladislav
 * @version 1.0
 */
class PolynomInput
{

    /**
     * Зчитує степінь полінома з клавіатури.
     *
     * @return степінь полінома
     */
    static Scanner scanner = new Scanner(System.in);
    static int getPolynomDegree( )

    {
        System.out.println("Enter count of degree: ");
        int count = scanner.nextInt();
        return count;
    }
    /**
     * Зчитує коефіцієнти полінома.
     *
     * @param count кількість коефіцієнтів полінома
     * @return масив коефіцієнтів полінома
     */
    static double[] getPolynomCoeff(int count)
    {
        double[] polynomCoefficients = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Enter coefficient for x^" + i + ": ");
            polynomCoefficients[i] = scanner.nextDouble();
        }
        return polynomCoefficients;
    }
}