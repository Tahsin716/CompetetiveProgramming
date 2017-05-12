package com.acm;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BoxSorting {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        int cnt = 1;

        while(testCase-- > 0) {

            int n = nextInt();
            long x;
            int maxFrq = 0;
            Map<Long, Count> map = new TreeMap<Long, Count>();

            for(int i = 0; i < n; i++) {

                x = nextLong();
                Count val = map.get(x);
                if(val == null) {
                    val = new Count();
                    map.put(x, val);
                }
                else  {
                    val.update();
                }
            }

            for(Long temp: map.keySet()) {
                if(maxFrq < map.get(temp).getValue())
                    maxFrq = map.get(temp).getValue();
            }

            printWriter.printf("Case %d: %d%n", cnt, maxFrq);
            cnt++;
        }
        printWriter.flush();
    }

    static class Count {

        int value = 1;

        void update() { ++value; }
        int getValue() { return value; }
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
