package mypackage;

import java.util.Scanner;

/**
 * Головний клас програми для знаходження коренів полінома різними чисельними методами.
 * Забезпечує введення даних користувачем та запуск обраного методу обчислення.
 *
 * @author Vladislav
 * @version 1.0
 */

public class Main {

    /**
     * Головний метод програми.
     * Отримує степінь полінома, його коефіцієнти, межі пошуку кореня
     * та задану точність, після чого запускає вибір методу обчислення.
     *
     * @param args аргументи командного рядка
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = PolynomInput.getPolynomDegree();
        double[] polynomCoefficients = PolynomInput.getPolynomCoeff(count);

        System.out.println("Enter range, from least to most, by k_SPACE : ");
        double min = scanner.nextDouble();
        double max = scanner.nextDouble();

        System.out.println("Enter an accuracy : ");
        double epsilon = scanner.nextDouble();

        while (true) {

            MethodDataInput.getMethodData(min, max, epsilon, polynomCoefficients, count);

        }
    }
}