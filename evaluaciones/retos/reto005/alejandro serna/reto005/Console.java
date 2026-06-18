public class Console {
    
    public void write(String text) {
        System.out.print(text);
    }
    
    public void writeln(String text) {
        System.out.println(text);
    }
    
    public void pause(long milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void cleanScreen() {
        // Limpiar pantalla
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}
