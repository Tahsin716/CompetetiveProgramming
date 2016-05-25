package com.uva.datastructures;

//Uva- 123

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchingQuickly {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        String str;
        Set<String> ignoreWords = new TreeSet<String>();

        while( !(str = bufferedReader.readLine()).equals("::") )
            ignoreWords.add(str.trim());

        List<String> titles = new ArrayList<String>();
        Set<String> kwicWords = new TreeSet<String>();
        Map<String, Set<String>> titleContains = new HashMap<String, Set<String>>();

        while( (str = bufferedReader.readLine()) != null && !(str.equals(""))) {

            str = str.toLowerCase().intern();
            titles.add(str);

            Scanner words = new Scanner(str);
            while (words.hasNext()) {
                String word = words.next();
                if (!ignoreWords.contains(word)) {
                    boolean isNew = kwicWords.add(word);
                    if (isNew) {
                        titleContains.put(word, new HashSet<String>());
                    }
                    titleContains.get(word).add(str);
                }
            }
        }

        for (String kwicWord : kwicWords) {
            for (String title : titles) {
                if (titleContains.get(kwicWord).contains(title)) {

                    Pattern patt = Pattern.compile("\\b" + kwicWord + "\\b");
                    Matcher match = patt.matcher(title);
                    while (match.find()) {
                        int start = match.start();
                        int end = match.end();
                        System.out.println(title.substring(0, start) + match.group().toUpperCase() + title.substring(end));
                    }
                }
            }
        }

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
