package mypackage;

class Method { //Клас містить реалізації чисельних методів знаходження коренів полінома.

    static double bruteForce(double a, double b, double epsilon, double[] polynomCoefficients, int count) { //Реалізує метод повного перебору для пошуку кореня на заданому проміжку.

        long startTime = System.nanoTime();

        double root = 0;

//            epsilon=step;

        double x = a;

        if (a == b) {
            if (FuncPoly.polynom(a, polynomCoefficients) == 0)
                return a;
            else
                System.out.println("Немає коренів на проміжку");
        }

        while (x < b) {
            double nextX = x + epsilon;
            if (FuncPoly.polynom(x, polynomCoefficients) * FuncPoly.polynom(nextX, polynomCoefficients) < 0) {
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

        if (FuncPoly.polynom(a, k) * FuncPoly.polynom(b, k) > 0)
            System.out.println("метод половинного ділення на цьому проміжку не можна застосувати");

        double root = 0;
        double medium = (a + b) / 2;


        if (a == b) {
            if (FuncPoly.polynom(a, k) == 0)
                return a;
            else
                System.out.println("Немає коренів на проміжку");
        }

        while ((b - a) > epsilon) {
            if (FuncPoly.polynom(a, k) * FuncPoly.polynom(medium,k) < 0) {
                b = medium;
                medium = (a + b) / 2;
                root = medium;
            } else if (FuncPoly.polynom(b, k) * FuncPoly.polynom(medium, k) < 0) {
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

    static double iteration(double start, double epsilon, double[] polynomCoefficients) { //Реалізує метод простої ітерації для знаходження кореня рівняння F(x)=0.
    
    long startTime = System.nanoTime();
    
    // Визначення параметра lambda для забезпечення збіжності
    // Використовуємо формулу: lambda = 1 / (1 + |F'(start)|)
    double h = 1e-6; // крок для чисельного диференціювання
    
    // Обчислюємо F(start)
    double f_start = FuncPoly.polynom(start, polynomCoefficients);
    
    // Обчислюємо похідну F'(start) методом центральної різниці
    double f_start_plus = FuncPoly.polynom(start + h, polynomCoefficients);
    double f_start_minus = FuncPoly.polynom(start - h, polynomCoefficients);
    double f_deriv = (f_start_plus - f_start_minus) / (2 * h);
    
    // Підбираємо lambda для забезпечення умови збіжності |φ'(x)| < 1
    // φ'(x) = 1 - λ·F'(x), тому обираємо λ = 1 / (|F'(start)| + 1)
    double lambda = 1.0 / (Math.abs(f_deriv) + 1.0);
    
    // Можна також використовувати фіксоване значення (як у прикладі звіту):
    // double lambda = 0.2;
    
    // Ітераційний процес
    double x_prev = start;
    double x_next = x_prev - lambda * f_start;
    int iterationCount = 0;
    final int MAX_ITERATIONS = 1000; // обмеження для запобігання зацикленню
    
    // Продовжуємо, поки різниця між наближеннями більша за точність
    while (Math.abs(x_next - x_prev) > epsilon && iterationCount < MAX_ITERATIONS) {
        x_prev = x_next;
        double f_prev = FuncPoly.polynom(x_prev, polynomCoefficients);
        x_next = x_prev - lambda * f_prev;
        iterationCount++;
    }
    
    double root = x_next;
    
    // Перевірка на перевищення ліміту ітерацій
    if (iterationCount >= MAX_ITERATIONS) {
        System.out.println("Увага: досягнуто максимальну кількість ітерацій (" + MAX_ITERATIONS + ")");
    }
    
    long endTime = System.nanoTime();
    long diffTime = endTime - startTime;
    
    System.out.println("Error = " + epsilon);
    System.out.println("Time = " + diffTime + " ns");
    System.out.println("Iterations = " + iterationCount);
    
    return root;
        }

}
