package com.uva.mathematics;

// Uva - 10281

import java.io.*;
import java.util.StringTokenizer;

public class AverageSpeed {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String str;
        String[] input, time;

        int speed = 0;
        double distance = 0.0, initialTime = 0.0, finalTime = 0.0, hour, minute, second;

        while ( !(str = bufferedReader.readLine()).equals("")) {

            str = str.trim();
            input = str.split("\\s+");

            if(input.length == 2) {
                time = input[0].split(":");

                hour = Integer.parseInt(time[0]);
                minute = Integer.parseInt(time[1]);
                second = Integer.parseInt(time[2]);
                initialTime = hour + (minute/60.0) + (second/3600.0);

                distance = distance + (speed * (initialTime - finalTime));
                speed = Integer.parseInt(input[1]);
            }
            else {
                time = input[0].split(":");

                hour = Integer.parseInt(time[0]);
                minute = Integer.parseInt(time[1]);
                second = Integer.parseInt(time[2]);
                finalTime = hour + (minute/60.0) + (second/3600.0);

                distance = distance + (speed * (finalTime - initialTime));

                initialTime = finalTime;
                printWriter.printf("%s %.2f km%n", str, distance);
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
