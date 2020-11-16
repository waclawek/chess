package chess.board;

import chess.pieces.Piece;

public class PawnMove extends Move {
    public PawnMove(Board board, Piece movedPiece, int destinationCoordinate) {
        super(board, movedPiece, destinationCoordinate);
    }

    @Override
    public boolean equals(final Object other){
        return this == other || other instanceof PawnMove && super.equals(other);
    }
    @Override
    public String toString(){
        return BoardUtils.getPositionAtCoordinate(this.destinationCoordinate);
    }
}
