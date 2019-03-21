import lombok.Builder;
import objects.Board;
import players.Player;

@Builder
public class Judy
{
    boolean boardFull = false;

    final Player playerOne;

    final Player playerTwo;

    final Board board;

    public void runGame()
    {

        while (boardFull)
        {


            boardFull = board.isBoardFull();
        }

    }


}
