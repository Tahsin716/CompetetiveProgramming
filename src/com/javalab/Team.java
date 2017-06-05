package com.javalab;

public class Team {

    private String name = "";
    private int id, win, loss;
    private Player[] players = new Player[2];


    public Team(String name, int id, int win, int loss, Player player1, Player player2) {

        this.name = name;
        this.id = id;
        this.win = win;
        this.loss = loss;
        players[0] = player1;
        players[1] = player2;
    }

}
