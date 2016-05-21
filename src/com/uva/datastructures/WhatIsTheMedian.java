package com.uva.datastructures;

//Uva- 10107

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WhatIsTheMedian {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static Scanner scanner;

    static void solve() throws Exception {

        int temp, ans;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        while (scanner.hasNext()) {

            temp = scanner.nextInt();
            arrayList.add(temp);

            Collections.sort(arrayList);
            if(arrayList.size() > 1 && arrayList.size() %2 == 0) {

                temp = arrayList.size()/2;
                ans = (arrayList.get(temp-1) + arrayList.get(temp))/2;
            }
            else {

                temp = (arrayList.size() - 1)/2;
                ans = arrayList.get(temp);
            }

            printWriter.println(ans);
            printWriter.flush();
        }

    }

    public static void main(String[] args) {

        try {

            scanner = new Scanner(System.in);
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
