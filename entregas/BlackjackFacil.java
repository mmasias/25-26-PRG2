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