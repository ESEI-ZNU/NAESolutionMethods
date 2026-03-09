package mypackage;

//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello, World!");
//    }
//}

import java.util.Scanner;

public class Main {

    static double bruteForce(double min, double max, double step, double epsilon, double[] k) {

        double root = 0;

        long startTime = System.nanoTime();

        /// METHOD

        long endTime = System.nanoTime();

        long diffTime = endTime - startTime;

        System.out.println("Error = " + epsilon);
        System.out.println("Time = " + diffTime + " ns");

        return root;
    }

    static double bisection(double min, double max, double epsilon, double[] k) {

        double root = 0;

        long startTime = System.nanoTime();

        /// METHOD

        long endTime = System.nanoTime();

        long diffTime = endTime - startTime;

        System.out.println("Error = " + epsilon);
        System.out.println("Time = " + diffTime + " ns");

        return root;
    }

    static double chord(double min, double max, double epsilon, double[] k) {

        double root = 0;

        long startTime = System.nanoTime();

        /// METHOD

        long endTime = System.nanoTime();

        long diffTime = endTime - startTime;

        System.out.println("Error = " + epsilon);
        System.out.println("Time = " + diffTime + " ns");

        return root;
    }

    static double newton(double start, double epsilon, double[] k) {

        double root = 0;

        long startTime = System.nanoTime();

        /// METHOD

        long endTime = System.nanoTime();

        long diffTime = endTime - startTime;

        System.out.println("Error = " + epsilon);
        System.out.println("Time = " + diffTime + " ns");

        return root;
    }

    static double iteration(double start, double epsilon, double[] k) {

        double root = 0;

        long startTime = System.nanoTime();

        /// METHOD

        long endTime = System.nanoTime();

        long diffTime = endTime - startTime;

        System.out.println("Error = " + epsilon);
        System.out.println("Time = " + diffTime + " ns");

        return root;
    }


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

                    root1 = bruteForce(min, max, step, epsilon, ArrayOfK);

                    System.out.println("Root = " + root1);

                }

                default -> {

                    System.out.print("Unknown method");

                }

            }
        }
    }
}
