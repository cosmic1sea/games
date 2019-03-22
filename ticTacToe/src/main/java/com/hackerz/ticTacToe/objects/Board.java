package com.hackerz.ticTacToe.objects;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Board
{
    @Getter
    Map<String, Character> theBoard = new HashMap<>();

    public Board()
    {
        wipeBoard();
    }

    private void wipeBoard()
    {
        theBoard.put("A1", Mark.EMPTY);
        theBoard.put("A2", Mark.EMPTY);
        theBoard.put("A3", Mark.EMPTY);
        theBoard.put("B1", Mark.EMPTY);
        theBoard.put("B2", Mark.EMPTY);
        theBoard.put("B3", Mark.EMPTY);
        theBoard.put("C1", Mark.EMPTY);
        theBoard.put("C2", Mark.EMPTY);
        theBoard.put("C3", Mark.EMPTY);
    }

    private boolean isBoardFull()
    {
        return !theBoard.containsValue(Mark.EMPTY);
    }

    public boolean isDraw()
    {
        return isBoardFull() && !isWinner();
    }

    public boolean isWinner()
    {
        //Horizontal
        if(theBoard.get("A1") == Mark.X && theBoard.get("A2") == Mark.X && theBoard.get("A3") == Mark.X
                || theBoard.get("A1") == Mark.O && theBoard.get("A2") == Mark.O && theBoard.get("A3") == Mark.O)
        {
            return true;
        }
        if(theBoard.get("B1") == Mark.X && theBoard.get("B2") == Mark.X && theBoard.get("B3") == Mark.X
                || theBoard.get("B1") == Mark.O && theBoard.get("B2") == Mark.O && theBoard.get("B3") == Mark.O)
        {
            return true;
        }
        if(theBoard.get("C1") == Mark.X && theBoard.get("C2") == Mark.X && theBoard.get("C3") == Mark.X
                || theBoard.get("C1") == Mark.O && theBoard.get("C2") == Mark.O && theBoard.get("C3") == Mark.O)
        {
            return true;
        }
        //Vertical
        if(theBoard.get("A1") == Mark.X && theBoard.get("B1") == Mark.X && theBoard.get("C1") == Mark.X
                || theBoard.get("A1") == Mark.O && theBoard.get("B1") == Mark.O && theBoard.get("C1") == Mark.O)
        {
            return true;
        }
        if(theBoard.get("A2") == Mark.X && theBoard.get("B2") == Mark.X && theBoard.get("C2") == Mark.X
                || theBoard.get("A2") == Mark.O && theBoard.get("B2") == Mark.O && theBoard.get("C2") == Mark.O)
        {
            return true;
        }
        //Diagonal
        if(theBoard.get("A1") == Mark.X && theBoard.get("B2") == Mark.X && theBoard.get("C3") == Mark.X
                || theBoard.get("A1") == Mark.O && theBoard.get("B2") == Mark.O && theBoard.get("C3") == Mark.O)
        {
            return true;
        }
        if(theBoard.get("C1") == Mark.X && theBoard.get("B2") == Mark.X && theBoard.get("A3") == Mark.X
                || theBoard.get("C1") == Mark.O && theBoard.get("B2") == Mark.O && theBoard.get("A3") == Mark.O)
        {
            return true;
        }
        return false;
    }
}
