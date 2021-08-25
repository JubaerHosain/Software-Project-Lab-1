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
            System.out.println("\t\t\t\t\tChosse A Option(Number Base Converter Mode):");
            System.out.println("\t\t\t\t\tPress 1 For Converting Binary To Others:");
            System.out.println("\t\t\t\t\tPress 2 For Converting Octal To Others:");
            System.out.println("\t\t\t\t\tPress 3 For Converting Decimal To Others:");
            System.out.println("\t\t\t\t\tPress 4 For Converting HexaDecimal To Others:");
            System.out.println("\t\t\t\t\tPress 0 For Go Back:");
            
            int option = scan.nextInt();
            NumberConverter obj = new NumberConverter();
            String decimal, binary, octal, hexaDecimal;
            
            switch(option) {  
                case 1:
                    System.out.println("\t\t\t\t\tEnter A Binary Number:");
                    binary = scan.next();
                    octal = obj.binaryToOctal(binary);
                    decimal = obj.binaryToDecimal(binary);
                    hexaDecimal = obj.binaryToHexadecimal(binary);
                    System.out.println("\t\t\t\t\t" + "Binary      = " + binary);
                    System.out.println("\t\t\t\t\t" + "Octal       = " + octal);
                    System.out.println("\t\t\t\t\t" + "Decimal     = " + decimal);
                    System.out.println("\t\t\t\t\t" + "HexaDecimal = " + hexaDecimal + '\n');
                    break;
                    
                case 2:
                    System.out.println("\t\t\t\t\tEnter A Octal Number:");
                    octal = scan.next();
                    binary = obj.octalToBinary(octal);
                    decimal = obj.octalToDecimal(octal);
                    hexaDecimal = obj.octalToHexadecimal(octal);
                    System.out.println("\t\t\t\t\t" + "Octal       = " + octal);
                    System.out.println("\t\t\t\t\t" + "Binary      = " + binary);
                    System.out.println("\t\t\t\t\t" + "Decimal     = " + decimal);
                    System.out.println("\t\t\t\t\t" + "HexaDecimal = " + hexaDecimal + '\n');
                    break;
                    
                case 3:
                    System.out.println("\t\t\t\t\tEnter A Decimal Number:");
                    decimal = scan.next();
                    binary = obj.decimalToBinary(decimal);
                    octal =  obj.decimalToOctal(decimal);
                    hexaDecimal = obj.decimalToHexadecimal(decimal);
                    System.out.println("\t\t\t\t\t" + "Decimal     = " + decimal);
                    System.out.println("\t\t\t\t\t" + "Binary      = " + binary);
                    System.out.println("\t\t\t\t\t" + "Octal       = " + octal);
                    System.out.println("\t\t\t\t\t" + "HexaDecimal = " + hexaDecimal + '\n');
                    break;
                    
                case 4:
                    System.out.println("\t\t\t\t\tEnter A HexaDecimal Number:");
                    hexaDecimal = scan.next();
                    binary = obj.hexadecimalToBinary(hexaDecimal);
                    octal = obj.hexadecimalToOctal(hexaDecimal);
                    decimal = obj.hexadecimalToDecimal(hexaDecimal);
                    System.out.println("\t\t\t\t\t" + "HexaDecimal = " + hexaDecimal);
                    System.out.println("\t\t\t\t\t" + "Binary      = " + binary);
                    System.out.println("\t\t\t\t\t" + "Octal       = " + octal);
                    System.out.println("\t\t\t\t\t" + "Decimal     = " + decimal + '\n');
                    break;
             
                case 0:
                    return;
                
                default:
                    System.out.println("\n\t\t\t\t\tWrong Option!! Choose Correct One.\n");
            }
        }
    }
    
    private void expressionConverter() {
        while(true) {
            System.out.println("\t\t\t\t\tChosse A Option(Arithmetic Expression Converter Mode):");
            System.out.println("\t\t\t\t\tPress 1 For Converting Prefix To Others:");
            System.out.println("\t\t\t\t\tPress 2 For Converting Infix To Others:");
            System.out.println("\t\t\t\t\tPress 3 For Converting Postfix To Others:");
            System.out.println("\t\t\t\t\tPress 0 For Go Back:");
            
            int option = scan.nextInt();
            ExpressionConverter obj = new ExpressionConverter();
            String prefix, infix, postfix;
            
            //bcz below takes nextLine
            scan.nextLine();
            
            switch(option) {
                case 1:
                    System.out.println("\t\t\t\t\tEnter A Prefix Expression:");
                    prefix = scan.nextLine();
                    prefix = prefix.replaceAll("\\s", "");
                    infix = obj.prefixToInfix(prefix);
                    postfix = obj.prefixToPostfix(prefix);
                    System.out.println("\t\t\t\t\t" + "Prefix      = " + prefix);
                    System.out.println("\t\t\t\t\t" + "Infix       = " + infix);
                    System.out.println("\t\t\t\t\t" + "Postfix     = " + postfix + '\n');
                    break;
                    
                case 2:
                    System.out.println("\t\t\t\t\tEnter A Infix Expression:");
                    infix = scan.nextLine();
                    infix = infix.replaceAll("\\s", "");
                    prefix = obj.infixToPrefix(infix);
                    postfix = obj.infixToPostfix(infix);
                    System.out.println("\t\t\t\t\t" + "Infix       = " + infix);
                    System.out.println("\t\t\t\t\t" + "Prefix      = " + prefix);
                    System.out.println("\t\t\t\t\t" + "Postfix     = " + postfix + '\n');
                    break;
                    
                case 3:
                    System.out.println("\t\t\t\t\tEnter A Postfix Expression:");
                    postfix = scan.nextLine();
                    postfix = postfix.replaceAll("\\s", "");
                    prefix = obj.postfixToPrefix(postfix);
                    infix = obj.postfixToInfix(postfix);
                    System.out.println("\t\t\t\t\t" + "Postfix     = " + postfix);
                    System.out.println("\t\t\t\t\t" + "Prefix      = " + prefix);
                    System.out.println("\t\t\t\t\t" + "Infix       = " + infix + '\n');
                    break;
                    
                case 0:
                    return;
                    
                default:
                   System.out.println("\n\t\t\t\t\tWrong Option!! Choose Correct One.\n"); 
            }
        }
    }
    
    private void basic() {
        while(true) {
            System.out.println("\t\t\t\t\tChosse A Option(Basic Mode):");
            System.out.println("\t\t\t\t\tEnter An Arithmetic Expression To Calculate:");
            System.out.println("\t\t\t\t\tEnter 0 For Go To Main Menu:");
            
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
            switch (option) {
                case 1:
                    numberConverter();
                    break;
                    
                case 2:
                    expressionConverter();
                    break;
                    
                case 0:
                    return;
                    
                default:
                    System.out.println("\n\t\t\t\t\tWrong Option!! Choose Correct One.\n");
                    break;
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