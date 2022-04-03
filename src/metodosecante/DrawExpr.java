package metodosecante;

import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import metodosecante.Expr;


//CLASE PARA GRAFICAR
public class DrawExpr extends JComponent {
    
    Expr funcion;
    DrawExpr(Expr funcion){
        this.funcion = funcion;
    }
    
    public void paintComponent(Graphics g) {
        //w is x, and h is y (as in x/y values in a graph)
        int w = this.getWidth() / 2;
        int h = this.getHeight() / 2;
        final double MAX_X = 30;
        final double SCALE = w / MAX_X;

        Graphics2D g1 = (Graphics2D) g;
        g1.setStroke(new BasicStroke(2));
        g1.setColor(Color.black);
        g1.drawLine(0, h, w * 2, h);
        g1.drawLine(w, 0, w, h * 2);
        g1.drawString("0", w - 7, h + 13);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.red);
        //line1
        Polygon p = new Polygon();
        for (int x = 0; x <= w; ++x) {
            double xScaled = x / SCALE;
            p.addPoint(w + x, h - (int)Math.round(SCALE * funcion.value(xScaled)));
        }
        g2.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }

    public void pintarGrafica(){
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setTitle("Graphs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        DrawExpr draw = new DrawExpr(funcion);
        frame.add(draw);
        frame.setVisible(true);
    }
}
