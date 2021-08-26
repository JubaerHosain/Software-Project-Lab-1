/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompanyjj.calculator;

/**
 * Gauss-Jordan method
 * @author jubaer
 */
public class LinearEquationSolver {
    //size = matrix size
    //matrix = augmented mtrix
    private int size;
    private double[][] matrix;
    
    public LinearEquationSolver(double[][] matrix, int size) {
        this.size = size;
        this.matrix = matrix;
    }
    
    private int performOperation() {
        //perform elementary operations
        //to reduced row echelon form(diagonal matrix)
        for(int i = 0; i < size; i++) {
            if(matrix[i][i] == 0) {
                int c = 1;
                
                //find a row which i'th colum's value is non-zero
                while(i + c < size && matrix[i + c][i] == 0)
                    c++;
                
                if(i + c == size) 
                    return 1;
                
                //replace i'th row wiht i+c th row
                for(int k = 0; k <= size; k++) {
                    double tmp = matrix[i][k];
                    matrix[i][k] = matrix[i + c][k];
                    matrix[i + c][k] = tmp;
                }
            }
            
            for(int j = 0; j < size; j++) {
                if(i == j)
                    continue;
                
                //making all elements of i'th
                //colum to zero excluding matrix[i][i]
                double ratio = matrix[j][i] / matrix[i][i];
                for(int k = 0; k <= size; k++) 
                    matrix[j][k] = matrix[j][k] - (matrix[i][k] * ratio);
            }
        }
        
        return 0;
    }
    
    private int checkConsistency() {
        // To heck whether infinite 
        //solutions exists or no solution exists
        for(int i = 0; i < size; i++) {
            double sum = 0;
            
            for(int j = 0;  j < size; j++) 
                sum += matrix[i][j];
            
            if(sum == matrix[i][size])
                return 2;
        }

        return 3;
    }
    
    public void solveEquation() {
        //flag 0 means solution exists
        //flag 1 means no-solution or infinte-solution
        //flag 2 means infinite-solution exists
        //flag 3 means no-solution exists
        int flag = performOperation();
        if(flag == 1) 
            flag = checkConsistency();
        
        switch (flag) {
            case 2:
                System.out.println("Infinite Solution Exists");
                break;
                
            case 3:
                System.out.println("No Solution Exists");
                break;
                
            default:
                char[] variables = {'m', 'n', 'o', 'p', 'q', 'r', 'u', 'v', 'w', 'x', 'y', 'z'};
                for(int i = 0; i < size; i++)
                    System.out.println(variables[i] + " = " + (matrix[i][size] / matrix[i][i]));
                break;
        }
    }
}
