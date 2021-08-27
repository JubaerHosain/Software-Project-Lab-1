/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompanyjj.calculator;

/**
 *
 * @author jubaer
 */
public class PolynomialEquationSolver {
    public void solveFirstOrder(double[] coefficient) {
        if(coefficient[0] == 0) {
            System.out.println("No Solution Exists.");
        }
        else {
            System.out.println("x = " + (coefficient[1]/coefficient[0]) + '\n');
        }
    }
    
    public void solveSecondOrder(double coeffficient) {
        
    }
    
    public void solveThirdOrder() {
        
    }
}
