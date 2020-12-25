package ru.vsu.cs.roschupkin_ya_a.gui;

import javax.swing.table.DefaultTableModel;

public class CpusTableModel extends DefaultTableModel
{
    final int NAME_COLUMN_INDEX = 0;

   CpusTableModel(Object[][] data, String[] headers)
   {
       super(data, headers);
   }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        if (columnIndex == NAME_COLUMN_INDEX) return String.class;
        return Double.class;
    }
}
