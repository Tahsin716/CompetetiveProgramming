package com.uva.datastructures;

//UVa- 10226

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class HardwoodSpecies {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int testCase = nextInt();
        bufferedReader.readLine();

        boolean first = true;
        while (testCase-- > 0) {

            int cnt = 0;
            Map<String, Count> map = new TreeMap<String, Count>();
            String str;

            while( ((str = bufferedReader.readLine()) != null) && !(str.trim().isEmpty()) ) {

                Count val = map.get(str);
                if(val == null) {
                    val = new Count();
                    map.put(str, val);
                }
                else  {
                    val.update();
                }
                cnt++;
            }

            if(first) first = false;
            else printWriter.println();

            for(String temp: map.keySet())
                printWriter.printf("%s %.4f%n", temp, 100* (double)map.get(temp).getValue() / (double)cnt);


        }

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
}
