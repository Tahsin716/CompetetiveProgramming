package com.uva.problemsolvingparadigm;

//UVa- 787

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Maximum_Subsequence_Product {

    static Scanner scanner;
    static PrintWriter printWriter;

    static void solve() throws Exception {

        ArrayList<Integer> nums = new ArrayList<Integer>();
        int current;
        BigInteger max, product;

        while(scanner.hasNext()) {

            current = scanner.nextInt();

            if(current == -999999){

                max = BigInteger.valueOf(current);

                //Multiplying all the other numbers with the indexed one, to find the max_subsequence_product
                //Time-complexity O(n^2)
                for(int i = 0; i < nums.size(); i++) {
                    product = BigInteger.valueOf(1);

                    for(int j = i; j < nums.size(); j++) {
                        product = product.multiply(BigInteger.valueOf(nums.get(j)));

                        if (product.compareTo(max) == 1)
                            max = product;
                    }
                }
                printWriter.println(max.toString());
                nums.clear();
                continue;
            }

            nums.add(current);
        }
        printWriter.flush();
    }


    public static void main(String[] args) {

        try {

            //scanner = new Scanner(new FileInputStream("input.txt"));
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
