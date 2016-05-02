package com.uva.introduction;

//Uva- 11679

import java.io.*;
import java.util.StringTokenizer;

public class SubPrime {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int banks, debentureNum, creditor, debitor, money;
        String str;
        String[] temp;
        int[]  moneyReserve = new int [20];

        while(true) {

            str = nextLine();
            if(str.equals("0 0"))
                break;

            boolean flag = true;

            temp = str.split(" ");
            banks = Integer.parseInt(temp[0]);
            debentureNum = Integer.parseInt(temp[1]);

            for(int i = 0; i < banks; i++)
                moneyReserve[i] = nextInt();

            for(int i = 0; i < debentureNum; i++) {

                debitor = nextInt();
                creditor = nextInt();
                money = nextInt();

                //if any of the bank's reserve money is <0 then, 'N' else 'S'
                moneyReserve[debitor -1] -= money;
                moneyReserve[creditor -1] += money;
            }

            for(int i = 0; i < banks; i++) {
                if(moneyReserve[i] < 0) {
                    flag = false;
                    break;
                }
            }

            String ans = (flag) ? "S" : "N";

            printWriter.println(ans);
            printWriter.flush();
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

    static String nextLine() throws IOException {
        String str;
        str = bufferedReader.readLine();
        return str;
    }
}
