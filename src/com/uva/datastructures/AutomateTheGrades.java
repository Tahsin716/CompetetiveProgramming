package com.uva.datastructures;

//Uva- 11777

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AutomateTheGrades {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int testCase = nextInt();
        for(int i = 1; i <= testCase; i++) {

            int term1 = nextInt();
            int term2 = nextInt();
            int finalTest = nextInt();
            int attendance = nextInt();
            int[] test = new int[3];
            test[0] = nextInt();
            test[1] = nextInt();
            test[2] = nextInt();

            Arrays.sort(test);

            int total = term1+term2+finalTest+attendance+((test[1]+test[2])/2 );
            String ans = grades(total);
            printWriter.printf("Case %d: %s%n",i,ans);
        }
        printWriter.flush();
    }

     static String grades(int total) {

        if(total >= 90) return "A";
        else if(total >= 80) return "B";
        else if(total >= 70) return "C";
        else if(total >= 60) return "D";
        else return "F";
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
