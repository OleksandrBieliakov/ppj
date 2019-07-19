package gui.calculator2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class PolyMemory extends JPanel {

    MainFrame frame;
    private JButton addB = new JButton("ADD");
    private JButton removeB = new JButton("REMOVE");
    private JPanel buttonsP = new JPanel();
    private JTable table = new JTable(new TableModel(this));

    private void setButtons() {
        addB.setBackground(Color.DARK_GRAY);
        addB.setForeground(Color.WHITE);
        removeB.setBackground(Color.DARK_GRAY);
        removeB.setForeground(Color.WHITE);
        addB.setFont(new Font(getFont().getName(), Font.BOLD, 15));
        removeB.setFont(new Font(getFont().getName(), Font.BOLD, 15));


        addB.addActionListener(e -> {
            addNewPoly();
        });
        removeB.addActionListener(e -> {
            removePoly();
        });
        //buttonsP.setBackground(Color.LIGHT_GRAY);
        buttonsP.add(addB);
        buttonsP.add(removeB);
    }

    private void addNewPoly() {
        System.out.println("ADD P");
    }

    private void removePoly() {
        System.out.println("REMOVE P");
    }

    private void editPoly() {
        System.out.println("EDIT P");
    }

    PolyMemory(MainFrame f) {
        frame = f;

        setLayout(new BorderLayout());
        setButtons();

        JLabel title = new JLabel("POLYNOMIALS");
        title.setFont(new Font(getFont().getName(), Font.BOLD, 12));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(title, BorderLayout.NORTH);

        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);

        JScrollPane scr = new JScrollPane(table);
        add(scr, BorderLayout.CENTER);
        add(buttonsP, BorderLayout.SOUTH);
        table.setBackground(Color.LIGHT_GRAY);
        table.setDefaultRenderer(java.awt.Color.class, new MyColorCellRend());
        table.getColumnModel().getColumn(1).setCellEditor(new ColorEditor());
        table.setTableHeader(null);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(1).setMaxWidth(10);
        table.setFont(new Font(getFont().getName(), Font.PLAIN, 15));
        table.setRowSelectionAllowed(false);

        addB.addActionListener(e -> {
            String s = JOptionPane.showInputDialog("Enter a polynomial");
            if (s != null) {
                frame.list.add(new Polynomial(s));
                table.updateUI();
            }

        });

        removeB.addActionListener(e -> {
            int i = table.getSelectedRow();
            if(i != -1) {
                frame.list.remove(i);
                table.updateUI();
            }
        });

    }


}
