package com.michalprzysucha.math;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

/**
 * @author Michal Przysucha
 * @since 2015-01-11
 */
public class OptimizeFunctionTest extends TestCase {

    /**
     * function: y = x^2
     * derivative: y = 2*x
     * min: 0
     */
    public void testFun1() {
        testMin(0,
                v -> v[0] * v[0],
                v -> new double[]{2 * v[0]},
                -100);
    }

    /**
     * function: y = -x^2 - 3*x
     * derivative: y = -2*x - 3
     * max: -1,5
     */
    public void testFun2() {
        testMax(-1.5,
                v -> -v[0] * v[0] - 3 * v[0],
                v -> new double[]{-2 * v[0] - 3},
                -100);
    }

    /**
     * function: z= -y^2 - 3*y - 5*x^2 - 13*x
     * dz/dx=-10*x-13
     * dz/dy=-2y-3
     * max: [-1.3, -1.5]
     */
    public void testFun3() {
        testMax(new double[]{-1.3, -1.5},
                v -> -v[1] * v[1] - 3 * v[1] - 5 * v[0] * v[0] - 13 * v[0],
                v -> new double[]{
                        -10 * v[0] - 13,
                        -2 * v[1] - 3
                },
                new double[]{-100, -100}
        );
    }

    public static Test suite() {
        return new TestSuite(OptimizeFunctionTest.class);
    }

    public void testMin(double expected, MultivariateFunction function, MultivariateVectorFunction gradient, double startPoint) {
        assertEqualsAbsoluteThreshold(expected, OptimizeFunction.optimize(GoalType.MINIMIZE, function, gradient, new double[]{startPoint})[0], 0.001);
        assertEqualsRelativeThreshold(expected, OptimizeFunction.optimize(GoalType.MINIMIZE, function, gradient, new double[]{startPoint})[0], 0.001);
    }

    public void testMax(double expected, MultivariateFunction function, MultivariateVectorFunction gradient, double startPoint) {
        assertEqualsAbsoluteThreshold(expected, OptimizeFunction.optimize(GoalType.MAXIMIZE, function, gradient, new double[]{startPoint})[0], 0.001);
        assertEqualsRelativeThreshold(expected, OptimizeFunction.optimize(GoalType.MAXIMIZE, function, gradient, new double[]{startPoint})[0], 0.001);
    }

    public void testMin(double[] expected, MultivariateFunction function, MultivariateVectorFunction gradient, double[] startPoint) {
        assertEqualsAbsoluteThreshold(expected, OptimizeFunction.optimize(GoalType.MINIMIZE, function, gradient, startPoint), new double[]{0.001, 0.001});
        assertEqualsRelativeThreshold(expected, OptimizeFunction.optimize(GoalType.MINIMIZE, function, gradient, startPoint), new double[]{0.001, 0.001});
    }

    public void testMax(double[] expected, MultivariateFunction function, MultivariateVectorFunction gradient, double[] startPoint) {
        assertEqualsAbsoluteThreshold(expected, OptimizeFunction.optimize(GoalType.MAXIMIZE, function, gradient, startPoint), new double[]{0.001, 0.001});
        assertEqualsRelativeThreshold(expected, OptimizeFunction.optimize(GoalType.MAXIMIZE, function, gradient, startPoint), new double[]{0.001, 0.001});
    }


    public void assertEqualsRelativeThreshold(double expected, double actual, double threshold) {
        double denominator = Math.min(Math.abs(expected), Math.abs(actual));
        if (denominator != 0) {
            assertTrue(Math.abs(expected - actual) / denominator < threshold);
        }
    }

    public void assertEqualsAbsoluteThreshold(double expected, double actual, double threshold) {
        assertTrue(Math.abs(expected - actual) < threshold);
    }

    public void assertEqualsRelativeThreshold(double[] expected, double[] actual, double[] threshold) {
        assertNotNull(expected);
        assertNotNull(actual);
        assertNotNull(threshold);
        assertEquals(expected.length, actual.length);
        assertEquals(expected.length, threshold.length);
        for (int i = 0; i < expected.length; i++) {
            double denominator = Math.min(Math.abs(expected[i]), Math.abs(actual[i]));
            if (denominator != 0) {
                assertTrue(Math.abs(expected[i] - actual[i]) / denominator < threshold[i]);
            }
        }
    }

    public void assertEqualsAbsoluteThreshold(double[] expected, double[] actual, double[] threshold) {
        assertNotNull(expected);
        assertNotNull(actual);
        assertNotNull(threshold);
        assertEquals(expected.length, actual.length);
        assertEquals(expected.length, threshold.length);
        for (int i = 0; i < expected.length; i++) {
            assertTrue(Math.abs(expected[i] - actual[i]) < threshold[i]);
        }
    }

}
