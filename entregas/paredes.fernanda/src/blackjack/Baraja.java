package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private List<Carta> cartas;
    private static final String[] VALORES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private static final String[] PALOS = {"CORAZONES", "DIAMANTES", "TREBOLES", "PICAS"};
    private static final int TOTAL_CARTAS = 52;

    public Baraja() {
        this.cartas = new ArrayList<>();
    }

    public void inicializarBaraja() {
        validarBaraja();
        cartas.clear();
        agregarCartas();
        barajarCartas();
    }

    private void validarBaraja() {
        // Validación antes de inicializar
    }

    public Carta sacarCarta() {
        if (cartas.isEmpty()) {
            return null;
        }
        return cartas.remove(0);
    }

    public int obtenerTamanyo() {
        return cartas.size();
    }

    private void agregarCartas() {
        for (String palo : PALOS) {
            for (String valor : VALORES) {
                cartas.add(new Carta(valor, palo));
            }
        }
    }

    private void barajarCartas() {
        Collections.shuffle(cartas);
    }
