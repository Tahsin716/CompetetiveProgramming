package com.uva.datastructures;

//Uva- 10258

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ContestScoreboard {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        bufferedReader.readLine();

        ArrayList<Team> teams = new ArrayList<Team>();
        String str, temp[];
        int contestant, question, time;

        while(testCase-- >0) {

            for(int i = 0; i < 100; i++)
                teams.add(i, new Team(i+1));

            while( (str = bufferedReader.readLine()) != null && str.length() >0) {

                temp = str.split(" ");
                contestant = Integer.parseInt(temp[0]);
                question = Integer.parseInt(temp[1]);
                time = Integer.parseInt(temp[2]);
                teams.get(contestant-1).submit(question, time, temp[3]);
            }

            Collections.sort(teams);

            for(Team team: teams) {

                if(team.submitted) {
                    printWriter.printf("%d %d %d%n", team.teamNumber, team.correct, team.timePenalty);
                }
            }

            if(testCase > 0) printWriter.println();

            teams.clear();
        }

        printWriter.flush();
    }

    static class Team implements Comparable<Team>{
        public int timePenalty, correct, teamNumber;
        public boolean[] answered;
        public int[] wrongCount;
        public boolean submitted;

        public Team(int teamNumber) {

            this.teamNumber = teamNumber;
            timePenalty = correct = 0;
            answered = new boolean[10];
            Arrays.fill(answered,0,10,false);
            wrongCount = new int[10];
            submitted = false;
        }
        public void submit(int question, int time, String status){
            submitted = true;
            if(status.equals("I")){
                if(!answered[question]){
                    wrongCount[question] ++;
                }
            }else if(status.equals("C")){
                if(!answered[question]){
                    answered[question] = true;
                    correct++;
                    timePenalty += time + wrongCount[question]*20;
                }
            }
        }
        @Override
        public int compareTo(Team o) {
            if(correct != o.correct)
                return o.correct - correct;
            if(timePenalty != o.timePenalty)
                return timePenalty - o.timePenalty;
            return teamNumber - o.teamNumber;
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
