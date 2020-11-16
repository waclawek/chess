package chess.board;

import chess.pieces.Piece;

public class EmptyTile extends Tile {

    EmptyTile(int tileCoordinate) {
        super(tileCoordinate);
    }

    public String toString(){
        return "-";
    }



    public boolean isTileOccupied() {
        return false;
    }

    public Piece getPiece() {
        return null;
    }
}
