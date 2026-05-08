class Mano {

    private Carta[] cartas;
    private int tamaño;
    private Console console;
    
    public Mano() {
        cartas = new Carta[52];
        tamaño = 0;
        console = new Console();
    }

    public void recibir(Carta carta) {
        assert carta != null;

        cartas[tamaño] = carta;
        tamaño = tamaño + 1;
    }

    public int puntaje() {
        int puntaje = 0;

        for (int i = 0; i < tamaño; i++) {
            puntaje = 
                puntaje + 
                cartas[i].valorBlackjack();
        }

        return puntaje;
    }

    public boolean haPerdido() {
        return this.puntaje() > 21;
    }

    public void mostrar() {
        
    }
}
