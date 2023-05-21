package hu.nye.mestint.service;

import hu.nye.mestint.model.enums.Operation;
import hu.nye.mestint.persistance.xml.XmlManager;
import hu.nye.mestint.service.search.AbstractState;
import hu.nye.mestint.service.search.State;
import hu.nye.mestint.ui.TableUI;
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

    private final XmlManager xmlManager = new XmlManager();
    private final ArrayUtil arrayUtil = new ArrayUtil();
    private final Operations operations = new Operations();
    private static int size = 3;
    private int stateCount = 0;

    private String [][] table = arrayUtil.convertTableToStringTable(xmlManager.getTables().getInitialTable());

    private Operation lastOperation = null;
    private Integer lastA = null;
    private Integer lastB =  null;

    PuzzleN (PuzzleN parent, Operation operation, int a, int b) {
        super(parent);

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

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i == j) {
                    continue;
                }

                if(!Objects.isNull(lastOperation) && !Objects.isNull(lastA) && !Objects.isNull(lastB)) {
                    if ((lastA == i && lastB == j) || (lastA == j && lastB == i)) {

                        if (lastOperation.equals(Operation.HORIZONTAL)) {
                            possibleMoves.add(new PuzzleN(this, Operation.VERTICAL, i, j));
                        } else {
                            possibleMoves.add(new PuzzleN(this, Operation.HORIZONTAL, i, j));
                        }
                    }
                }
                possibleMoves.add(new PuzzleN(this, Operation.HORIZONTAL, i, j));
                possibleMoves.add(new PuzzleN(this, Operation.VERTICAL, i, j));
            }
        }
        return possibleMoves;
    }

    @Override
    public boolean isSolution() {
        String[][] convert = arrayUtil.convertTableToStringTable(xmlManager.getTables().getEndTable());
        return Arrays.deepEquals(table, convert);
    }

    @Override
    public double getHeuristic() {
        return 0;
    }

    @Override
    public String toString() {
        return TableUI.getToString(this);
    }
}