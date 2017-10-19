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
public class Beginner_1211 {
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

            int testCase, x1, y1, z1, x2, y2, z2, maxX, maxY, maxZ, minX, minY, minZ, cubeNumber, ans;

            testCase = in.nextInt();
            for (int i = 1; i <= testCase; i++) {

                cubeNumber = in.nextInt();

                out.print("Case ");
                out.print(i);
                out.print(": ");

                maxX = maxY = maxZ = Integer.MIN_VALUE;
                minX = minY = minZ = Integer.MAX_VALUE;

                while (cubeNumber-- > 0) {
                    x1 = in.nextInt();
                    y1 = in.nextInt();
                    z1 = in.nextInt();

                    x2 = in.nextInt();
                    y2 = in.nextInt();
                    z2 = in.nextInt();

                    maxX = max(x1, maxX);
                    maxY = max(y1, maxY);
                    maxZ = max(z1, maxZ);

                    minX = min(x2, minX);
                    minY = min(y2, minY);
                    minZ = min(z2, minZ);

                }

                if (maxX >= minX || maxY >= minY || maxZ >= minZ)
                    ans = 0;
                else
                    ans = (minX - maxX) * (minY - maxY) * (minZ - maxZ);

                out.println(ans);
            }
            out.flush();
        }

        private int min(int x, int y) {
            return (x > y) ? y : x;
        }

        private int max(int x, int y) {
            return (x < y) ? y : x;
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

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
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

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

