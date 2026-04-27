package entregas.rodriguezJavier;

public class Utilidad {
    
    public static void pausar() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
    }
    
    public static void limpiarPantalla() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}