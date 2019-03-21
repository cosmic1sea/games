package com.hackerz.ticTacToe.players;


import com.hackerz.ticTacToe.objects.Mark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The all powerful machine learning robot.
 */
public class Glados implements Player
{
    /**
     * Map of values which determine which spaces have the highest likelihood of winning.
     */
    private final Map<String, Integer> weightedValues = new HashMap<>();

    private final Character myMark = Mark.O;

    private final Character enemyMark = Mark.X;

    @Override
    public Map<String, Character> makeMove(final Map<String, Character> currentBoard)
    {
        initWeightedValues();
        final String newSpace = evaluate(currentBoard);
        currentBoard.put(newSpace, myMark);
        return currentBoard;
    }

    /**
     * Currently randomly picks a move based on weight.
     *
     * @param currentBoard - the current board state
     * @return new move
     */
    private String evaluate(final Map<String, Character> currentBoard)
    {
        final Random random = new Random();

        // Weight of 4
        if (isSpaceEmpty("B2",currentBoard))
        {
            return "B2";
        }

        // Weight of 3
        List<String> weightThreePossibilities = new ArrayList<>();

        if (isSpaceEmpty("A1",currentBoard))
        {
            weightThreePossibilities.add("A1");
        }
        if (isSpaceEmpty("A3",currentBoard))
        {
            weightThreePossibilities.add("A3");
        }
        if (isSpaceEmpty("C1",currentBoard))
        {
            weightThreePossibilities.add("C1");
        }
        if (isSpaceEmpty("C3",currentBoard))
        {
            weightThreePossibilities.add("C3");
        }

        // Only one option
        if (weightThreePossibilities.size() == 1)
        {
            return weightThreePossibilities.get(0);
        }
        else if (weightThreePossibilities.size() > 1)
        {
            return weightThreePossibilities.get(random.nextInt(weightThreePossibilities.size()));
        }


        // Weight of 2
        List<String> weightTwoPossibilities = new ArrayList<>();

        if (isSpaceEmpty("A2",currentBoard))
        {
            weightTwoPossibilities.add("A2");
        }
        if (isSpaceEmpty("B1",currentBoard))
        {
            weightTwoPossibilities.add("B1");
        }
        if (isSpaceEmpty("B3",currentBoard))
        {
            weightTwoPossibilities.add("B3");
        }
        if (isSpaceEmpty("C2",currentBoard))
        {
            weightTwoPossibilities.add("C2");
        }

        // Only one option
        if (weightTwoPossibilities.size() == 1)
        {
            return weightTwoPossibilities.get(0);
        }
        else if (weightTwoPossibilities.size() > 1)
        {
            return weightTwoPossibilities.get(random.nextInt(weightTwoPossibilities.size()));
        }
        return null;
    }

    /**
     * Is the given space available for our mark?
     *
     * @param coordinates - space in question
     * @param currentBoard - current board state
     * @return state of the coordinates
     */
    private boolean isSpaceEmpty(final String coordinates, final Map<String, Character> currentBoard)
    {
        // Is the enemy mark on a space or not empty? (Could be our mark)
        return !(currentBoard.get(coordinates).equals(enemyMark) || !currentBoard.get(coordinates).equals(Mark.EMPTY));
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
