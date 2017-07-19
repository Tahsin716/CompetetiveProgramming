import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

/**
 * Created by Tahsin Rashad on 7/20/2017.
 * ID: 1432020022
 */
public class InfixToPrefix {

    private static BufferedReader bufferedReader;
    private static PrintWriter printWriter;

    private static void solve() throws Exception {
        String input = bufferedReader.readLine();

        printWriter.printf("Infix Expression: %s%nPrefix Expression: %s%n", input, infixToPrefix(input));
        printWriter.flush();

    }

    private static String infixToPrefix(String input) {
        String temp;
        StringBuilder prefix = new StringBuilder(input);

        temp = prefix.reverse().toString();
        prefix = new StringBuilder();

        for(int i = 0; i < temp.length(); i++) {
            if(temp.charAt(i) == '(')
                prefix.append(')');

            else if(temp.charAt(i) == ')')
                prefix.append('(');
            else
                prefix.append(temp.charAt(i));
        }

        temp = infixToPostfix(prefix.toString());
        prefix = new StringBuilder(temp);

        return prefix.reverse().toString();
    }

    private static String infixToPostfix(String input) {
        StringBuilder postFix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {

            if(input.charAt(i) == ' ')
                continue;

            else if(isOperator(input.charAt(i))) {

                while(!stack.isEmpty() && stack.peek() != '(' && hasHigherPrecedence(stack.peek(), input.charAt(i))) {
                    postFix.append(stack.pop());
                }
                stack.push(input.charAt(i));
            }

            else if(isOperand(input.charAt(i))) {
                postFix.append(input.charAt(i));
            }

            else if(input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            }

            else if(input.charAt(i) == ')') {

                while(!stack.isEmpty() && stack.peek() != '(') {
                    postFix.append(stack.pop());
                }
                stack.pop();
            }
        }

        while(!stack.isEmpty()) {
            postFix.append(stack.pop());
        }

        return postFix.toString();
    }

    private static boolean isOperator(char C) {
        return C == '+' || C == '-' || C == '*' || C == '/' || C == '^';

    }

    private static boolean isOperand(char C) {
        return (C >= '0' && C <= '9') || (C >= 'a' && C <= 'z') || (C >= 'A' && C <= 'Z');

    }

    private static boolean hasHigherPrecedence(char operator1, char operator2) {
        int operatorPrecedence1 = getOperatorPrecedence(operator1);
        int operatorPrecedence2 = getOperatorPrecedence(operator2);

        if(operatorPrecedence1 == operatorPrecedence2) {
            if (isRightAssociative(operator1))
                return false;
            else
                return true;
        }
        return (operatorPrecedence1 > operatorPrecedence2);
    }

    private static int getOperatorPrecedence(char operator) {
        int precedence = 0;

        switch (operator) {
            case '+':
            case '-':
                precedence = 1;
                break;
            case '*':
            case '/':
                precedence = 2;
                break;
            case '^':
                precedence = 3;
                break;
        }

        return precedence;
    }

    private static boolean isRightAssociative(char operator) {
        return operator == '^';

    }

    public static void main(String[] args) {

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printWriter = new PrintWriter(new BufferedOutputStream(System.out));
            solve();
            bufferedReader.close();
            printWriter.close();
        }
        catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
