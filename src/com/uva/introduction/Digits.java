package com.uva.introduction;

//Uva- 11687

import java.io.*;
import java.util.StringTokenizer;

public class Digits {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        String str;

        while(true) {

            str = nextLine();
            int ans;
            if(str.equals("END"))
                break;
            else {
                ans = recurse(str);
            }

            printWriter.println(ans);
            printWriter.flush();
        }
    }

    static int recurse(String input) {
        int count = 1;
        int length = input.length();

        if((length +"").equals(input))
            return count;
        else
            return count + recurse(length +"");
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
