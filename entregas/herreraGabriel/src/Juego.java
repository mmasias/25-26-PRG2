public class Juego {
    private Baraja baraja;
    private Mano manoJugador;
    private Console console;
    private boolean plantado; 

    public Juego() {
        console = new Console();
    }

    private void nuevaMano() {
        baraja = new Baraja();
        manoJugador = new Mano();
        manoJugador.poner(baraja.sacar());
        manoJugador.poner(baraja.sacar());
        plantado = false; 
    }

    private String mostrarInterfaz() {
        int puntaje = manoJugador.calcularPuntaje();
        String estado = "Sigue jugando";

        if (puntaje == 21) {
            estado = "Ganó";
        } else if (puntaje > 21) {
            estado = "Perdió";
        } else if (plantado) {
            estado = "Se plantó"; 
        }

        console.writeln("--------------------");
        console.write("Mano: ");
        manoJugador.mostrar();
        console.writeln(" - Puntaje: " + puntaje + " ==> " + estado);
        console.writeln("--------------------");
        console.writeln("1. Pedir");
        console.writeln("2. Quedarse");
        console.writeln("3. Empezar de nuevo");
        console.writeln("4. Salir");
        console.writeln("--------------------");

        return estado;
    }

    public void iniciar() {
        nuevaMano();
        boolean jugando = true;

        while (jugando) {
            String estado = mostrarInterfaz();
            String opcion = console.readString();

            if (opcion.equals("1")) {
                if (estado.equals("Sigue jugando")) {
                    manoJugador.poner(baraja.sacar());
                } else {
                    console.writeln("El juego ya terminó. Elige empezar de nuevo (3) o salir (4).");
                }
            } else if (opcion.equals("2")) {
                if (estado.equals("Sigue jugando")) {
                    plantado = true;
                } else {
                    console.writeln("El juego ya terminó. Elige empezar de nuevo (3) o salir (4).");
                }
            } else if (opcion.equals("3")) {
                nuevaMano();
            } else if (opcion.equals("4")) {
                console.writeln("¡Gracias por jugar!");
                jugando = false;
            } else {
                console.writeln("Opción inválida. Ingresa 1, 2, 3 o 4.");
            }
        }
    }
}