package ru.vsu.cs.roschupkin_ya_a.gui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CpusDataModel
{
    final int NAME_COLUMN_INDEX = 0;

    final File cpusDataFile = new File("CPUs_data.txt");

    String[] headers;
    Object[][] data;

    public CpusDataModel()
    {
        List<List<String>> summedCpusData = getCpusDataFromFile();

        this.headers = summedCpusData.get(0).toArray(new String[0]);
        this.data = listToObjectArray(summedCpusData.subList(1, summedCpusData.size() - 1));
    }

    List<List<String>> getCpusDataFromFile()
    {
        try
        {
            return RawDataHandler.handleData(TextReader.readAll(cpusDataFile));
        }

        catch (Exception e)
        {
            return new ArrayList<>();
        }
    }
    Object[][] listToObjectArray(List<List<String>> initialList)
    {
        Object[][] array = new Object[initialList.size()][initialList.get(0).size()];

        for (int row = 0; row < initialList.size(); row++)
        {
            for (int column = 0; column < initialList.get(row).size(); column++)
            {
                if (initialList.get(row).get(column).isEmpty() || initialList.get(row).get(column).isBlank())
                {
                    array[row][column] = null;
                }
                else if (column == NAME_COLUMN_INDEX)
                {
                    array[row][column] = String.valueOf(initialList.get(row).get(column));
                }
                else
                {
                    array[row][column] = Double.valueOf(initialList.get(row).get(column));
                }
            }
        }

        return array;
    }

    public String[] getHeaders()
    {
        return headers;
    }

    public void setHeaders(String[] headers)
    {
        this.headers = headers;
    }

    public Object[][] getData()
    {
        return data;
    }

    public void setData(String[][] data)
    {
        this.data = data;
    }
}
