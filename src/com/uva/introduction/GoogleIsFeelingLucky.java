package com.uva.introduction;

//Uva- 12015
//No need to loop till end of file

import java.io.*;
import java.util.StringTokenizer;


public class GoogleIsFeelingLucky {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, var;
        String str;
        String[] temp;
        int[] rank = new int[10];
        String[] url = new String[10];

        testCase = nextInt();

        for(int k = 1; k <= testCase; k++) {
            var = 0;

            for(int i = 0; i < 10; i++) {

                str = nextLine();
                temp = str.split(" ");
                url[i] = temp[0];
                rank[i] = Integer.parseInt(temp[1]);

                if(var < rank[i])
                    var = rank[i];
            }
            printWriter.println("Case #" + k + ":");
            printWriter.flush();

            for(int j = 0; j < 10; j++) {

                if(rank[j] == var) {
                    printWriter.println(url[j]);
                    printWriter.flush();
                }
            }
        }

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
