public class Mano {
    private Carta[] cartas;
    private int ultima;

    public Mano() {
        cartas = new Carta[21];
        ultima = 0;
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    public int calcularPuntaje() {
        int puntaje = 0;
        int ases = 0;

        for (int i = 0; i < ultima; i++) {
            puntaje += cartas[i].obtenerValorNumerico();
            if (cartas[i].esAs()) {
                ases++;
            }
        }

        while (puntaje > 21 && ases > 0) {
            puntaje -= 10;
            ases--;
        }

        return puntaje;
    }

    public void mostrar() {
        for (int i = 0; i < ultima; i++) {
            cartas[i].mostrar();
        }
    }
}