package com.uva.introduction;

//Uva- 11764

import java.io.*;
import java.util.StringTokenizer;

public class JumpingMario {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, highJump, lowJump, wallCount, height, temp = 0, count = 1;

        testCase = nextInt();

        for(int i = 0; i < testCase; i++) {

            wallCount =nextInt();
            highJump = lowJump = 0;

            for(int j = 0; j < wallCount; j++) {

                height = nextInt();

                if(j == 0)
                    temp = height;
                else {

                    if(height > temp)
                        highJump++;
                    else if(height < temp)
                        lowJump++;

                    temp = height;
                }
            }

            printWriter.println("Case " + count +": " + highJump + " " + lowJump);
            printWriter.flush();
            count++;
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

}
