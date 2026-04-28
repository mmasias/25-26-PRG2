public class Utilidad {
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pausar(int segundos){
        try {
            Thread.sleep(1000* segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
