package com.uva.datastructures;

//Uva- 12541

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Birthdates {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase;
        String str;
        String[] temp;

        testCase = nextInt();
        ArrayList<Birth> births = new ArrayList<Birth>();

        for(int i = 0; i < testCase; i++) {

            str = bufferedReader.readLine();
            temp = str.split(" ");
            str = temp[0];
            int day = Integer.parseInt(temp[1]);
            int month = Integer.parseInt(temp[2]);
            int year = Integer.parseInt(temp[3]);

            births.add(new Birth(str, day, month, year));
        }

        Collections.sort(births);
        printWriter.printf("%s%n%s%n", births.get(0).getName(), births.get(testCase-1).getName());
        printWriter.flush();
    }

    static class Birth implements Comparable<Birth> {

        String name;
        int date, month, year;
        public Birth(String name, int date, int month, int year) {
            this.name = name;
            this.date = date;
            this.month = month;
            this.year = year;
        }


        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Birth o) {

            if(this.year > o.year) return -1;
            else if(this.year < o.year) return 1;
            else  {
                if(this.month > o.month) return -1;
                else if(this.month < o.month) return 1;
                else {
                    if(this.date > o.date) return -1;
                    else return 1;
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

}
