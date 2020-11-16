package chess.board;

import java.util.*;

public class BoardUtils {


    public static final boolean[] FIRST_COLUMN = initColumn(0);
    public static final boolean[] SECOND_COLUMN = initColumn(1);
    public static final boolean[] SEVENTH_COLUMN = initColumn(6);
    public static final boolean[] EIGHTH_COLUMN = initColumn(7);

    public static final boolean[] EIGHT_RANK = initRow(0);
    public static final boolean[] SEVENTH_RANK = initRow(8);
    public static final boolean[] SIXTH_RANK = initRow(16);
    public static final boolean[] FIFTH_RANK = initRow(24);
    public static final boolean[] FOURTH_RANK = initRow(32);
    public static final boolean[] THIRD_RANK = initRow(40);
    public static final boolean[] SECOND_RANK = initRow(48);
    public static final boolean[] FIRST_RANK = initRow(56);

    public static final List<String> ALGEBRAIC_NOTATION = initializeAlgebraicNotation();
    public static final Map<String, Integer> POSITION_TO_COORDINATE = initializePositionToCoordinateMap();
    public static final int START_TILE_INDEX = 0 ;
    public static final int TILE_NUMBER = 64;
    public static final int NUM_TILES_PER_ROW = 8;


    public static Map<String, Integer> initializePositionToCoordinateMap() {
        final Map<String, Integer> positionMap = new HashMap<>();
        for(int i = START_TILE_INDEX; i < TILE_NUMBER; i++){
            positionMap.put(ALGEBRAIC_NOTATION.get(i), i);
        }
        return Collections.unmodifiableMap(positionMap);
    }

    public static final List<String> initializeAlgebraicNotation() {
        return Collections.unmodifiableList(Arrays.asList(
                "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8",
                "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7",
                "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6",
                "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5",
                "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4",
                "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3",
                "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2",
                "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"));
    }


    public BoardUtils() {
    throw new RuntimeException("You can't create me");
    }


    private static boolean[] initColumn(int columnNumber){
        boolean[] column = new boolean[TILE_NUMBER];
        for (int i = 0; i < column.length; i++) {
            column[i] = false;
        }
        do {
            column[columnNumber] = true;
            columnNumber += NUM_TILES_PER_ROW;
        }while (columnNumber < TILE_NUMBER);
        return column;
    }

    private static boolean[] initRow(int startTileNumber){
        final boolean[] row = new boolean[TILE_NUMBER];
        do {
            row[startTileNumber] = true;
            startTileNumber++;
        }while(startTileNumber % NUM_TILES_PER_ROW != 0);

        return row;
    }

    public static boolean isValidTileCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate < 64;
    }

    public static int getCoordinateAtPosition(final String position){
        return POSITION_TO_COORDINATE.get(position);
    }

    public static String getPositionAtCoordinate(final int coordinate){
        return ALGEBRAIC_NOTATION.get(coordinate);
    }
}