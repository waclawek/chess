package chess.player.ai;

import chess.board.Board;

public interface BoardEvaluator {

    public int evaluate(Board board, int depth);
}
