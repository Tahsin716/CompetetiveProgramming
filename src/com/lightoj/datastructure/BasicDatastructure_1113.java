package com.lightoj.datastructure;

import java.io.*;
import java.util.StringTokenizer;

public class BasicDatastructure_1113 {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, position, stackTop, index = 0;
        final int NAVIGATING_COMMAND_LENGTH = 7;

        StringBuilder stringBuilder = new StringBuilder();
        String[] urls;
        String input;

        testCase = nextInt();
        while (testCase-- > 0) {
            urls = new String[105];
            urls[0] = "http://www.lightoj.com/";

            position = 0;
            stackTop = 0;
            ++index;

            stringBuilder.append(String.format("Case %d:\n", index));
            while (true) {

                input = bufferedReader.readLine();

                if (input.length() > NAVIGATING_COMMAND_LENGTH) {
                    ++position;
                    stackTop = position;

                    urls[position] = input.substring(6, input.length());
                    stringBuilder.append(urls[position] + "\n");
                }
                else if (input.equals("BACK")) {
                    --position;

                    if(position == -1) {
                        position = 0;
                        stringBuilder.append("Ignored\n");
                    }
                    else
                        stringBuilder.append(urls[position] + "\n");
                }
                else if (input.equals("FORWARD")) {
                    ++position;

                    if (position > stackTop) {
                        stringBuilder.append("Ignored\n");
                        --position;
                    }
                    else
                        stringBuilder.append(urls[position] + "\n");

                }
                else if (input.equals("QUIT"))
                    break;

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
