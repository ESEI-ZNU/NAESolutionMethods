package mypackage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cout of degree : ");
        int count = scanner.nextInt();

        System.out.print("Enter step : ");
        double step = scanner.nextDouble();

        System.out.print("Enter range, from least to most, by k_SPACE : ");
        double min = scanner.nextDouble();
        double max = scanner.nextDouble();

        System.out.print("Enter an accuracy : ");
        double epsilon = scanner.nextDouble();

        double[] ArrayOfK = new double[count];

        for (int i = 0; i < count; i++) {

            System.out.print("Enter k of x with " + i + " degree : ");
            ArrayOfK[i] = scanner.nextDouble();

        }

        while (true) {

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

                    root1 = Function.bruteForce(min, max, step, epsilon, ArrayOfK, count);

                    System.out.println("Root = " + root1);

                }

                default -> {

                    System.out.print("Unknown method");

                }

            }
        }
    }
}

public class Method  {

        static double bruteForce(double a, double b, double step, double epsilon, double[] k, int count)
        {
            long startTime = System.nanoTime();

            double root = 0;

            epsilon=step;

            double x=a;

            if(a==b)
            {
                if (Function.f(a, count, k ) == 0)
                    return a;
                else
                    System.out.println("Немає коренів на проміжку");
            }

            while(x<b)
            {
                double nextX=0;
                if ( Function.f(x, count, k )*Function.f(nextX, count, k )< 0)
                {
                    root = (x+nextX)/2;
                    break;
                }

                else
                    x=nextX;
            }

            long endTime = System.nanoTime();

            long diffTime = endTime - startTime;

            System.out.println("Error = " + epsilon);
            System.out.println("Time = " + diffTime + " ns");

            return root;
        }

    static double bisection(double a, double b, double epsilon, double[] k, int count) {

        long startTime = System.nanoTime();

        if (Function.f(a, count, k ) * Function.f(b, count, k ) > 0)
            System.out.println("метод половинного ділення на цьому проміжку не можна застосувати");

        double root = 0;
        double medium = (a + b) / 2;


        if (a == b) {
            if (Function.f(a, count, k ) == 0)
                return a;
            else
                System.out.println("Немає коренів на проміжку");
        }

        while ((b - a) > epsilon) {
            if (Function.f(a, count, k ) * Function.f(medium, count, k ) < 0) {
                b = medium;
                medium = (a + b) / 2;
                root = medium;
            } else if (Function.f(b, count, k ) * Function.f(medium, count, k ) < 0) {
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

        static double f_chord(double min, double max, double epsilon, double[] k) {

            double root = 0;

            long startTime = System.nanoTime();

            /// METHOD

            long endTime = System.nanoTime();

            long diffTime = endTime - startTime;

            System.out.println("Error = " + epsilon);
            System.out.println("Time = " + diffTime + " ns");

            return root;
        }

        static double f_newton(double start, double epsilon, double[] k) {

            double root = 0;

            long startTime = System.nanoTime();

            /// METHOD

            long endTime = System.nanoTime();

            long diffTime = endTime - startTime;

            System.out.println("Error = " + epsilon);
            System.out.println("Time = " + diffTime + " ns");

            return root;
        }

        static double f_iteration(double start, double epsilon, double[] k) {

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

public class Function {

    public static double f(double x, int count, double k[]) {

        double polynom = 0;

        for (int i = count; i > 0; i--) {

            polynom = k[i] * Math.pow(x, i) + polynom;

        }

        return polynom;

    }
}
