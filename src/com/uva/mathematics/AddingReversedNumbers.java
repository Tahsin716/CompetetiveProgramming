package com.uva.mathematics;

//UVa- 713
//Bigint gets rid of the trailing zeroes after parsing string
import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class AddingReversedNumbers {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int count = nextInt();

        BigInteger num1, num2, sum;
        StringBuilder temp;

        while(count-- > 0) {

            temp = new StringBuilder(next());
            num1 = new BigInteger(temp.reverse().toString());

            temp = new StringBuilder(next());
            num2 = new BigInteger(temp.reverse().toString());

            temp = new StringBuilder( (num1.add(num2)).toString());
            sum = new BigInteger(temp.reverse().toString());

            printWriter.println(sum);
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
