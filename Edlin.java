import java.util.Scanner;

public class Edlin {

    static final int MAX_LINEAS = 10;
    static String[] texto = new String[MAX_LINEAS];
    static int lineaActiva = 0;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        for (int i = 0; i < MAX_LINEAS; i++) {
            texto[i] = "";
        }

        char opcion;

        do {
            mostrarTexto();
            mostrarMenu();
            opcion = sc.nextLine().toUpperCase().charAt(0);

            switch (opcion) {
                case 'L':
                    cambiarLineaActiva();
                    break;
                case 'E':
                    editarLinea();
                    break;
                case 'I':
                    intercambiarLineas();
                    break;
                case 'B':
                    borrarLinea();
                    break;
                case 'S':
                    System.out.println("Saliendo del editor...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 'S');
    }
    
     static void mostrarTexto() {
        System.out.println("\n---------------------------------");
        for (int i = 0; i < MAX_LINEAS; i++) {
            if (i == lineaActiva) {
                System.out.println(i + ":* " + texto[i]);
            } else {
                System.out.println(i + ":  " + texto[i]);
            }
        }
        System.out.println("---------------------------------");
    }


