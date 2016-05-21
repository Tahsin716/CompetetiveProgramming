package com.uva.introduction;

//Uva- 10424

import java.io.*;
import java.util.StringTokenizer;

public class LoveCalculator {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;


    static void solve() throws Exception {

        String str;
        int sum1, sum2, ratio1, ratio2;
        double ans;
        char temp;

        while(true) {

            str = nextLine();
            if(str == null || str.isEmpty())
                break;

            sum1 = 0;
            sum2 = 0;

            for(int i = 0; i < str.length(); i++) {

                if(str.charAt(i) >= 'A' && str.charAt(i) <= 'z') {
                    temp = isLower(str.charAt(i));
                    sum1 += temp - 'a' +1;
                }
            }

            str = nextLine();

            for(int i = 0; i < str.length(); i++) {

                if(str.charAt(i) >= 'A' && str.charAt(i) <= 'z') {
                   temp = isLower(str.charAt(i));
                   sum2 += temp - 'a' +1;
                }
            }

            ratio1 = answer(sum1);
            ratio2 = answer(sum2);

            if(ratio1 >= ratio2){
                ans = ( (double)ratio2 / (double)ratio1 )*100;
            }
            else {
                ans = ( (double)ratio1 / (double)ratio2 )*100;
            }

            printWriter.printf("%.2f %%%n", ans);
            printWriter.flush();
        }
    }

    static char isLower(char i) {
        if(i >= 'A' && i <= 'Z')
            return (char) (i+32);

        return i;
    }

    static int answer(int number) {
        int ans = 0;

        while(true) {

            while(number != 0) {
                ans += number%10;
                number /= 10;
            }

            if(ans / 10 == 0)
                break;
            else {
                number = ans;
                ans = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printWriter = new PrintWriter(System.out);
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
