package src;
import java.util.Scanner;

public class Edlin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] lineas = new String[10];
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
            
            break;
        }
        
        sc.close();
    }
}