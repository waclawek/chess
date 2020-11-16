package chess.board;

public class MoveFactory {
    private static final Move NULL_MOVE = new NullMove();

    private MoveFactory(){
        throw new RuntimeException("No instantable!!");
    }
    public static Move getNullMove(){ return NULL_MOVE;}

    public static Move createMove(final Board board,
                                   final int currentCoordinate,
                                   final int destinationCoordinate){

        for(final Move move : board.getAllLegalMoves()){
            if(move.getCurrentCoordinate() == currentCoordinate &&
            move.getDestinationCoordinate() == destinationCoordinate){
                return move;
            }
        }
        // miało byc return NULL_MOVE ale ukryłem NULL MOVE bo dawało będy
        return NULL_MOVE;

    }


}
