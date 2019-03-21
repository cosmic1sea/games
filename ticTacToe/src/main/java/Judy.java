//package main.java;

import lombok.Builder;
import lombok.NonNull;
import objects.Board;
import players.Player;

@Builder
public class Judy
{
    boolean boardFull = false;

    boolean isPlayerOneTurn = true;

    @NonNull
    final Player playerOne;

    @NonNull
    final Player playerTwo;

    final Board board;

    public void runGame()
    {
        while (!boardFull)
        {
            if (isPlayerOneTurn)
            {
                playerOne.makeMove(board.getTheBoard());
            }
            else
            {
                playerTwo.makeMove(board.getTheBoard());
            }
            boardFull = board.isBoardFull();
            isPlayerOneTurn = !isPlayerOneTurn;
        }

    }


}
