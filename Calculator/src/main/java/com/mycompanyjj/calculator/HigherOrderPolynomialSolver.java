/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompanyjj.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jubaer
 */
public class HigherOrderPolynomialSolver {
    private int order;
    private double[] diff;               //first order derivative coefficient
    private double[] coeff;              //orginal coefficient
    static final double EPSILON = 0.001;
    static final int MAX_ITERATION = 10000000;
    private List<Double> roots;
    
    public HigherOrderPolynomialSolver(double[] coefficient, int order) {
        this.order = order;
        this.coeff = coefficient;
        roots = new ArrayList<>();
        diff = new double[order];
    }
    
    private void calculateFirstDerivative() {
        for(int i = 0; i < order; i++)
            diff[i] = coeff[i] * (order-i);
    }
    
    private double orginalFunction(double x) {
        double result = 0;
        for(int i = 0; i <= order; i++) 
            result += (Math.pow(x, order-i) * coeff[i]);
        
        return result;
    }
    
    private double derivativeFunction(double x) {
        double result = 0;
        for(int i = 0; i < order; i++) 
            result += (Math.pow(x, order-i-1) * diff[i]);
        
        return result;
    }
    
    private double solveEquation(double x) {
        int it = 0;
        
        do {
            double h = orginalFunction(x) / derivativeFunction(x);
            x = x - h;
            
            it++;
            if(it > MAX_ITERATION) 
                break;
        } while(Math.abs(orginalFunction(x)) > EPSILON);
        
        return x;
    }
    
    public void solveHigherOrder() {
        calculateFirstDerivative();
        
        double x0 = 100000;
        double result = solveEquation(x0);
            
        System.out.println("Found Real Root: x = " + result + "\n");
        
    }
}
