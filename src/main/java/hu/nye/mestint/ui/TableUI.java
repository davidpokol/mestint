package hu.nye.mestint.ui;

import hu.nye.mestint.service.PuzzleN;

public class TableUI {

    public static String getToString(PuzzleN puzzleN) {

        StringBuilder sb = new StringBuilder();

        sb.append("------------------\n");
        sb.append(String.format("|%d| Operation: %s, a:%d, b:%d\n",
                puzzleN.getStateCount(), puzzleN.getLastOperation(), puzzleN.getLastA(), puzzleN.getLastB()));

        for (String[] row : puzzleN.getTable()) {
            for (String element : row) {
                sb.append(String.format("%s, ", element));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}