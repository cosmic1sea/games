package com.hackerz.ticTacToe.players;

import java.util.Map;

public interface Player
{
    Map<String, Character> makeMove(final Map<String, Character> currentBoard);
}
