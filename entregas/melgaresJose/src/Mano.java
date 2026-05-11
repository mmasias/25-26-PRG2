class Mano {
    private Carta[] cartas;
    private int tamaño;
    private final int MAXIMO_DE_CARTAS = 11;

    public Mano() {
        cartas = new Carta[MAXIMO_DE_CARTAS];
        tamaño = 0;
    }

    public void pedirCarta(Baraja baraja) {
        cartas[tamaño] = baraja.sacar();
        tamaño++;
    }

    public void mostrar() {
        for(int i = 0; i < tamaño; i++) {
            cartas[i].mostrar();
        }
    }

    public int contarPuntos() {
        int puntos = 0;
        int asesCompletos = 0;
        for(int i = 0; i < tamaño; i++) {
            asesCompletos = cartas[i].esAs() ? asesCompletos : asesCompletos + 1;
            puntos += cartas[i].obtenerValor();
            if(puntos > 21 && asesCompletos > 0) {
                puntos = puntos - 10;
                asesCompletos = asesCompletos - 1;
            }
        }
        return puntos;
    }

}
