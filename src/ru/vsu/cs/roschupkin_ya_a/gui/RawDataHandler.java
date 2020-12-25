package ru.vsu.cs.roschupkin_ya_a.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawDataHandler
{
    static List<List<String>> handleData (String RawData)
    {
        List<List<String>> cpusData = new ArrayList<>();

        String[] splittedData = RawData.split("\r\n");

        for (String line : splittedData)
        {
            cpusData.add(splitLine(line));
        }

        return cpusData;
    }

    static List<String> splitLine (String line)
    {
        List<String> splittedLine= new ArrayList<>();

        Scanner sc = new Scanner(line);
        sc.useDelimiter(",");

        while (sc.hasNext())
        {
            splittedLine.add(sc.next());
        }

        return splittedLine;
    }
}
