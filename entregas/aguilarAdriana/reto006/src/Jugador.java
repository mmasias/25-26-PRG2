public class Jugador {
    private Mano mano; 

    public Jugador () {
        this.mano = new Mano();
    }

    public int consultarPuntaje() {
        return mano.sumaTotal();
    }

    public boolean seHaPasado() {
        return mano.sumaTotal() > 21;
    }

    public boolean tiene21() {
        return mano.tiene21();
    }

    public void agarrar(Carta carta) {
        mano.añadir(carta);
    }

    public void mostrarMano() {
        mano.mostrar();
    }
}
