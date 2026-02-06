public class Edlin {
    private String[] lineas = new String[10];

    public Edlin() {
        for (int i = 0; i < 10; i++) {
            lineas[i] = "";
        }
    }

    public void mostrar() {
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ": " + lineas[i]);
        }
    }

    public static void main(String[] args) {
        Edlin e = new Edlin();
        e.mostrar();
    }
}