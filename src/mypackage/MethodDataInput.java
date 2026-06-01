package mypackage;

import java.util.Scanner;

class MethodDataInput //Клас відповідає за відображення меню та виклик відповідного методу знаходження кореня.

{
    static Scanner scanner = new Scanner(System.in);
    static void getMethodData(double min, double max, double epsilon, double[] polynomCoefficients, int count) // Відображає меню методів розв’язання полінома, зчитує вибір користувача та викликає відповідний метод із класу Method.

    {
        System.out.println("Choose path to solution : ");
        System.out.println("1. Brute force method (переборка)");
        System.out.println("2. Method of half division (половнинне ділення)");
        System.out.println("3. Decimal  method (дотичні)");
        System.out.println("4. Сhord method (хорди)");
        System.out.println("5. Сhord-decimal method (хорди - дотичні)");
        System.out.println("6. Іteration method (ітерації)");
        System.out.println(" ");
        System.out.println("0. EXIT");
        int path = scanner.nextInt();

        switch (path) {

            case 0 -> {

                System.exit(0);

            }
            case 1 -> {

                double root1 = 0;

                System.out.println("1. Brute force method (переборка)");

                root1 = Method.bruteForce(min, max, epsilon, polynomCoefficients, count);

                System.out.println("Root = " + root1);

            }
            case 2 -> {

                double root1 = 0;

                System.out.println("2. Method of half division (половнинне ділення)");

                root1 = Method.bisection(min, max, epsilon, polynomCoefficients, count);

                System.out.println("Root = " + root1);

            }
            case 3 -> {

                double root1 = 0;

                System.out.println("2. Method of half division (половнинне ділення)");

                root1 = Method.bisection(min, max, epsilon, polynomCoefficients, count);

                System.out.println("Root = " + root1);

            }

            case 4 -> {

                double root1 = 0;

                System.out.println("2. Method of half division (половнинне ділення)");

                root1 = Method.bisection(min, max, epsilon, polynomCoefficients, count);

                System.out.println("Root = " + root1);

            }


            default -> {

                System.out.println("Unknown method");

            }
        }
    }
}

