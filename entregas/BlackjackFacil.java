import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackjackFacil {

    // ===== Clase Carta =====
    static class Carta {
        String palo;
        int valor;

        Carta(String palo, int valor) {
            this.palo = palo;
            this.valor = valor;
        }

        public String toString() {
            return valor + " de " + palo;
        }
    }

    public static void main(String[] args) {
        System.out.println("Blackjack - por ahora solo tengo cartas");
        Carta ejemplo = new Carta("Corazones", 10);
        System.out.println(ejemplo);
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackjackFacil {

    // ----- Carta -----
    static class Carta {
        String palo;
        int valor;

        Carta(String palo, int valor) {
            this.palo = palo;
            this.valor = valor;
        }

        public String toString() {
            return valor + " de " + palo;
        }
    }

    // ----- Baraja -----
    static class Baraja {
        ArrayList<Carta> cartas;

        Baraja() {
            cartas = new ArrayList<>();
            String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
            for (String palo : palos) {
                for (int numero = 2; numero <= 10; numero++) {
                    cartas.add(new Carta(palo, numero));
                }
                cartas.add(new Carta(palo, 10)); // J
                cartas.add(new Carta(palo, 10)); // Q
                cartas.add(new Carta(palo, 10)); // K
                cartas.add(new Carta(palo, 11)); // As
            }
        }

        void barajar() {
            Collections.shuffle(cartas);
        }

        Carta repartir() {
            return cartas.remove(cartas.size() - 1);
        }
    }

    public static void main(String[] args) {
        Baraja b = new Baraja();
        b.barajar();
        System.out.println("Primera carta: " + b.repartir());
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackjackFacil {

    // ----- Carta -----
    static class Carta {
        String palo;
        int valor;
        Carta(String palo, int valor) { this.palo = palo; this.valor = valor; }
        public String toString() { return valor + " de " + palo; }
    }

    // ----- Baraja -----
    static class Baraja {
        ArrayList<Carta> cartas;
        Baraja() {
            cartas = new ArrayList<>();
            String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
            for (String palo : palos) {
                for (int i = 2; i <= 10; i++) cartas.add(new Carta(palo, i));
                cartas.add(new Carta(palo, 10)); // J
                cartas.add(new Carta(palo, 10)); // Q
                cartas.add(new Carta(palo, 10)); // K
                cartas.add(new Carta(palo, 11)); // As
            }
        }
        void barajar() { Collections.shuffle(cartas); }
        Carta repartir() { return cartas.remove(cartas.size()-1); }
    }

    // ----- Mano -----
    static class Mano {
        ArrayList<Carta> cartas = new ArrayList<>();

        void recibir(Carta c) { cartas.add(c); }

        int puntuacion() {
            int total = 0, ases = 0;
            for (Carta c : cartas) {
                total += c.valor;
                if (c.valor == 11) ases++;
            }
            while (total > 21 && ases > 0) { total -= 10; ases--; }
            return total;
        }

        boolean seHaPasado() { return puntuacion() > 21; }
        boolean esBlackjack() { return cartas.size() == 2 && puntuacion() == 21; }

        public String toString() {
            String res = "";
            for (Carta c : cartas) res += c + ", ";
            if (res.length() >= 2) res = res.substring(0, res.length()-2);
            return res + " (puntuación: " + puntuacion() + ")";
        }
    }

    public static void main(String[] args) {
        // Prueba rápida de Mano
        Baraja b = new Baraja();
        b.barajar();
        Mano mano = new Mano();
        mano.recibir(b.repartir());
        mano.recibir(b.repartir());
        System.out.println("Mano: " + mano);
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackjackFacil {

    // ===== Carta =====
    static class Carta {
        String palo;
        int valor;
        Carta(String palo, int valor) { this.palo = palo; this.valor = valor; }
        public String toString() { return valor + " de " + palo; }
    }

    // ===== Baraja =====
    static class Baraja {
        ArrayList<Carta> cartas;
        Baraja() {
            cartas = new ArrayList<>();
            String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
            for (String palo : palos) {
                for (int i = 2; i <= 10; i++) cartas.add(new Carta(palo, i));
                cartas.add(new Carta(palo, 10)); // J
                cartas.add(new Carta(palo, 10)); // Q
                cartas.add(new Carta(palo, 10)); // K
                cartas.add(new Carta(palo, 11)); // As
            }
        }
        void barajar() { Collections.shuffle(cartas); }
        Carta repartir() { return cartas.remove(cartas.size()-1); }
    }

    // ===== Mano =====
    static class Mano {
        ArrayList<Carta> cartas = new ArrayList<>();
        void recibir(Carta c) { cartas.add(c); }
        int puntuacion() {
            int total = 0, ases = 0;
            for (Carta c : cartas) {
                total += c.valor;
                if (c.valor == 11) ases++;
            }
            while (total > 21 && ases > 0) { total -= 10; ases--; }
            return total;
        }
        boolean seHaPasado() { return puntuacion() > 21; }
        boolean esBlackjack() { return cartas.size() == 2 && puntuacion() == 21; }
        public String toString() {
            String res = "";
            for (Carta c : cartas) res += c + ", ";
            if (res.length() >= 2) res = res.substring(0, res.length()-2);
            return res + " (puntuación: " + puntuacion() + ")";
        }
    }

    // ===== JUEGO =====
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Baraja baraja = new Baraja();
        baraja.barajar();

        Mano manoJugador = new Mano();
        Mano manoDealer = new Mano();

        // Reparto inicial: 2 cartas cada uno
        manoJugador.recibir(baraja.repartir());
        manoDealer.recibir(baraja.repartir());
        manoJugador.recibir(baraja.repartir());
        manoDealer.recibir(baraja.repartir());

        System.out.println("=== BLACKJACK ===");
        System.out.println("Tu mano: " + manoJugador);
        System.out.println("Carta visible del dealer: " + manoDealer.cartas.get(0));

        if (manoJugador.esBlackjack()) {
            System.out.println("¡Blackjack! Has ganado.");
            teclado.close();
            return;
        }

        // Turno del jugador
        while (true) {
            if (manoJugador.seHaPasado()) {
                System.out.println("Te has pasado de 21. Pierdes.");
                teclado.close();
                return;
            }
            System.out.print("¿Quieres pedir (P) o plantarte (S)? ");
            String opcion = teclado.nextLine().trim().toUpperCase();
            if (opcion.equals("P")) {
                Carta nueva = baraja.repartir();
                System.out.println("Recibes: " + nueva);
                manoJugador.recibir(nueva);
            } else if (opcion.equals("S")) {
                break;
            } else {
                System.out.println("Opción no válida. Escribe P o S.");
            }
        }

        // Turno del dealer
        System.out.println("\n--- Turno del Dealer ---");
        System.out.println("Dealer: " + manoDealer);
        while (manoDealer.puntuacion() < 17) {
            Carta nueva = baraja.repartir();
            System.out.println("Dealer pide: " + nueva);
            manoDealer.recibir(nueva);
            System.out.println("Dealer: " + manoDealer);
        }

        // Resultados
        int puntosJugador = manoJugador.puntuacion();
        int puntosDealer = manoDealer.puntuacion();
        System.out.println("\n--- Resultado ---");
        System.out.println("Tu mano: " + manoJugador);
        System.out.println("Dealer: " + manoDealer);

        if (manoDealer.seHaPasado()) {
            System.out.println("El dealer se pasa. ¡Ganas!");
        } else if (puntosJugador > puntosDealer) {
            System.out.println("¡Ganas!");
        } else if (puntosJugador < puntosDealer) {
            System.out.println("Pierdes. Gana el dealer.");
        } else {
            System.out.println("Empate.");
        }
        teclado.close();
    }
}