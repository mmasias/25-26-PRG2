import java.util.Scanner;

public class buscaminas {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);;
        int[][] tablero = new int[4][4];
        int x=1;
        int y=1;
        boolean juegoperdido=false;
        colocarmina (tablero);
        final int MINA = 1;
        do{
            imprimirTablero(tablero,MINA);
            int[] coords = leercoordenadas(scanner, x, y);
            x = coords[0];
            y = coords[1];
        if (tablero[x][y]==MINA){
            System.out.println("Has perdido");
            juegoperdido=true;
        }else{
                        revelarcelda(tablero,x,y);
                            for(int j=0;j<tablero.length;j++){
                                for(int i=0;i<tablero.length;i++){
                             System.out.print(mapearCelda(tablero[i][j], false));
                                }
                                System.out.println();
                        }
            System.out.println("Continua, no habia mina");
        }
    }while(!juegoperdido);

}



    static void colocarmina (int[][] tablero) {
    int fila = (int) (Math.random() * tablero.length);
    int columna = (int) (Math.random() * tablero[0].length);
    tablero[fila][columna] = 1;
}
   static void revelarcelda(int[][] tablero, int x, int y){
    tablero[x][y] = 2;
   }
   static void imprimirTablero(int[][]tablero, int MINA){
    for(int j=0;j<tablero.length;j++){
                for(int i=0;i<tablero.length;i++){
                    System.out.print(mapearCelda(tablero[i][j], true));
                }
                System.out.println();
            }
        }

    static String mapearCelda(int val, boolean ocultar) {
        if (ocultar) {
            if (val == 2) {
                return " . ";
            }
            return "[ ]";
        } else {
            if (val == 1) {
                return "[*]";
            }
            if (val == 2) {
                return " . ";
            }
            return " . ";
        }
    }
    static int[] leercoordenadas(Scanner scanner, int x, int y){
        System.out.println("Elige la posicion x");
         x= scanner.nextInt();
        System.out.println("Elige la posicion y");
         y= scanner.nextInt();
        return new int[]{x, y};
    }
}
