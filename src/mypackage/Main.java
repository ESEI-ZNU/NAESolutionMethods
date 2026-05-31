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

        System.out.println("Enter range, from least to most, by k_SPACE : ");
        double min = scanner.nextDouble();
        double max = scanner.nextDouble();
//
        System.out.println("Enter an accuracy : ");
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
//}

// class menuChoos {

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





