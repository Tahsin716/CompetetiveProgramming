package com.uva.introduction;

//Uva- 11559
//taking input until EOF
//minCost

import java.io.*;
import java.util.StringTokenizer;

public class EventPlanning {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int number, budget, hotel, week, price, beds,minCost, minBeds;
        boolean flag;
        String str;

        while(true) {

            str = nextLine();

            if(str == null || str.isEmpty())
                break;

            String[] strTemp = str.split(" ");
            number = Integer.parseInt(strTemp[0]);
            budget = Integer.parseInt(strTemp[1]);
            hotel = Integer.parseInt(strTemp[2]);
            week = Integer.parseInt(strTemp[3]);
            minBeds = number;
            minCost = 10000000;
            flag = false;

            for (int i = 0; i < hotel; i++) {

                price = nextInt();

                for(int j = 0; j < week; j++) {

                    beds = nextInt();

                    if(beds >= minBeds)
                        flag = true;
                }

                if(flag == true)
                    minCost = Math.min(minCost,price*number);

                flag = false;
            }

            if(minCost != 10000000 && minCost <= budget) {
                printWriter.println(minCost);
                printWriter.flush();
            }
            else {
                printWriter.println("stay home");
                printWriter.flush();
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

    static String nextLine() throws IOException {
        String str;
        str = bufferedReader.readLine();
        return str;
    }
}
