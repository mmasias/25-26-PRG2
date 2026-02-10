package entregas.garciaJacobo;

public class Edlin {
    public static void main(String[] args) {
        String[] fichero = new String[10];

        fichero[0] = "Bienvenidos al editor EDLIN";
        fichero[1] = "Utilice el menu inferior para editar el texto";
        fichero[2] = "------";
        fichero[3] = "[L] permite definir la linea activa";
        fichero[4] = "[E] permite editar la linea activa";
        fichero[5] = "[I] permite intercambiar dos lineas";
        fichero[6] = "[B] borra el contenido de la linea activa";
        fichero[7] = "[D] deshace la última acción realizada";
        fichero[8] = "[S] sale del programa";
        mostrarMenu(fichero);

    }

    private static void mostrarMenu(String[] fichero) {
        imprimirBordeHorizontal();
        for (int i = 0; i < fichero.length; i++) {
            System.out.print(i + ":" + " |  ");
            if (fichero[i] != null) {
                System.out.println(fichero[i]);
            } else {
                System.out.println();
            }
        }
        imprimirBordeHorizontal();
        imprimirComandos();

    }

    private static void imprimirComandos() {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
    }

    private static void imprimirBordeHorizontal() {
        System.out.println("---------------------------------------------------");
    }

}
