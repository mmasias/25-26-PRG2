package entregas.riveraJorge.src.reto002;

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
            System.out.println("Comandos: [L]inea | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir: ");
            String opcion = scanner.nextLine().toUpperCase();

            if (opcion.equals("L")) {

                System.out.print("Numero de linea (0-9): ");
                lineaActiva = Integer.parseInt(scanner.nextLine());
            }
            else if (opcion.equals("B")) {
                lineas[lineaActiva] = "";
            }
            else if (opcion.equals("I")) {
                System.out.print("Intercambiar con linea numero: ");
                int destino = Integer.parseInt(scanner.nextLine());
                String temporal = lineas[lineaActiva];
                lineas[lineaActiva] = lineas[destino];
                lineas[destino] = temporal;
            }
            else if (opcion.equals("S")) {
                ejecutar = false;
                System.out.println("Programa cerrado.");
            }
        }
        scanner.close();


        }

    }


    

