/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompanyjj.calculator;

import mylibrary.MyStack;

/**
 *
 * @author jubaer
 */
public class ExpressionConverter {
    
    public ExpressionConverter() {
        
    }
    
    private boolean isOperand(char ch) {
        return (ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9');
    }
    
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
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
                    
                    String operand2 = prefix.pop();
                    String operand1 = prefix.pop();
                    prefix.push(operator + operand1 + operand2);
                    
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
                    
                    String operand2 = prefix.pop();
                    String operand1 = prefix.pop();
                    prefix.push(operator + operand1 + operand2);
                }
                
                operators.push(ch);
            }
        }
        
        while(operators.size() > 0) {
            char operator = operators.pop();
                    
            String operand2 = prefix.pop();
            String operand1 = prefix.pop();
            prefix.push(operator + operand1 + operand2);
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
                String operand2 = operands.pop();
                String operand1 = operands.pop();
                operands.push("(" + operand1 + ch + operand2 + ")");
            }
        }
        
        return operands.pop();
    }
    
    public String prefixToInfix(String prefix) {
        MyStack<String> operands = new MyStack<>();
        
        for(int i = prefix.length()-1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            
            if(isOperand(ch)) {
                operands.push(ch + "");
            }
            else if(isOperator(ch)) {
                //for postfix to infix
                //String operand2 = operands.pop();
                //String operand1 = operands.pop();
                String operand1 = operands.pop();
                String operand2 = operands.pop();
                operands.push("(" + operand1 + ch + operand2 + ")");
            }
        }
        
        return operands.pop();
    }
    
    public String postfixToPrefix(String postfix) {
        MyStack<String> operands = new MyStack<>();
        
        for(int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            
            if(isOperand(ch)) {
                operands.push(ch + "");
            }
            else if(isOperator(ch)) {
                String operand2 = operands.pop();
                String operand1 = operands.pop();
                operands.push(ch + operand1 + operand2);
            }
        }
        
        return operands.pop();
    }
    
    public String prefixToPostfix(String prefix) {
        MyStack<String> operands = new MyStack<>();
        
        for(int i = prefix.length()-1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            
            if(isOperand(ch)) {
                operands.push(ch + "");
            }
            else if(isOperator(ch)) {
                String operand1 = operands.pop();
                String operand2 = operands.pop();
                operands.push(operand1 + operand2 + ch);
            }
        }
        
        return operands.pop();
    }
}
