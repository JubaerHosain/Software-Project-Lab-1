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
            System.out.println("No Solution Exists.\n");
        }
        else {
            System.out.println("x = " + (coefficient[1]/coefficient[0]) + '\n');
        }
    }
    
    public void solveSecondOrder(double[] coeffficient) {
        double a = coeffficient[0];
        double b = coeffficient[1];
        double c = coeffficient[2];
        
        double discriminant = b*b - 4*a*c;
        if(discriminant < 0) {
            System.out.println("No Real Solution Exists.\n");
        }
        else if(discriminant == 0) {
            System.out.println("x1 = x2 =" + (-b/(2*a)) + '\n');
        } 
        else {
            discriminant = Math.sqrt(discriminant);
            double x1 = -b + discriminant;
            double x2 = -b - discriminant;
            System.out.println("x1 = " + (x1/(2*a)) + ", x2 = " + (x2/(2*a)) + '\n');
        }
    }
    
    public void solveThirdOrder(double[] coeffficient) {
        double a = coeffficient[0];
        double b = coeffficient[1];
        double c = coeffficient[2];
        double d = coeffficient[3];
        
        double f = ((3*c/a) - ((b*b)/(a*a))) / 3;
        double g = ((2*(b*b*b) / (a*a*a)) - (9*b*c/(a*a)) + (27*d/a))/27;   
        double h = ((g*g)/4) + ((f*f*f)/27);
           
        double x1, x2, x3;
        if(f == 0 && g == 0 && h == 0) {            // all roots are real and equal
            x1 = Math.pow((d/a),0.33333333333333333333333333333333);
            System.out.println("x1 = x2 = x3 = " + x1 + '\n');
        }
        else if(h <= 0) {                           // all 3 roots are real
            double i = Math.pow((((g*g)/4)-h), 0.5);
            double j = Math.pow(i, 0.33333333333333333333333333333333);
            double k = Math.acos((g/(2*i))*(-1));
            double l = j * -1;
            double m = Math.cos(k/3);
            double n = Math.sqrt(3) * Math.sin(k/3);
            double p = (b/(3*a)) * (-1);
            
            x1 = (2*j)*m - (b/(3*a));
            x2 = l * (m+n) + p;
            x3 = l * (m-n) + p;
            System.out.println("x1 = " + x1 + ", x2 = " + x2 + ", x3 = " + x3 + '\n');
        }
        else if(h > 0) {                            // only 1 root is real
            double r = ((g/2)*(-1)) + Math.pow(h,0.5);
            double s = Math.pow(r, 0.33333333333333333333333333333333);
            double t = ((g/2)*(-1)) - Math.pow(h,0.5);
            double u = Math.pow((t), 0.33333333333333333333333333333333);
            
            x1 = (s+u) - (b/(3*a));
            double x2re = (((s+u)*(-1))/2) - (b/(3*a));
            double x2im = -(s-u) * Math.pow(3, 0.5)/2;
            double x3re = (((s+u)*(-1))/2) - (b/(3*a));
            double x3im = (s-u) * Math.pow(3, 0.5)/2;
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2re + ", " + x2im);
            System.out.println("x3 = " + x3re + ", " + x3im + '\n');
        }
    }
}
