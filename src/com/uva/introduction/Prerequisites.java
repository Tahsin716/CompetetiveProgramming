package com.uva.introduction;

//Uva- 10919

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Prerequisites {


    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int testCase, courseNum;
        int[] courses;

        while(true) {

            testCase = nextInt();
            if(testCase == 0)
                break;
            courseNum = nextInt();
            courses = new int[testCase];
            HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
            String ans = "yes";

            for(int i = 0; i < testCase; i++) {
                courses[i] = nextInt();
                hashMap.put(i,courses[i]);
            }

            boolean[] flag = new boolean[courseNum];

            for(int i = 0; i < courseNum; i++) {
                int subjects = nextInt();
                int minSub = nextInt();
                int k = 0;

                for(int j = 0; j < subjects; j++){
                    if(hashMap.containsValue(nextInt()))
                        k++;
                }

                if(k >= minSub) {
                    flag[i] = true;
                }
            }

            for(boolean count : flag) {
                if(count == false) {
                    ans = "no";
                    break;
                }
            }

            printWriter.println(ans);
            printWriter.flush();
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