package com.uva.datastructures;

//Uva- 450

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class LittleBlackBook {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        ArrayList<Info> infos = new ArrayList<Info>();

        while (testCase-- > 0) {

            String department = bufferedReader.readLine();
            String str;
            String[] temp;

            while( (str = bufferedReader.readLine()) != null && !(str.trim().equals("")) ) {
                temp = str.split("[,]");
                infos.add(new Info(department,temp));
            }
        }

        Collections.sort(infos);

        for (Info info : infos) info.printInfos();
    }

    static class Info implements Comparable<Info> {

        String dep, title, first, last, address,home, work, campus;

        public Info(String dep, String[] temp) {

            title = temp[0];
            first = temp[1];
            last = temp[2];
            address = temp[3];
            home = temp[4];
            work = temp[5];
            campus = temp[6];
            this.dep = dep;
        }

        public void printInfos() {
            printWriter.println("----------------------------------------");
            printWriter.println(title + " " + first + " " + last);
            printWriter.println(address);
            printWriter.println("Department: " + dep);
            printWriter.println("Home Phone: " + home);
            printWriter.println("Work Phone: " + work);
            printWriter.println("Campus Box: " + campus);
        }


        @Override
        public int compareTo(Info o) {

            return this.last.compareTo(o.last);
        }
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
