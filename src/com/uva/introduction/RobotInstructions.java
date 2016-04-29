package com.uva.introduction;

//Uva- 12503

import java.io.*;
import java.util.StringTokenizer;

public class RobotInstructions {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase, instructionNum, position, tmp, tmp2;
        String str;

        testCase = nextInt();

        for(int i = 0; i < testCase; i++) {

            instructionNum = nextInt();
           int[] arr = new int[instructionNum];
            position = 0;

            for(int j = 0; j < instructionNum; j++) {

                str = nextLine();

                if(str.equals("LEFT")) {
                    arr[j] = -1;
                }
                else if(str.equals("RIGHT")) {
                    arr[j] = 1;
                }
                else {
                    tmp = str.lastIndexOf(' ');
                    tmp2 = Integer.parseInt(new String(str.substring( tmp + 1)));
                    arr[j] = arr[tmp2-1];
                }
                position += arr[j];
            }
            printWriter.println(position);
            printWriter.flush();
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
}
