public class Mano {
    Carta[] cartas = new Carta[52];
    int indiceSiguienteCarta = 0;

    Mano() {
    }

    public void agregarCarta(Carta carta) {
        cartas[indiceSiguienteCarta] = carta;
        indiceSiguienteCarta++;
    }

    public void mostrarMano() {
        System.out.println("puntaje: " + calcularValor()+"de 21 \n");
        System.out.println("Tu mano:");
        for (int i = 0; i < indiceSiguienteCarta; i++) {
            cartas[i].mostrarCarta();
        }
    }

    public int calcularValor() {
        int valorTotal = 0;
        for (int i = 0; i < indiceSiguienteCarta; i++) {
            valorTotal += valorCarta(cartas[i]);
        }
        return valorTotal;
    }

 
}