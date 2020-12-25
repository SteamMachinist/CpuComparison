package ru.vsu.cs.roschupkin_ya_a.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CpusTableMainView
{
    private JFrame frameMain;
    private JPanel panelMain;
    private JTable cpusTable;
    private JScrollPane tableScrollPane;
    private JPanel panelButtons;
    private JCheckBox editableCheckBox;
    private JCheckBox uniformTestScaleCheckBox;
    private JButton addNewPerformanceTestButton;
    private JButton removePerformanceTestButton;
    private JButton addCpuButton;
    private JButton removeCpuButton;
    private JComboBox<String> chartComboBox;
    private JButton displayChartButton;

    File icon = new File("icon.png");

    CpusTableMainView()
    {
        initFrameMain();
        panelMain.setVisible(true);
        tableScrollPane.setVisible(true);
        initCpusTable();
    }

    void initFrameMain()
    {
        frameMain = new JFrame("CPU comparison");
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setBounds(100, 100, 700, 500);
        frameMain.setContentPane(panelMain);
        frameMain.setVisible(true);

        setIconImage();
    }

    void setIconImage()
    {
        try
        {
            BufferedImage iconImage = ImageIO.read(icon);
            frameMain.setIconImage(iconImage);
        }

        catch (Exception ignored)
        {}
    }

    void initCpusTable()
    {
        CpusDataModel dataModel = new CpusDataModel();
        cpusTable.setModel(new CpusTableModel(dataModel.getData(), dataModel.getHeaders()));
        cpusTable.setAutoCreateRowSorter(true);
        cpusTable.setVisible(true);
    }
}
