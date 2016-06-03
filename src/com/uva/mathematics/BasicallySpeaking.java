package com.uva.mathematics;

//UVa- 389

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class BasicallySpeaking {

    static Scanner scanner;
    static PrintWriter printWriter;


    static void solve() throws Exception {

        int to, from;
        String ans, num;
        BigInteger temp;

        while (scanner.hasNext()) {

            num = scanner.next();
            from = scanner.nextInt();
            to = scanner.nextInt();

            temp = new BigInteger(num, from);
            ans = temp.toString(to).toUpperCase();

            if (ans.length() > 7)
                ans = "ERROR";

            printWriter.printf("%7s%n", ans);
        }
    }

    public static void main(String[] args) {

        try {

            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            solve();
            scanner.close();
            printWriter.close();
        }
        catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
