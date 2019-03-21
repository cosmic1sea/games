package com.hackerz.ticTacToe.players;


import java.util.HashMap;
import java.util.Map;

public class Glados implements Player
{
    private final Map<String, Integer> weightedValues = new HashMap<>();

    @Override
    public Map<String, Character> makeMove(final Map<String, Character> currentBoard)
    {
        initWeightedValues();
        evaluate(currentBoard);
    }

    private void evaluate(final Map<String, Character> currentBoard)
    {
//        if (currentBoard.get("B2").equals()
    }

    private void initWeightedValues()
    {
        weightedValues.put("A2", 2);
        weightedValues.put("B1", 2);
        weightedValues.put("B3", 2);
        weightedValues.put("C2", 2);

        weightedValues.put("A1", 3);
        weightedValues.put("A3", 3);
        weightedValues.put("C1", 3);
        weightedValues.put("C3", 3);

        weightedValues.put("B2", 4);
    }

}
