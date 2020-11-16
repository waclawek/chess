package chess.board;

import chess.pieces.Pawn;
import chess.pieces.Piece;

public class PawnPromotion extends Move {
    final Move decerateMove;
    final Pawn promotedPawn;


    public PawnPromotion(final Move decorateMove) {
        super(decorateMove.getBoard(), decorateMove.getMovedPiece(), decorateMove.getDestinationCoordinate());
        this.decerateMove = decorateMove;
        this.promotedPawn = (Pawn) decorateMove.getMovedPiece();
    }
    @Override
    public int hashCode(){
      return decerateMove.hashCode() + (31* promotedPawn.hashCode());
    }

    @Override
    public boolean equals(Object other){
        return this == other || other instanceof PawnPromotion && (super.equals(other));
    }

    @Override
    public Board execute(){
        final Board pawnMovedBoard = this.decerateMove.execute();
        final Board.Builder builder = new Board.Builder();
        for(final Piece piece : pawnMovedBoard.currentPlayer().getActivePieces()){
            if(!(this.promotedPawn.equals(piece))){
                builder.setPiece(piece);
            }
        }
        for(final Piece piece : pawnMovedBoard.currentPlayer().getOpponent().getActivePieces()){
            builder.setPiece(piece);
        }
        builder.setPiece(this.promotedPawn.getPromotionPiece().movePiece(this));
        builder.setMoveMaker(pawnMovedBoard.currentPlayer().getOpponent().getAlliance());
        return builder.build();
    }
    @Override
    public boolean isAttack(){
        return this.decerateMove.isAttack();
    }
    @Override
    public Piece getAttackedPiece(){
        return this.decerateMove.getAttackedPiece();
    }
    @Override
    public String toString(){
        return "";
    }
}
