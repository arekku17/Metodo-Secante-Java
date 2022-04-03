package metodosecante;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

//CLASE QUE NOS AYUDA A CAMBIAR EL HEADER DE LA TABLA
 public class HeaderColor extends DefaultTableCellRenderer {

        public HeaderColor() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            setBackground(new java.awt.Color(29, 90, 116));
            setForeground(new java.awt.Color(255, 255, 255));
//you can change the color that u want 
            return this;
        }

    }