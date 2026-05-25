package mypackage;

import java.util.Scanner;



public class Main {

//    Клас містить головний метод програми та відповідає за запуск застосунку. Забезпечує отримання вхідних даних від користувача та організовує виклик методів обчислення.


    public static void main(String[] args) {

//        Головний метод програми.


                Scanner scanner = new Scanner(System.in);

        int count = PolynomInput.getPolynomDegree();
        double[] polynomCoefficients=PolynomInput.getPolynomCoeff(count);

//        System.out.print("Enter count of degree : ");
//        int count = scanner.nextInt();

        System.out.print("Enter range, from least to most, by k_SPACE : ");
        double min = scanner.nextDouble();
        double max = scanner.nextDouble();
//
        System.out.print("Enter an accuracy : ");
        double epsilon = scanner.nextDouble();

//        double[] arrayOfKof = new double[count];
//
//        for (int i = 0; i < count; i++) {
//
//            System.out.print("Enter k of x with " + i + " degree : ");
//            arrayOfKof[i] = scanner.nextDouble();
//
//        }

        while (true) {

            MethodDataInput.getMethodData(min, max, epsilon, polynomCoefficients, count);

        }
    }
}

 class menuChoos {

//    static void conChoos(double min, double max, double epsilon, double[] arrayOfKof, int count) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Choose path to solution : ");
//        System.out.print("1. Brute force method (переборка)");
//        System.out.print("2. Method of half division (половнинне ділення)");
//        System.out.print("3. Decimal  method (дотичні)");
//        System.out.print("4. Сhord method (хорди)");
//        System.out.print("5. Сhord-decimal method (хорди - дотичні)");
//        System.out.print("6. Іteration method (ітерації)");
//        System.out.print(" ");
//        System.out.print("0. EXIT");
//        int path = scanner.nextInt();
//
//        switch (path) {
//
//            case 0 -> {
//
//                return;
//
//            }
//            case 1 -> {
//
//                double root1 = 0;
//
//                System.out.print("1. Brute force method (переборка)");
//
//                root1 = Method.bruteForce(min, max, epsilon, arrayOfKof, count);
//
//                System.out.println("Root = " + root1);
//
//            }
//            case 2 -> {
//
//                double root1 = 0;
//
//                System.out.print("2. Method of half division (половнинне ділення)");
//
//                root1 = Method.bisection(min, max, epsilon, arrayOfKof, count);
//
//                System.out.println("Root = " + root1);
//
//            }
//            case 3 -> {
//
//                double root1 = 0;
//
//                System.out.print("2. Method of half division (половнинне ділення)");
//
//                root1 = Method.bisection(min, max, epsilon, arrayOfKof, count);
//
//                System.out.println("Root = " + root1);
//
//            }
//
//            case 4 -> {
//
//                double root1 = 0;
//
//                System.out.print("2. Method of half division (половнинне ділення)");
//
//                root1 = Method.bisection(min, max, epsilon, arrayOfKof, count);
//
//                System.out.println("Root = " + root1);
//
//            }
//
//
//            default -> {
//
//                System.out.print("Unknown method");
//
//            }
//        }
//    }
}


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



 class Method { //Клас містить реалізації чисельних методів знаходження коренів полінома.

    static double bruteForce(double a, double b, double epsilon, double[] polynomCoefficients, int count) { //Реалізує метод повного перебору для пошуку кореня на заданому проміжку.

        long startTime = System.nanoTime();

        double root = 0;

//            epsilon=step;

        double x = a;

        if (a == b) {
            if (funcPoly.polynom(a, count, polynomCoefficients) == 0)
                return a;
            else
                System.out.println("Немає коренів на проміжку");
        }

        while (x < b) {
            double nextX = 0;
            if (funcPoly.polynom(x, count, polynomCoefficients) * funcPoly.polynom(nextX, count, polynomCoefficients) < 0) {
                root = (x + nextX) / 2;
                break;
            } else
                x = nextX;
        }

        long endTime = System.nanoTime();

        long diffTime = endTime - startTime;

        System.out.println("Error = " + epsilon);
        System.out.println("Time = " + diffTime + " ns");

        return root;
    }

    static double bisection(double a, double b, double epsilon, double[] k, int count) { //Реалізує метод половинного ділення. Послідовно звужує інтервал пошуку кореня до досягнення необхідної точності.


        long startTime = System.nanoTime();

        if (funcPoly.polynom(a, count, k) * funcPoly.polynom(b, count, k) > 0)
            System.out.println("метод половинного ділення на цьому проміжку не можна застосувати");

        double root = 0;
        double medium = (a + b) / 2;


        if (a == b) {
            if (funcPoly.polynom(a, count, k) == 0)
                return a;
            else
                System.out.println("Немає коренів на проміжку");
        }

        while ((b - a) > epsilon) {
            if (funcPoly.polynom(a, count, k) * funcPoly.polynom(medium, count, k) < 0) {
                b = medium;
                medium = (a + b) / 2;
                root = medium;
            } else if (funcPoly.polynom(b, count, k) * funcPoly.polynom(medium, count, k) < 0) {
                a = medium;
                medium = (a + b) / 2;
                root = medium;
            }
        }

        long endTime = System.nanoTime();

        long diffTime = endTime - startTime;

        System.out.println("Error = " + epsilon);
        System.out.println("Time = " + diffTime + " ns");

        return root;

    }

    static double nchord(double min, double max, double epsilon, double[] polynomCoefficients) { //Заготовка для реалізації методу хорд.


        double root = 0;

        long startTime = System.nanoTime();

        /// METHOD

        long endTime = System.nanoTime();

        long diffTime = endTime - startTime;

        System.out.println("Error = " + epsilon);
        System.out.println("Time = " + diffTime + " ns");

        return root;
    }

    static double newton(double start, double epsilon, double[] polynomCoefficients) { //Заготовка для реалізації методу Ньютона.


        double root = 0;

        long startTime = System.nanoTime();

        /// METHOD

        long endTime = System.nanoTime();

        long diffTime = endTime - startTime;

        System.out.println("Error = " + epsilon);
        System.out.println("Time = " + diffTime + " ns");

        return root;
    }

    static double iteration(double start, double epsilon, double[] polynomCoefficients) { //Заготовка для реалізації ітераційного методу.


        double root = 0;

        long startTime = System.nanoTime();

        /// METHOD

        long endTime = System.nanoTime();

        long diffTime = endTime - startTime;

        System.out.println("Error = " + epsilon);
        System.out.println("Time = " + diffTime + " ns");

        return root;
    }

}

 class funcPoly { //Клас містить допоміжну функцію для обчислення значення полінома.

    public static double polynom(double x, int count, double polynomCoefficients[]) { //Обчислює значення полінома для заданого значення x та масиву коефіцієнтів.


        double polynom = 0;


        for (int i = count; i > 0; i--) {

            polynom = polynomCoefficients[i] * Math.pow(x, i) + polynom;

        }

        return polynom;

    }
}

