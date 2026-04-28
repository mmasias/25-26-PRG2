class Caballo {
    private int numero;
    private int posicion;
    final private String DIBUJO = ";-;'";

    public Caballo(int numero){
        this.numero = numero;
        posicion = 0;
    }

    public void Correr(){
        int avance = (int) (Math.random() * 3); 
        posicion = posicion + avance;
    }

    public int obtenerPosicion(){
        return posicion;
    }

    public String obtenerDibujo(){
        return DIBUJO;
    }
}