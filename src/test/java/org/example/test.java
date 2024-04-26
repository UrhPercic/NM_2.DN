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
    public void testBarycentricInterpolate() {
        int n = 10;
        double[] x = new double[n + 1];
        double[] y = new double[n + 1];
        double[] weights = new double[n + 1];
        double a = -1;
        double b = 1;


        Interpolation.generateChebyshevPoints(n, a, b, x, weights);


        for (int i = 0; i <= n; i++) {
            y[i] = Math.exp(-x[i] * x[i]);
        }


        double point = 0.5;
        double expectedResult = Math.exp(-point * point);
        double interpolatedValue = Interpolation.barycentricInterpolate(x, y, weights, point);


        double delta = 0.01;
        assertEquals(expectedResult, interpolatedValue, delta, "The interpolated value should be close to the actual function value.");
    }
}
