package com.uva.introduction;

//Uva- 119

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class GreedyGiftGivers {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int testCase;
        String str;
        boolean first = true;

        while(true) {

            str = nextLine();
            if(str == null || str.isEmpty())
                break;

            if(!first) {
                printWriter.println();
                printWriter.flush();
            }

            testCase = Integer.parseInt(str);
            String[] friends = new String[testCase];
            HashMap<String, Integer> map = new HashMap<String, Integer>();

            for(int i = 0; i < testCase; i++) {
                friends[i] = next();
                map.put(friends[i], i);
            }

            int money[] = new int[testCase];
            for(int i = 0; i < testCase; i++) {

                int index = map.get( next() );
                int gift = nextInt();
                int people = nextInt();

                if(people > 0) {

                    money[index] -= gift;
                    if((gift != 0) && (gift % people != 0)) {
                        int temp = gift % people;
                        money[index] += temp;
                        gift -= temp;
                    }
                    for(int j = 0; j < people; j++) {
                        money[map.get(next())] += gift/people;
                    }
                }
            }

            for(int i = 0; i < testCase; i++) {
                printWriter.println(friends[i] + " " + money[i]);
                printWriter.flush();
            }

            first = false;
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
