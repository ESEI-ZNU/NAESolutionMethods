package mypackage;

import java.util.Scanner;

class MethodDataInput //Клас відповідає за відображення меню та виклик відповідного методу знаходження кореня.

{
    static Scanner scanner = new Scanner(System.in);
    static void getMethodData(double min, double max, double epsilon, double[] polynomCoefficients, int count) // Відображає меню методів розв’язання полінома, зчитує вибір користувача та викликає відповідний метод із класу Method.

    {
        System.out.print("Choose path to solution : ");
        System.out.print("1. Brute force method (переборка)");
        System.out.print("2. Method of half division (половнинне ділення)");
        System.out.print("3. Decimal  method (дотичні)");
        System.out.print("4. Сhord method (хорди)");
        System.out.print("5. Сhord-decimal method (хорди - дотичні)");
        System.out.print("6. Іteration method (ітерації)");
        System.out.print(" ");
        System.out.print("0. EXIT");
        int path = scanner.nextInt();

        switch (path) {

            case 0 -> {

                return;

            }
            case 1 -> {

                double root1 = 0;

                System.out.print("1. Brute force method (переборка)");

                root1 = Method.bruteForce(min, max, epsilon, polynomCoefficients, count);

                System.out.println("Root = " + root1);

            }
            case 2 -> {

                double root1 = 0;

                System.out.print("2. Method of half division (половнинне ділення)");

                root1 = Method.bisection(min, max, epsilon, polynomCoefficients, count);

                System.out.println("Root = " + root1);

            }
            case 3 -> {

                double root1 = 0;

                System.out.print("2. Method of half division (половнинне ділення)");

                root1 = Method.bisection(min, max, epsilon, polynomCoefficients, count);

                System.out.println("Root = " + root1);

            }

            case 4 -> {

                double root1 = 0;

                System.out.print("2. Method of half division (половнинне ділення)");

                root1 = Method.bisection(min, max, epsilon, polynomCoefficients, count);

                System.out.println("Root = " + root1);

            }


            default -> {

                System.out.print("Unknown method");

            }
        }
    }
}

