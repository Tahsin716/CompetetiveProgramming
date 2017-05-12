package com.uva.stringprocessing;

//UVa- 576

import java.io.*;
import java.util.regex.Pattern;

public class HaikuReview {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;


    static void solve() throws Exception {

        String str;
        String vowel ="aeiouy";
        Pattern five = Pattern.compile(String.format("^[^%1$s]*([%1$s]+[^%1$s]+){5}$", vowel));
        Pattern seven = Pattern.compile(String.format("^[^%1$s]*([%1$s]+[^%1$s]+){7}$", vowel));

        while( (str = bufferedReader.readLine()) != null && !(str.equals("e/o/i"))) {

            String[] temp = str.split("/");


            if(!five.matcher(temp[0]).matches()) {
                printWriter.println("1");
                continue;
            }

            if(!seven.matcher(temp[1]).matches()) {
                printWriter.println("2");
                continue;
            }

            if(!five.matcher(temp[2]).matches()) {
                printWriter.println("3");
                continue;
            }

            printWriter.println("Y");
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
}
