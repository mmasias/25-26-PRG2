class Pista {
    final private int LONGITUD = 40;
    private Console console;

    public Pista(){
        console = new Console();
    }

    public void mostrar(Caballo[] caballos){
        this.imprimirBorde();
        this.imprimirCarril(caballos[0]);
        this.imprimirCarril(caballos[1]);
        this.imprimirBorde();
        console.writeln();
    }

    private void imprimirBorde(){
        for (int i = 0; i < LONGITUD + 4; i++) {
            console.write("-");
        }
        console.writeln();
    }

    private void imprimirCarril(Caballo caballo){
        for (int i = 0; i < caballo.obtenerPosicion(); i++) {
            console.write(" ");
        }
        console.writeln(caballo.obtenerDibujo());
    }

    public boolean haTerminado(Caballo[] caballos){
        return this.haGanado(caballos[0]) || this.haGanado(caballos[1]);
    }

    public boolean haGanado(Caballo caballo){
        return caballo.obtenerPosicion() >= LONGITUD;
    }
}