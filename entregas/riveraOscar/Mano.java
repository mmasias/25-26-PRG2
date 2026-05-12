package entregas.riveraOscar;
public class Mano {
    private Carta[] misCartas;
    int contadorMisCartas;

    public Mano(){
        this.misCartas = new Carta[10]; 
        this.contadorMisCartas = 0;
    }

    public void recibirCarta(Carta cartaActualCarta){
        misCartas[contadorMisCartas] = cartaActualCarta;
        contadorMisCartas++;
    }
    public int calcularPuntaje() {
        int puntajeTotal = 0;
        int cantidadAses = 0;

        for (int i = 0; i < contadorMisCartas; i++) {
            int valorCarta = misCartas[i].obtenerValor();
            if (valorCarta == 11) {
                cantidadAses++;
            }
            puntajeTotal += valorCarta;
        }

        while (puntajeTotal > 21 && cantidadAses > 0) {
            puntajeTotal -= 10;
            cantidadAses--;
        }

        return puntajeTotal;
    }
    public void mostrarMano() {
        for (int i = 0; i < contadorMisCartas; i++) {
            misCartas[i].mostrarCarta();
        }
        System.out.println(" - Puntaje: " + calcularPuntaje());
    }
}