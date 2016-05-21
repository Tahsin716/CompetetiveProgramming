package com.uva.datastructures;

//Uva- 11039

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Buildingdesigning {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int testCase, numFloors, temp, r, b, max, count;
        boolean rb;
        ArrayList<Integer> red, blue;
        testCase = nextInt();

        while(testCase-- > 0) {

            numFloors = nextInt();
            red = new ArrayList<Integer>();
            blue = new ArrayList<Integer>();

            r = -1;
            b = -1;

            for(int i = 0; i < numFloors; i++) {

                temp = nextInt();
                if(temp < 0)    red.add(-temp);
                else            blue.add(temp);
            }

            if(red.size() > 0) {
                Collections.sort(red);
                r = red.size() -1;
            }
            if(blue.size() > 0) {
                Collections.sort(blue);
                b = blue.size() -1;
            }

            if(r == -1)
                rb = false;
            else if(b == -1)
                rb = true;
            else
                rb = red.get(r) > blue.get(b);


            count = 0;
            max = Integer.MAX_VALUE;

            while (true) {

                if(rb) {
                    if(r < 0) break;

                    while(r >= 0 && red.get(r) >= max)
                        r--;

                    if(r >= 0) {
                        max = red.get(r);
                        count++;
                        rb = false;
                    }
                }
                else {
                    if(b < 0) break;

                    while(b >= 0 && blue.get(b) >= max)
                        b--;

                    if(b >= 0) {
                        max = blue.get(b);
                        count++;
                        rb = true;
                    }
                }
            }
            printWriter.println(count);
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
}
