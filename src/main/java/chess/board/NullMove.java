package chess.board;

import chess.pieces.Piece;

public class NullMove extends Move {
    /*
    NullMove(Board board, Piece movedPiece, int destinationCoordinate) {
        super(board, movedPiece, destinationCoordinate);
    }

     */

    public NullMove() {
        super(null,65);
    }

    @Override
    public Board execute() {
        throw new RuntimeException("null move exception can't move");
    }

    @Override
    public int getCurrentCoordinate() {
        return -1;
    }

    @Override
    public int getDestinationCoordinate() {
        return -1;
    }

    @Override
    public String toString() {
        return "Null Move";
    }
}
