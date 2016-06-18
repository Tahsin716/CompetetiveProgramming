package com.hackerrank.algorithms;

import java.io.*;
import java.util.StringTokenizer;

public class Dynamic_MaximumSubarray {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int testCase = nextInt();

        while(testCase-- > 0) {

            int numElements = nextInt();
            String[] temp = bufferedReader.readLine().split(" ");
            int[] array = new int[numElements];

            for(int i = 0; i < numElements; i++)
                array[i] = Integer.parseInt(temp[i]);


            int ans1 = contiguousSum(array);
            int ans2 = non_contiguousSum(array);

            printWriter.println(ans1 + " " + ans2);
        }
        printWriter.flush();
    }

    static int contiguousSum(int[] array) {

        int max = Integer.MIN_VALUE, maxSubSum = -1;

        for (int anArray : array) {

            if (maxSubSum >= 0) {
                maxSubSum += anArray;
            } else {
                maxSubSum = anArray;
            }

            if (max < maxSubSum)
                max = maxSubSum;
        }

        return max;
    }

    static int non_contiguousSum(int[] array) {

        int max = array[0], maxSubSum = array[0];

        for(int i = 1; i < array.length && array.length > 1; i++) {

            if(maxSubSum >= 0 && array[i] > 0)
                maxSubSum += array[i];
            else if(maxSubSum < 0 && array[i] > 0)
                maxSubSum = array[i];
            else if(maxSubSum < 0 && array[i] < 0) {
                if(maxSubSum < array[i])
                    maxSubSum = array[i];
            }

            if(max < maxSubSum)
                max = maxSubSum;
        }

        return max;
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
