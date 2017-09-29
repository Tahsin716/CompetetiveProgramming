package com.uva.mathematics;

// Uva - 256

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class QurksomeSquares {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static ArrayList<Integer> squares, twos, fours, sixes, eights;

    static void solve() throws Exception {

        squares = new ArrayList<Integer>();
        twos = new ArrayList<Integer>();
        fours = new ArrayList<Integer>();
        sixes = new ArrayList<Integer>();
        eights = new ArrayList<Integer>();

        squareCalculate();

        String str;
        String[] input;
        int N;

        while ( (str = bufferedReader.readLine()) != null ) {

            input = str.split(" ");
            N = Integer.parseInt(input[0]);
            findQuirksomeSquare(N);
            printSquares(N);

        }
        printWriter.flush();
    }

    static void squareCalculate() {

        for (int i = 0; i < 10000; i++) {
            squares.add(i*i);
        }
    }

    static void findQuirksomeSquare(int N) {

        int termination = (int) Math.pow(10,N);
        int temp = (int)Math.pow(10, N/2);

        if (N == 2 && twos.isEmpty()) {
            for(int i = 0; i < 10000; i++) {
                if(squares.get(i) >= termination)
                    break;

                if((int) Math.pow( (squares.get(i) / temp + squares.get(i) % temp),2) == squares.get(i))
                    twos.add(squares.get(i));
            }
        }
        else if (N == 4 && fours.isEmpty()) {
            for(int i = 0; i < 10000; i++) {
                if(squares.get(i) >= termination)
                    break;

                if((int) Math.pow( (squares.get(i) / temp + squares.get(i) % temp),2) == squares.get(i))
                    fours.add(squares.get(i));
            }
        }
        else if (N == 6 && sixes.isEmpty()) {
            for(int i = 0; i < 10000; i++) {
                if(squares.get(i) >= termination)
                    break;

                if((int) Math.pow( (squares.get(i) / temp + squares.get(i) % temp),2) == squares.get(i))
                    sixes.add(squares.get(i));
            }
        }
        else if (N == 8 && eights.isEmpty()){
            for(int i = 0; i < 10000; i++) {
                if(squares.get(i) >= termination)
                    break;

                if((int) Math.pow( (squares.get(i) / temp  +  squares.get(i) % temp),2) == squares.get(i))
                    eights.add(squares.get(i));
            }
        }
    }

    static void printSquares(int N) {

        if(N == 2) {
            for(int two: twos) {
                printWriter.println( String.format("%02d", two));
            }
        }
        else if (N == 4) {
            for(int four: fours) {
                printWriter.println( String.format("%04d", four));
            }
        }
        else if (N == 6) {
            for(int six: sixes) {
                printWriter.println( String.format("%06d", six));
            }
        }
        else if (N == 8) {
            for(int eight: eights) {
                printWriter.println( String.format("%08d", eight));
            }
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
}
