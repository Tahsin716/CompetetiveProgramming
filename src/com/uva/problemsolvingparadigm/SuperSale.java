package com.uva.problemsolvingparadigm;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Tahsin Rashad
 */
public class SuperSale {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        int capacity = 0;
        int n = 0;
        int profit = 0;
        int[] weight;
        int[] cost;
        int[][] dp;

        public void solve(int testNumber, InputReader in, OutputWriter out) {

            int testCase = in.nextInt();

            weight = new int[1005];
            cost = new int[1005];

            dp = new int[1005][105];

            while (testCase-- > 0) {

                n = in.nextInt();

                for (int i = 0; i < n; i++) {
                    cost[i] = in.nextInt();
                    weight[i] = in.nextInt();
                }

                int G = in.nextInt();
                int ans = 0;


                for (int i = 0; i < G; i++) {
                    capacity = in.nextInt();

                    for (int[] temp : dp) {
                        Arrays.fill(temp, -1);
                    }

                    ans += knapsack(0, 0);
                }

                out.println(ans);
            }
        }

        public int knapsack(int i, int w) {

            if (i >= n) {
                return 0;
            }

            if (dp[i][w] != -1) {
                return dp[i][w];
            }

            profit = 0;

            if (w + weight[i] <= capacity) {
                profit = Math.max(knapsack(i + 1, w + weight[i]) + cost[i], knapsack(i + 1, w));
            } else {
                profit = knapsack(i + 1, w);
            }

            return dp[i][w] = profit;
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void println(int i) {
            writer.println(i);
        }

    }
}

