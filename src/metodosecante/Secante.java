package metodosecante;

import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Secante {
    String fxStr;
    int i = 2;
    double x0, x1, xi, fxi;
    double errC = 0.001;
    double err;
    Expr fx;
    LinkedList<Valor> valores = new LinkedList<>();
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
            val.setFx1("" + fx.value(x1));
            xi = x1 - (((x1 - x0)/(fx.value(x1)-fx.value(x0)))*fx.value(x1));
            val.setXi("" + xi);
            val.setFxi("" + Math.round(fx.value(xi)*1000000.0)/1000000.0);
            err = Math.abs(fx.value(xi));
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
        Object[] object = new Object[8];
        for (int i = 0; i < valores.size(); i++) {
            object[0] = i+2;
            object[1] = valores.get(i).getX0();
            object[2] = valores.get(i).getX1();
            object[3] = valores.get(i).getFx0();
            object[4] = valores.get(i).getFx1();
            object[5] = valores.get(i).getXi();
            object[6] = valores.get(i).getFxi();
            modelo.addRow(object);
        }
        return modelo;
//        frm.TablaDatos.setModel(modelo);
    }
}
