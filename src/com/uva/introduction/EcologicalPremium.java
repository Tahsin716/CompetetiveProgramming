package com.uva.introduction;

//Uva- 10300
//Note you don't need the number of animals, its just for distracting!

import java.io.*;
import java.util.StringTokenizer;

public class EcologicalPremium {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        int total, farmerNumber,eco, farmSize, animalNumber;

        for(int i = 0; i < testCase; i++) {

            farmerNumber = nextInt();
            total = 0;

            for(int j = 0; j < farmerNumber; j++) {

                farmSize = nextInt();
                animalNumber = nextInt();
                eco = nextInt();

                total += farmSize*eco;
            }
            printWriter.println(total);
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
