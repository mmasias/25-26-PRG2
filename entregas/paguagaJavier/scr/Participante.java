public abstract class Participante {
    protected Mano mano = new Mano();
    protected Console console = new Console();
    protected String nombre;

    public Participante(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarEstado() {
        this.console.write(nombre + ": ");
        this.mano.mostrar();
        this.console.write(" - Puntaje: " + getPuntaje());
    }

    public int getPuntaje() {
        return mano.obtenerPuntaje();
    }

    public void recibirCarta(Carta carta) {
        mano.recibir(carta);
    }

    public void limpiarMano() {
        mano.limpiar();
    }

    public void mostrar() {
        new Console().write(nombre + " - ");
        mano.mostrar();
        new Console().writeln("");
    }
}