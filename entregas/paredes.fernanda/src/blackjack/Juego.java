package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private Baraja baraja;
    private List<Carta> manoJugador;
    private int puntuacion;
    private boolean jugando;
    private String estado;
    private static final int LIMITE_PUNTOS = 21;
    private static final int MANO_INICIAL = 2;

    public Juego() {
        this.baraja = new Baraja();
        this.manoJugador = new ArrayList<>();
        this.puntuacion = 0;
        this.jugando = false;
        this.estado = "";
    }

    public void iniciarJuego() {
        validarJuego();
        baraja.inicializarBaraja();
        manoJugador.clear();
        repartirDosCartas();
        puntuacion = calcularPuntuacion();
        actualizarEstado();
        jugando = true;
    }

    private void validarJuego() {
        // Validación antes de iniciar
    }

    public void pedirCarta() {
        if (jugando) {
            Carta carta = baraja.sacarCarta();
            if (carta != null) {
                manoJugador.add(carta);
                puntuacion = calcularPuntuacion();
                actualizarEstado();
            }
        }
    }

    public void plantarse() {
        jugando = false;
        estado = "Plantado";
    }

    public int calcularPuntuacion() {
        int puntos = sumarValoresCartas();
        int ases = contarAses();
        puntos = ajustarPorAses(puntos, ases);
        return puntos;
    }

    private int sumarValoresCartas() {
        int suma = 0;
        for (Carta carta : manoJugador) {
            if (carta.getValor().equals("A")) {
                suma += 11;
            } else {
                suma += carta.obtenerValor();
            }
        }
        return suma;
    }

    private int contarAses() {
        int ases = 0;
        for (Carta carta : manoJugador) {
            if (carta.getValor().equals("A")) {
                ases++;
            }
        }
        return ases;
    }

    private int ajustarPorAses(int puntos, int ases) {
        while (puntos > LIMITE_PUNTOS && ases > 0) {
            puntos -= 10;
            ases--;
        }
        return puntos;
    }

    public List<Carta> obtenerMano() {
        return new ArrayList<>(manoJugador);
    }

    public int obtenerPuntuacion() {
        return puntuacion;
    }

    public boolean estaJugando() {
        return jugando;
    }

    public String obtenerEstado() {
        return estado;
    }

    private void repartirDosCartas() {
        manoJugador.add(baraja.sacarCarta());
        manoJugador.add(baraja.sacarCarta());
    }

    private void actualizarEstado() {
        if (puntuacion > LIMITE_PUNTOS) {
            estado = "Perdió";
            jugando = false;
        } else if (puntuacion == LIMITE_PUNTOS && manoJugador.size() == MANO_INICIAL) {
            estado = "Ganó";
            jugando = false;
        } else {
            estado = "Sigue jugando";
        }
    }
