package objects;

public class Board
{
    private char[][] theBoard = new char[3][3];

    public char[][] getEmptyBoard()
    {
        wipeBoard();
        return theBoard;
    }

    public char[][] getTheBoard()
    {
        return theBoard;
    }

    public void setBoardState(final char[][] newState)
    {
        theBoard[0][0] = newState[0][0];
        theBoard[0][1] = newState[0][1];
        theBoard[0][2] = newState[0][2];
        theBoard[1][0] = newState[1][0];
        theBoard[1][1] = newState[1][1];
        theBoard[1][2] = newState[1][2];
        theBoard[2][0] = newState[2][0];
        theBoard[2][1] = newState[2][1];
        theBoard[2][2] = newState[2][2];
    }

    private void wipeBoard()
    {
        theBoard[0][0] = Mark.EMPTY;
        theBoard[0][1] = Mark.EMPTY;
        theBoard[0][2] = Mark.EMPTY;
        theBoard[1][0] = Mark.EMPTY;
        theBoard[1][1] = Mark.EMPTY;
        theBoard[1][2] = Mark.EMPTY;
        theBoard[2][0] = Mark.EMPTY;
        theBoard[2][1] = Mark.EMPTY;
        theBoard[2][2] = Mark.EMPTY;
    }

    public boolean isBoardFull()
    {
        return false;
    }
}
