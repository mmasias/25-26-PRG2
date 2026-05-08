public class Mano {

    private Carta[] cartas;
    private int ultima;
    private Console console;

    public Mano() {
        cartas = new Carta[12];
        ultima = 0;
        console= new Console();

    }

    public void agarrar(Baraja baraja) {
        cartas[ultima] = baraja.sacar();
        ultima++;
        this.cima().voltearCarta();
    }

    public void reiniciar(Baraja baraja) {
        ultima = 0;
        this.roboInicial(baraja);
    }

    public void mostrar() {
        console.write("Mano: ");
        for (int i = 0; i < ultima; i++) {
            cartas[i].mostrar();
        }
        console.write(" - Puntaje: " + this.getPuntaje());
       if (this.getPuntaje() == 21) {
            console.writeln("  ==> Ganó");
        } else if (this.getPuntaje() > 21) {
            console.writeln("  ==> Perdió");
        } else {
            console.writeln("  ==> Sigue jugando");
        }
    }

    public void roboInicial(Baraja baraja) {
        for (int i = 0; i < 2; i++) {
            this.agarrar(baraja);
        }
    }

    public int getPuntaje() {
        int puntajeTotal = 0;
        boolean hayAs = false;
        for (int i = 0; i < ultima; i++) {
            puntajeTotal += cartas[i].puntajeDeLaCarta();
            if (cartas[i].esAs()) {
                hayAs = true;
            }
        }
        if (hayAs && puntajeTotal + 10 <= 21) {
            puntajeTotal += 10;
        }

        return puntajeTotal;
    }

    private Carta cima() {
        return cartas[ultima - 1];
    }

}
