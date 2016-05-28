package com.uva.datastructures;

//UVa- 10815

//Either use hasNext or bufferedReader.readLine != null
//Don't close the reader if str is empty

import java.io.*;
import java.util.*;

public class AndysFirstDictionary {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        TreeSet<String> dictionary = new TreeSet<String>();
        String str;

        while((str = bufferedReader.readLine()) != null) {

            StringBuilder temp = new StringBuilder();
            char[] c = str.toCharArray();

            for(int i = 0; i < str.length(); i++) {

                if(Character.isLetter(c[i]))
                    temp.append(c[i]);
                else if(temp.length() > 0) {

                    dictionary.add(temp.toString().toLowerCase());
                    temp = new StringBuilder();
                }
            }

            if(temp.length() > 0)
                dictionary.add(temp.toString().toLowerCase());

        }

        for(String ans : dictionary) {
            printWriter.println(ans);
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
