package com.uva.introduction;

//Uva- 10141

import java.io.*;
import java.util.StringTokenizer;

public class RequestForProposal {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int itemsNum, proposalNum, maxProposal, hasItems, count = 1;
        double money, tempMoney;
        String str, companyName = "";
        String[] temp, items, company;
        boolean first = true;

        while(true) {

            str = nextLine();
            if(str.equals("0 0"))
                break;

            if(!first) {
                printWriter.println();
                printWriter.flush();
            }

            temp = str.split(" ");
            maxProposal = 0;
            tempMoney = 1000000;

            itemsNum = Integer.parseInt(temp[0]);
            proposalNum = Integer.parseInt(temp[1]);
            items = new String[itemsNum];
            company = new String[proposalNum];

            for(int i = 0; i < itemsNum; i++) {
                items[i] = nextLine();
            }

            for(int i = 0; i < proposalNum; i++) {
                company[i] = nextLine();
                money = nextDouble();
                hasItems = nextInt();

                for(int j = 0; j < hasItems; j++)
                    str = nextLine();

                if(hasItems > maxProposal) {
                    maxProposal = hasItems;
                    tempMoney = money;
                    companyName = company[i];
                }
                else if(hasItems == maxProposal && money < tempMoney) {
                    maxProposal = hasItems;
                    tempMoney = money;
                    companyName = company[i];
                }
            }
            printWriter.printf("RFP #%d%n%s%n",count,companyName);
            printWriter.flush();
            count++;
            first = false;
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

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
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
