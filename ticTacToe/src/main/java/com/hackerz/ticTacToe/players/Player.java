package com.hackerz.ticTacToe.players;

import com.hackerz.ticTacToe.objects.Board;

public interface Player
{
    Board makeMove(final Board currentBoard);
}
