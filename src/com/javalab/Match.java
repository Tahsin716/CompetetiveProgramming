package com.javalab;

public class Match {

    private int serialNumber;
    private Team[] teams = new Team[2];


    public Match(int serialNumber, Team team1, Team team2) {

        this.serialNumber = serialNumber;
        teams[0] = team1;
        teams[1] = team2;
    }
}
