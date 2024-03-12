package com.example.calculator;

/**
# For the following String expression, evaluate output a Float
#
# "1234" -> 1234.0
# "( + 1 2 )" -> 3.0
# "( + ( * ( / 2 1 ) 2 ) 2 )" -> 6.0
# "( - ( + 15 2 ) ( / ( * 2 2 ) 8 ) )" -> 16.5
# "(1234 + (1 + 2))" -> 1237

# ( + 1234 ( - 1 2 ) ) -> 1233
# The grammar for the language follows:
#
# Expr -> "[Int >= 0]"
# Expr -> "( Op Expr Expr )"
#
# Op -> { "+", "-", "*", "/" }

# Assume all inputs are valid; the following inputs are invalid:
# INVALID: "(+ 1 2)" (not properly spaced)
# INVALID: "( 12 )" (does not follow recursive case grammar)
# INVALID: "-12" (does not follow base case grammar)
# INVALID: "( / 1 0 )" (does not output valid result)
*/

import java.util.Stack;

public class CalculatorOperatorFirst {
    public static double evaluate(String expression) {
        // Create stacks to store operands and operators
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int i = 0;

        // Loop through the characters in the expression
        while (i < expression.length()) {
            char ch = expression.charAt(i);

            if (ch == ' ') {
                i++; // Skip whitespace
            } else if (Character.isDigit(ch) || (ch == '-' && (i == 0 || expression.charAt(i - 1) == '('))) {
                // Handle numeric values (including negative numbers)
                int j = i;
                while (j < expression.length() && (Character.isDigit(expression.charAt(j)) || expression.charAt(j) == '.')) {
                    j++;
                }
                double operand = Double.parseDouble(expression.substring(i, j));
                operandStack.push(operand);
                i = j; // Move the index past the processed number
            } else if (ch == '(') {
                operatorStack.push(ch); // Push an opening parenthesis onto the operator stack
                i++;
            } else if (ch == ')') {
                // Handle closing parenthesis
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    applyOperator(operandStack, operatorStack); // Process operators until an opening parenthesis is encountered
                }
                operatorStack.pop(); // Pop the '('
                i++;
            } else if (isOperator(ch)) {
                // Handle arithmetic operators (+, -, *, /)
                while (!operatorStack.isEmpty() && precedence(ch) <= precedence(operatorStack.peek())) {
                    applyOperator(operandStack, operatorStack); // Process operators with higher or equal precedence
                }
                operatorStack.push(ch); // Push the current operator onto the operator stack
                i++;
            } else {
                // Handle invalid characters in the expression
                throw new IllegalArgumentException("Invalid character in expression: " + ch);
            }
        }

        // Process any remaining operators
        while (!operatorStack.isEmpty()) {
            applyOperator(operandStack, operatorStack);
        }

        // Check if there is a single result on the operand stack
        if (operandStack.size() == 1) {
            return operandStack.pop();
        } else {
            // If there is more than one value on the operand stack, the expression is invalid
            throw new IllegalArgumentException("Invalid expression");
        }
    }

    // Helper method to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Helper method to determine the precedence of an operator
    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0; // Default precedence
    }

    // Helper method to apply an operator to the operand stack
    private static void applyOperator(Stack<Double> operandStack, Stack<Character> operatorStack) {
        char operator = operatorStack.pop();
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();
        double result = 0;

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = operand1 / operand2;
                break;
        }

        operandStack.push(result); // Push the result back onto the operand stack
    }

    public static void main(String[] args) {
        String[] expressions = {
            "1234",
            "( + 1 2 )",
            "( + ( * ( / 2 1 ) 2 ) 2 )",
            "( - ( + 15 2 ) ( / ( * 2 2 ) 8 ) )",
            "(1234 + (1 + 2))",
            "( + 1234 ( - 1 2 ) )"
        };

        for (String expression : expressions) {
            double result = evaluate(expression);
            System.out.println(expression + " -> " + result);
        }
    }
}
