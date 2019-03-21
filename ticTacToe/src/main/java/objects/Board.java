package objects;

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

    public void setSpace (final String key, final Character value)
    {
        theBoard.put(key, value);
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

    public boolean isBoardFull()
    {
        return theBoard.containsValue(Mark.EMPTY);
    }

    public boolean isWinner()
    {

        return false;
    }
}
