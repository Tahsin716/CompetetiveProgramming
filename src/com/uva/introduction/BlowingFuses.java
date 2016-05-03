package com.uva.introduction;

//Uva- 661

import java.io.*;
import java.util.StringTokenizer;

public class BlowingFuses {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int numDevice, numOperation, fuseCapacity, count = 1;
        String str;
        String[] temp;

        while(true) {

            str = nextLine();
            if(str.equals("0 0 0"))
                break;

            temp = str.split(" ");
            numDevice = Integer.parseInt(temp[0]);
            numOperation = Integer.parseInt(temp[1]);
            fuseCapacity = Integer.parseInt(temp[2]);

            int[] consumption = new int[numDevice];
            boolean[] flag = new boolean[numDevice];
            int amperes = 0, operation, maxAmpere = 0;

            for(int i = 0; i < numDevice; i++) {
                consumption[i] = nextInt();
            }

            //main calculation
            for(int i = 0; i < numOperation; i++) {
                operation = nextInt();

                if(!flag[operation - 1]) {
                    amperes += consumption[operation - 1];
                    flag[operation -1] = true;
                }
                else {
                    amperes -= consumption[operation -1];
                    flag[operation -1] = false;
                }

                maxAmpere = Math.max(maxAmpere, amperes);
            }

            printWriter.println("Sequence " + count);
            printWriter.flush();
            count++;

            if(maxAmpere > fuseCapacity) {
                printWriter.println("Fuse was blown.");
                printWriter.flush();
            }
            else {
                printWriter.println("Fuse was not blown.");
                printWriter.flush();
                printWriter.println("Maximal power consumption was " + maxAmpere + " amperes.");
                printWriter.flush();
            }

            //print newline after each test case
            printWriter.println();
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