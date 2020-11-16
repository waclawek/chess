package chess.board;

import chess.pieces.Piece;

public class OccupiedTile extends Tile {

    private Piece pieceOnTile;

    OccupiedTile(int tileCoordinate, Piece pieceOnTile) {
        super(tileCoordinate);
        this.pieceOnTile = pieceOnTile;
    }

    @Override
    public String toString() {
        return getPiece().getPieceAlliance().isBlack() ? getPiece().toString().toLowerCase() :
                getPiece().toString();
    }

    @Override
    public boolean isTileOccupied() {
        return true;
    }
    @Override
    public Piece getPiece() {
        return this.pieceOnTile;
    }
}
