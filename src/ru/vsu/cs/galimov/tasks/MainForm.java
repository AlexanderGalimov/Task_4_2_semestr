package ru.vsu.cs.galimov.tasks;

import ru.vsu.cs.galimov.tasks.util.JTableUtils;
import ru.vsu.cs.galimov.tasks.util.SwingUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;

public class MainForm extends JFrame {
    private JPanel BubbleSort;
    private JTable tableInput;
    private JTable tableSorted;
    private JButton solveButton;
    private JTextField from;
    private JTextField to;
    private JButton backButton;
    private JButton startStopButton;
    private JButton nextButton;
    public boolean timeContinue;
    public ArrayList<SortState> states;
    public int count = 0;
    public int tempJ = 0;
    public static final Color EMPTY_CELL_COLOR = UIManager.getColor("TextField.background");
    public static final Color FIRST_CELL_COLOR = Color.GREEN;
    public static final Color SECOND_CELL_COLOR = Color.YELLOW;
    public static final Color ERROR_CELL_COLOR = Color.RED;

    private Timer timer = new Timer(1000, e -> {
        try {
            JTableUtils.writeArrayToJTable(tableSorted, states.get(count).getArr());
            tempJ = states.get(count).getTempJ();
            count++;
        } catch (Exception except) {
            SwingUtils.showInfoMessageBox("Ура!!!", "Массив отсортирован");
            stopTime();
        }
    });

    public void stopTime(){
        timer.stop();
    }

    public MainForm(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(BubbleSort);
        this.pack();

        JTableUtils.initJTableForArray(tableInput,40,false,false,false,true);
        JTableUtils.initJTableForArray(tableSorted,40,false,false,false,true);

        tableInput.setRowHeight(25);
        tableSorted.setRowHeight(25);

        class CellRenderer extends DefaultTableCellRenderer {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                Color color = EMPTY_CELL_COLOR;
                try {
                    if (column == tempJ) {
                        color = FIRST_CELL_COLOR;
                    } else if (column == tempJ + 1) {
                        color = SECOND_CELL_COLOR;
                    }
                } catch (Exception e) {
                    color = ERROR_CELL_COLOR;
                }
                comp.setBackground(color);
                return comp;
            }
        }
        tableSorted.setDefaultRenderer(Object.class,new CellRenderer());

        solveButton.addActionListener(e -> {
            try {
                count = 0;
                int[] src = JTableUtils.readIntArrayFromJTable(tableInput);
                states = new ArrayList<>(BubbleSortFromTo.sort(src,Integer.parseInt(from.getText()),Integer.parseInt(to.getText())));
                JTableUtils.writeArrayToJTable(tableSorted, states.get(count).getArr());
                tempJ = states.get(count).getTempJ();
                count++;
                timer.start();
                timeContinue = true;
            } catch (IllegalArgumentException | ParseException exception) {
                displayError();
            }
        });
        nextButton.addActionListener(e -> {
            try {
                JTableUtils.writeArrayToJTable(tableSorted, states.get(count).getArr());
                tempJ = states.get(count).getTempJ();
                count++;
            } catch (Exception except) {
                SwingUtils.showInfoMessageBox("Ура!!!", "Массив отсортирован");
            }
        });
        backButton.addActionListener(e -> {
            try {
                count--;
                JTableUtils.writeArrayToJTable(tableSorted, states.get(count).getArr());
                tempJ = states.get(count).getTempJ();
            } catch (Exception except) {
                SwingUtils.showInfoMessageBox("Ура!!!", "Массив отсортирован");
            }
        });

        startStopButton.addActionListener(e -> {
            try {
                if (timeContinue) {
                    timer.stop();
                    timeContinue = false;
                } else {
                    timer.start();
                }
            } catch (Exception except) {
                SwingUtils.showInfoMessageBox("ERROR", "error");
            }
        });
    }

    private void displayError() {
        JOptionPane.showMessageDialog(this, "Введите данные корректно",
                "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}
