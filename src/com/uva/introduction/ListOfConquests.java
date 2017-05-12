package com.uva.introduction;

import java.io.*;
import java.util.*;

public class ListOfConquests {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        Map<String,Integer> map = new TreeMap<String, Integer>();
        String temp;
        String[] tmp;
        int current;

        for(int i = 0; i < testCase; i++) {
            temp = bufferedReader.readLine().replaceAll("\\s+", " ");

            if(temp.startsWith(" ")) {
                temp = temp.substring(1, temp.indexOf(" ", 1));
            }
            else {
                temp = temp.substring(0, temp.indexOf(" ", 1));
            }


            if(!map.containsKey(temp)) {
                map.put(temp, 1);
            }
            else {
                current = map.get(temp) + 1;
                map.put(temp, current);
            }
        }

        for(Map.Entry<String, Integer> mapEntry : map.entrySet()) {
            printWriter.printf("%s %d%n", mapEntry.getKey(), mapEntry.getValue());
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

    static long nextLong() throws Exception {
        return Long.parseLong( next() );
    }
}
