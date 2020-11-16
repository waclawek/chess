package chess.board;

import chess.pieces.Piece;
import chess.pieces.Rook;

public class QueenSideCastelMove extends CastleMove {

    public QueenSideCastelMove(Board board, Piece movedPiece, int destinationCoordinate, Rook castleRook, int castleRookStart, int castleRookDestination) {
        super(board, movedPiece, destinationCoordinate, castleRook, castleRookStart, castleRookDestination);
    }

    @Override
    public String toString() {
        return "0-0-0";
    }

    @Override
    public boolean equals(Object other){
        return this == other || other instanceof QueenSideCastelMove && super.equals(other);
    }
}



