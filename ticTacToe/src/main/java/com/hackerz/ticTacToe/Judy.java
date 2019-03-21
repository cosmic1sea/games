package com.hackerz.ticTacToe;

import com.hackerz.ticTacToe.objects.Board;
import com.hackerz.ticTacToe.players.Player;
import lombok.Builder;
import lombok.NonNull;

@Builder
public class Judy
{
    boolean isWinner = false;

    boolean isDraw = false;

    public boolean isPlayerOneTurn = true;

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
                // did player 1 win?
                // was it a draw?
            }
            else
            {
                playerTwo.makeMove(board.getTheBoard());
                // did player 2 win?
                // was it a draw?
            }
            isPlayerOneTurn = !isPlayerOneTurn;
            orwell.writeToFile();
        }
        
    }
    
    public boolean stateChange()
    {
        
        return false;
    }
    
    
    
    

}
