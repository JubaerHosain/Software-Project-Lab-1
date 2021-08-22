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
    
    private boolean isOperand(char ch){
        if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')){
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean isOperator(char ch){
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'){
            return true;
        }
        else {
            return false;
        }
    }
    
    private int precedence(char ch){
        switch(ch)
        {
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
}
