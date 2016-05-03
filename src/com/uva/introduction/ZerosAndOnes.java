package com.uva.introduction;

//Uva- 10324

import java.io.*;
import java.util.StringTokenizer;

public class ZerosAndOnes {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        String str;
        char temp;
        int i, j, max, min, testCase, count = 1;
        boolean flag;

        while(true) {

            str = nextLine();
            if(str == null || str.isEmpty())
                break;

            testCase = nextInt();

            printWriter.println("Case " + count + ":");

            count++;

            for(int m = 0; m < testCase; m++) {

                i = nextInt();
                j = nextInt();
                flag = true;

                min = Math.min(i,j);
                max = Math.max(i,j);
                temp = str.charAt(min);

                for(int k = min; k <= max; k++) {
                    if(str.charAt(k) != temp) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    printWriter.println("Yes");
                }
                else {
                    printWriter.println("No");
                }
            }
        }
    }


    public static void main(String[] args) {

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printWriter = new PrintWriter(System.out);
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
