package riscv;

import java.util.Collection;

import org.controlsfx.control.spreadsheet.GridChange;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;

import common.IMemory;
import common.IntegerParserUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;

public class DefaultMemory implements IMemory, EventHandler<GridChange> {

    private static final int MEMORY_SIZE_IN_BYTES = 1024;

    // protected byte[] memory = new byte[1024];
    private int[] memory = new int[1024];

    private int rowCount;

    private int columnCount;

    private ObservableList<ObservableList<SpreadsheetCell>> rows = FXCollections.observableArrayList();

    /**
     * ctor
     */
    public DefaultMemory() {

        int columnCount = 8;
        int rowCount = MEMORY_SIZE_IN_BYTES / columnCount;

        for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {

            final ObservableList<SpreadsheetCell> row = FXCollections.observableArrayList();
            for (int columnIdx = 0; columnIdx < columnCount; columnIdx++) {

                SpreadsheetCell spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, columnIdx, 1, 1,
                        "value");
                row.add(spreadsheetCell);
            }
            rows.add(row);
        }
    }

    @Override
    public int get(int sourceAddress) {

        if (sourceAddress > MEMORY_SIZE_IN_BYTES) {
            throw new RuntimeException("Memory address " + sourceAddress + " is out of bounds!");
        }
        return memory[sourceAddress];
    }

    @Override
    public void set(int targetAddress, int value) {

        if (targetAddress > MEMORY_SIZE_IN_BYTES) {
            throw new RuntimeException("Memory address " + targetAddress + " is out of bounds!");
        }
        memory[targetAddress] = value;

        // update UI
        int rowIdx = targetAddress / 8;
        int columnIdx = targetAddress % 8;

        ObservableList<SpreadsheetCell> row = rows.get(rowIdx);
        row.get(columnIdx).setItem(IntegerParserUtil.hexByte(value));
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public Collection<ObservableList<SpreadsheetCell>> getRows() {
        return rows;
    }

    @Override
    public void handle(GridChange gridChangeEvent) {

        System.out.println(gridChangeEvent);

        System.out.println("Row: " + gridChangeEvent.getRow());
        System.out.println("Column: " + gridChangeEvent.getColumn());
        System.out.println("Old: " + gridChangeEvent.getOldValue());
        System.out.println("New: " + gridChangeEvent.getNewValue());

        int targetAddress = gridChangeEvent.getRow() * columnCount + gridChangeEvent.getColumn();
        memory[targetAddress] = IntegerParserUtil.parseInt((String) gridChangeEvent.getNewValue());
    }

}
