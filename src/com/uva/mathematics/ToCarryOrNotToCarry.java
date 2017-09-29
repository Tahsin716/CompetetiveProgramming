package com.uva.mathematics;

//Uva - 10469

import java.io.*;
import java.util.StringTokenizer;

public class ToCarryOrNotToCarry {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int firstNumber, secondNumber, ans, sum, carry;
        String input;
        String[] numbers;

        while ( (input = bufferedReader.readLine()) != null ) {
            numbers = input.split(" ");
            firstNumber = Integer.parseInt(numbers[0]);
            secondNumber = Integer.parseInt(numbers[1]);

            carry = firstNumber & secondNumber;
            sum = firstNumber ^ secondNumber;

            printWriter.println(sum);
        }
        printWriter.flush();
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
