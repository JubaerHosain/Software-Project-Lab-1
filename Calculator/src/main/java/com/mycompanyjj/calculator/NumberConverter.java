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
public class NumberConverter {
    
    public NumberConverter() {
        
    }
    
    public String reverseString(String string) {
        char array[] = string.toCharArray();

        for(int i = 0, j = array.length-1; i < j;  i++,j--) {
            char ch = array[i];
            array[i] = array[j];
            array[j] = ch;
        }
        
        string = String.valueOf(array);
        
        return string;
    }
    
    public String decimalToBinary(String decimalString) {
        String binary = "";
        long decimal = Long.valueOf(decimalString);

        while (decimal != 0) {
            binary += (decimal % 2);
            decimal /= 2;
        }

        binary = reverseString(binary);
        
        return binary;
    }
    
    public String decimalToOctal(String decimalString) {
        String octal = "";
        long decimal = Long.valueOf(decimalString);

        while (decimal != 0) {
            octal += (decimal % 8);
            decimal /= 8;
        }

        octal = reverseString(octal);
        
        return octal;
    }
    
    public String decimalToHexadecimal(String  decimalString) {
        String hexadecimal = "";
        long decimal = Long.valueOf(decimalString);
        char array[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while(decimal != 0) {                     
            long reminder =  decimal % 16;
            hexadecimal += array[(int)reminder];
            decimal /= 16;
        }

        hexadecimal = reverseString(hexadecimal);

        return hexadecimal;
    }
    
    public String binaryToDecimal(String binary) {
        char array[] = binary.toCharArray();
        
        int index = 0;
        long decimal = 0, pow;
        int exp = array.length- 1;

        while(exp >= 0) {
            int digit = array[index] - 48;
            pow = (long)Math.pow(2L, exp);
            decimal += digit * pow;
            exp--; index++;
        }
        
        return String.valueOf(decimal);
    }
    
    public String binaryToOctal(String binary) {
        String decimal = binaryToDecimal(binary);
        String octal = decimalToOctal(decimal);

        return octal;
    }
    
    public String binaryToHexadecimal(String binary) {
        String decimal = binaryToDecimal(binary);
        String Hexadecimal = decimalToHexadecimal(decimal);

        return Hexadecimal;
    }
    
    public String octalToDecimal(String octal) {
        char array[] = octal.toCharArray();
        
        int index = 0;
        long decimal = 0, pow;
        int exp = array.length- 1;

        while(exp >= 0) {
            int digit = array[index] - 48;
            pow = (long)Math.pow(8L, exp);
            decimal += digit * pow;
            exp--; index++;
        }
        
        return String.valueOf(decimal);
    }
    
    public String octalToBinary(String octal) {
        String decimal = octalToDecimal(octal);
        String binary = decimalToBinary(decimal);

        return binary;
    }

    public String octalToHexadecimal(String octal) {
        String decimal = octalToDecimal(octal);
        String Hexadecimal = decimalToHexadecimal(decimal);

        return Hexadecimal;
    }
    
    public String hexadecimalToDecimal(String hexadecimal) {
        char array[] = hexadecimal.toCharArray();
        
        int index = 0;
        long decimal = 0, pow;
        int exp = array.length- 1;

        while(exp >= 0) {
            int digit;
            
            switch(array[index]) {
                case 'A':
                    digit = 10;
                    break;
                case 'B':
                    digit = 11;
                    break;
                case 'C':
                    digit = 12;
                    break;
                case 'D':
                    digit = 13;
                    break;
                case 'E':
                    digit = 14;
                    break;
                case 'F':
                    digit = 15;
                    break;
                default:
                    digit = array[index] - 48;
                    break;
            }
            
            pow = (long)Math.pow(16L, exp);
            decimal += digit * pow;
            exp--; index++;
        }
        
        return String.valueOf(decimal);
    }
    
    public String hexadecimalToBinary(String hexadecimal) {
        String decimal = hexadecimalToDecimal(hexadecimal);
        String binary = decimalToBinary(decimal);

        return binary;
    }

    public String hexadecimalToOctal(String hexadecimal){
        String decimal = hexadecimalToDecimal(hexadecimal);
        String octal = decimalToOctal(decimal);

        return octal;
    }
}
