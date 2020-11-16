package chess.player.ai;

import chess.board.Board;
import chess.board.Move;

public interface MoveStrategy {

    public Move execute(Board board);
}
