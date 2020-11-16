package chess.player.ai;

import chess.board.Board;
import chess.board.Move;
import chess.board.MoveFactory;
import chess.player.MoveTransition;

public class MiniMax implements MoveStrategy {

    private BoardEvaluator boardEvaluator;
    private int searchedDepth;

    public MiniMax(final int searchedDepth){
        this.boardEvaluator = new StandardBoardEvaluator();
        this.searchedDepth = searchedDepth;

    }

    @Override
    public Move execute(Board board) {
        // here we take existing Bord and evaluate it by MiniMax strategy and we throw Move we think is the best one

        final long startTime = System.currentTimeMillis();
        Move bestMove = MoveFactory.getNullMove();

        int highestValue = Integer.MIN_VALUE;
        int lowestValue = Integer.MAX_VALUE;
        int currentValue;

        System.out.println(board.currentPlayer() + " THINKING with depth = " + this.searchedDepth);

        int numMoves = board.currentPlayer().getLegalMoves().size();

        for(final Move move : board.currentPlayer().getLegalMoves()){
            final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
            if(moveTransition.getMoveStatus().isDone()){
                currentValue = board.currentPlayer().getAlliance().isWhite() ?
                        min(moveTransition.getBoard(), this.searchedDepth -1) :
                        max(moveTransition.getBoard(), this.searchedDepth -1);
                if(board.currentPlayer().getAlliance().isWhite() &&
                        currentValue >= highestValue){
                    highestValue = currentValue;
                    bestMove = move;
                } else if(board.currentPlayer().getAlliance().isBlack() &&
                        currentValue <= lowestValue){
                    lowestValue = currentValue;
                    bestMove = move;
                }
            }
        }
        final long executionTime = System.currentTimeMillis() - startTime;
        return bestMove;
    }

    public int min(final Board board,
                   final int depth){
        if(depth == 0  || isEndGameScenario(board) ){
            // when you finish going down on the tree and you reach the end of depth you evaluate the board \/
            return this.boardEvaluator.evaluate(board, depth);
        }
        // we go down the tree the number of layers as set depth in recursive way we call min and max
        int lowestSeenValue = Integer.MAX_VALUE;
        for(final Move move : board.currentPlayer().getLegalMoves()){
            final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
            if(moveTransition.getMoveStatus().isDone()){
                final int currentValue = max(moveTransition.getBoard(), depth -1);
                if(currentValue <= lowestSeenValue){
                    lowestSeenValue = currentValue;
                }
            }
        }
        return lowestSeenValue;
    }

    private boolean isEndGameScenario(Board board) {
        return board.currentPlayer().isInCheckMate() ||
                board.currentPlayer().isInStaleMate();
    }

    public int max(final Board board,
                   final int depth){
        if(depth == 0  || isEndGameScenario(board)){
            return this.boardEvaluator.evaluate(board, depth);
        }
        int highestSeenValue = Integer.MIN_VALUE;
        for(final Move move : board.currentPlayer().getLegalMoves()){
            final MoveTransition moveTransition = board.currentPlayer().makeMove(move);
            if(moveTransition.getMoveStatus().isDone()){
                final int currentValue = min(moveTransition.getBoard(), depth -1);
                if(currentValue >= highestSeenValue){
                    highestSeenValue = currentValue;
                }
            }
        }
        return highestSeenValue;
    }

    @Override
    public String toString() {
        return "MiniMax";
    }
}
