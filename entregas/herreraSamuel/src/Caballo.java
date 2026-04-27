public class Caballo {
    
    private int numero;
    private int posicion;

    public Caballo(int numero) {
        assert numero > 0; 
        this.numero = numero;
        this.posicion = 0; 
    }

    public void avanzar() {
        int avance = (int) (Math.random() * 3);
        this.posicion = this.posicion + avance;
    }

    public int posicion() {
        return this.posicion;
    }

    public void dibujar() {
        for (int i = 0; i < this.posicion; i++) {
            System.out.print(" ");
        }
        System.out.println(";-;'");
    }
}