public class Pista {
    private int largo;

    public Pista(int largo) {
        this.largo = largo;
    }

    public int obtenerLargo() {
        return largo;
    }

    public void mostrar(Caballo[] caballos) {
        for (int i = 0; i < caballos.length; i++) {
            Caballo caballo = caballos[i];
            int posicion = caballo.obtenerPosicion();
            if (posicion >= largo) {
                posicion = largo - 1;
            }
            String espacios = " ".repeat(Math.max(0, posicion));
            System.out.println(espacios + ";-;'");
        }
    }
}
