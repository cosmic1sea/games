import lombok.Builder;
import lombok.NonNull;
import objects.Board;
import players.Player;

@Builder
public class Judy
{
    boolean boardFull = false;



    @NonNull
    final Player playerOne;

    @NonNull
    final Player playerTwo;

    final Board board;

    public void runGame()
    {
        while (boardFull)
        {
            playerOne.makeMove(board.getTheBoard());
            playerTwo.makeMove(board.getTheBoard());
            boardFull = board.isBoardFull();
        }

    }


}
