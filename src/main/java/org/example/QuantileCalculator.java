package org.example;

/**
 * Provides methods to calculate the probability density function (PDF) and cumulative distribution function (CDF)
 * of a standard normal distribution, and to find quantiles using the Newton-Raphson method.
 */
public class QuantileCalculator {
    private static final double EPSILON = 1e-10;
    private static final double SQRT_TWO_PI = Math.sqrt(2 * Math.PI);

    /**
     * Calculates the value of the probability density function (PDF) for a standard normal distribution at a given x.
     *
     * @param x The point at which to evaluate the PDF.
     * @return The PDF value at x.
     */
    public static double normalPdf(double x) {
        return Math.exp(-0.5 * x * x) / SQRT_TWO_PI;
    }

    /**
     * Calculates the cumulative distribution function (CDF) for a standard normal distribution up to a given x using Simpson's rule.
     *
     * @param x The upper limit to which the CDF is calculated.
     * @return The CDF value up to x.
     */
    public static double normalCdf(double x) {
        final int N = 10000;  // More segments mean more accuracy
        double a = -5, b = x, h = (b - a) / N;
        double sum = normalPdf(a) + normalPdf(b);

        for (int i = 1; i < N; i += 2) {
            sum += 4 * normalPdf(a + i * h);
        }
        for (int i = 2; i < N - 1; i += 2) {
            sum += 2 * normalPdf(a + i * h);
        }

        return sum * h / 3;
    }

    /**
     * Finds the quantile for a given probability in a standard normal distribution using the Newton-Raphson method.
     *
     * @param p The probability for which to find the corresponding quantile.
     * @return The quantile corresponding to the probability p.
     */
    public static double findQuantile(double p) {
        double x = (p > 0.5) ? Math.sqrt(-2 * Math.log(1 - p)) : -Math.sqrt(-2 * Math.log(p));  // Improved initial guess
        while (true) {
            double fx = normalCdf(x) - p;
            if (Math.abs(fx) < EPSILON) {
                return x;
            }
            double dfx = normalPdf(x);
            x = x - fx / dfx;
        }
    }

    public static void main(String[] args) {
        double p = 0.95;
        double q = findQuantile(p);
        System.out.printf("The 95th percentile of the standard normal distribution is approximately %.10f%n", q);
    }
}
