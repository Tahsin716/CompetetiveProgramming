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
public class DividingCoins {
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
        int n;
        int capacity;
        int[] weight;
        int[][] dp;

        public void solve(int testNumber, InputReader in, OutputWriter out) {

            int testCase = in.nextInt();

            weight = new int[501];
            dp = new int[501][50001];

            while (testCase-- > 0) {

                n = in.nextInt();
                int sum = 0;

                for (int[] temp : dp) {
                    Arrays.fill(temp, -1);
                }

                for (int i = 1; i <= n; i++) {
                    weight[i] = in.nextInt();
                    sum += weight[i];
                }

                capacity = sum / 2;

                int value = knapsack(1, 0);
                int ans = sum - 2 * value;

                out.println(ans);
            }
        }

        public int knapsack(int i, int w) {

            if (i == n + 1) {
                return 0;
            }

            if (dp[i][w] != -1) {
                return dp[i][w];
            }

            int profitTaken = 0;

            if (w + weight[i] <= capacity) {
                profitTaken = weight[i] + knapsack(i + 1, w + weight[i]);
            } else {
                profitTaken = 0;
            }

            int profitNotTaken = knapsack(i + 1, w);
            dp[i][w] = Math.max(profitTaken, profitNotTaken);

            return dp[i][w];
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
}

