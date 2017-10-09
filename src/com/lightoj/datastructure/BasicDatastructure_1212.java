package com.lightoj.datastructure;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BasicDatastructure_1212 {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, dequeSize, commandSize, index = 0, currentDequeSize;
        final int REMOVE_STRING_LENGTH = 8;

        Deque<String> deque;

        StringBuilder stringBuilder = new StringBuilder();
        String inputString;
        String[] inputData;

        testCase = nextInt();

        while (testCase-- > 0) {
            inputString = bufferedReader.readLine();
            inputData = inputString.split(" ");

            dequeSize = Integer.parseInt(inputData[0]);
            commandSize = Integer.parseInt(inputData[1]);
            deque = new ArrayDeque<String>();

            ++index;
            currentDequeSize = 0;
            stringBuilder.append(String.format("Case %d:\n", index));

            for (int i = 0; i < commandSize; i++) {

                inputString = bufferedReader.readLine();

                if (inputString.length() > REMOVE_STRING_LENGTH) {

                    inputData = inputString.split(" ");

                    if(inputData[0].equals("pushLeft") && currentDequeSize != dequeSize) {

                        deque.addFirst(inputData[1]);
                        currentDequeSize++;
                        stringBuilder.append(String.format("Pushed in left: %s\n", inputData[1]));
                    }
                    else if (inputData[0].equals("pushRight") && currentDequeSize != dequeSize) {

                        deque.addLast(inputData[1]);
                        currentDequeSize++;
                        stringBuilder.append(String.format("Pushed in right: %s\n", inputData[1]));

                    }
                    else {
                        stringBuilder.append("The queue is full\n");
                    }
                }
                else if (inputString.equals("popLeft")) {
                    if (currentDequeSize != 0) {

                        stringBuilder.append(String.format("Popped from left: %s\n", deque.removeFirst()));
                        currentDequeSize--;
                    }
                    else
                        stringBuilder.append("The queue is empty\n");
                }
                else if (inputString.equals("popRight")) {
                    if (currentDequeSize != 0) {

                        stringBuilder.append(String.format("Popped from right: %s\n", deque.removeLast()));
                        currentDequeSize--;
                    }
                    else
                        stringBuilder.append("The queue is empty\n");
                }

            }
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
