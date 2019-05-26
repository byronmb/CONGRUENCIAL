
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class CongruencialMultiplicativo {

    public static int nPrimo_Cercano(int num) {
        int cont = 2;
        boolean n_primo = true;

        while ((n_primo) && (cont != num)) {
            if (num % cont == 0) {
                n_primo = false;
            }
            cont++;
        }
        if (n_primo) {
            return num;
        } else {
            return nPrimo_Cercano(num - 1);
        }
    }


    public static void main(String[] args) {
        String[] botones = {"DECIMAL", "BINARIO"};

        int variable = JOptionPane.showOptionDialog(null, "SELECCIONE EL SISTEMA", "sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null/*icono*/, botones, botones[0]);

        int d = 0;
        int m = 0;
        int semilla = 0;
        int t = 0;
        int a = 0;
        int n_pseudo = 0;
        ArrayList<Double> numeros = new ArrayList<>();
        double n_uniformes = 0.00;
        DecimalFormat df = new DecimalFormat("0.00000");
        switch (variable) {

            case 0:
                //Xn+1 = aXn mod m
                d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de 'd' para el calculo del modulo 'm'", "MODULO \nm=10^d", JOptionPane.INFORMATION_MESSAGE));
                m = (int) Math.pow(10, d);
                System.out.println("El valor de m es " + m);

                semilla = nPrimo_Cercano(m);
                System.out.println("El valor de semilla Xn es " + semilla);

                int p[] = {3, 11, 13, 19, 21, 27, 29, 37, 53, 59, 61, 67, 69, 77, 83, 91};
                int numeroaleat = (int) (Math.random() * p.length) + 1;
                int p_selec = p[numeroaleat];

                t = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de 't' para el calculo del la constante mulplicativa 'a'", "MODULO \na=200t+p", JOptionPane.INFORMATION_MESSAGE));

                a = (200 * t) + p_selec;  //a = 200t + p
                System.out.println("El valor de a es " + a);
                System.out.println("El p seleccionado es " + p_selec);
                System.out.println("\n");
                // int m =  Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el valor de m"));

                int aux = semilla;

                System.out.println("n \t Xn \t Numeros Uniformes");

                for (int i = 0; i < m; i++) {
                    n_pseudo = (a * semilla) % m;

                    n_uniformes = (double) semilla / m; //para calcular el valor del numero uniforme (0,1)

                    System.out.println(i + 1 + " \t " + semilla + " \t " + semilla + "/" + m + " ==> " + df.format(n_uniformes));

                    numeros.add(n_uniformes);//arreglo para guardadr los numeros para hacer las pruebas

                    semilla = n_pseudo;

                    if (i > 1 && aux == n_pseudo) {
                        break;
                    }
                }

                Metodos_Pruebas.prueba_Promedios(numeros); //llamo al metodo para la prueba de promedios
                Metodos_Pruebas.prueba_Frecuencias(numeros);
                break;

            case 1:
                d = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de 'd' para el calculo del modulo 'm'", "MODULO \nm=2^d", JOptionPane.INFORMATION_MESSAGE));
                m = (int) Math.pow(2, d);
                System.out.println("El valor de m es " + m);

                semilla = 17;//nPrimo_Cercano(m);
                System.out.println("El valor de semilla Xn es " + semilla);

                t = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de 't' para el calculo del la constante mulplicativa 'a'", "MODULO \na=8t+3", JOptionPane.INFORMATION_MESSAGE));

                a = 5;//(8 * t) + 3;  //a = 8t + 3
                System.out.println("El valor de a es " + a);
                System.out.println("\n");

                /*
                m=32;
                semilla=5;
                a=5;
                 */
                int periodo = m / 4;
                System.out.println("n \t Xn \t Numeros uniformes");
                for (int i = 0; i < periodo; i++) {
                    n_pseudo = (a * semilla) % m;

                    n_uniformes = (double) semilla / m; //para calcular el valor del numero uniforme (0,1)

                    System.out.println(i + 1 + "\t" + semilla + " \t " + semilla + "/" + m + " ==> " + df.format(n_uniformes));
                    numeros.add(n_uniformes);//arreglo para guardadr los numeros para hacer las pruebas

                    semilla = n_pseudo;
                }
                Metodos_Pruebas.prueba_Promedios(numeros);
                Metodos_Pruebas.prueba_Frecuencias(numeros);
                
                break; // break es opcional

            default:

        }
    }

}
