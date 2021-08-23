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
public class Main {
   
    public static void main(String[] args) {
        //InfixEvaluation obj = new InfixEvaluation();
        ExpressionConverter obj1 = new ExpressionConverter();
        System.out.println(obj1.postfixToPrefix("ABC/-AK/L-*"));
        System.out.println(obj1.prefixToPostfix("*-A/BC-/AKL"));
        
    }
}