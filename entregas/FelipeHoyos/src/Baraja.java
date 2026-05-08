class Baraja {

    private Carta[] cartas;
    private int ultima;
    
    public Baraja() {
        ultima = 0;
        cartas = new Carta[52];

        this.generar();
        this.mezclar();

    }

    public boolean hayCartas() {
        return ultima < 0;
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
