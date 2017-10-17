package com.lightoj.datastructure;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BasicDatastructure_1303 {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

     static void solve() throws Exception {

        int testCase, n, m, totalTime, currentSeat, currentPersonRiding, nextPerson, personNumber;
        testCase = nextInt();

        int[][] seatsRidden;
        int[] cicularArray;
        ArrayList<Integer> programmerList;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCase; i++) {

            currentSeat = 0; totalTime = 0;
            n = nextInt();
            m = nextInt();

            seatsRidden = new int[n+2][m+2];
            cicularArray = new int[m+2];
            programmerList = new ArrayList<Integer>();

            for (int j = 1; j <= n; j++) {
                programmerList.add(j);
            }

            do {

                currentSeat = (currentSeat + 1) % m;
                currentPersonRiding = cicularArray[currentSeat];
                cicularArray[currentSeat] = 0;

                if (hasNotRidden(seatsRidden, currentPersonRiding, m)) {
                    programmerList.add(currentPersonRiding);
                }

                nextPerson = getProgrammer(programmerList, seatsRidden, currentSeat);

                if (nextPerson >= 0) {
                    personNumber = programmerList.get(nextPerson);
                    seatsRidden[personNumber][currentSeat] = 1;
                    programmerList.remove(nextPerson);
                    cicularArray[currentSeat] = personNumber;
                }
                totalTime += 5;
            } while (!isFerrisWheelEmpty(cicularArray, m));

            totalTime = (n == 1) ? totalTime*m : totalTime;

            stringBuilder.append(String.format("Case %d: %d%n", i, totalTime));
        }

        printWriter.print(stringBuilder);
        printWriter.flush();
    }

    static boolean hasNotRidden(int[][] seatsRidden, int personRiding, int m) {
        if (personRiding == 0)
            return false;

        for (int i = 0; i < m; i++) {
            if (seatsRidden[personRiding][i] == 0)
                return true;
        }

        return false;
    }

    static int getProgrammer(ArrayList<Integer> programmerList, int[][] seatsRidden, int currentSeat){

         for (int i = 0; i < programmerList.size(); i++) {
             if (seatsRidden[programmerList.get(i)][currentSeat] == 0)
                 return i;
         }

         return  -1;
    }

    static boolean isFerrisWheelEmpty(int[] circularArray, int m) {

        for (int i = 0; i < m; i++) {
            if (circularArray[i] > 0)
                return false;
        }

        return true;
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
