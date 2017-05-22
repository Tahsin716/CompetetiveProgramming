package com.uva.datastructures;

//Uva-673
//Uva_id: Sephiroth616(Tahsin Rashad)
//Student ID: 1432020022
//Status: Accepted

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class ParenthesesBalance {


    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        Stack<Character> stack;

        while(testCase-- > 0) {

            String str = bufferedReader.readLine();
            stack = new Stack<Character>();
            boolean flagMatch = false;

            if(str.isEmpty()) {
                printWriter.println("Yes");
            }
            else {

                for(int i = 0; i < str.length(); i++) {

                    flagMatch = false;

                    if((str.charAt(i) == '(') || (str.charAt(i) == '[')) {
                        stack.push(str.charAt(i));
                    }
                    else if(str.charAt(i) == ')') {

                        while(!stack.isEmpty()) {
                            if(stack.pop() == '(') {
                                flagMatch = true;
                                break;
                            }
                        }

                        if(!flagMatch)
                            break;

                    }
                    else if(str.charAt(i) == ']'){

                        while(!stack.isEmpty()) {
                            if(stack.pop() == '[') {
                                flagMatch = true;
                                break;
                            }
                        }

                        if(!flagMatch)
                            break;
                    }
                    else
                        stack.push(str.charAt(i));
                }

                if(!stack.isEmpty()) {
                    printWriter.println("No");
                    continue;
                }

                if(flagMatch){
                    printWriter.println("Yes");
                }
                else
                    printWriter.println("No");

            }
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
