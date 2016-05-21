package com.uva.datastructures;

//Uva- 11588

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ImageCoding {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        String str;
        String[] temp;

        for(int i = 1; i <= testCase; i++) {

            str = bufferedReader.readLine();
            temp = str.split(" ");

            int rows = Integer.parseInt(temp[0]);
            int columns = Integer.parseInt(temp[1]);
            int M = Integer.parseInt(temp[2]);
            int N = Integer.parseInt(temp[3]);
            int totalChar = rows*columns;
            char[] frequency = new char[26];


            for(int j = 0; j < rows; j++) {

                char[] arr;
                arr = bufferedReader.readLine().toCharArray();

                for(int k = 0; k < columns; k++)
                    frequency[ arr[k] - 'A']++;

            }

            Arrays.sort(frequency);
            int max = frequency[25];
            int maxTemp = 0;

            for(int j = 24; j >= 0; j--) {

                if(frequency[j] != max)
                    break;
                else
                    maxTemp += frequency[j];
            }

            max += maxTemp;
            int rest = totalChar - max;

            int sum = max*M + rest*N;

            printWriter.printf("Case %d: %d%n",i,sum);
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
