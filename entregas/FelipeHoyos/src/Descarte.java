class Descarte {

    private Carta[] cartas;
    private int tamaño;

    public Descarte() {
        cartas = new Carta[52];
        tamaño = 0;
    }

    public boolean hayCartas() {
        return tamaño > 0;
    }

    public void recibir(Carta carta) {
        assert carta != null;

        cartas[tamaño] = carta;
        tamaño = tamaño + 1;
    }

    private Carta sacar() {
        assert this.hayCartas();

        tamaño = tamaño - 1;

        Carta carta = cartas[tamaño];
        cartas[tamaño] = null;

        return carta;
    }

    public void moverA(Mano mano) {
        assert mano != null;

        if(this.hayCartas()) {
            mano.recibir(this.sacar());
        }
    }


}
