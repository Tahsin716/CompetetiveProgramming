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
public class SumOfDifferentPrimes {
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
        int k;
        int N = 1120;
        int[] arr;
        int[][][] dp;
        boolean[] primes;

        public void solve(int testNumber, InputReader in, OutputWriter out) {

            arr = new int[188];
            dp = new int[190][15][1125];
            primes = new boolean[N];

            Arrays.fill(primes, false);
            primes[0] = primes[1] = true;

            for (int i = 2; i * i < N; i++) {
                if (!primes[i]) {
                    for (int j = i * i; j < N; j += i) {
                        primes[j] = true;
                    }
                }
            }

            int j = 0;

            for (int i = 2; i < N; i++) {
                if (!primes[i]) {
                    arr[j++] = i;
                }
            }

            while (((n = in.nextInt()) != 0) && ((k = in.nextInt()) != 0)) {

                for (int[][] temp : dp) {
                    for (int[] temp2 : temp) {
                        Arrays.fill(temp2, -1);
                    }
                }

                int ans = knapsack(0, 0, n);
                out.println(ans);
            }
        }

        public int knapsack(int i, int taken, int sum) {

            if (taken == k) {

                if (sum == 0)
                    return 1;

                return 0;
            } else if (sum == 0) {

                if (taken == k)
                    return 1;

                return 0;
            } else if (i == 187) {

                if (sum == 0 && taken == k)
                    return 1;

                return 0;
            } else if (sum - arr[i] < 0 || sum < 0 || taken >= k || (taken == k && sum > 0) || i > 187) {
                return 0;
            } else if (dp[i][taken][sum] != -1) {
                return dp[i][taken][sum];
            } else {

                dp[i][taken][sum] = knapsack(i + 1, taken + 1, sum - arr[i]) + knapsack(i + 1, taken, sum);
                return dp[i][taken][sum];
            }
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

