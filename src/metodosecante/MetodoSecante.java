package metodosecante;

import java.util.Scanner;

public class MetodoSecante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fxStr;
        int i = 2;
        double x0, x1, xi, fxi;
        double errC = 0.00001;
        double err;
        Scanner scn = new Scanner(System.in);
        System.out.println("Ingresa la función:");
        fxStr = scn.nextLine();
        Expr fx = new Expr(fxStr);
        System.out.println("Ingresa el valor de x0:");
        x0 = Double.parseDouble(scn.nextLine());
        System.out.println("Ingresa el valor de x1:");
        x1 = Double.parseDouble(scn.nextLine());
        
        do{
            xi = x1 - ((x1 - x0)/(fx.value(x1)-fx.value(x0)))*fx.value(x1);
            System.out.println("i = " + i);
            System.out.println("f(xi-1) = " + fx.value(x1));
            System.out.println("f(xi-2) = " + fx.value(x0));
            System.out.println("xi = " + xi);
            err = Math.abs(fx.value(xi) - fx.value(x1));
            System.out.println("Error: " + err);
            x0 = x1;
            x1 = xi;
            i++;
        } while(err > errC);
        
        
    }
    
}
