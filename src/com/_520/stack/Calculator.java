package com._520.stack;

import java.util.Stack;

/**
 *  逆波兰表达式求值
 *
 *  "2", "1", "+", "3", "*"
 */
public class Calculator {

    private int evalRPN(String[] tokens){

        int[] result = new int[tokens.length / 2 + 1];
        int index = 0;

        for (String token : tokens) {
            switch (token){
                case "+" :
                    result[index - 2] += result[--index];
                    break;
                case "-" :
                    result[index - 2] -= result[--index];
                    break;
                case "*" :
                    result[index - 2] *= result[--index];
                    break;
                case "/" :
                    result[index - 2] /= result[--index];
                    break;
                default:
                    result[index++] = Integer.parseInt(token);
                    break;
            }
        }
        return result[0];
    }

    private int evalRPN1(String[] tokens){

        Stack<String> number = new Stack<>();
        int val1 = 0;
        int val2 = 0;

        for (String token : tokens) {
            switch (token){
                case "+" :
                    val2 = Integer.parseInt(number.pop());
                    val1 = Integer.parseInt(number.pop());
                    number.push(String.valueOf(val1 + val2));
                    break;
                case "-" :
                    val2 = Integer.parseInt(number.pop());
                    val1 = Integer.parseInt(number.pop());
                    number.push(String.valueOf(val1 - val2));
                    break;
                case "*" :
                    val2 = Integer.parseInt(number.pop());
                    val1 = Integer.parseInt(number.pop());
                    number.push(String.valueOf(val1 * val2));
                    break;
                case "/" :
                    val2 = Integer.parseInt(number.pop());
                    val1 = Integer.parseInt(number.pop());
                    number.push(String.valueOf(val1 / val2));
                    break;
                default:
                    number.push(token);
                    break;
            }
        }
        return Integer.parseInt(number.pop());
    }
    public static void main(String[] args) {
        String[] ex = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Calculator().evalRPN1(ex));
    }
}
