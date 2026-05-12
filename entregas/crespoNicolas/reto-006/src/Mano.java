public class Mano {
    private Carta[] cartas;
    private int contador;
    private Console console;

    public Mano() {
        this.cartas = new Carta[21];  
        this.contador = 0;
        this.console = new Console();
    }

    public void añadir(Carta carta) {
        if (this.contador < this.cartas.length) {
            this.cartas[this.contador] = carta;
            this.contador++;
        }
    }

    public int sumaTotal() {
        int suma = 0;
        int ases = 0;

        for (int i = 0; i < contador; i++) {
            suma += cartas[i].valor21();
            if (cartas[i].esAs()) {
                ases++;
            }
        }


        while (ases > 0 && suma + 10 <= 21) {
            suma += 10;
            ases--;
        }

        return suma;
    }

    public boolean tiene21() {
        return this.sumaTotal() == 21;
    }

    public boolean esMenora21() {
        return this.sumaTotal() < 21;
    }

    public void mostrar() {
        this.console.write("Mano: ");
        for (int i = 0; i < this.contador; i++) {
            this.cartas[i].mostrar();
            this.console.write(" ");
        }
        this.console.writeln("| Suma: " + this.sumaTotal());
    }
}
