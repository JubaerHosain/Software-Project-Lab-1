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
    
    private void newline() {
        System.out.println();
    }
    
    private boolean isOperator(char operator) {
        switch (operator) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
                
            default:
                return false;
        }
    }
    
    private void numberConverter() {
        while(true) {
            System.out.println("Choose A Option(Number Base Converter Mode):");
            System.out.println("Press 1 For Converting Binary To Others:");
            System.out.println("Press 2 For Converting Octal To Others:");
            System.out.println("Press 3 For Converting Decimal To Others:");
            System.out.println("Press 4 For Converting HexaDecimal To Others:");
            System.out.println("Press 0 For Go Back:");
            
            int option = scan.nextInt();
            NumberConverter obj = new NumberConverter();
            String decimal, binary, octal, hexaDecimal;
            
            switch(option) {  
                case 1:
                    System.out.println("Enter A Binary Number:");
                    binary = scan.next();
                    octal = obj.binaryToOctal(binary);
                    decimal = obj.binaryToDecimal(binary);
                    hexaDecimal = obj.binaryToHexadecimal(binary);
                    System.out.println("Binary      = " + binary);
                    System.out.println("Octal       = " + octal);
                    System.out.println("Decimal     = " + decimal);
                    System.out.println("HexaDecimal = " + hexaDecimal + '\n');
                    break;
                    
                case 2:
                    System.out.println("Enter A Octal Number:");
                    octal = scan.next();
                    binary = obj.octalToBinary(octal);
                    decimal = obj.octalToDecimal(octal);
                    hexaDecimal = obj.octalToHexadecimal(octal);
                    System.out.println("Octal       = " + octal);
                    System.out.println("Binary      = " + binary);
                    System.out.println("Decimal     = " + decimal);
                    System.out.println("HexaDecimal = " + hexaDecimal + '\n');
                    break;
                    
                case 3:
                    System.out.println("Enter A Decimal Number:");
                    decimal = scan.next();
                    binary = obj.decimalToBinary(decimal);
                    octal =  obj.decimalToOctal(decimal);
                    hexaDecimal = obj.decimalToHexadecimal(decimal);
                    System.out.println("Decimal     = " + decimal);
                    System.out.println("Binary      = " + binary);
                    System.out.println("Octal       = " + octal);
                    System.out.println("HexaDecimal = " + hexaDecimal + '\n');
                    break;
                    
                case 4:
                    System.out.println("Enter A HexaDecimal Number:");
                    hexaDecimal = scan.next();
                    binary = obj.hexadecimalToBinary(hexaDecimal);
                    octal = obj.hexadecimalToOctal(hexaDecimal);
                    decimal = obj.hexadecimalToDecimal(hexaDecimal);
                    System.out.println("HexaDecimal = " + hexaDecimal);
                    System.out.println("Binary      = " + binary);
                    System.out.println("Octal       = " + octal);
                    System.out.println("Decimal     = " + decimal + '\n');
                    break;
             
                case 0:
                    newline();
                    return;
                
                default:
                    System.out.println("Wrong Option!! Choose Correct One.\n");
            }
        }
    }
    
    private void expressionConverter() {
        while(true) {
            System.out.println("Choose A Option(Arithmetic Expression Converter Mode):");
            System.out.println("Press 1 For Converting Prefix To Others:");
            System.out.println("Press 2 For Converting Infix To Others:");
            System.out.println("Press 3 For Converting Postfix To Others:");
            System.out.println("Press 0 For Go Back:");
            
            int option = scan.nextInt();
            ExpressionConverter obj = new ExpressionConverter();
            String prefix, infix, postfix;
            
            //bcz below takes nextLine
            scan.nextLine();
            
            switch(option) {
                case 1:
                    System.out.println("Enter A Prefix Expression:");
                    prefix = scan.nextLine();
                    prefix = prefix.replaceAll("\\s", "");
                    infix = obj.prefixToInfix(prefix);
                    postfix = obj.prefixToPostfix(prefix);
                    System.out.println("Prefix      = " + prefix);
                    System.out.println("Infix       = " + infix);
                    System.out.println("Postfix     = " + postfix + '\n');
                    break;
                    
                case 2:
                    System.out.println("Enter A Infix Expression:");
                    infix = scan.nextLine();
                    infix = infix.replaceAll("\\s", "");
                    prefix = obj.infixToPrefix(infix);
                    postfix = obj.infixToPostfix(infix);
                    System.out.println("Infix       = " + infix);
                    System.out.println("Prefix      = " + prefix);
                    System.out.println("Postfix     = " + postfix + '\n');
                    break;
                    
                case 3:
                    System.out.println("Enter A Postfix Expression:");
                    postfix = scan.nextLine();
                    postfix = postfix.replaceAll("\\s", "");
                    prefix = obj.postfixToPrefix(postfix);
                    infix = obj.postfixToInfix(postfix);
                    System.out.println("Postfix     = " + postfix);
                    System.out.println("Prefix      = " + prefix);
                    System.out.println("Infix       = " + infix + '\n');
                    break;
                    
                case 0:
                    newline();
                    return;
                    
                default:
                   System.out.println("Wrong Option!! Choose Correct One.\n"); 
            }
        }
    }
    
    private void linearEquationSolver() {
        while(true) {
            System.out.println("(Linear Equation Solver Mode):");
            System.out.println("Enter Number Of Variable: ");
            System.out.println("Enter 0 For Go To Main Menue: ");
                    
            int count = scan.nextInt();
            if(count <= 0) {
                newline();
                return;
            } 
            else {
                double[][] matrix = new double[count][count+1];
                System.out.println("Enter Augmented Matrix(" + count + "x" + (count+1) + "): ");
                
                for(int i = 0; i < count; i++) {
                    for(int j = 0; j <= count; j++)
                        matrix[i][j] = scan.nextDouble();
                }
                
                LinearEquationSolver obj = new LinearEquationSolver(matrix, count);
                obj.solveEquation();
                newline();
            }
        }
    }
    
    private void polynomialEquationSolver() {
        while(true) {
            System.out.println("(Polynomial Equation Solver Mode):");
            System.out.println("Enter Order Of Polynomial:");
            System.out.println("Enter 0 For Go To Main Menue:");
            
            int order = scan.nextInt();
            
            if(order == 0) {
                newline();
                return;
            } 
            
            double[] coefficient = new double[order+1]; 
            PolynomialEquationSolver obj = new PolynomialEquationSolver();
            
            System.out.println("Enter " + (order+1) + " Coefficient: ");
            for(int i = 0; i <= order; i++)
                coefficient[i] = scan.nextDouble();
            
            switch(order) {
                case 1:
                    obj.solveFirstOrder(coefficient);
                    break;
                    
                case 2:
                    obj.solveSecondOrder(coefficient);
                    break;
                
                case 3:
                    obj.solveThirdOrder(coefficient);
                    break;
                    
                default:
                    break;
            }
        }
    }
    
    private void basic() {
        while(true) {
            System.out.println("Choose A Option(Basic Mode):");
            System.out.println("Enter An Arithmetic Expression To Calculate:");
            System.out.println("Enter 0 For Go To Main Menu:");
            
            String input = scan.nextLine();
            
            //remove all whitespaces
            input = input.replaceAll("\\s", "");
            
            //put space before and after each operator
            String tmp = "";
            for(int i = 0; i < input.length(); i++) {
                if(i == 0 || i == input.length()-1) {
                    tmp += input.charAt(i) + "";
                    continue;
                }
                
                char ch = input.charAt(i);
                char prev = input.charAt(i-1);
                char post = input.charAt(i+1);
                if(isOperator(ch) && prev != '(' && post != ')')
                    tmp += " " + ch + " ";
                else
                    tmp += ch + "";
            }
            
            input = tmp;
            if(input.equals("0")) {
                newline();
                return;
            }
            else {
                InfixEvaluation obj = new InfixEvaluation();
                System.out.println(input + " = " + obj.evaluate(input) + '\n');
            }
        }
    }
    
    private void programmer() {
        while(true) {
            System.out.println("Choose A Option(Programmer Mode):");
            System.out.println("Press 1 For Number Base Conversion:");
            System.out.println("Press 2 For Arithmetic Expression Conversion:");
            System.out.println("Press 0 For Go To Main Menu:");
            
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    newline();
                    numberConverter();
                    break;
                    
                case 2:
                    newline();
                    expressionConverter();
                    break;
                    
                case 0:
                    newline();
                    return;
                    
                default:
                    System.out.println("Wrong Option!! Choose Correct One.\n");
                    break;
            }
        }
    }
    
    public void start() {
        System.out.println();
        System.out.println("==========Welcome To Calculator==========\n");
        
        while(true) {
            System.out.println("Choose A Option(Main Menu):");
            System.out.println("Press 1 For Basic Mode: ");
            System.out.println("Press 2 For Programmer Mode: ");
            System.out.println("Press 3 For Linear Equation Solver Mode: ");
            System.out.println("Press 4 For Polynomial Equation Solver Mode: ");
            System.out.println("Press 0 For Exit: ");
            
            int option = scan.nextInt();
            
            switch(option) {
                case 1:
                    newline();
                    scan.nextLine();
                    basic();
                    break;
                    
                case 2:
                    newline();
                    programmer();
                    break;
                
                case 3:
                    newline();
                    linearEquationSolver();
                    break;
                    
                case 4:
                    newline();
                    polynomialEquationSolver();
                    break;
                
                case 0:
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Wrong Option!! Choose Correct One.\n");
            }
        }
    }
   
    public static void main(String[] args) {
        Main obj = new Main();
        obj.start();
    }
}