package blackjack;

import java.util.Scanner;
import java.util.List;

public class Principal {
    private Juego juego;
    private Scanner scanner;
    private boolean ejecutando;
    private static final int OPCION_PEDIR = 1;
    private static final int OPCION_NUEVA_PARTIDA = 2;
    private static final int OPCION_SALIR = 3;
    private static final String SEPARADOR = "--------------------";
    private static final String TITULO = "=== Bienvenido al Blackjack ===";

    public Principal() {
        this.juego = new Juego();
        this.scanner = new Scanner(System.in);
        this.ejecutando = true;
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.ejecutar();
    }

    public void ejecutar() {
        System.out.println(TITULO + "\n");
        
        while (ejecutando) {
            juego.iniciarJuego();
            
            while (juego.estaJugando()) {
                mostrarMano();
                mostrarMenu();
                procesarOpcion(obtenerOpcion());
            }
            
            mostrarEstadoFinal();
            
            if (!pedirNuevaPartida()) {
                ejecutando = false;
            }
        }
        
        salir();
    }

    private void mostrarMenu() {
        System.out.println(SEPARADOR);
        System.out.println(OPCION_PEDIR + ". Pedir");
        System.out.println(OPCION_NUEVA_PARTIDA + ". Empezar de nuevo");
        System.out.println(OPCION_SALIR + ". Salir");
        System.out.println(SEPARADOR);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case OPCION_PEDIR -> pedirCarta();
            case OPCION_NUEVA_PARTIDA -> iniciarNuevaPartida();
            case OPCION_SALIR -> {
                ejecutando = false;
                juego.plantarse();
            }
            default -> System.out.println("Opción inválida");
        }
    }

    private void mostrarMano() {
        System.out.println(SEPARADOR);
        System.out.print("Mano: ");
        mostrarCartas();
        mostrarPuntaje();
        System.out.println();
    }

    private void mostrarCartas() {
        List<Carta> mano = juego.obtenerMano();
        for (Carta carta : mano) {
            System.out.print(carta.obtenerRepresentacion());
        }
    }

    private void mostrarPuntaje() {
        System.out.print(" - Puntaje: " + juego.obtenerPuntuacion() + " ==> " + juego.obtenerEstado());
    }

    private void mostrarEstado() {
        System.out.println("Estado: " + juego.obtenerEstado());
    }

    private void mostrarEstadoFinal() {
        mostrarMano();
    }

    private void iniciarNuevaPartida() {
        juego.plantarse();
    }

    private void pedirCarta() {
        juego.pedirCarta();
    }

    private int obtenerOpcion() {
        try {
            int opcion = Integer.parseInt(scanner.nextLine());
            return validarOpcion(opcion) ? opcion : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean validarOpcion(int opcion) {
        return opcion >= OPCION_PEDIR && opcion <= OPCION_SALIR;
    }

    private boolean pedirNuevaPartida() {
        mostrarMenu();
        int opcion = obtenerOpcion();
        if (opcion == 2) {
            return true;
        } else if (opcion == 3) {
            return false;
        }
        return false;
    }

    private void salir() {
        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }
}
