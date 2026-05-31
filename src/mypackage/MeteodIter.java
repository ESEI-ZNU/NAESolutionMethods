static double iteration(double start, double epsilon, double[] polynomCoefficients) {
    long startTime = System.nanoTime();

    // Підготовка: обчислення λ для забезпечення збіжності
    // Використовуємо числове диференціювання для оцінки F'(start)
    double h = 1e-6;
    double f_start = funcPoly(start, polynomCoefficients);
    double f_start_deriv = (funcPoly(start + h, polynomCoefficients) - f_start) / h;
    double lambda = 1.0 / (Math.abs(f_start_deriv) + 1.0); // λ = 1/(1+|F'(x₀)|) ∈ (0,1]
    // (можна задати константу, як у прикладі: lambda = 0.2; – тоді прибрати обчислення)

    // Ітераційний процес
    double x_prev = start;
    double x_next;
    int iter = 0;
    final int MAX_ITER = 1000; // запобігання зацикленню

    do {
        // φ(x) = x - λ·F(x)
        x_next = x_prev - lambda * funcPoly(x_prev, polynomCoefficients);
        iter++;
        if (iter > MAX_ITER) {
            System.out.println("Метод ітерацій не зійшовся за " + MAX_ITER + " кроків");
            break;
        }
        double diff = Math.abs(x_next - x_prev);
        if (diff < epsilon) break;
        x_prev = x_next;
    } while (true);

    long endTime = System.nanoTime();
    long diffTime = endTime - startTime;

    System.out.println("Error = " + epsilon);
    System.out.println("Time = " + diffTime + " ns");
    System.out.println("Iterations = " + iter);

    return x_next;
}

 // Допоміжна функція для обчислення значення полінома в точці x.
 // Використовується замість FuncPoly.polynom, оскільки в ньому є помилка.
//  Можна замінити на виправлений FuncPoly.polynom, коли той буде готовий.
private static double funcPoly(double x, double[] coeff) {
    double result = 0.0;
    for (int i = 0; i < coeff.length; i++) {
        result += coeff[i] * Math.pow(x, i);
    }
    return result;
}