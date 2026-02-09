import java.util.Scanner;

class EditorEdlin {
    public static void main(String[] args) {
        int opcion;
        imprimirMenuIncial();
        opcion = leerComando();
        switch(opcion) {
            case 0 -> cambiarLineaActiva();
            case 1 -> editarLineaActiva();
            case 2 -> intercambiarLineas();
            case 3 -> borrar();
        }
        limpiarPantalla();
    }

    private static void imprimirMenuIncial() {
        System.out.println("--------------------------------------------------");
        System.out.println("0: | Bienvenidos al editor EDLIN");
        System.out.println("1:*| Utilice el menu inferior para editar el texto");
        System.out.println("2: | ------");
        System.out.println("3: | [L] permite definir la linea activa");
        System.out.println("4: | [E] permite editar la linea activa");
        System.out.println("5: | [I] permite intercambiar dos lineas");
        System.out.println("6: | [B] borra el contenido de la linea activa");
        System.out.println("7: | [S] sale del programa");
        System.out.println("8: | ");
        System.out.println("9: | ");
        System.out.println("--------------------------------------------------");
        imprimirBarraEstado();
    }

    private static void imprimirBarraEstado() {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }

    private static int leerComando() {
        Scanner scanner = new Scanner(System.in);
        return mapearComando(scanner.nextLine());
    }

    private static int mapearComando(String comando) {
        String[] comandosValidos = { "L", "E", "I", "B", "S" };
        final int OPCION_INVALIDA = -1;

        for (int i = 0; i < comandosValidos.length; i++) {
            if (comando.equalsIgnoreCase(comandosValidos[i]))
                return i;
        }
        return OPCION_INVALIDA;
    }

    private static void cambiarLineaActiva() { 
        System.out.println("cambiar linea activa...");
    }
    private static void editarLineaActiva() {
        System.out.println("Intercambiando lineas...");
    }
    private static void intercambiarLineas(){
        System.out.println("Intercambiando lineas...");
    }
    private static void borrar(){
        System.out.println("Borrando todo...");
    }
    private static void salir(){
        System.out.println("Bye Bye :D");
    }
    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
