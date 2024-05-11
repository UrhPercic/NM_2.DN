package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class test {

    private final int n = 10;
    private final double a = -1;
    private final double b = 1;
    private final double delta = 0.01;

    private final double[] x = new double[n + 1];
    private final double[] weights = new double[n + 1];

    private void generateChebyshevPointsAndWeights() {
        Interpolation.generateChebyshevPoints(n, a, b, x, weights);
    }

    private double[] evaluateFunction(FunctionEvaluator evaluator) {
        double[] y = new double[n + 1];

        for (int i = 0; i <= n; i++) {
            y[i] = evaluator.eval(x[i]);
        }

        return y;
    }

    @FunctionalInterface
    interface FunctionEvaluator {
        double eval(double x);
    }

    public test() {
        generateChebyshevPointsAndWeights();
    }

    @Test
    public void testExponentialFunction() {
        FunctionEvaluator expEvaluator = (xi) -> Math.exp(-xi * xi);
        double[] y = evaluateFunction(expEvaluator);

        double point = 0.5;
        double expectedResult = expEvaluator.eval(point);
        double interpolatedValue = Interpolation.barycentricInterpolate(x, y, weights, point);

        assertEquals(expectedResult, interpolatedValue, delta, "Exponential function interpolation failed at x = " + point);
    }

    @Test
    public void testSineXFunction() {
        double[] y = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            y[i] = (x[i] == 0 ? 1 : Math.sin(x[i]) / x[i]);
        }

        double point = Math.PI;  // Testing direct computation
        double expectedResult = Math.sin(point) / point;
        double interpolatedValue = Interpolation.barycentricInterpolate(x, y, weights, point);

        assertEquals(expectedResult, interpolatedValue, delta, "Sine x/x function interpolation failed at x = " + point);
    }

    @Test
    public void testPolynomialFunction() {
        FunctionEvaluator polynomialEvaluator = (xi) -> Math.abs(xi * xi - 2 * xi);
        double[] y = evaluateFunction(polynomialEvaluator);

        double point = 0.0;
        double expectedResult = polynomialEvaluator.eval(point);
        double interpolatedValue = Interpolation.barycentricInterpolate(x, y, weights, point);

        assertEquals(expectedResult, interpolatedValue, delta, "Polynomial function |x^2 - 2x| interpolation failed at x = " + point);
    }
}
