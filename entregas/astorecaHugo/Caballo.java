
class Caballo {
    private int numero;
    private int posicion;


    Caballo(int numero) {
        this.numero = numero;
        this.posicion = 0;
    }

    void moverse(Pista pista) {
        int movimiento = (int)(Math.random()*3);
        posicion = posicion + movimiento;

    }
    public int getPosicion (){
        return posicion;

    }
    public int getNumero(){
        return numero;
    }
}
