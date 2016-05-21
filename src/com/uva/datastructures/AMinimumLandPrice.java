package com.uva.datastructures;

//Uva- 11824

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class AMinimumLandPrice {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int testCase = nextInt();

        for(int i = 0; i < testCase; i++) {
            int temp;
            ArrayList<Integer> landPrices = new ArrayList<Integer>();

            while( (temp = nextInt()) != 0)
                landPrices.add(temp);

            Collections.sort(landPrices, Collections.<Integer>reverseOrder());

            double tempPrice;
            long price = 0;
            int j = 1;

            for (Integer landPrice : landPrices) {
                tempPrice = (long) (2 * Math.pow(landPrice, j));
                price += tempPrice;
                if (price > 5000000)
                    break;
                j++;
            }

            if(price > 5000000) {
                printWriter.println("Too expensive");
            }
            else {
                printWriter.println(price);
            }
        }
        printWriter.flush();
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
