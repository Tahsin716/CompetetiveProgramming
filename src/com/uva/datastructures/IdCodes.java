package com.uva.datastructures;

//Uva- 146

import java.io.*;
import java.util.StringTokenizer;

public class IdCodes {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        String str;

        while(true) {

            str = nextLine();
            if(str.equals("#"))
                break;

            boolean flag = false;

            int arr[] = new int[str.length()];
            for(int i = 0; i < arr.length; i++)
                arr[i] = str.charAt(i) - 'a';

            while (nextPermutation(arr)) {
                flag = true;

                for(int i = 0; i < arr.length; i++) {
                    printWriter.print( (char)(arr[i]+'a') );
                    printWriter.flush();
                }
                printWriter.println();
                printWriter.flush();

                break;
            }

            if(!flag) {
                printWriter.println("No Successor");
                printWriter.flush();
            }
        }


    }

    static boolean nextPermutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a) {
            if (p[a] < p[a + 1]) {
                for (int b = p.length - 1;; --b) {
                    if (p[b] > p[a]) {
                        p[a] = p[a]^p[b];
                        p[b] = p[b]^p[a];
                        p[a] = p[a]^p[b];
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            p[a] = p[a]^p[b];
                            p[b] = p[b]^p[a];
                            p[a] = p[a]^p[b];
                        }
                        return true;
                    }
                }
            }
        }
        return false;
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

    static String nextLine() throws IOException {
        String str;
        str = bufferedReader.readLine();
        return str;
    }
}
