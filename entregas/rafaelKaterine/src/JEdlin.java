
import java.util.*;

public class main {
    Scanner sc = new Scanner(System.in);
    String[] linea = new String[10];
    int punteroLinea = 1;

    linea[0] = "Bienvenidos al editor de texto JEdlin";
    linea[1] = "Utilice el menu inferior para editar el texto";
    linea[2] = " ------------------------------------";
    linea[3] = "[L] permite definir la linea activa";
    linea[4] = "[E] permite editar la linea activa";
    linea[5] = "[I] permite intercambiar dos lineas";
    linea[6] = "[B] borra el contenido de la linea activa";
    linea[7] = "[D] deshace la última acción realizada";
    linea[8] = "[S] sale del programa";
    linea[9] = " ------------------------------------";

    while(true){
        for (int i = 0; i < 10; i++){
            String signo = (i == punteroLinea) ? ":*" : ": | ";
            System.out.println(i + signo + linea[i]);
        }

    }
    System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir\n> ");

    String cmd = sc.nextLine().toUpperCase();

    if (cmd.equals("S")) break;



}



