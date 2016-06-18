package com.uva.problemsolvingparadigm;

//UVa- 108

import java.io.*;
import java.util.StringTokenizer;

public class MaximumSum {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        String str;
        while ((str = bufferedReader.readLine()) != null) {

            int N = Integer.parseInt(str);
            int[][] arr = new int[N][N];

            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                    arr[i][j] = nextInt();

            findMaxSubSum(arr);
        }

    }

    static int kadane(int[] array) {

        int[] result = new int[]{Integer.MIN_VALUE, 0, -1};
        int currentSum = 0, start = 0;

        for(int i = 0; i < array.length; i++) {
            currentSum += array[i];

            if (currentSum < 0) {
                currentSum = 0;
                start = i + 1;
            }
            else if (currentSum > result[0]) {
                result[0] = currentSum;
                result[1] = start;
                result[2] = i;
            }
        }
        //if all numbers are negative number
        if(result[2] == -1) {
            result[0] = Integer.MIN_VALUE;
            for(int i = 0; i < array.length; i++) {
                if(array[i] > result[0]) {
                    result[0] = array[i];
                    result[1] = i;
                    result[2] = i;
                }
            }
        }

        return result[0];
    }

    static void findMaxSubSum(int[][] array) {

        int columns = array[0].length;
        int rows = array.length;
        int currentResult;
        int maxSum = Integer.MIN_VALUE;

        for(int leftColumns = 0; leftColumns < columns; leftColumns++) {
            int[] temp = new int[rows];

            for(int rightColumns = leftColumns; rightColumns < columns; rightColumns++) {

                for(int i = 0; i < rows; i++)
                    temp[i] += array[i][rightColumns];

                currentResult = kadane(temp);

                if(currentResult > maxSum) {
                    maxSum = currentResult;
                }
            }
        }
        printWriter.println(maxSum);
        printWriter.flush();
    }


    public static void main(String[] args) {

        try {

            //bufferedReader = new BufferedReader(new FileReader("input.txt"));
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
