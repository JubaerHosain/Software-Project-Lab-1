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
        InfixEvaluation obj = new InfixEvaluation();
        System.out.println(obj.evaluate("10-4+(-4)"));
        
    }
}