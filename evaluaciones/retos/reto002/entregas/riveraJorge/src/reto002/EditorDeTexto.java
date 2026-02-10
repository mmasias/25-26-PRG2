package evaluaciones.retos.reto002.entregas.riveraJorge.src.reto002;

import java.util.Scanner;
class EditorDeTexto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lineas = new String[10];
        for (int i = 0; i < 10; i++) {
            lineas[i] = "";
        }

        int lineaActiva = 0;
        boolean ejecutar = true;

        while (ejecutar) {
            System.out.println("--------------------------------------------------");
            for (int i = 0; i < 10; i++) {
                String marca;
                if(i == lineaActiva) {
                    marca = "*";
                } else {
                     marca = " ";
                }

                System.out.println(i + ":" + marca + "| " + lineas[i]);

            }

        }

    }

}
    

