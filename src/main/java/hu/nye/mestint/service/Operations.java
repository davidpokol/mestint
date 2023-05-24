package hu.nye.mestint.service;

public class Operations {

    public String[][] swapRows(String[][] table, int firstRowIndex, int secondRowIndex) {

        String[] tmp = table[firstRowIndex];
        table[firstRowIndex] = table[secondRowIndex];
        table[secondRowIndex] = tmp;

        return table;
    }

    public String[][] swapColumns(String[][] table, int firstColumnIndex, int secondColumnIndex) {

        String[] tmp = new String[table.length];

        for (int i = 0; i < table.length; i++) {
            tmp[i] = table[i][firstColumnIndex];
        }
        for (int i = 0; i < table.length; i++) {
            table[i][firstColumnIndex] = table[i][secondColumnIndex];
        }
        for (int i = 0; i < table.length; i++) {
            table[i][secondColumnIndex] = tmp[i];
        }

        return table;
    }

    public boolean areColumnsEqual(String[][] table, int firstColumnIndex, int secondColumnIndex) {
        int elementsMatch = 0;
        for (int a = 0; a < table.length; a++) {
            if (table[a][firstColumnIndex].equals(table[a][secondColumnIndex])) {
                elementsMatch++;
            }
        }
        return elementsMatch == table.length;
    }
}
