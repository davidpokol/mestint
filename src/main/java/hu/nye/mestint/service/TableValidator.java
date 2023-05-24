package hu.nye.mestint.service;

import hu.nye.mestint.service.exception.TableSizeException;

public class TableValidator {

    public void validate(String[][] table) throws TableSizeException {

        int size = table.length;

        if(size < 2) {
            throw new TableSizeException("The table must contain at least two rows!");
        }

        for (int i = 0; i < size; i++) {

            int rowLength = table[i].length;
            if(rowLength < 2) {
                throw new TableSizeException("The rows must contain at least two elements!");
            }
            if (rowLength != size) {
                throw new TableSizeException("The table must be symmetrical!");
            }
        }
    }

    public void compare(int initSize, int endSize) {

        if (initSize != endSize) {
            throw new TableSizeException("The size of the initTable must match the size of the endTable!");
        }
    }
}