package com.hackerz.ticTacToe.players;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerImpl implements Player
{
    @Override
    public Map<String, Character> makeMove(final Map<String, Character> currentBoard)
    {
        // TODO: link to Jeff
        // read from Jeff's file
        final List<String> fileListStructure = new ArrayList<>(); // temp

        return convertListStructureToBoard(fileListStructure);
    }

    private Map<String, Character> convertListStructureToBoard(final List<String> fileListStructure)
    {
        // todo
    }
}
