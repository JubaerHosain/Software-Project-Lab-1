/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompanyjj.calculator;

import MyLibrary.MyStack;

/**
 *
 * @author jubaer
 */
public class InfixEvaluation {
    
    public InfixEvaluation() {
        
    }
    
    private boolean isDigit(char digit){
        if( digit >= '0' && digit <= '9' ){
            return true;
        } else {
            return false;
        }
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
    
    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
                
            case '*':
            case '/':
                return 2;
                
            case '^':
                return 3;
                
            default:
                return -1;
        }
    }
    
    private double operation(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
                 
            case '-':
                return a - b;
                
            case '*':
                return a * b;
            
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
                
            case '^':
                return Math.pow(a, b);
                
            default:
                return 0;
        }
    }
    
    
    public double evaluate(String input) {
        MyStack<Double> numbers = new MyStack<>();
        MyStack<Character> operators = new MyStack<>();
        
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            
            if(i == 0 && ch == '-') {
                i++;
                String add = "";
                
                ch = input.charAt(i);
                while(isDigit(ch) || ch == '.') {
                    add += ch;
                    i++;
                    if(i < input.length()) {
                        ch = input.charAt(i);
                    } else {
                        break;
                    }
                }
                
                i--;
                numbers.push(-Double.parseDouble(add));
                
            } else if(ch == '(') {
                if(input.charAt(i+1) == '-') {
                    i += 2;
                    String add = "";

                    ch = input.charAt(i);
                    while(isDigit(ch) || ch == '.') {
                        add += ch;
                        i++;
                        if(i < input.length()) {
                            ch = input.charAt(i);
                        } else {
                            break;
                        }
                    }

                    //i--;
                    numbers.push(-Double.parseDouble(add));
                } else {
                    operators.push(ch);
                }
                
            } else if(isDigit(ch)) {
                String add = "";
                
                while(isDigit(ch) || ch == '.') {
                    add += ch;
                    i++;
                    if(i < input.length()) {
                        ch = input.charAt(i);
                    } else {
                        break;
                    }
                }
                
                i--;
                numbers.push(Double.parseDouble(add));
                
            } else if(ch == ')') {
                while(operators.top() != '(') {
                    char operator = operators.pop();
                    double b = numbers.pop();
                    double a = numbers.pop();
                    
                    double result = operation(a, b, operator);
                    numbers.push(result);
                }
                
                operators.pop();
                
            } else if(isOperator(ch)) {
                while(operators.size() > 0 && operators.top() != '(' 
                    && precedence(ch) <= precedence(operators.top())) {
                    char operator = operators.pop();
                    double b = numbers.pop();
                    double a = numbers.pop();
                    
                    double result = operation(a, b, operator);
                    numbers.push(result);
                }
                
                operators.push(ch);
            }
        }
        
        while(operators.size() >  0) {
            char operator = operators.pop();
            double b = numbers.pop();
            double a = numbers.pop();

            double result = operation(a, b, operator);
            numbers.push(result);
        }
        
        return numbers.pop();
    }
}



























