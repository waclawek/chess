package chess.board;

import chess.pieces.Piece;
import chess.pieces.Rook;

public class KingSideCastleMove extends CastleMove {
    public KingSideCastleMove(Board board, Piece movedPiece, int destinationCoordinate, Rook castleRook, int castleRookStart, int castleRookDestination) {
        super(board, movedPiece, destinationCoordinate, castleRook, castleRookStart, castleRookDestination);
    }

    @Override
    public String toString() {
        return "0-0";
    }

    @Override
    public boolean equals(Object other){
        return this == other || other instanceof KingSideCastleMove && super.equals(other);
    }
}
