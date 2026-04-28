class Turno {
    private int valorInicial;
    private int valorActual;

    public Turno(){
        valorInicial = (int) (Math.random() * 2);
        valorActual = valorInicial;
    }

    public int toca(){
        return valorActual;
    }

    public void cambiar(){
        valorActual = (valorActual + 1) % 2;
    }

    public boolean esFinDeRonda(){
        return valorActual == valorInicial;
    }

}