package com.michalprzysucha.math;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.optim.SimpleValueChecker;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.univariate.SearchInterval;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * At this moment it doesn't work.
 * 
 * @author Michal Przysucha
 * @since 2015-01-11
 */
public class LinearRegression<A extends Number, B extends Number> {

    public double[] get(final Map<A, B> data) {
        MultivariateFunction function = theta -> {
            double cost = 0;
            double m = data.size();
            double sum = 0;
            Iterator<A> iter = data.keySet().iterator();
            while (iter.hasNext()) {
                double x = iter.next().doubleValue();
                double y = data.get(x).doubleValue();
                double h = theta[0] + theta[1] * x;
                sum += (h - y) * (h - y);
            }
            cost = (1 / (2 * m)) * sum;
            return cost;
        };
        MultivariateVectorFunction gradient = theta -> {
            double[] gradientVal = new double[] { 0, 0 };
            double m = data.size();
            double sum0 = 0;
            double sum1 = 0;
            Iterator<A> iter = data.keySet().iterator();
            while (iter.hasNext()) {
                double x = iter.next().doubleValue();
                double y = data.get(x).doubleValue();
                double h = theta[0] + theta[1] * x;
                sum0 += h - y;
                sum1 += (h - y) * x;
            }
            gradientVal[0] = (1 / m) * sum0;
            gradientVal[1] = (1 / m) * sum1;
            return gradientVal;
        };
        double[] startPoint = new double[] { 0, 0 };
        return OptimizeFunction.optimize(GoalType.MAXIMIZE, function, gradient, startPoint, new SimpleValueChecker(0.1, 0.1), new SearchInterval(0.01, 100));
    }

    public static void main(String[] args) {
        LinearRegression<Double, Double> linearRegression = new LinearRegression<Double, Double>();
        double[] res = linearRegression.get(linearRegression.getData());
        System.out.println(res.length);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    private Map<Double, Double> getData() {
        Map<Double, Double> res = new HashMap<Double, Double>();
        res.put(30.0, 310000.0);
        res.put(50.0, 400000.0);
        res.put(60.0, 530000.0);
        res.put(80.0, 670000.0);
        res.put(100.0, 700000.0);
        return res;
    }

}
