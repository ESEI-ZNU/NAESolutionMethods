package mypackage;

import java.util.Scanner;

class PolynomInput
{
//        Клас призначений для введення параметрів полінома.


    static Scanner scanner = new Scanner(System.in);
    static int getPolynomDegree( ) //Зчитує від користувача кількість коефіцієнтів полінома.

    {
        System.out.print("Enter count of degree: ");
        int count = scanner.nextInt();
        return count;
    }

    static double[] getPolynomCoeff(int count) //Створює масив коефіцієнтів полінома та заповнює його введеними значеннями.
    {
        double[] polynomCoefficients = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter coefficient for x^" + i + ": ");
            polynomCoefficients[i] = scanner.nextDouble();
        }
        return polynomCoefficients;
    }
}