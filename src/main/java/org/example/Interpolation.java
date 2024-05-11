package org.example;


/**
 * This class provides static methods for interpolating values using barycentric formulas
 * and generating Chebyshev points for interpolation.
 */
public class Interpolation {

    /**
     * Performs barycentric interpolation for the given set of points.
     *
     * @param x The Chebyshev points.
     * @param y The function values at the Chebyshev points.
     * @param weights The weights for the barycentric interpolation.
     * @param point The point at which to evaluate the interpolation.
     * @return The interpolated value.
     */
    public static double barycentricInterpolate(double[] x, double[] y, double[] weights, double point) {
        double numerator = 0.0;
        double denominator = 0.0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == point) return y[i]; // Avoid division by zero
            double term = weights[i] / (point - x[i]);
            numerator += term * y[i];
            denominator += term;
        }
        return numerator / denominator;
    }

    /**
     * Generates Chebyshev points and corresponding weights for interpolation.
     *
     * @param n The number of points.
     * @param a The lower bound of the interval.
     * @param b The upper bound of the interval.
     * @param x Array to store the generated points.
     * @param weights Array to store the weights.
     */
    public static void generateChebyshevPoints(int n, double a, double b, double[] x, double[] weights) {
        for (int i = 0; i <= n; i++) {
            x[i] = 0.5 * (a + b) + 0.5 * (b - a) * Math.cos(Math.PI * i / n);
            weights[i] = (i % 2 == 0 ? 1 : -1);
        }
        weights[0] *= 0.5;
        weights[n] *= 0.5;
    }

    public static void main(String[] args) {
        int n = 10;
        double[] x = new double[n + 1];
        double[] y = new double[n + 1];
        double[] weights = new double[n + 1];

        double a = -1;
        double b = 1;


        generateChebyshevPoints(n, a, b, x, weights);

        for (int i = 0; i <= n; i++) {
            y[i] = Math.sin(x[i]) / x[i];
        }

        double point = Math.PI / 4;
        double interpolatedValue = barycentricInterpolate(x, y, weights, point);

        System.out.println("Interpolated value at x = " + point + " is: " + interpolatedValue);
    }
}
