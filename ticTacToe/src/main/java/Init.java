import objects.Board;
import players.Glados;
import players.Player;
import players.PlayerImpl;

class Init
{
    public static void main(String[] args)
    {
        init();
    }

    static private void init()
    {
        Board newBoard = new Board();
        final Player humanPlayer = new PlayerImpl();
        final Player robot = new Glados();
        final Judy judge = Judy.builder().build();


        char[][] board = newBoard.getEmptyBoard();


    }
}