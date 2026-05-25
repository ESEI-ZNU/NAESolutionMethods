package mypackage;

class Method { //Клас містить реалізації чисельних методів знаходження коренів полінома.

    static double bruteForce(double a, double b, double epsilon, double[] polynomCoefficients, int count) { //Реалізує метод повного перебору для пошуку кореня на заданому проміжку.

        long startTime = System.nanoTime();

        double root = 0;

//            epsilon=step;

        double x = a;

        if (a == b) {
            if (FuncPoly.polynom(a, count, polynomCoefficients) == 0)
                return a;
            else
                System.out.println("Немає коренів на проміжку");
        }

        while (x < b) {
            double nextX = 0;
            if (FuncPoly.polynom(x, count, polynomCoefficients) * FuncPoly.polynom(nextX, count, polynomCoefficients) < 0) {
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

        if (FuncPoly.polynom(a, count, k) * FuncPoly.polynom(b, count, k) > 0)
            System.out.println("метод половинного ділення на цьому проміжку не можна застосувати");

        double root = 0;
        double medium = (a + b) / 2;


        if (a == b) {
            if (FuncPoly.polynom(a, count, k) == 0)
                return a;
            else
                System.out.println("Немає коренів на проміжку");
        }

        while ((b - a) > epsilon) {
            if (FuncPoly.polynom(a, count, k) * FuncPoly.polynom(medium, count, k) < 0) {
                b = medium;
                medium = (a + b) / 2;
                root = medium;
            } else if (FuncPoly.polynom(b, count, k) * FuncPoly.polynom(medium, count, k) < 0) {
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