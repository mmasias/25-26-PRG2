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
        
    }

    public boolean haPerdido() {
        
    }

    public void mostrar() {
        
    }
}
