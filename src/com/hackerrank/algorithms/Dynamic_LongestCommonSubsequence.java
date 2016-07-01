package com.hackerrank.algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Dynamic_LongestCommonSubsequence {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int N = nextInt();
        int M = nextInt();

        String[] string1 = bufferedReader.readLine().split(" ");
        String[] string2 = bufferedReader.readLine().split(" ");
        ArrayList<String> ans = LCS_String(string1, string2);

        for(String answer: ans)
            printWriter.print(answer +" ");

        printWriter.flush();
    }


    public static void main(String[] args) {

        try {

            //bufferedReader = new BufferedReader(new FileReader("input.txt"));
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

    static ArrayList<String> LCS_String(String[] string1, String[] string2) {

        int len1 = string1.length, len2 = string2.length;
        int[][] temp = new int[len1+1][len2+1];

        for(int i = 0; i <= len1; i++) {
            for(int j = 0; j <= len2; j++) {

                if(i == 0 || j == 0) {
                    temp[i][j] = 0;
                }
                else if (string1[i - 1].equals(string2[j - 1])) {
                    temp[i][j] = temp[i-1][j-1] + 1;
                }
                else {
                    temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]);
                }
            }
        }

        ArrayList<String> result = new ArrayList<String>();
        int i = len1, j = len2;

        while(i > 0 && j > 0) {

            if(string1[i-1].equals(string2[j-1])) {
                result.add(string1[i-1]);
                i--;
                j--;
            }
            else if(temp[i-1][j] > temp[i][j-1])
                i--;
            else
                j--;
        }

        Collections.reverse(result);

        return result;
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
