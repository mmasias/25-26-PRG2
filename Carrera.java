class Carrera {

    private static final int LONGITUD = 40;
    private int[] posiciones = new int[2];

    private void mostrarPista() {
        System.out.println("--------------------------------------------");
        for (int i = 0; i < posiciones.length; i++) {
            System.out.println(" ".repeat(posiciones[i]) + ";-;'");
        }
        System.out.println("--------------------------------------------");
    }

    void jugar() {
    }
}
