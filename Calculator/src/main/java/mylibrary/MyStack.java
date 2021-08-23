/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mylibrary;

import java.util.Objects;

/**
 *
 * @author jubaer
 * @param <T>
 */

public class MyStack<T> {
    private T stack[];
    private int top, MAX;

    public MyStack(){
        MAX = 200;
        top = -1;
        stack = (T[]) new Object[MAX];
    }

    public void push(T data){
         if(top <= MAX-1){
             stack[++top] = data;
         }
         else {
             System.out.println("Stack Overflow!");
             return;
         }
    }

    public T pop(){
        if(!isEmpty()) {
            top--;
            return stack[top+1];
        }
        else {
            System.out.println("Stack Underflow");
            return stack[0];
        }
    }

    public T top(){
        if(top > -1 && top <= MAX-1){
            return stack[top];
        }
        else {
            System.out.println("Stack Underflow");
            return stack[0];
        }
    }

    public boolean isEmpty(){
        if(top <= -1){
            return true;
        }
        else {
            return false;
        }
    }
    
    public int size() {
        return top+1;
    }
}

