package com.uva.introduction;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WhatsTheFrequencyKenneth {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String temp;
        while((temp = bufferedReader.readLine()) != null) {
            int max = 0, current;
            char tmp;
            Map<Character, Integer> map = new TreeMap<Character, Integer>();

            for(int i = 0; i < temp.length(); i++) {
                tmp = temp.charAt(i);

                if((tmp >= 'A' && tmp <= 'Z') || (tmp >= 'a' && tmp <= 'z')) {
                    if(!map.containsKey(tmp)) {
                        map.put(tmp, 1);
                    }
                    else {
                        current = map.get(tmp) + 1;
                        map.put(tmp, current);
                    }
                    current = map.get(tmp);
                    max = (max < current) ? current : max;
                }
            }

            for(Map.Entry<Character,Integer> mapEntry : map.entrySet()) {
                if(mapEntry.getValue() == max)
                    printWriter.printf("%s", mapEntry.getKey());
            }
            printWriter.printf(" %d%n", max);
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
