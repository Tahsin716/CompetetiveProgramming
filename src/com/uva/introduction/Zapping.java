package com.uva.introduction;

//Uva- 12468

import java.io.*;
import java.util.StringTokenizer;

public class Zapping {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int a, b, clicks, ans, tmp;
        String str;
        String[] temp;

        while(true) {

            tmp = 1000;

            str = nextLine();
            if (str.equals("-1 -1"))
                break;

            temp = str.split(" ");
            a = Integer.parseInt(temp[0]);
            b = Integer.parseInt(temp[1]);


            clicks = Math.abs(b-a);

            if(clicks > 50)
                tmp = (b > a)? (99 - b + a + 1) : (99 - a + b + 1);

            ans = Math.min(clicks, tmp);

            printWriter.println(ans);
            printWriter.flush();
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

    static String nextLine() throws IOException {
        String str;
        str = bufferedReader.readLine();
        return str;
    }
}
