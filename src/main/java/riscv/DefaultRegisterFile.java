package riscv;

import org.controlsfx.control.spreadsheet.GridChange;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;


import java.util.Collection;

import common.IRegisterFile;
import common.IntegerParserUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;

public class DefaultRegisterFile implements IRegisterFile, EventHandler<GridChange> {

    //private static final String INITIAL_REGISTER_VALUE = "0x00";
    private static final String INITIAL_REGISTER_VALUE = "____";

    private static final int MEMORY_SIZE_IN_BYTES = 32 * 2;

    private int[] registerFile = new int[MEMORY_SIZE_IN_BYTES];

    private int rowCount;

    private int columnCount;

    private ObservableList<ObservableList<SpreadsheetCell>> rows = FXCollections.observableArrayList();

    /**
     * ctor
     *
     * https://en.wikichip.org/wiki/risc-v/registers
     */
    public DefaultRegisterFile() {

        // int columnCount = 8;
        // int rowCount = MEMORY_SIZE_IN_BYTES / columnCount;

        // for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {

        //     final ObservableList<SpreadsheetCell> row = FXCollections.observableArrayList();
        //     for (int columnIdx = 0; columnIdx < columnCount; columnIdx++) {

        //         SpreadsheetCell spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, columnIdx, 1, 1,
        //                 "value");
        //         row.add(spreadsheetCell);
        //     }
        //     rows.add(row);
        // }

        SpreadsheetCell spreadsheetCell = null;
        ObservableList<SpreadsheetCell> row = null;

        int rowIdx = 0;
        row = FXCollections.observableArrayList();
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 0, 1, 1, "x0 (zero)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 1, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 2, 1, 1, "x8 (s0/fp)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 3, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 4, 1, 1, "x16 (a6)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 5, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 6, 1, 1, "x24 (s8)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 7, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        rows.add(row);



        rowIdx = 1;
        row = FXCollections.observableArrayList();
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 0, 1, 1, "x1 (ra)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 1, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 2, 1, 1, "x9 (s1)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 3, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 4, 1, 1, "x17 (a7)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 5, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 6, 1, 1, "x25 (s9)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 7, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        rows.add(row);




        rowIdx = 2;
        row = FXCollections.observableArrayList();
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 0, 1, 1, "x2 (sp)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 1, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 2, 1, 1, "x10 (a0)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 3, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 4, 1, 1, "x18 (s2)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 5, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 6, 1, 1, "x26 (s10)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 7, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        rows.add(row);


        rowIdx = 3;
        row = FXCollections.observableArrayList();
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 0, 1, 1, "x3 (gp)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 1, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 2, 1, 1, "x11 (a1)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 3, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 4, 1, 1, "x19 (s3)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 5, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 6, 1, 1, "x27 (s11)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 7, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        rows.add(row);




        rowIdx = 4;
        row = FXCollections.observableArrayList();
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 0, 1, 1, "x4 (tp)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 1, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 2, 1, 1, "x12 (a2)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 3, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 4, 1, 1, "x20 (s4)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 5, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 6, 1, 1, "x28 (t3)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 7, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        rows.add(row);





        rowIdx = 5;
        row = FXCollections.observableArrayList();
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 0, 1, 1, "x5 (t0)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 1, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 2, 1, 1, "x13 (a3)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 3, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 4, 1, 1, "x21 (s5)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 5, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 6, 1, 1, "x29 (t4)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 7, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        rows.add(row);





        rowIdx = 6;
        row = FXCollections.observableArrayList();
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 0, 1, 1, "x6 (t1)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 1, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 2, 1, 1, "x14 (a4)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 3, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 4, 1, 1, "x22 (s6)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 5, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 6, 1, 1, "x30 (t5)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 7, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        rows.add(row);





        rowIdx = 7;
        row = FXCollections.observableArrayList();
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 0, 1, 1, "x7 (t2)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 1, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 2, 1, 1, "x15 (a5)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 3, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 4, 1, 1, "x23 (s7)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 5, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 6, 1, 1, "x31 (t6)");
        spreadsheetCell.setEditable(false);
        row.add(spreadsheetCell);
        spreadsheetCell = SpreadsheetCellType.STRING.createCell(rowIdx, 7, 1, 1, INITIAL_REGISTER_VALUE);
        row.add(spreadsheetCell);

        rows.add(row);
    }

    @Override
    public int get(int sourceAddress) {

        if (sourceAddress > MEMORY_SIZE_IN_BYTES) {
            throw new RuntimeException("Memory address " + sourceAddress + " is out of bounds!");
        }
        return registerFile[sourceAddress];
    }

    @Override
    public void set(int registerIndex, int value) {

        if (registerIndex > MEMORY_SIZE_IN_BYTES) {
            throw new RuntimeException("Memory address " + registerIndex + " is out of bounds!");
        }
        registerFile[registerIndex] = value;

        // update UI
        int columnIdx = (registerIndex / 8) + 1;
        int rowIdx = registerIndex % 8;

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

        // System.out.println(gridChangeEvent);

        // System.out.println("Row: " + gridChangeEvent.getRow());
        // System.out.println("Column: " + gridChangeEvent.getColumn());
        // System.out.println("Old: " + gridChangeEvent.getOldValue());
        // System.out.println("New: " + gridChangeEvent.getNewValue());

        int row = gridChangeEvent.getRow();
        int col = gridChangeEvent.getColumn()/2;

        int targetAddress = col * 8 + row;
        registerFile[targetAddress] = IntegerParserUtil.parseInt((String) gridChangeEvent.getNewValue());

        // System.out.println(targetAddress);
    }

}
