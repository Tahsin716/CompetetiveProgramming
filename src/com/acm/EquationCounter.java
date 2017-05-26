package com.acm;

import java.io.*;
import java.util.StringTokenizer;

public class EquationCounter {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        char[] input = bufferedReader.readLine().toCharArray();

        int variableCounter = 0, constantCounter = 0, operatorCounter = 0;

        for(int i = 0; i < input.length; i++) {

            if(Character.isLetter(input[i])) {
                ++variableCounter;
                ++i;

                while(Character.isLetter(input[i])) {
                    ++i;
                }

                if(isOperator(input[i]))
                    ++operatorCounter;
            }
            else if(Character.isDigit(input[i])) {
                ++constantCounter;
                ++i;

                while(Character.isDigit(input[i])) {
                    ++i;
                }

                if(isOperator(input[i]))
                    ++operatorCounter;
            }
            else if(isOperator(input[i])) {
                ++operatorCounter;
            }


        }

        printWriter.printf("Variables: %d%nConstants: %d%nOperators: %d%n", variableCounter, constantCounter, operatorCounter);
        printWriter.flush();

    }

    static boolean isOperator(char c) {
        boolean flag = false;

        switch (c) {
            case '+':
                flag = true;
                break;
            case '-':
                flag = true;
                break;
            case '*':
                flag = true;
                break;
            case '/':
                flag = true;
                break;
            case '%':
                flag = true;
                break;
            case '=':
                flag = true;
                break;

        }

        return flag;
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

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return stringTokenizer.nextToken();
    }
}
