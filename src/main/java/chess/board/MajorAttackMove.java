package chess.board;

import chess.pieces.Piece;

public class MajorAttackMove extends AttackMove {

    public MajorAttackMove (final Board board,
                            final Piece movedPiece,
                            final int destinationCoordinate,
                            final Piece attackedPiece){
        super(board, movedPiece, destinationCoordinate, attackedPiece);
    }

    @Override
    public boolean equals(Object other) {
        return this == other || other instanceof AttackMove && super.equals(other);
    }
    @Override
    public String toString(){
        return movedPiece.getPieceType() + BoardUtils.getPositionAtCoordinate(this.destinationCoordinate);
    }
}
