package com.lightoj.beginner;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;



/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Tahsin Rashad
 */
public class Beginner_1414 {
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
        public void solve(int testNumber, InputReader in, OutputWriter out) {

            int testCase, date1, date2, year1, year2, ans;
            String month1, month2, str;
            String[] input;

            testCase = in.nextInt();
            for (int i = 1; i <= testCase; i++) {

                str = in.readLine();
                str = str.replaceAll(",", " ");
                input = str.split("\\s+");

                month1 = input[0];
                //date1 = Integer.parseInt(input[1]);
                year1 = Integer.parseInt(input[2]);

                str = in.readLine();
                str = str.replaceAll(",", " ");
                input = str.split("\\s+");

                month2 = input[0];
                date2 = Integer.parseInt(input[1]);
                year2 = Integer.parseInt(input[2]);

                if (!(month1.equals("January") || month1.equals("February"))) {
                    ++year1;
                }

                if (month2.equals("January") || (month2.equals("February") && date2 < 29)) {
                    --year2;
                }

                ans = (year2 / 4) - ((year1 - 1) / 4);
                ans -= (year2 / 100) - ((year1 - 1) / 100);
                ans += (year2 / 400) - ((year1 - 1) / 400);

                out.printf("Case %d: %d\n", i, ans);
            }
            out.flush();
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

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
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

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

