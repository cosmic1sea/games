package com.hackerz.ticTacToe;

import com.hackerz.ticTacToe.objects.Board;
import com.hackerz.ticTacToe.players.Player;
import lombok.Builder;
import lombok.NonNull;

@Builder
public class Judy
{
    private boolean isWinner = false;

    private boolean isDraw = false;

    private boolean isPlayerOneTurn = true;

    @NonNull
    final Player playerOne;

    @NonNull
    final Player playerTwo;

    final Board board;
   
    final Orwell orwell = new Orwell();

    public void runGame()
    {
        while (!isDraw || !isWinner)
        {
            if (isPlayerOneTurn)
            {
                playerOne.makeMove(board.getTheBoard());
            }
            else
            {
                playerTwo.makeMove(board.getTheBoard());
            }

            // Determine if there is a winner or if there was a draw
            isWinner = board.isWinner();
            if (isWinner)
            {
                if (isPlayerOneTurn)
                {
                    System.out.println("Player one is the winner!");
                }
                else
                {
                    System.out.println("Player two is the winner!");
                }
                break;
            }
            isDraw = board.isDraw();
            if (isDraw)
            {
                System.out.println("It was a draw!");
                break;
            }

            // Other player's turn
            isPlayerOneTurn = !isPlayerOneTurn;
            orwell.writeToFile();
        }
    }
}
