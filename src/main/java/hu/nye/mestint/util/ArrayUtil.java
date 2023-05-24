package hu.nye.mestint.util;

import hu.nye.mestint.model.table.Table;

import java.util.Arrays;

public class ArrayUtil {
    public String[][] convertTableToStringArray(Table table) {

        String[][] result = new String[table.getRows().size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = table.getRows().get(i).getElements().toArray(new String[0]);
        }

        return result;
    }
    public String[][] deepCopy(String[][] array) {

        String[][] result = new String[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Arrays.copyOf(array[i], array[i].length);
        }
        return result;
    }
}