public class Mano {
    private Carta[] cartas;
    private int cantidad;

    public Mano() {
        cartas = new Carta[10]; 
        cantidad = 0;
    }

    public void mostrar() {
    }

    public boolean puedeSeguir() {
        
    }

    public void recibirCarta(Carta carta) {
       if (cantidad < cartas.length) {
            cartas[cantidad] = carta;
            cantidad++;
        }
    }

}
