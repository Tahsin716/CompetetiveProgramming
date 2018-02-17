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
public class Boxes {
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
        int N;
        int[][] dp;
        int[] weight;
        int[] load;

        public void solve(int testNumber, InputReader in, OutputWriter out) {

            weight = new int[1005];
            load = new int[1005];
            dp = new int[1005][3005];

            while ((N = in.nextInt()) != 0) {

                for (int i = 0; i < N; i++) {
                    weight[i] = in.nextInt();
                    load[i] = in.nextInt();
                }

                for (int[] temp : dp) {
                    Arrays.fill(temp, -1);
                }

                int ans = make_dp();

                out.println(ans);
            }
        }

        public int make_dp() {

            int best = 0;

            for (int box = 0; box < N; box++) {

                best = Math.max(best, knapsack(box + 1, load[box]) + 1);
            }

            return best;
        }

        public int knapsack(int currentBox, int loadLeft) {

            if (currentBox == N) {
                return 0;
            }

            if (dp[currentBox][loadLeft] != -1) {
                return dp[currentBox][loadLeft];
            }

            int num = -1;

            num = knapsack(currentBox + 1, loadLeft);

            if (loadLeft >= weight[currentBox]) {
                num = Math.max(num, 1 + knapsack(currentBox + 1, Math.min(loadLeft - weight[currentBox], load[currentBox])));
            }

            return dp[currentBox][loadLeft] = num;
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

