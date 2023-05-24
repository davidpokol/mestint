package hu.nye.mestint.service;

import hu.nye.mestint.model.enums.Operation;
import hu.nye.mestint.persistance.xml.XmlManager;
import hu.nye.mestint.service.search.AbstractState;
import hu.nye.mestint.service.search.State;
import hu.nye.mestint.ui.PuzzleNUI;
import hu.nye.mestint.util.ArrayUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
public class PuzzleN extends AbstractState {

    private XmlManager xmlManager = new XmlManager();
    private final ArrayUtil arrayUtil = new ArrayUtil();
    private final Operations operations = new Operations();

    private String [][] table = arrayUtil.convertTableToStringArray(xmlManager.getTables().getInitialTable());
    private String [][] endTable = arrayUtil.convertTableToStringArray(xmlManager.getTables().getEndTable());
    private int size = table.length;

    private int stateCount = 0;
    private Operation lastOperation = null;
    private Integer lastA = null;
    private Integer lastB =  null;

    PuzzleN (XmlManager xmlManager, PuzzleN parent, Operation operation, int a, int b) {
        super(parent);
        this.xmlManager = xmlManager;

        if(operation.equals(Operation.HORIZONTAL)) {
            this.table = operations.swapRows(arrayUtil.deepCopy(parent.table), a, b);
        } else {
            this.table = operations.swapColumns(arrayUtil.deepCopy(parent.table), a, b);
        }
        this.stateCount = parent.stateCount + 1;
        this.lastOperation = operation;
        this.lastA = a;
        this.lastB = b;
    }

    @Override
    public Iterable<State> getPossibleMoves() {

        List<State> possibleMoves = new ArrayList<>();

        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = k; j < size; j++) {
                if(i == j) {
                    continue;
                }

                if(!Objects.isNull(lastOperation) && !Objects.isNull(lastA) && !Objects.isNull(lastB)) {
                    if ((lastA == i && lastB == j) || (lastA == j && lastB == i)) {

                        if (lastOperation.equals(Operation.HORIZONTAL) && !Arrays.equals(table[i], table[j])) {
                            possibleMoves.add(new PuzzleN(xmlManager, this, Operation.VERTICAL, i, j));
                        } else if (!operations.areColumnsEqual(table, i, j)) {
                            possibleMoves.add(new PuzzleN(xmlManager, this, Operation.HORIZONTAL, i, j));
                        }
                    }
                }
                if(!Arrays.equals(table[i], table[j])) { // sor szerinti összehasonlítás
                    possibleMoves.add(new PuzzleN(xmlManager, this, Operation.HORIZONTAL, i, j));
                }

                if (!operations.areColumnsEqual(table, i, j)) {// oszlop szerinti összehasonlítás
                    possibleMoves.add(new PuzzleN(xmlManager, this, Operation.VERTICAL, i, j));
                }
            }
            k++;
        }
        return possibleMoves;
    }




    @Override
    public boolean isSolution() {
        return Arrays.deepEquals(table, endTable);
    }

    @Override
    public double getHeuristic() {
        int differentCharacters = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!table[i][j].equals(endTable[i][j])) {
                    differentCharacters++;
                }
            }
        }

        return differentCharacters;
    }

    @Override
    public String toString() {
        return PuzzleNUI.getToString(this);
    }
}