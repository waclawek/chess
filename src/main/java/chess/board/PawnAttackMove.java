package chess.board;

import chess.pieces.Piece;

public class PawnAttackMove extends AttackMove {
    public PawnAttackMove(Board board, Piece movedPiece, int destinationCoordinate, Piece attackedPiece) {
        super(board, movedPiece, destinationCoordinate, attackedPiece);
    }

    @Override
    public boolean equals(final Object other){
         return this == other || other instanceof PawnAttackMove && super.equals(other);
    }

    @Override
    public String toString(){
        return BoardUtils.getPositionAtCoordinate(this.movedPiece.getPiecePosition()) + "x" +
                BoardUtils.getPositionAtCoordinate(this.destinationCoordinate);
    }
}
