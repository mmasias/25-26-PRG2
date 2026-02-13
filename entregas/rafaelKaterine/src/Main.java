import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] linea = new String[10];
        int[] punteroLinea = {1};

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
        boolean estaFuncionando = true;

        do {
            imprimirArray(linea, punteroLinea);
            String comando = scanner.nextLine().toUpperCase();

            switch(comando){
                case "L" -> lineaActiva(linea, punteroLinea);
                case "E" -> editarLinea(linea, punteroLinea);
                case "I" -> intercambiarLineas(linea, punteroLinea);
                case "B" -> borrarContenido(linea, punteroLinea);
                case "D" -> deshacerAccion();
                case "S" -> {
                    estaFuncionando = false;
                    salirDelPrograma();
                }
                default -> System.out.println("Comando no reconocido.");
            }

        } while (estaFuncionando);

        imprimirArray(linea, punteroLinea);
        editarLinea( linea, punteroLinea);
        lineaActiva(linea, punteroLinea);
        borrarContenido(linea, punteroLinea);
        salirDelPrograma();

        String cmd = scanner.nextLine().toUpperCase();
    }

    static void imprimirArray(String[]linea, int[] punteroLinea ){
            for (int i = 0; i < 10; i++){
            String signo = (i == punteroLinea[0]) ? ":*" : ": | ";
            System.out.println(i + signo + linea[i]);
        }
        System.out.print("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir\n> ");}
    static void editarLinea(String[]linea, int[] punteroLinea){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Editando la linea" + punteroLinea[0]);
            linea[punteroLinea[0]] = scanner.nextLine();
        }

    static void lineaActiva(String[]linea, int[] punteroLinea){
            System.out.println("Indique la linea activa");
            punteroLinea[0] = new Scanner(System.in).nextInt();
        }

    static void borrarContenido(String[]linea, int[] punteroLinea){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Borrando la linea" + punteroLinea[0]);
            linea[punteroLinea[0]]= "";
        }

    static void salirDelPrograma(){
            System.out.println("Saliendo el programa");
            System.exit(0);
        }
        
        

}

        




