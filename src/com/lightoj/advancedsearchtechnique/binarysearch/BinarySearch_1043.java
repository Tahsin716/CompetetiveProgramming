package com.lightoj.advancedsearchtechnique.binarysearch;

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
public class BinarySearch_1043 {
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

            double ab, ac, bc, ratio, ans;

            int testCase = in.nextInt();

            for (int i = 1; i <= testCase; i++) {

                ab = in.nextDouble();
                ac = in.nextDouble();
                bc = in.nextDouble();
                ratio = in.nextDouble();

                ans = BinarySearch(ab, ac, bc, ratio);

                out.printf("Case %d: %.10f\n", i, ans);
            }
        }

        private double BinarySearch(double ab, double ac, double bc, double ratio) {

            double low, high, mid, ad;

            ad = 0.0;
            low = 0.0;
            high = ab;

            for (int i = 0; i < 100; i++) {

                mid = (low + high) / 2.0;
                ad = mid;

                if (TriangleRatio(ab, ac, bc, ad) > ratio) {
                    high = mid;
                } else {
                    low = mid;
                }
            }

            return ad;
        }

        private double TriangleRatio(double ab, double ac, double bc, double ad) {

            double ae, de, perimeter1, perimeter2, smallTriangleArea, largeTriangleArea, trapeziumArea, ratio;

            ae = (ad / ab) * ac;
            de = (ad / ab) * bc;

            perimeter1 = (ab + bc + ac) / 2.0;
            perimeter2 = (ad + de + ae) / 2.0;

            smallTriangleArea = Math.sqrt(perimeter2 * (perimeter2 - ad) * (perimeter2 - ae) * (perimeter2 - de));
            largeTriangleArea = Math.sqrt(perimeter1 * (perimeter1 - ab) * (perimeter1 - ac) * (perimeter1 - bc));

            trapeziumArea = largeTriangleArea - smallTriangleArea;

            ratio = smallTriangleArea / trapeziumArea;

            return ratio;
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

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
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

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

    }
}

