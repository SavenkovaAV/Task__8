package src.ru.vsu.sc.savenkova_a_v;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class FrameMain extends JFrame {
    private JTable tableOutputArray;
    private JTable tableInputArray;
    private JButton buttonLoadFromFile;
    private JButton buttonSaveIntoFile;
    private JButton buttonCreateRandomArray;
    private JButton buttonOutputArray;
    private JPanel panelMain;
    private JScrollPane scrollPaneTableInput;

    private final JFileChooser fileChooserOpen;
    private final JFileChooser fileChooserSave;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;

    public FrameMain() {
        this.setTitle("Task 8");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        ru.vsu.cs.util.JTableUtils.initJTableForArray(tableInputArray, 60, true, true, true, true);
        ru.vsu.cs.util.JTableUtils.initJTableForArray(tableOutputArray, 60, true, true, true, true);

        tableInputArray.setRowHeight(30);
        tableOutputArray.setRowHeight(30);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        ru.vsu.cs.util.JTableUtils.writeArrayToJTable(tableInputArray, new int[]{0, 1, 2, 3});

        buttonLoadFromFile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] arr = ru.vsu.cs.util.ArrayUtils.readIntArray2FromFile(fileChooserOpen.getSelectedFile().getPath());
                        ru.vsu.cs.util.JTableUtils.writeArrayToJTable(tableInputArray, arr);
                    }
                } catch (Exception e) {
                    ru.vsu.cs.util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonSaveIntoFile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] arr = ru.vsu.cs.util.JTableUtils.readIntMatrixFromJTable(tableOutputArray);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ru.vsu.cs.util.ArrayUtils.writeArrayToFile(file, arr);
                    }
                } catch (Exception e) {
                    ru.vsu.cs.util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonCreateRandomArray.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[][] arr = ru.vsu.cs.util.ArrayUtils.createRandomIntMatrix(tableInputArray.getRowCount(), tableInputArray.getColumnCount(), 100);
                    ru.vsu.cs.util.JTableUtils.writeArrayToJTable(tableInputArray, arr);
                } catch (Exception e) {
                    ru.vsu.cs.util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonOutputArray.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[][] arr = ru.vsu.cs.util.JTableUtils.readIntMatrixFromJTable(tableInputArray);
                    ArrayRowsInDescendingOrder permutation = new ArrayRowsInDescendingOrder();
                    int[][] result = permutation.putLinesInDescendingOrder(arr);
                    ru.vsu.cs.util.JTableUtils.writeArrayToJTable(tableOutputArray, result);
                } catch (Exception e) {
                    ru.vsu.cs.util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }

}

