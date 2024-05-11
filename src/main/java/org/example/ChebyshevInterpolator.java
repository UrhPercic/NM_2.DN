package org.example;

/**
 * Encapsulates Chebyshev interpolation, storing points and weights and providing an interpolation method.
 */
public class ChebyshevInterpolator {
    private double[] x;      // Chebyshev points
    private double[] y;      // Function values at Chebyshev points
    private double[] weights; // Weights for interpolation
    private int n;           // Number of points

    public ChebyshevInterpolator(int n, double a, double b) {
        this.n = n;
        this.x = new double[n + 1];
        this.weights = new double[n + 1];
        generateChebyshevPoints(a, b);
    }

    private void generateChebyshevPoints(double a, double b) {
        for (int i = 0; i <= n; i++) {
            x[i] = 0.5 * (a + b) + 0.5 * (b - a) * Math.cos(Math.PI * i / n);
            weights[i] = (i % 2 == 0 ? 1 : -1);
        }
        weights[0] *= 0.5;
        weights[n] *= 0.5;
    }

    /**
     * Retrieves the Chebyshev point at a specified index.
     * @param index The index of the point.
     * @return The Chebyshev point at the given index.
     */
    public double getX(int index) {
        if (index < 0 || index > n) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return x[index];
    }

    public void setFunctionValues(double[] functionValues) {
        if (functionValues.length != x.length) {
            throw new IllegalArgumentException("Function values array must match the number of Chebyshev points");
        }
        this.y = functionValues;
    }

    public double interpolate(double point) {
        return Interpolation.barycentricInterpolate(x, y, weights, point);
    }
}
