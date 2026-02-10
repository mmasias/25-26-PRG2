package src;
import java.util.Scanner;

public class Edlin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] lineas = new String[10];
        String[] historial = new String[10];
        int lineaActiva = 1;
        
        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[I] permite intercambiar dos lineas";
        lineas[6] = "[B] borra el contenido de la linea activa";
        lineas[7] = "[D] deshace la ultima accion realizada";
        lineas[8] = "[S] sale del programa";
        lineas[9] = "";
        
        while (true) {
            System.out.println("--------------------------------------------------");
            for (int i = 0; i < 10; i++) {
                String marca;
                if (i == lineaActiva) {
                    marca = "*";
                } else {
                    marca = " ";
                }
                String contenido = (lineas[i] != null) ? lineas[i] : "";
                System.out.println(i + ":" + marca + "| " + contenido);
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
            System.out.print("Opcion: ");
            
            char opcion = sc.next().charAt(0);
            sc.nextLine();
            
            if (opcion == 'S' || opcion == 's') {
                System.out.println("Saliendo del editor EDLIN.");
                break;
            } else if (opcion == 'L' || opcion == 'l') {
                System.out.print("Numero de linea activa (0-9): ");
                int nuevaLinea = sc.nextInt();
                sc.nextLine();
                if (nuevaLinea >= 0 && nuevaLinea <= 9) {
                    lineaActiva = nuevaLinea;
                    System.out.println("Linea activa cambiada a: " + lineaActiva);
                } else {
                    System.out.println("Numero de linea invalido.");
                }
            } else if (opcion == 'E' || opcion == 'e') {
                guardarHistorial(lineas, historial);
                System.out.println("Contenido actual: " + lineas[lineaActiva]);
                System.out.print("Nuevo contenido: ");
                String nuevoContenido = sc.nextLine();
                lineas[lineaActiva] = nuevoContenido;
                System.out.println("Linea " + lineaActiva + " editada.");
            } else if (opcion == 'B' || opcion == 'b') {
                guardarHistorial(lineas, historial);
                lineas[lineaActiva] = "";
                System.out.println("Linea " + lineaActiva + " borrada.");
            } else if (opcion == 'I' || opcion == 'i') {
                guardarHistorial(lineas, historial);
                System.out.print("Primera linea a intercambiar (0-9): ");
                int linea1 = sc.nextInt();
                System.out.print("Segunda linea a intercambiar (0-9): ");
                int linea2 = sc.nextInt();
                sc.nextLine();
                
                if (linea1 >= 0 && linea1 <= 9 && linea2 >= 0 && linea2 <= 9) {
                    String temp = lineas[linea1];
                    lineas[linea1] = lineas[linea2];
                    lineas[linea2] = temp;
                    System.out.println("Lineas " + linea1 + " y " + linea2 + " intercambiadas.");
                } else {
                    System.out.println("Numeros de linea invalidos.");
                }
            }
        }
        
        sc.close();
    }
    
    static void guardarHistorial(String[] lineas, String[] historial) {
        for (int i = 0; i < 10; i++) {
            historial[i] = lineas[i];
        }
    }
}