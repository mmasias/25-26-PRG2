import java.util.Scanner;
import java.util.Random;

public class BuscaMinas {
    
    final int FILAS = 5;
    final int COLUMNAS = 7;
    final int TOTAL_MINAS = 5;
    final int EXPLOSIONES_MAXIMAS = 3;
    
    boolean[][] tablero = new boolean[FILAS][COLUMNAS];
    boolean[][] descubiertas = new boolean[FILAS][COLUMNAS];
    int explosiones = 0;
    int casillasSeguras = 0;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    
    public static void main(String[] args) {
        BuscaMinas juego = new BuscaMinas();
        juego.ejecutar();
    }
    
    public void ejecutar() {
        char respuesta;
        
        do {
            inicializarJuego();
            jugar();
            
            System.out.print("\nDeseas jugar otra vez? (s/n): ");
            respuesta = scanner.next().charAt(0);
            
        } while (respuesta == 's' || respuesta == 'S');
        
        System.out.println("\nGracias por jugar!");
        scanner.close();
    }
    
    void inicializarJuego() {
        explosiones = 0;
        casillasSeguras = 0;
        
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = false;
                descubiertas[i][j] = false;
            }
        }

        int minasColocadas = 0;
        while (minasColocadas < TOTAL_MINAS) {
            int fila = random.nextInt(FILAS);
            int columna = random.nextInt(COLUMNAS);
            
            if (!tablero[fila][columna]) {
                tablero[fila][columna] = true;
                minasColocadas++;
            }
        }
    }
    
    void jugar() {
        mostrarBienvenida();
        mostrarTablero();
        
        boolean continuar = true;
        while (continuar) {
           
            int[] coords = solicitarCoordenadas();
            int fila = coords[0];
            int columna = coords[1];
            
            if (descubiertas[fila][columna]) {
                System.out.println("[!] Ya exploraste esta casilla.\n");
                continue;
            }
            
            descubiertas[fila][columna] = true;
            
            if (tablero[fila][columna]) {
                System.out.println("[X] EXPLOSION! Detonaste una mina.\n");
                explosiones++;
            } else {
                System.out.println("[+] Casilla segura.\n");
                casillasSeguras++;
            }
            
            mostrarTablero();
            mostrarEstado();
            
            
            if (casillasSeguras == (FILAS * COLUMNAS - TOTAL_MINAS)) {
                System.out.println("\n*** GANASTE ***");
                System.out.println("Lograste desactivar el terreno minado!");
                continuar = false;
            } else if (explosiones >= EXPLOSIONES_MAXIMAS) {
                System.out.println("\n[!] GAME OVER - PERDISTE [!]");
                System.out.println("Detonaste demasiadas minas!");
                mostrarMinas();
                continuar = false;
            }
        }
    }
    
    
    int[] solicitarCoordenadas() {
        int x, y;
        
        while (true) {
            System.out.print("Ingrese X (1-" + COLUMNAS + "): ");
            x = scanner.nextInt();
            
            System.out.print("Ingrese Y (1-" + FILAS + "): ");
            y = scanner.nextInt();
            
            // Validar rango
            if (x >= 1 && x <= COLUMNAS && y >= 1 && y <= FILAS) {
                return new int[] {y - 1, x - 1};
            } else {
                System.out.println("[!] Coordenadas fuera de rango.\n");
            }
        }
    }
   
    void mostrarTablero() {
        System.out.println("\n   1 2 3 4 5 6 7");
        System.out.println("  ===============");
        
        for (int i = 0; i < FILAS; i++) {
            System.out.print((i + 1) + "| ");
            
            for (int j = 0; j < COLUMNAS; j++) {
                char simbolo;
                
                if (!descubiertas[i][j]) {
                    simbolo = '-';  
                } else if (tablero[i][j]) {
                    simbolo = 'X';  
                } else {
                    simbolo = '.';  
                }
                
                System.out.print(simbolo + " ");
            }
            System.out.println();
        }
        System.out.println("  ===============");
    }
    
    
    void mostrarBienvenida() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("   BUSCAMINAS");
        System.out.println("=".repeat(40));
        System.out.println("Objetivo: Descubre todas las casillas");
        System.out.println("Cuidado: Hay " + TOTAL_MINAS + " minas ocultas!");
        System.out.println("Limite: " + EXPLOSIONES_MAXIMAS + " explosiones para perder.");
        System.out.println("=".repeat(40));
    }
    
    
    void mostrarEstado() {
        int casillasTotal = FILAS * COLUMNAS;
        int casillasSegurasTotales = casillasTotal - TOTAL_MINAS;
        
        System.out.println("--- ESTADO ---");
        System.out.println("Explosiones: " + explosiones + "/" + EXPLOSIONES_MAXIMAS);
        System.out.println("Casillas seguras: " + casillasSeguras + "/" + casillasSegurasTotales);
        System.out.println();
    }
    
   
    void mostrarMinas() {
        System.out.println("\nMinas ubicadas en:");
        
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (tablero[i][j]) {
                    System.out.println("  -> Posicion (" + (j + 1) + ", " + (i + 1) + ")");
                }
            }
        }
    }
}
