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
public class Beginner_1133 {
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

            int testCase, numbers, operationCount;
            char operation;
            int[] num;

            testCase = in.nextInt();
            for (int i = 1; i <= testCase; i++) {

                numbers = in.nextInt();
                operationCount = in.nextInt();
                num = new int[numbers];

                for (int j = 0; j < numbers; j++)
                    num[j] = in.nextInt();

                for (int k = 0; k < operationCount; k++) {

                    operation = in.nextCharacter();

                    if (operation == 'S') {

                        int temp = in.nextInt();
                        for (int m = 0; m < numbers; m++) {
                            num[m] += temp;
                        }
                    } else if (operation == 'M') {

                        int temp = in.nextInt();
                        for (int m = 0; m < numbers; m++) {
                            num[m] *= temp;
                        }
                    } else if (operation == 'D') {

                        int temp = in.nextInt();
                        for (int m = 0; m < numbers; m++) {
                            num[m] /= temp;
                        }
                    } else if (operation == 'R') {

                        for (int m = 0; m < num.length / 2; m++) {

                            int temp = num[m];
                            num[m] = num[num.length - m - 1];
                            num[num.length - m - 1] = temp;
                        }
                    } else if (operation == 'P') {

                        int y = in.nextInt();
                        int z = in.nextInt();

                        int temp = num[y];
                        num[y] = num[z];
                        num[z] = temp;
                    }
                }

                out.print("Case ");
                out.print(i);
                out.println(":");

                for (int m = 0; m < num.length; m++) {

                    if (m == num.length - 1)
                        out.println(num[m]);
                    else
                        out.print(num[m] + " ");
                }
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

        public char nextCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

