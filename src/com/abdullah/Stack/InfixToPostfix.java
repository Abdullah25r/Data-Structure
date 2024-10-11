package com.abdullah.Stack;

import java.util.Stack;

public class InfixToPostfix {
    StringBuilder output = new StringBuilder();
    Stack<Character> operators = new Stack<Character>();
    public String infixToPostfix(String str) {
        for (int i = 0; i < str.length(); i++) {
           char ch = str.charAt(i);
           if(Character.isLetterOrDigit(ch)){
               output.append(ch);
           }
           if(ch == '('){
               operators.push(ch);
           }
           if(ch == ')'){
               while(!operators.isEmpty() && operators.peek() != '('){
                   output.append(operators.pop());
               }
               operators.pop();
           }
           if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
               while(!operators.isEmpty() && precedence(ch) >= precedence(operators.peek())){
                   output.append(operators.pop());
               }
               operators.push(ch);
           }
           while(!operators.isEmpty()){
               output.append(operators.pop());
           }









        }
        return output.toString();
    }
    public int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }
}
