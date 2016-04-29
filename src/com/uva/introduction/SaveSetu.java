package com.uva.introduction;

//Uva- 12403

import java.io.*;
import java.util.StringTokenizer;

public class SaveSetu {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        String operation;
        int totalMoney = 0;

        for(int i = 0; i < testCase; i++) {

            operation = nextLine();

            if(operation.equals("report")) {
                printWriter.println(totalMoney);
                printWriter.flush();
            }
            else {

                totalMoney += Integer.parseInt(new String(operation.substring(7)));
            }
        }
    }

    public static void main(String[] args){

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
        String str = "";
        str = bufferedReader.readLine();
        return str;
    }
}
