package com.lightoj.beginner;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.Writer;
import java.io.OutputStreamWriter;


/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Tahsin Rashad
 */
public class Beginner_1354 {
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

            int testCase, first, second, third, fourth, binFirst, binSecond, binThird, binFourth;
            int decFirst, decSecond, decThird, decFourth;
            String[] input;

            testCase = in.nextInt();
            for (int i = 1; i <= testCase; i++) {

                input = in.nextString().split("\\.");
                first = Integer.parseInt(input[0]);
                second = Integer.parseInt(input[1]);
                third = Integer.parseInt(input[2]);
                fourth = Integer.parseInt(input[3]);

                input = in.nextString().split("\\.");
                binFirst = Integer.parseInt(input[0]);
                binSecond = Integer.parseInt(input[1]);
                binThird = Integer.parseInt(input[2]);
                binFourth = Integer.parseInt(input[3]);

                decFirst = toDecimal(binFirst);
                decSecond = toDecimal(binSecond);
                decThird = toDecimal(binThird);
                decFourth = toDecimal(binFourth);

                out.print("Case ");
                out.print(i);
                out.print(": ");

                if ((first == decFirst) && (second == decSecond) && (third == decThird) && (fourth == decFourth))
                    out.println("Yes");
                else
                    out.println("No");

            }

        }

        private int toDecimal(int binaryNumber) {
            int remainder, sum = 0, index = 0;

            while (binaryNumber != 0) {
                remainder = binaryNumber % 10;
                binaryNumber /= 10;
                sum += remainder * Math.pow(2, index++);
            }

            return sum;
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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void print(int i) {
            writer.print(i);
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

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
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

