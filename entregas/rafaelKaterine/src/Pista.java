public class Pista {
    private int limite;

    public Pista(int limite) {
        this.limite = limite;
    }

    public int limite() {
        return this.limite;
    }

    public boolean haTerminado(Caballo caballo) {
        return caballo.posicion() >= this.limite;
    }

    public void mostrar(Console console) {
        for (int i = 0; i < this.limite; i++) {
            console.write("-");
        }
        console.writeln();
    }
}