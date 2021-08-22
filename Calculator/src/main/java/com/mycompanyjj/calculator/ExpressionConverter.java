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
public class ExpressionConverter {
    
    public ExpressionConverter() {
        
    }
    
    private boolean isOperand(char ch) {
        if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean isOperator(char ch) {
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
            return true;
        }
        else {
            return false;
        }
    }
    
    private int precedence(char ch) {
        switch(ch) {
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
    
    private String reverseExpression(String expression) {
        char string[] = expression.toCharArray();

        for(int i = 0, j = string.length-1;  i < j;  i++, j--) {
            char temp = string[j];
            string[j] = string[i];
            string[i] = temp;
        }
        
        for(int i = 0; i < string.length; i++) {
            if(string[i] == '(') {
                string[i] = ')';
            }
            else if(string[i] == ')'){
                string[i] = '(';
            }
        }

        return String.valueOf(string);
    }
    
    public String infixToPostfix(String infix) {
        String postfix = "";
        MyStack<Character> operators = new MyStack<>();
        
        for(int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            
            if(isOperand(ch)) {
                postfix += ch;
            } 
            else if(ch == '(') {
                operators.push(ch);
            }
            else if(ch == ')') {
                while(!operators.isEmpty() && operators.top() != '(') {
                    postfix += operators.pop();
                }
                
                if(operators.top() == '(') {
                    operators.pop();
                }
            }
            else if(isOperator(ch)) {
                while(operators.size() > 0 && operators.top() != '(' 
                    && precedence(ch) <= precedence(operators.top())) {
                    postfix += operators.pop();
                }
                
                operators.push(ch);
            }
        }
        
        while(operators.size() > 0) {
            postfix += operators.pop();
        }
        
        return postfix;
    }
        
    public String infixToPrefix(String infix) {
        MyStack<String> prefix = new MyStack<>();
        MyStack<Character> operators = new MyStack<>();
        
        for(int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            
            if(ch == '(') {
                operators.push(ch);
            }
            else if(isOperand(ch)) {
                prefix.push(ch + "");
                //postfix.push(ch + "");
            }
            else if(ch == ')') {
                while(!operators.isEmpty() &&  operators.top() != '(') {
                    char operator = operators.pop();
                    
                    String b = prefix.pop();
                    String a = prefix.pop();
                    prefix.push(operator + a + b);
                    
                    //String b1 = postfix.pop();
                    //String a2 = postfix.pop();
                    //prefix.push(a1 + b1 +operator);
                }
                
                if(operators.top() == '(') {
                    operators.pop();
                }
            }
            else if(isOperator(ch)) {
                while(operators.size() > 0 && operators.top() != '(' 
                    && precedence(ch) <= precedence(operators.top())) {
                    char operator = operators.pop();
                    
                    String b = prefix.pop();
                    String a = prefix.pop();
                    prefix.push(operator + a + b);
                }
                
                operators.push(ch);
            }
        }
        
        while(operators.size() > 0) {
            char operator = operators.pop();
                    
            String b = prefix.pop();
            String a = prefix.pop();
            prefix.push(operator + a + b);
        }
        
        return prefix.pop();
    }
    
    public String postfixToInfix(String postfix) {
        MyStack<String> operands = new MyStack<>();
        
        for(int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            
            if(isOperand(ch)) {
                operands.push(ch + "");
            }
            else if(isOperator(ch)) {
                String b = operands.pop();
                String a = operands.pop();
                operands.push("(" + a + ch + b + ")");
            }
        }
        
        return operands.pop();
    }
}
