package com.acm;

import java.io.*;
import java.util.StringTokenizer;

public class CountingWeekDays {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        while(testCase-- > 0) {

            String[] temp = bufferedReader.readLine().split(" ");
            Month month = Month.valueOf(temp[0]);
            String day = temp[1];

            int days = 0;
            int weekendDays;

            switch (month) {
                case JAN:
                    days = 31;
                    break;
                case FEB:
                    days = 28;
                    break;
                case MAR:
                    days = 31;
                    break;
                case APR:
                    days = 30;
                    break;
                case MAY:
                    days = 31;
                    break;
                case JUN:
                    days = 30;
                    break;
                case JUL:
                    days = 31;
                    break;
                case AUG:
                    days = 31;
                    break;
                case SEP:
                    days = 30;
                    break;
                case OCT:
                    days = 31;
                    break;
                case NOV:
                    days = 30;
                    break;
                case DEC:
                    days = 31;
                    break;
            }

            if(day.equals("SUN") || day.equals("MON") || day.equals("TUE")) {
                weekendDays = 8;
            }
            else if (day.equals("WED")) {
                if(days == 31)
                    weekendDays = 9;
                else
                    weekendDays = 8;
            }
            else if(day.equals("THU")) {
                if (days == 31)
                    weekendDays = 10;
                else if(days == 30)
                    weekendDays = 9;
                else
                    weekendDays = 8;
            }
            else if (day.equals("SAT")) {
                if (days == 28)
                    weekendDays = 8;
                else
                    weekendDays = 9;
            }
            else {
                if(days == 28)
                    weekendDays = 8;
                else
                    weekendDays = 10;
            }

            printWriter.println(weekendDays);
        }
        printWriter.flush();
    }

    private enum Month {
        JAN, FEB, MAR, APR, MAY , JUN, JUL, AUG, SEP, OCT, NOV, DEC
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
