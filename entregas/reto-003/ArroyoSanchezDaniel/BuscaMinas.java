public class BuscaMinas {
    public static void main(String[] args) {
        final int MINAS_TOTALES = 5;
        int posicionMinas[][] = new int[5][7];
        int tableroVisible[][] = new int[5][7];
        int minasDescubiertas = 0; 

        colocarMinas(posicionMinas, MINAS_TOTALES);
    
    }
    static void colocarMinas(int posicionMinas[][], int MINAS_TOTALES ){
        int minas = 0;
        while (minas < MINAS_TOTALES) {
            int px = (int) (Math.random() * 8);
            int py = (int) (Math.random() * 8);
            if (posicionMinas[py][px] == 0) {
                minas++;
                posicionMinas[py][px] = 1;
            } else if (posicionMinas[py][px] == 1) {
            }
        }
    }
}
