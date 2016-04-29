package com.uva.introduction;

//Uva- 11332

import java.io.*;
import java.util.StringTokenizer;

public class SummingDigits {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int number,ans;

        while(true) {

            number = nextInt();
            ans = 0;

            if(number == 0)
                return;

            while (true) {

                while (number != 0) {
                    ans += number%10;
                    number /= 10;
                }
                if(ans/10 == 0)  //if ans already summed to one integer
                    break;
                else {
                    number = ans; //if ans more than one integer
                    ans = 0;
                }
            }
            printWriter.println(ans);
            printWriter.flush();
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
}
