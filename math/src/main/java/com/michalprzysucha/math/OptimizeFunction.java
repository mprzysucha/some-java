package com.michalprzysucha.math;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.InitialGuess;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.SimpleValueChecker;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.ObjectiveFunction;
import org.apache.commons.math3.optim.nonlinear.scalar.ObjectiveFunctionGradient;
import org.apache.commons.math3.optim.nonlinear.scalar.gradient.NonLinearConjugateGradientOptimizer;
import org.apache.commons.math3.optim.univariate.SearchInterval;

import java.util.function.Function;

/**
 * @author Michal Przysucha
 * @since 2015-01-11
 */
public class OptimizeFunction {

    public static double[] optimize(GoalType goalType, final MultivariateFunction function, final MultivariateVectorFunction gradient, double[] startPoint) {
        return optimize(goalType, function, gradient, startPoint, new SimpleValueChecker(0.001, 0.001));
    }

    public static double[] optimize(GoalType goalType, final MultivariateFunction function, final MultivariateVectorFunction gradient, double[] startPoint,
                                    ConvergenceChecker<PointValuePair> checker) {
        return optimize(goalType, function, gradient, startPoint, checker, new SearchInterval(0.1, 10));
    }

    public static double[] optimize(GoalType goalType, final MultivariateFunction function, final MultivariateVectorFunction gradient, double[] startPoint,
                                    ConvergenceChecker<PointValuePair> checker, SearchInterval searchInterval) {
        NonLinearConjugateGradientOptimizer optimizer = new NonLinearConjugateGradientOptimizer(
                NonLinearConjugateGradientOptimizer.Formula.FLETCHER_REEVES, checker);
        PointValuePair res = optimizer.optimize(new OptimizationData[]{
                goalType,
                new ObjectiveFunction(function),
                new ObjectiveFunctionGradient(gradient),
                new InitialGuess(startPoint),
                searchInterval,
                new MaxIter(10000),
                new MaxEval(10000)
        });
        return res.getPoint();
    }

}
