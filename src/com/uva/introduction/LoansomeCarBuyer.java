package com.uva.introduction;

//Uva- 10114

import java.io.*;
import java.util.StringTokenizer;

public class LoansomeCarBuyer {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        int months, numDepriciation;
        double downpayment, loan;
        double[] depriciation = new double[101];
        String str;
        String[] temp;

        while(true) {

            str = nextLine();
            if(str.startsWith("-"))
                break;

            int m, k = 0;
            double dep;

            temp = str.split(" ");
            months = Integer.parseInt(temp[0]);
            downpayment = Double.parseDouble(temp[1]);
            loan = Double.parseDouble(temp[2]);
            numDepriciation = Integer.parseInt(temp[3]);

            for(int i = 0; i < numDepriciation; i++) {

                m = nextInt();
                dep = nextDouble();

                //previous month percentage
                for(int j = m; j < 101; j++)
                    depriciation[j] = dep;

            }

            //main formulas
            double monthlyPayment = loan / months;
            double currentValue = (loan + downpayment)*(1 - depriciation[0]);
            double currentLoan  = loan;
            int numMonths = 0;

            while(currentLoan > currentValue) {

                numMonths++;
                currentLoan -= monthlyPayment;
                currentValue = currentValue*(1 - depriciation[numMonths]);
            }

            String time = (numMonths == 1) ? "month" : "months";

            printWriter.println(numMonths + " " + time);
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

    static double nextDouble() throws Exception {
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
