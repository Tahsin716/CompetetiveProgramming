package com.uva.datastructures;

//UVa- 11988

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BrokenKeyboard {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        String str;

        while( (str = bufferedReader.readLine()) != null && !(str.trim().isEmpty())) {

            char[] input = str.toCharArray();
            boolean begin = false;
            LinkedList<String> linkedList = new LinkedList<String>();
            StringBuilder stringBuilder = new StringBuilder();

            for(char stream: input) {

                if (stream == '[') {

                    if (begin)
                        linkedList.addFirst(stringBuilder.toString());
                    else
                        linkedList.addLast(stringBuilder.toString());

                    stringBuilder = new StringBuilder();
                    begin = true;

                } else if (stream == ']') {

                    if (begin)
                        linkedList.addFirst(stringBuilder.toString());
                    else
                        linkedList.addLast(stringBuilder.toString());

                    stringBuilder = new StringBuilder();
                    begin = false;

                } else {
                    stringBuilder.append(stream);
                }
            }

            if (begin)
                linkedList.addFirst(stringBuilder.toString());
            else
                linkedList.addLast(stringBuilder.toString());

            for(String string: linkedList) {
                printWriter.print(string);
            }
            printWriter.println();
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
