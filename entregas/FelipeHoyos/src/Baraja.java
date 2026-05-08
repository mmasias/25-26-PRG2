class Baraja {

    private Carta[] cartas;
    private int ultima;
    
    public Baraja() {
        ultima = 0;
        cartas = new Carta[52];

        this.generar();
        this.mezclar();

    }

    private void generar() {
        for (int palo = 0; palo < 4; palo++) {
            for (int numero = 1; numero <= 13; numero++) {
                this.poner(new Carta(palo, numero));
            }
        }
    }

    private void poner(Carta carta) {
        assert carta != null;

        cartas[ultima] = carta;
        ultima = ultima + 1;
    }

    private void mezclar() {
        for (int i = 0; i < ultima; i++) {
            int posicion = (int) (Math.random() * ultima);
            this.intercambiar(i, posicion);
        }
    }

    public boolean hayCartas() {
        return ultima > 0;
    }

    public Carta sacar() {
        assert this.hayCartas();

        ultima = ultima - 1;

        Carta carta = cartas[ultima];
        cartas[ultima] = null;

        return carta;
    }

    public void moverA(Descarte descarte) {
        assert descarte != null;

        if(this.hayCartas()) {
            descarte.recibir(this.sacar());
        }
    }
}
