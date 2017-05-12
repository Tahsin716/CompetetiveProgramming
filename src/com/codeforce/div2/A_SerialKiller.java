package com.codeforce.div2;


import java.io.*;
import java.util.StringTokenizer;

public class A_SerialKiller {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String[] temp = bufferedReader.readLine().split(" ");
        StringBuilder answer = new StringBuilder(temp[0] +" "+ temp[1] +"\n");
        String[] current = temp;

        int n = nextInt();
        for(int i = 0; i < n; i++) {
            temp = bufferedReader.readLine().split(" ");

            if(temp[0].equals(current[0])) {
                answer.append(temp[1] +" "+ current[1] +"\n");
                current[0] = temp[1];
            }
            else {
                answer.append(temp[1] + " " + current[0] + "\n");
                current[1] = temp[1];
            }
        }

        printWriter.print(answer);
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
