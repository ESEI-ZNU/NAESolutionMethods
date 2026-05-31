static double iteration(double start, double epsilon, double[] polynomCoefficients) { //Реалізує метод простої ітерації для знаходження кореня рівняння F(x)=0.
    
    long startTime = System.nanoTime();
    
    // Визначення параметра lambda для забезпечення збіжності
    // Використовуємо формулу: lambda = 1 / (1 + |F'(start)|)
    double h = 1e-6; // крок для чисельного диференціювання
    
    // Обчислюємо F(start)
    double f_start = FuncPoly.polynom(start, polynomCoefficients.length, polynomCoefficients);
    
    // Обчислюємо похідну F'(start) методом центральної різниці
    double f_start_plus = FuncPoly.polynom(start + h, polynomCoefficients.length, polynomCoefficients);
    double f_start_minus = FuncPoly.polynom(start - h, polynomCoefficients.length, polynomCoefficients);
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
        double f_prev = FuncPoly.polynom(x_prev, polynomCoefficients.length, polynomCoefficients);
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
