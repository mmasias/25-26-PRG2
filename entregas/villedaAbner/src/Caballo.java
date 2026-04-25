public class Caballo {

    private int numero;
    private int posicion;
    private Console console;

    public Caballo(int numero) {
        this.numero = numero;
        this.posicion = 0;
        console = new Console();
    }

    public void avanzar() {
        int casillasAvanzadas;
        casillasAvanzadas = (int) (Math.random() * 3);
        this.posicion = posicion + casillasAvanzadas;
    }

    public void celebrar() {
        console.writeln("El caballo '" + this.numero + "' ha ganado!!");
    }

    public int getPosicion() {
        return this.posicion;
    }
}
