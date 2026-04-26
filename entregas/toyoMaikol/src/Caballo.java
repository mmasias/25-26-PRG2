public class Caballo {
    private int numero;

    public Caballo(int numero){
        this.numero = numero;
    }

    public void mover(Pista pista) {
        int avance = (int)(Math.random() * 3);
        pista.avanzarCaballo(numero, avance);
    }
}
