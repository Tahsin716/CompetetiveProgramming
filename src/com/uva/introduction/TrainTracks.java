package com.uva.introduction;

//Uva- 11586

import java.io.*;
import java.util.StringTokenizer;

public class TrainTracks {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int testCase = Integer.parseInt(bufferedReader.readLine().trim());

        for(int i = 0; i < testCase; i++) {

            int f,m;
            f = m = 0;
            String str  = bufferedReader.readLine().trim();
            StringTokenizer input = new StringTokenizer(str);
            String ans;

            while(input.hasMoreTokens()) {
                String piece = input.nextToken();

                if(piece.equals("MM"))
                    m+=2;
                else if(piece.equals("FF"))
                    f+=2;
                else {
                    m+=2;
                    f+=2;
                }
            }

            if(f==m && str.length() > 2)
                ans = "LOOP";
            else
                ans = "NO LOOP";

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
}
