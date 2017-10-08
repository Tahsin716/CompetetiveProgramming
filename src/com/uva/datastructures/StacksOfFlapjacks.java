package com.uva.datastructures;

// Uva - 120

import java.io.*;
import java.util.StringTokenizer;

public class StacksOfFlapjacks {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        StringBuilder stringBuilder = new StringBuilder();
        String input;
        StringTokenizer stringTokenizer;
        int position, maximum, maximumPosition, reverseTemp;

        while ((input = bufferedReader.readLine()) != null) {

            stringTokenizer = new StringTokenizer(input);
            int tokenLength = stringTokenizer.countTokens();
            int[] elements = new int[tokenLength];

            for (int i = 0; i < tokenLength; i++) {
                stringBuilder.append(
                        elements[i] = Integer.parseInt(stringTokenizer.nextToken()) ).append((i == tokenLength -1)? "\n" : " ");
            }

            position = tokenLength - 1;
            while (position > 0) {

                maximum = 0; maximumPosition = -1;
                for (int i = 0; i < position; i++) {
                    if (elements[i] > maximum)
                        maximum = elements[maximumPosition = i];
                }

                if (elements[position] < maximum) {

                    if (maximumPosition != 0) {
                        stringBuilder.append(tokenLength - maximumPosition + " ");

                        for (int i = 0, j = maximumPosition; i < j; i++, j--) {
                            reverseTemp = elements[i];
                            elements[i] = elements[j];
                            elements[j] = reverseTemp;
                        }

                    }

                    stringBuilder.append(tokenLength - position + " ");
                    for (int i = 0, j = position; i < j; i++, j--) {
                        reverseTemp = elements[i];
                        elements[i] = elements[j];
                        elements[j] = reverseTemp;
                    }

                }
                position--;
            }
            stringBuilder.append("0\n");
        }
        printWriter.print(stringBuilder);
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
