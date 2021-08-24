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
    
    private void basic() {
        while(true) {
            System.out.println("\t\t\t\t\tChosse A Option(Basic Mode):");
            System.out.println("\t\t\t\t\tEnter An Arithmetic Expression To Calculate:");
            System.out.println("\t\t\t\t\tEnter '0' For Go To Main Menu:");
            
            String input = scan.nextLine();
            if(input.equals("0")) {
                return;
            }
            else {
                InfixEvaluation obj = new InfixEvaluation();
                System.out.println("\t\t\t\t\t" + input + " = " + obj.evaluate(input) + '\n');
            }
        }
    }
    
    private void programmer() {
        while(true) {
            System.out.println("\t\t\t\t\tChosse A Option(Programmer Mode):");
            System.out.println("\t\t\t\t\tPress 1 For Number Base Conversion:");
            System.out.println("\t\t\t\t\tPress 2 For Arithmetic Expression Conversion:");
            System.out.println("\t\t\t\t\tPress 0 For Go To Main Menu:");
            
            int option = scan.nextInt();
            if(option == 1) {
                
            } 
            else if(option == 2) {
                
            }
            else if(option == 0) {
                return;
            } 
            else {
                System.out.println("\n\t\t\t\t\tWrong Option!! Choose Correct One.\n");
            }
        }
    }
    
    public void start() {
        System.out.println();
        System.out.println("\t\t\t\t\t================Welcome To Calculator===============\n");
        
        while(true) {
            System.out.println("\t\t\t\t\tChosse A Option(Main Menu):");
            System.out.println("\t\t\t\t\tPress 1 For Basic Mode: ");
            System.out.println("\t\t\t\t\tPress 2 For Programmer Mode: ");
            System.out.println("\t\t\t\t\tPress 3 For Linear Equation Solver mode: ");
            System.out.println("\t\t\t\t\tPress 0 For Exit: ");
            
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
            
            switch(option) {
                case 1:
                    basic();
                    break;
                    
                case 2:
                    programmer();
                    break;
                
                case 3:
                    break;
                
                case 0:
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("\n\t\t\t\t\tWrong Option!! Choose Correct One.\n");
            }
            
        }
        
    }
   
    public static void main(String[] args) {
        Main obj = new Main();
        obj.start();
        
    }
}