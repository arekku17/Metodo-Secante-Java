package metodosecante;

import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Secante {
    //ATRIBUTOS
    String fxStr;
    int i = 2;
    double x0, x1, xi, fxi;
    double errC = 0.001;
    double err;
    Expr fx;
    LinkedList<Valor> valores = new LinkedList<>();
    private DefaultTableModel modelo = new DefaultTableModel();

    //CONSTRUCTOR
    public Secante(String fxStr, double x0, double x1) {
        this.fxStr = fxStr;
        this.x0 = x0;
        this.x1 = x1;
        fx = new Expr(fxStr);
    }
    
    //METODO CON EL ALGORITMO DEL METODO SECANTE
    public void calcularValores(){
        do{
            Valor val = new Valor();
            //SALIDA
            val.setX0("" + Math.round(x0*10000.0)/10000.0);
            val.setFx0("" + Math.round(fx.value(x0)*10000.0)/10000.0);
            val.setX1("" + Math.round(x1*10000.0)/10000.0);
            val.setFx1("" + Math.round(fx.value(x1)*10000.0)/10000.0);
            //OPERACION
            xi = x1 - (((x1 - x0)/(fx.value(x1)-fx.value(x0)))*fx.value(x1));
            //SALIDA
            val.setXi("" + Math.round(xi*10000.0)/10000.0);
            val.setFxi("" + Math.round(fx.value(xi)*100000.0)/100000.0);
            //OPERACION
            err = Math.abs(fx.value(xi)); //VALOR REAL POSITIVO
            val.setMult("" + err);
            //REEMPLAZAMOS NUEVOS VALORES
            x0 = x1;
            x1 = xi;
            //AGREGAMOS LAS SALIDAS
            valores.add(val);
            //AUMENTAMOS EL VALOR DE ITERACION
            i++;
        } while(err > errC);
    }
    
    //METODO QUE NOS AYUDA A LISTAR LOS VALORES OBTENIDOS EN LA TABLA
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
    }
}
