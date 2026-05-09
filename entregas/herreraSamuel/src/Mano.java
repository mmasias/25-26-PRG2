public class Mano {
    private Carta[] cartas;
    private int cantidad;

    public Mano() {
        cartas = new Carta[10];
        cantidad = 0;
    }

    public void mostrar() {
        int puntos = calcularPuntaje();
        System.out.print("Mano: ");
        for (int i = 0; i < cantidad; i++) {
            cartas[i].mostrar();
        }

        String estado = switch (puntos) {
            case 21 -> "Ganó";
            default -> puntos > 21 ? "Perdió" : "Sigue jugando";
        };

        System.out.println(" - Puntaje: " + puntos + " ==> " + estado);
    }

    public boolean puedeSeguir() {
        return calcularPuntaje() < 21;
    }

    public void recibirCarta(Carta carta) {
        if (cantidad < cartas.length) {
            cartas[cantidad] = carta;
            cantidad++;
        }
    }

    public int calcularPuntaje() {
        int total = 0;
        int ases = 0;

        for (int i = 0; i < cantidad; i++) {
            total += cartas[i].obtenerValor();
            if (cartas[i].esAs()) {
                ases++;
            }
        }

        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }

        return total;
    }

}
