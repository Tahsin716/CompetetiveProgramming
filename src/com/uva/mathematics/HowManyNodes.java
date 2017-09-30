package com.uva.mathematics;

// Uva - 10223

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class HowManyNodes {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static HashMap<Long,Integer> map;

    static void solve() throws Exception {
        map = new HashMap<Long, Integer>();
        fillMap();

        String str;
        String[] input;
        long number;

        while ( (str = bufferedReader.readLine()) != null ) {
            input = str.split(" ");
            number = Long.parseLong(input[0]);

            printWriter.println(map.get(number));
        }
        printWriter.flush();
    }

    static void fillMap() {
        long[] temp = new long[20];
        temp[0] = 1;

        for(int i = 1; i < 20 ; i++) {
            temp[i] = (temp[i-1] * (4*(i-1) + 2)) / ((i-1) + 2);
            map.put(temp[i],i);
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
