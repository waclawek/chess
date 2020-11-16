package chess.board;

import chess.pieces.Piece;

public class AttackMove extends Move {

    private final Piece attackedPiece;

    public AttackMove(Board board, Piece movedPiece, int destinationCoordinate, Piece attackedPiece) {
        super(board, movedPiece, destinationCoordinate);
        this.attackedPiece = attackedPiece;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = this.attackedPiece.hashCode() + super.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof AttackMove)){
            return false;
        }
        final AttackMove otherAttackMove = (AttackMove) obj;
        return  super.equals(otherAttackMove) && getAttackedPiece().equals(otherAttackMove.getAttackedPiece());
    }
    @Override
    public boolean isAttack(){
        return true;
    }
    public boolean isCastlingMove(){
        return false;
    }
    @Override
    public Piece getAttackedPiece(){
        return this.attackedPiece;
    }

    @Override
    public String toString() {
        return BoardUtils.getPositionAtCoordinate(this.getCurrentCoordinate()) + "x" +
                BoardUtils.getPositionAtCoordinate(this.destinationCoordinate);
    }
}
