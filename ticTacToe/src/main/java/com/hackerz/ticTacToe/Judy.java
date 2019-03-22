package com.hackerz.ticTacToe;

import com.hackerz.ticTacToe.objects.Board;
import com.hackerz.ticTacToe.players.Player;
import lombok.Builder;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Map;

@Builder
public class Judy
{
    private FileWatcher fileWatcher;

    private boolean isWinner = false;

    private boolean isDraw = false;

    private boolean isGladosTurn = false;

    @NonNull
    final Player playerOne;

    @NonNull
    final Player playerTwo;

    final Board board;
   
    final Orwell orwell = new Orwell();

    boolean shouldStartFileWatcher = true;

    @SneakyThrows
    public void runGame()
    {
        if (shouldStartFileWatcher)
        {
            fileWatcher = new FileWatcher("/Users/christophermosley/workspace/file.txt", this);
            fileWatcher.start();
            shouldStartFileWatcher = false;
            fileWatcher.join();
        }
        else
        {
            playerTwo.makeMove(board.getTheBoard());
            orwell.writeToFile(board.getTheBoard());

            // Determine if there is a winner or if there was a draw
            isWinner = board.isWinner();
            if (isWinner)
            {
                if (isGladosTurn)
                {
                    System.out.println("YOU HAVE BEEN BEATEN BY GLADOS, LITERALLY A ROBOT.");
                } else
                {
                    System.out.println("THIS WASN'T SUPPOSED TO HAPPEN");
                }
            }
            isDraw = board.isDraw();
            if (isDraw)
            {
                System.out.println("YOU ARE EQUAL BUT NOT REALLY.");
            }

            System.out.println("meow");
            if (isWinner || isDraw)
            {
                System.out.println("fatality");
                fileWatcher.stopThread();
            }
        }
    }

    public void orderInTheCourt(final List<String> fileListStructure)
    {
        isGladosTurn = !isGladosTurn;
        if (isGladosTurn)
        {
            runGame();
        }
        Map<String, String> newBoardFromFile = orwell.convertListStructureToBoard(fileListStructure);
        System.out.println(newBoardFromFile);
        System.out.println("Something was updated.");
    }
}
