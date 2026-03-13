import java.util.Scanner;

public class EditorEdlin {

    private static String[] documento = new String[10];
    private static int filaSeleccionada = 0; 

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String entradaUsuario = "";

        for (int i = 0; i < documento.length; i++) {
            documento[i] = "";
        }
        while (!entradaUsuario.equalsIgnoreCase("S")) {
            renderizarInterfaz(); 
            System.out.print("Comando: ");
            entradaUsuario = lector.nextLine().toUpperCase();

       if (entradaUsuario.equals("L")) {
                System.out.print("Número de fila a activar (0-9): ");
                int nuevaFila = Integer.parseInt(lector.nextLine());
                if (nuevaFila >= 0 && nuevaFila < documento.length) {
                    filaSeleccionada = nuevaFila;
                } else {
                    System.out.println("Error: Fila inexistente.");
                }
            } else if (entradaUsuario.equals("E")) {
                System.out.print("Escriba el contenido: ");
                documento[filaSeleccionada] = lector.nextLine();
            } else if (entradaUsuario.equals("B")) {
                documento[filaSeleccionada] = "";
                System.out.println("Línea limpiada.");
            } else if (entradaUsuario.equals("I")) {
                System.out.print("Intercambiar fila " + filaSeleccionada + " con: ");
                int destino = Integer.parseInt(lector.nextLine());
                if (destino >= 0 && destino < documento.length) {
                    String temporal = documento[filaSeleccionada];
                    documento[filaSeleccionada] = documento[destino];
                    documento[destino] = temporal;
                } else {
                    System.out.println("Error: Índice de destino inválido.");
                }
            }
        }
        System.out.println("Cerrando el editor...");
        lector.close();
    }

    public static void renderizarInterfaz() {
        System.out.println("==================================================");
        for (int n = 0; n < documento.length; n++) {
            String puntero = (n == filaSeleccionada) ? "*" : " ";
            System.out.printf("%d:%s| %s%n", n, puntero, documento[n]);
        }
        System.out.println("==================================================");
        System.out.println("Opciones: [L]ínea | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }
}