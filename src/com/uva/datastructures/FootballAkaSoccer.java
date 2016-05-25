package com.uva.datastructures;

//Uva- 10194

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FootballAkaSoccer {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static StringTokenizer stringTokenizer;

    static void solve() throws Exception {

        int testCase = nextInt();
        boolean first = true;

        while(testCase-- > 0) {

            String tourName = bufferedReader.readLine();
            HashMap<String, Integer> teamId = new HashMap<String, Integer>();

            int numTeams = nextInt();
            ArrayList<Team> teams = new ArrayList<Team>();

            for (int i = 0; i < numTeams; ++i) {
                String teamName = bufferedReader.readLine();
                teamId.put(teamName, i);
                teams.add(new Team(teamName));
            }

            int numGames = nextInt();

            while(numGames-- > 0){
                String game = bufferedReader.readLine();
                String[] parts = game.split("[#@]");
                assert (parts.length == 4);

                String team1 = parts[0];
                int goal1 = Integer.parseInt(parts[1]);
                String team2 = parts[3];
                int goal2 = Integer.parseInt(parts[2]);

                int id1 = teamId.get(team1);
                int id2 = teamId.get(team2);
                teams.get(id1).update(goal1, goal2);
                teams.get(id2).update(goal2, goal1);
            }

            Collections.sort(teams);
            int count = 1;

            if(first) first = false;
            else printWriter.println();

            printWriter.println(tourName);
            for(Team team: teams) {
                printWriter.printf("%d) %s %dp, %dg (%d-%d-%d), %dgd (%d-%d)%n",
                        count++, team.name, team.points, team.played, team.wins, team.ties, team.loses, team.diff, team.scored, team.against);
            }
        }
        printWriter.flush();
    }

    static class Team implements Comparable<Team> {

        String name;
        int wins, loses, ties, played, scored, against, points, diff;
        public Team(String name) {
            this.name = name;
            this.wins = 0;
            this.loses = 0;
            this.ties = 0;
            this.played = 0;
            this.scored = 0;
            this.against = 0;
            this.points = 0;
            this.diff = 0;
        }
        public void update(int scored, int against) {
            ++this.played;
            this.scored += scored;
            this.against += against;
            if (scored > against) {
                ++this.wins;
                this.points += 3;
            } else if (scored < against)
                ++this.loses;
            else {
                ++this.ties;
                ++this.points;
            }
            this.diff = this.scored - this.against;
        }
        public int compareTo(Team t) {
            if (this.points != t.points) return t.points - this.points;
            if (this.wins != t.wins) return t.wins - this.wins;
            if (this.diff != t.diff) return t.diff - this.diff;
            if (this.scored != t.scored) return t.scored - this.scored;
            if (this.played != t.played) return this.played - t.played;
            return this.name.toLowerCase().compareTo(t.name.toLowerCase());
        }
    }


    public static void main(String[] args) {

        try {

            //Converting UTF-8 to ISO-8859-1
            bufferedReader = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
            printWriter = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
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
