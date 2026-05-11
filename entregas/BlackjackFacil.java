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