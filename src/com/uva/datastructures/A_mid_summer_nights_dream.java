package com.uva.datastructures;

//UVa- 10057

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A_mid_summer_nights_dream {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {


        while (true) {

            String str = bufferedReader.readLine();
            if(str == null || str.equals(""))
                break;

            int testCase = Integer.parseInt(str);
            ArrayList<Integer> numbers = new ArrayList<Integer>();

            while(testCase-- > 0) {
                numbers.add(nextInt());
            }

            Collections.sort(numbers);
            int median;
            int ans;

            if(numbers.size()%2 == 0) {
                median = numbers.size()/2 -1;
            }
            else {
                median = (numbers.size() > 1)? numbers.size()/2 : 0;
            }

            ans = numbers.get(median);
            int count = 0;

            if(numbers.size()%2 == 0) {

                for (Integer number : numbers) {

                    if (number.equals(numbers.get(median)) || number.equals(numbers.get(median + 1)))
                        count++;
                }
            }
            else {

                for (Integer number : numbers) {

                    if (number.equals(numbers.get(median)))
                        count++;
                }
            }

            printWriter.printf("%d %d %d%n",
                    ans, count, (numbers.size()%2 == 0)? numbers.get(median+1) - numbers.get(median) +1 : 1);

            numbers.clear();
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
