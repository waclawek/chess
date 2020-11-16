package chess.player;

import chess.board.Board;
import chess.board.Move;

public class MoveTransition {
    private final Board transtionBoard;
    private final Move move;
    private final MoveStatus moveStatus;

    public MoveTransition(Board transtionBoard, Move move, MoveStatus moveStatus) {
        this.transtionBoard = transtionBoard;
        this.move = move;
        this.moveStatus = moveStatus;
    }
    public MoveStatus getMoveStatus(){
        return this.moveStatus;
    }

    public Board getBoard(){
        return this.transtionBoard;
    }
}
