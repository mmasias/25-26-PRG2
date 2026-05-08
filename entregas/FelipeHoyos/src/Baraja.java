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
    }

    public void moverA(Descarte descarte) {
    }
}
