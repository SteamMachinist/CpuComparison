package ru.vsu.cs.roschupkin_ya_a.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader
{
    static String readAll(File cpusData) throws FileNotFoundException
    {
        Scanner sc = new Scanner(cpusData);
        sc.useDelimiter("\\Z");
        return sc.next();
    }
}
