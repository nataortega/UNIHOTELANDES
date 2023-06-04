package view;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelAvailabilityCalendar extends JFrame {

    private static final int NUM_MONTHS = 12;
    private static final int NUM_WEEKDAYS = 7;

    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableCellRenderer centerRenderer;

    public HotelAvailabilityCalendar() {
        initializeComponents();
        createTable();
        setupUI();
    }

    private void initializeComponents() {
        table = new JTable(NUM_WEEKDAYS, NUM_MONTHS);
        scrollPane = new JScrollPane(table);
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    }

    private void createTable() {
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setGridColor(Color.BLACK);

        for (int i = 0; i < NUM_MONTHS; i++) {
            LocalDate date = LocalDate.now().withMonth(i + 1).withDayOfMonth(1);
            String monthName = date.format(DateTimeFormatter.ofPattern("MMMM"));
            table.getColumnModel().getColumn(i).setHeaderValue(monthName);
        }

        for (int i = 0; i < NUM_WEEKDAYS; i++) {
            DayOfWeek dayOfWeek = DayOfWeek.of((i + 1) % 7 + 1);
            String dayName = dayOfWeek.toString().substring(0, 3);
            table.setValueAt(dayName, i, 0);
        }

        table.setDefaultRenderer(Object.class, new AvailabilityCellRenderer());
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }

    private void setupUI() {
        setTitle(" Calendario de Disponibilidad Hotel UNIANDES ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 400));
        setLayout(new BorderLayout());

        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class AvailabilityCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (row > 0 && column > 0) {
                boolean isAvailable = controller.Sistema.available();
                Color color = isAvailable ? Color.GREEN : Color.RED;
                cell.setBackground(color);
            } else {
                cell.setBackground(Color.WHITE);
            }

            return cell;
        }
    }
