public class Edlin {
    private String[] lineas = new String[10];
    private int lineaActiva = 1;

    public Edlin() {
        for (int i = 0; i < 10; i++) {
            lineas[i] = "";
        }
    }

    public void mostrar() {
        for (int i = 0; i < 10; i++) {
            String marca = (i + 1 == lineaActiva) ? ">" : " ";
            System.out.println(marca + (i + 1) + ": " + lineas[i]);
        }
    }

    public void setLineaActiva(int n) {
        if (n >= 1 && n <= 10) {
            lineaActiva = n;
        }
    }

    public static void main(String[] args) {
        Edlin e = new Edlin();
        e.setLineaActiva(3);
        e.mostrar();
    }
}