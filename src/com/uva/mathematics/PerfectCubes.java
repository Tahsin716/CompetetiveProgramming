package com.uva.mathematics;

// Uva - 386

import java.io.*;
import java.util.StringTokenizer;

public class PerfectCubes {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int aCube, bCube, cCube, dCube;

        for (int a = 6; a <= 200 ; a++) {
            aCube = a*a*a;

            for (int b = 2; b < a; b++) {
                bCube = b*b*b;

                for (int c = b; c < a; c++) {
                    cCube = c*c*c;

                    for (int d = c; d < a; d++) {
                        dCube = d*d*d;

                        if(aCube == bCube + cCube + dCube)
                            printWriter.printf("Cube = %d, Triple = (%d,%d,%d)%n", a, b, c, d);
                    }
                }
            }

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
