package com.uva.datastructures;

//UVa- 514

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Rails {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String str;

        while( !(bufferedReader.readLine().equals("0")) ) {
            while(true) {

                str = bufferedReader.readLine();
                if(str.equals("0"))
                    break;

                String[] temp = str.split(" ");
                Stack<Integer> stack = new Stack<Integer>();

                int tempIndex = 0;
                for(int current = 1; current <= temp.length; current++) {

                    stack.push(current);

                    while(!stack.empty() && stack.peek() == Integer.parseInt(temp[tempIndex]) && tempIndex <= temp.length) {
                        stack.pop();
                        tempIndex++;
                    }
                }

                if(stack.empty())
                    printWriter.println("Yes");
                else
                    printWriter.println("No");

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
