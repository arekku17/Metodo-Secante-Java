package metodosecante;

import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Secante {
    String fxStr;
    int i = 2;
    double x0, x1, xi, fxi;
    double errC = 0.0001;
    double err;
    Expr fx;
    LinkedList<Valor> valores;
    private DefaultTableModel modelo = new DefaultTableModel();

    public Secante(String fxStr, double x0, double x1) {
        this.fxStr = fxStr;
        this.x0 = x0;
        this.x1 = x1;
        fx = new Expr(fxStr);
    }
    
    public void calcularValores(){
        do{
            Valor val = new Valor();
            val.setX0("" + x0);
            val.setFx0("" + fx.value(x0));
            val.setX1("" + x1);
            val.setFx0("" + fx.value(x0));
            xi = x1 - ((x1 - x0)/(fx.value(x1)-fx.value(x0)))*fx.value(x1);
            val.setXi("" + xi);
            val.setFxi("" + fx.value(xi));
            err = Math.abs(fx.value(xi) - fx.value(x1));
            val.setMult("" + err);
            x0 = x1;
            x1 = xi;
            valores.add(val);
            i++;
        } while(err > errC);
    }
    
    public DefaultTableModel listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        Object[] object = new Object[7];
        for (int i = 0; i < valores.size(); i++) {
            object[0] = valores.get(i).getX0();
            object[1] = valores.get(i).getX1();
            object[2] = valores.get(i).getFx0();
            object[3] = valores.get(i).getFx1();
            object[4] = valores.get(i).getXi();
            object[5] = valores.get(i).getFxi();
            object[6] = valores.get(i).getMult();
            modelo.addRow(object);
        }
        return modelo;
//        frm.TablaDatos.setModel(modelo);
    }
}
