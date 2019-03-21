package com.hackerz.ticTacToe;

import com.hackerz.ticTacToe.objects.Board;
import com.hackerz.ticTacToe.players.Glados;
import com.hackerz.ticTacToe.players.Player;
import com.hackerz.ticTacToe.players.PlayerImpl;

class Init
{
    public static void main(String[] args)
    {
        init();
    }

    static private void init()
    {
        Board newBoard = new Board();
        final Player humanPlayer = new PlayerImpl();
        final Player robot = new Glados();
        final Judy judge = Judy
                .builder()
                .playerOne(humanPlayer)
                .playerTwo(robot)
                .board(newBoard)
                .build();
        judge.runGame();
    }
   
}