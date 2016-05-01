package com.uva.introduction;

//Uva- 12554

import java.io.*;
import java.util.StringTokenizer;

public class ASpecialHappyBirthdaySong {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int testCase, count, k = 0;
        String str = "Happy birthday to you Happy birthday to you Happy birthday to Rujia Happy birthday to you";
        String[]temp = str.split(" ");


        testCase = nextInt();
        String[] people = new String[testCase+1];

        for(int i = 0; i < testCase; i++) {
            people[i] = nextLine();
        }

        //To check how many times the song has to be repeated, for the number of people
        if(testCase <= 16)
            count = 1;
        else if(testCase <= 32)
            count = 2;
        else if(testCase <= 48)
            count = 3;
        else if(testCase <= 64)
            count = 4;
        else if(testCase <= 80)
            count = 5;
        else
            count = 6;

        for(int i = 0; i < count; i++) {
            for(int j = 0; j < 16; j++) {
                printWriter.println(people[k%testCase] + ": " + temp[j]); //k modulo testCase to cycle between 0 - (testCase-1)
                printWriter.flush();
                k++;
            }
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
