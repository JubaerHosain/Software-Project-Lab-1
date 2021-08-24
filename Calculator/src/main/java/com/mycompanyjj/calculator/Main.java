/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompanyjj.calculator;

import java.util.Scanner;

/**
 *
 * @author jubaer
 */

public class Main {
    private Scanner scan;
    
    public Main() {
       scan = new Scanner(System.in);
    }
    
    public void start() {
        InfixEvaluation obj1 = new InfixEvaluation();
        System.out.println(obj1.evaluate("2(-5)+3+(-10/3)*3"));
    }
   
    public static void main(String[] args) {
        Main obj = new Main();
        obj.start();
    }
}