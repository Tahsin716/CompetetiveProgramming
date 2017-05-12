package com.codeforce.div2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_LuxuriousHouses {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int houses = nextInt();
        int max;
        int[] floors = new int[houses + 5];

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        for(int i = 0; i < houses; i++)
            floors[i] = nextInt();

        max = floors[houses - 1];

        for(int i = houses - 2; i >= 0; i--) {
            if(floors[i] < max) {
                stack.push(max - floors[i] + 1);
            }
            else if(floors[i] == max) {
                stack.push(1);
            }
            else {
                stack.push(0);
                max = floors[i];
            }
        }

        while (!stack.empty()) {
            printWriter.print(stack.pop() + " ");
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

    static long nextLong() throws Exception {
        return Long.parseLong( next() );
    }
}
