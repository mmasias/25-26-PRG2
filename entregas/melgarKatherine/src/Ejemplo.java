import java.util.Scanner;

public class Ejemplo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] textoAModificar = new String[10];
        llenarVariableConOpciones(textoAModificar);
        preguntarAlUsuarioOpciones(textoAModificar, sc);
        mostrarMenuAlUsuario(textoAModificar);
    }

    static void llenarVariableConOpciones(String[] mostrarMenuAlUsuario){
        mostrarMenuAlUsuario[0] = "0: | Bienvenidos al editor EDLIN";
        mostrarMenuAlUsuario[1] = "1:*| Utilice el menu inferior para editar el texto";
        mostrarMenuAlUsuario[2] = "2: | ------";
        mostrarMenuAlUsuario[3] = "3: | [L] permite definir la linea activa";
        mostrarMenuAlUsuario[4] = "4: | [E] permite editar la linea activa";
        mostrarMenuAlUsuario[5] = "5: | [I] permite intercambiar dos lineas";
        mostrarMenuAlUsuario[6] = "6: | [B] borra el contenido de la linea activa";
        mostrarMenuAlUsuario[7] = "7: | [D] deshace la última acción realizada";
        mostrarMenuAlUsuario[8] = "8: | [S] sale del programa";
        mostrarMenuAlUsuario[9] = "9: | ";
    }

    static void preguntarAlUsuarioOpciones(String[] textoAModificar, Scanner sc){
        boolean salirDeMenu = false;
        do{
            System.out.println("Elije una opción del menú");
            String letraOpcionElejida = sc.nextLine();
            switch (letraOpcionElejida){
                case "L" -> {
                    System.out.println("Escribe el indice de la linea que quieres activar");
                    String letraOpcionElejida = sc.nextLine();
                    activarLinea()
                }
                case "E" ->
                case "I" ->
                case "B" ->
                case "D" ->
                case "S" ->
            }
        } while(salirDeMenu);
        System.out.println("Elije una opción del menú");
    }

    static void mostrarMenuAlUsuario(String[] mostrarMenuAlUsuario){
        for(int i = 0; i < mostrarMenuAlUsuario.length; i++){
            System.out.println(mostrarMenuAlUsuario[i]);
        }
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
    }
}