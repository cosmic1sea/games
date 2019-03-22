package com.hackerz.ticTacToe.players;

import com.hackerz.ticTacToe.objects.Mark;

import java.util.ArrayList;
import java.util.Arrays;
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
    private final Map<String, Integer> weightedValuesEmptyBoard = new HashMap<>();

    private final List<List<String>> winningRows = new ArrayList<>();

    private final Character myMark = Mark.O;

    private final Character enemyMark = Mark.X;

    private final Random random = new Random();

    private Map<String, Character> currentBoard;

    @Override
    public Map<String, Character> makeMove(final Map<String, Character> currentBoard)
    {
        this.currentBoard = currentBoard;
        initWeightedMaps();
        // Make sure we select center first if available
        if (selectCenterIfAvailable())
        {
            this.currentBoard.put("B2", myMark);
            return this.currentBoard;
        }
        // todo handle pincer middle
        final String newSpace = evaluateRandomly();
        currentBoard.put(newSpace, myMark);
        return this.currentBoard;
    }

    private boolean selectCenterIfAvailable()
    {
        return isSpaceEmpty("B2");
    }

    private void blockEnemyWinningSpaces()
    {
        currentBoard.forEach((coords, mark) -> {
            if (!isSpaceEmpty(coords) && isSpaceEnemy(coords))
            {

            }
        });

        List<List<String>> possibleEnemyWinningRows = new ArrayList<>();

        winningRows.forEach(list -> {
            if (list.contains(currentBoard.toString()))
            {
                possibleEnemyWinningRows.add(list);
            }
        });

        // if a space appears in 2 arrays it intersects

        // determine imperative block

        // determine logical block (pincer attack)

        // attack if nothing above

        // will determine if first move
    }

    private void availableWinningSpaces()
    {

        // always use old moves that could produce a win
    }

    // TODO weighted map needs to change based on turn

    /**
     * Currently randomly picks a move based on weight.
     *
     * @return new move
     */
    private String evaluateRandomly()
    {
        // Weight of 4
        if (isSpaceEmpty("B2"))
        {
            return "B2";
        }

        // Weight of 3
        List<String> weightThreePossibilities = new ArrayList<>();

        if (isSpaceEmpty("A1"))
        {
            weightThreePossibilities.add("A1");
        }
        if (isSpaceEmpty("A3"))
        {
            weightThreePossibilities.add("A3");
        }
        if (isSpaceEmpty("C1"))
        {
            weightThreePossibilities.add("C1");
        }
        if (isSpaceEmpty("C3"))
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

        if (isSpaceEmpty("A2"))
        {
            weightTwoPossibilities.add("A2");
        }
        if (isSpaceEmpty("B1"))
        {
            weightTwoPossibilities.add("B1");
        }
        if (isSpaceEmpty("B3"))
        {
            weightTwoPossibilities.add("B3");
        }
        if (isSpaceEmpty("C2"))
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
     * @return state of the coordinates
     */
    private boolean isSpaceEmpty(final String coordinates)
    {
        // Is the enemy mark on a space or not empty? (Could be our mark)
        return !(currentBoard.get(coordinates).equals(enemyMark) || !currentBoard.get(coordinates).equals(Mark.EMPTY));
    }

    private boolean isSpaceEnemy(final String coordinates)
    {
        return currentBoard.get(coordinates).equals(enemyMark);
    }

    /**
     * If we end up with a board position that has the enemy has opposing corners (we will assume we have already
     * selected the center space because it has the highest value) then we can't select a corner even though
     * at first glance that makes sense. We need to be on the attack instead of blocking the intersecting
     * winning moves.
     *
     * @param possibleCornerOne - possible corner one
     * @param possibleCornerTwo - possible corner two
     * @return - a randomly selected middle space or null if no case is met
     */
    private String handleOpposingPincerAttack(final String possibleCornerOne, final String possibleCornerTwo)
    {
        if (possibleCornerOne.equals("A1") && possibleCornerTwo.equals("C3"))
        {
            return pickMiddleSpaceAtRandom();
        }
        if (possibleCornerOne.equals("C1") && possibleCornerTwo.equals("A3"))
        {
            return pickMiddleSpaceAtRandom();
        }
        if (possibleCornerOne.equals("C3") && possibleCornerTwo.equals("A1"))
        {
            return pickMiddleSpaceAtRandom();
        }
        if (possibleCornerOne.equals("A3") && possibleCornerTwo.equals("C1"))
        {
            return pickMiddleSpaceAtRandom();
        }
        return null;
    }

    private String pickMiddleSpaceAtRandom()
    {
        final List<String> middleMoves = Arrays.asList("A2", "B1", "B3", "C2");
        return middleMoves.get(random.nextInt(3));
    }

//    private boolean areSpacesEmpty(final Map<String, Character> currentBoard, final String... coordinates)
//    {
//        for (String string : coordinates)
//        {
//
//        }
//    }

    private void initWeightedMaps()
    {
        // Weighted values empty board
        weightedValuesEmptyBoard.put("A2", 2);
        weightedValuesEmptyBoard.put("B1", 2);
        weightedValuesEmptyBoard.put("B3", 2);
        weightedValuesEmptyBoard.put("C2", 2);

        weightedValuesEmptyBoard.put("A1", 3);
        weightedValuesEmptyBoard.put("A3", 3);
        weightedValuesEmptyBoard.put("C1", 3);
        weightedValuesEmptyBoard.put("C3", 3);

        weightedValuesEmptyBoard.put("B2", 4);

        // Winning rows
        winningRows.add(Arrays.asList("A1", "A2", "A3"));
        winningRows.add(Arrays.asList("B1", "B2", "B3"));
        winningRows.add(Arrays.asList("C1", "C2", "C3"));
        winningRows.add(Arrays.asList("A1", "B1", "C1"));
        winningRows.add(Arrays.asList("A2", "B2", "C2"));
        winningRows.add(Arrays.asList("A3", "B3", "C3"));
        winningRows.add(Arrays.asList("A1", "B2", "C3"));
        winningRows.add(Arrays.asList("A3", "B2", "C1"));
    }

}
