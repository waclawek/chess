package chess.board;

import chess.pieces.Piece;

public final class MajorMove extends Move {

    public MajorMove(Board board, Piece movedPiece, int destinationCoordinate) {
        super(board, movedPiece, destinationCoordinate);
    }

    @Override
    public boolean equals(Object obj) {
        return  this == obj || obj instanceof MajorMove && super.equals(obj);
    }

    @Override
    public String toString() {
        return movedPiece.getPieceType().toString() + BoardUtils.getPositionAtCoordinate(this.destinationCoordinate);
    }
}

